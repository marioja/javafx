package fx.sample;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,900,500);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			throw new IllegalStateException("Unable to load view:", e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
