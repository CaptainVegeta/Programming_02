package ch.teko.railtraffic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class APIinputStream {
	private int count_new;

	private static final String url_str_parameter = "https://data.sbb.ch/api/records/1.0/search/?"
			+ "dataset=rail-traffic-information" + "&pretty_print=true" + "&timezone=Europe%2FBerlin" + "&rows=";

	private TrafficRecords imported_records;
	protected ArrayList<TrafficDatasetFields> act_records = new ArrayList<>();
	private ArrayList<String> prev_records = new ArrayList<>();

	// Konstruktor
	APIinputStream(String max_values) {
		this.loadData(max_values);
	}
	
	// Getter
	public String getCountNew () {
		String count_new_str = Integer.toString(count_new);
		return count_new_str;
	}
	
	// Setter
	public void setCountNew() {
		this.count_new--;
	}

	// *** Load Data Methode ***
	void loadData(String max_values) {
		// act_records.clear();
		String url_str_prepared;
		URL url;
		try {
			// If Block für den Selektor "unlimited"
			if (max_values.equals("unlimited")) {
				if (imported_records.getNhits() > 0) {
					url_str_prepared = url_str_parameter + imported_records.getNhits();
				} else {
					url_str_prepared = url_str_parameter + 999;
				}
			} else {
				url_str_prepared = url_str_parameter + max_values;	
			}
			// URL Stream öffnen
			url = new URL (url_str_prepared);
			InputStream input = url.openStream();
			Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8.name());
			imported_records = new Gson().fromJson(reader, TrafficRecords.class);
			// If Block wenn noch keine Daten geladen wurden
			if (act_records.isEmpty()) {
				for (TrafficDataset temp_datasets : imported_records.getRecords()) {
					temp_datasets.perpareDatasets();
					act_records.add(temp_datasets.getDatasetFields());
				}
			} else {
				// Else Block wenn bereits Daten geladen wurden
				prev_records.clear();
				for (TrafficDatasetFields temp_fields : act_records) {
					temp_fields.setNew_entry(false);
					prev_records.add(temp_fields.getRecord_id());
				}
				act_records.clear();
				for (TrafficDataset temp_datasets : imported_records.getRecords()) {
					temp_datasets.perpareDatasets();
					act_records.add(temp_datasets.getDatasetFields());
				}
				this.comparData();
			}
		} catch (MalformedURLException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// *** Compare Data Methode ***
	void comparData() {
		int count = 0;
		for (TrafficDatasetFields temp_fields : act_records) {
			// Flag "new" setzen wenn der Datensatz zuvor noch nicht in der Array List war.
			if (!prev_records.contains(temp_fields.getRecord_id())) {
				temp_fields.setNew_entry(true);
				count++;
			} else {
				// Do nothing
			}
		}
		count_new = count;
		// Tray Notification anzeigen wenn mehr als 1 neuer Eintrag vorhanden ist.
		if (count > 1) {
			String title = count + " new entries";
			String message = "There have been " + count + " new entries be imported";
			TrayNotification tray = new TrayNotification();
			tray.setTitle(title);
			tray.setMessage(message);
			tray.setNotificationType(NotificationType.WARNING);
			tray.showAndWait();
		} else if (count == 1) {
			// Tray Notification anzeigen wenn genau ein neuer Eintrag vorhanden ist.
			for (TrafficDatasetFields temp_fields : act_records) {
				if (temp_fields.getNew_entry()) {
					String title = "1 new entry available";
					String message = temp_fields.getTitle();
					TrayNotification tray = new TrayNotification();
					tray.setTitle(title);
					tray.setMessage(message);
					tray.setNotificationType(NotificationType.NOTICE);
					tray.showAndWait();
				}
			}
		} else {
			// Try Notification anzeigen wenn keine neue Daten vorhanden sind.
			String title = "Refresh";
			String message = "Data successfully reloaded";
			TrayNotification tray = new TrayNotification();
			tray.setTitle(title);
			tray.setMessage(message);
			tray.setNotificationType(NotificationType.SUCCESS);
			tray.setAnimationType(AnimationType.POPUP);
			tray.showAndDismiss(Duration.seconds(3));
		}

	}
}
