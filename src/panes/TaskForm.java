package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TaskForm extends VBox {
	
	public TaskForm() {
		
		Label taskLabel = new Label("Task Creation Form");
		
		VBox labelsVBox = new VBox(25);
		
		Label nameLabel = new Label("Name: ");
		Label descLabel = new Label("Description:");
		
		labelsVBox.getChildren().addAll(nameLabel, descLabel);
		labelsVBox.setAlignment(Pos.CENTER);
		
		VBox inputsVBox = new VBox(15);
		
		TextField nameInput = new TextField();
		TextField descInput = new TextField();
		
		inputsVBox.getChildren().addAll(nameInput, descInput);
		inputsVBox.setAlignment(Pos.CENTER);
		
		HBox labelsAndInputsHBox = new HBox(15);
		labelsAndInputsHBox.getChildren().addAll(labelsVBox, inputsVBox);
		labelsAndInputsHBox.setAlignment(Pos.CENTER);
		
		Button submitBtn = new Button("Submit");
		
		Text error = new Text("Name field cannot be empty");
        error.setFill(Color.RED);
        error.setManaged(false);
		
		this.getChildren().addAll(taskLabel, labelsAndInputsHBox, error, submitBtn);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(25);
				
		submitBtn.setOnAction(e -> {
			if(nameInput.getText().equals("")) {
				error.setManaged(true);
			}
			
			//TODO: Make new Task object and assign
			//TODO: Make Project object
		});
		
	}

}
