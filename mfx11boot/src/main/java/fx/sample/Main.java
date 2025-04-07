package fx.sample;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class Main extends Application {

	private static String[] savedArgs;
	private ConfigurableApplicationContext context;

	@Override
	public void init() throws Exception {
		this.context=SpringApplication.run(Main.class, savedArgs);
	}

	@Override
	public void stop() throws Exception {
		context.close();
		System.gc();
		System.runFinalization();
	}
	
	private Object createControllerForType(Class<?> type) {
		return this.context.getBean(type);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
			loader.setControllerFactory(this::createControllerForType);
			Parent root = loader.load();
			Scene scene = new Scene(root,900,500);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			throw new IllegalStateException("Unable to load view:", e);
		}
	}

	public static void main(String[] args) {
		savedArgs=args;
		launch(args);
	}
}
