package ch.teko.railtraffic;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image icon = new Image(this.getClass().getResourceAsStream("/main/resources/Icon.png"));
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("Rail Traffic Messages");
		try {FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/main/resources/Layout.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
