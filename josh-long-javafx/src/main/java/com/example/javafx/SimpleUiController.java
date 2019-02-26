package com.example.javafx;



import org.springframework.stereotype.Component;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

@Component
public class SimpleUiController {
	private final HostServices hostServices;
	SimpleUiController(HostServices aHostservices) {
		this.hostServices=aHostservices;
	}
	@FXML
	public Label label;
	@FXML
	public Button button;

	@FXML
	public void initialize() {
		this.button.setOnAction(actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
	}
}
