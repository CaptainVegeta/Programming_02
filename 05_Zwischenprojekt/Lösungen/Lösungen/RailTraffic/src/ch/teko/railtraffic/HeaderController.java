package ch.teko.railtraffic;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HeaderController implements Initializable {
	// Attribute für Scene Builder
	@FXML
	public ComboBox<String> max_rows;
	@SuppressWarnings("rawtypes")
	@FXML
	public TableColumn column_time;
	@SuppressWarnings("rawtypes")
	@FXML
	public TableColumn column_date;
	@SuppressWarnings("rawtypes")
	@FXML
	public TableColumn column_new;
	@FXML
	public TableColumn<TrafficDatasetFields, String> column_description;
	@FXML
	public TableView<TrafficDatasetFields> table;
	@FXML
	public Label label_count_new;

	// Attribute für die Combobox
	private String max_rows_value = "50";
	private int max_rows_to_create = 210;
	
	// Date Format Vorlage für die Zellen Formatierung
	private SimpleDateFormat date_format_time = new SimpleDateFormat("hh:mm");
	private SimpleDateFormat date_format_date = new SimpleDateFormat("dd.MM.yyyy");

	// Observable List für die Choice Box 1 -max_rows_to_create in 10 Schritt
	// erstellen
	private ObservableList<String> obs_list_combobox = FXCollections.observableList(this.createList());
	// Observable List für die Tabelle
	private ObservableList<TrafficDatasetFields> obs_list_table = FXCollections.observableArrayList();

	// Daten von SBB API
	private APIinputStream datas;

	// Neuer Scheduler Task welcher ein neuer Thread erstellt und alle 5min läuft
	// (SBB aktualisiert nur alle 5min)
	ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		}
	});

	// *** Initialize Methode ***
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Thread starten welcher im Hintergrund die Daten neu ladet und vergleicht.
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				final Runnable runnable = new Runnable() {
					@Override
					public void run() {
						// Methode LoadData() aufrufen
						loadData();
					}
				};
				Platform.runLater(runnable);
			}
			// 1mal nach 5 min und dann alle 5 min
		}, 5, 5, TimeUnit.MINUTES);

		// Combobox mit observable Liste verknüpfen und Standartwert setzten
		max_rows.setItems(obs_list_combobox);
		max_rows.setValue(max_rows_value);

		// Daten erstmalig via SBB API abfragen
		datas = new APIinputStream(max_rows_value);
		for (TrafficDatasetFields temp_data : datas.act_records) {
			obs_list_table.add(temp_data);
		}

		// Tabelle mit Werten in der Observable Liste verknüpfen
		table.setItems(obs_list_table);
		column_description
				.setCellValueFactory(new PropertyValueFactory<TrafficDatasetFields, String>("property_description"));
		column_time.setCellValueFactory(new PropertyValueFactory<TrafficDatasetFields, String>("property_date"));
		column_date.setCellValueFactory(new PropertyValueFactory<TrafficDatasetFields, String>("property_date"));
		column_new.setCellValueFactory(new PropertyValueFactory<TrafficDatasetFields, String>("property_new"));
		// Column_new minimieren da diese nur für die Row Formatierung gebraucht wird
		column_new.setMinWidth(0);
		column_new.setMaxWidth(0);
		column_new.setPrefWidth(0);

		// Format der Zellen ändern damit nur die Zeit angezeigt wird. Im Hintergrund
		// ist es ein Date Object
		column_time.setCellFactory(column -> {
			return new TableCell<TrafficDatasetFields, Date>() {
				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
						setStyle("");
					} else {
						setText(date_format_time.format(item));
					}
				}
			};
		});
		// Format der Zellen ändern damit nur das Datum angezeigt wird. Im Hintergrund
		// ist es ein Date Object
		column_date.setCellFactory(column -> {
			return new TableCell<TrafficDatasetFields, Date>() {
				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
						setStyle("");
					} else {
						setText(date_format_date.format(item));
					}
				}
			};
		});

		// Format damit neue Zeilen markieren
		column_new.setCellFactory(column_date -> {
			return new TableCell<TrafficDatasetFields, String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					TableRow<TrafficDatasetFields> currentRow = getTableRow();
					if (item == null || empty) {
						setText(null);
						setStyle("");
					} else if (item.equals("New")) {
						setText(item);
						currentRow.setStyle("-fx-background-color:lightcoral;");
					} else {
						setText(item);
						currentRow.setStyle("");
					}
				}
			};
		});

		// Doppelklick auf der Zeile aktivieren
		table.setRowFactory(tv -> {
			TableRow<TrafficDatasetFields> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					if (row.getItem().getNew_entry()) {
						datas.setCountNew();
					}
					row.getItem().setNew_entry(false);
					label_count_new.setText(datas.getCountNew());
					// Refresh verursacht ein CSS Fehler da die TableView neu geladen wird wenn das PopOver erstellt wird.
					table.refresh();
					// Popover erstellen
					OwnPopOver own_popover = new OwnPopOver();
					own_popover.SetContentPopOver(row.getItem());
					own_popover.show(row);	
				}	
			});
			return row;	
		});
	}

	// *** ComboBox Selection Action ***
	public void onMaxRowSelection(ActionEvent e) {
		if (max_rows.getSelectionModel().getSelectedItem() != null) {
			this.max_rows_value = max_rows.getSelectionModel().getSelectedItem().toString();
		} else {
			this.max_rows_value = "0";
		}
		loadData();
	}

	// *** ArrayList erstellen für die ObservableList ***
	private ArrayList<String> createList() {
		ArrayList<String> list = new ArrayList<String>();
		{
			for (int i = 0; i <= max_rows_to_create; i = i + 10) {
				if (i == 0) {
					list.add("1");
				} else if (i == max_rows_to_create) {
					list.add("unlimited");
				} else {
					list.add(Integer.toString(i));
				}
			}
		}
		return list;
	}

	// *** Die Daten neu laden via SBB API ***
	private void loadData() {
		obs_list_table.clear();
		datas.loadData(max_rows_value);
		for (TrafficDatasetFields temp_data : datas.act_records) {
			obs_list_table.add(temp_data);
		}
		label_count_new.setText(datas.getCountNew());
		table.refresh();
	}
}
