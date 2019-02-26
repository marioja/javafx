package com.example.javafx;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {

	private final String applicationTitle;
	private final Resource fxml;
	private final ApplicationContext ac;
	
	StageListener(
			@Value("${spring.application.ui.title}") String anApplicationTitle,
			@Value("classpath:/ui.fxml") Resource anFxml, ApplicationContext anAc) {
		this.applicationTitle=anApplicationTitle;
		this.fxml=anFxml;
		this.ac=anAc;
	}
	
	@Override
	public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
		Stage stage=stageReadyEvent.getStage();
		try {
			URL url = this.fxml.getURL();
			FXMLLoader fxmlLoader = new FXMLLoader(url);
			fxmlLoader.setControllerFactory(ac::getBean);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, 600,600);
			stage.setScene(scene);
			stage.setTitle(applicationTitle);
			stage.show();
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
