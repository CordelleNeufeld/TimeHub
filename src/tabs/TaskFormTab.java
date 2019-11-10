package tabs;

import javabeans.Project;
import javabeans.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TaskFormTab extends Tab{
	
	public TaskFormTab(Project project) {
		
		//the vbox to hold everything
		VBox mainVBox = new VBox();
		
		//task label
		Label taskLabel = new Label("Task Creation Form");
		
		//vbox for the labels
		VBox labelsVBox = new VBox(25);
		
		//labels
		Label nameLabel = new Label("Name: ");
		Label descLabel = new Label("Description:");
		
		//add labels to vbox and center it
		labelsVBox.getChildren().addAll(nameLabel, descLabel);
		labelsVBox.setAlignment(Pos.CENTER);
		
		//vbox for the inputs
		VBox inputsVBox = new VBox(15);
		
		//inputs
		TextField nameInput = new TextField();
		TextField descInput = new TextField();
		
		//add inputs to the vbox and center it
		inputsVBox.getChildren().addAll(nameInput, descInput);
		inputsVBox.setAlignment(Pos.CENTER);
		
		//added inputs and labels vbox into an hbox
		HBox labelsAndInputsHBox = new HBox(15);
		labelsAndInputsHBox.getChildren().addAll(labelsVBox, inputsVBox);
		labelsAndInputsHBox.setAlignment(Pos.CENTER);
		
		//button for submit
		Button submitBtn = new Button("Submit");
		
		//error that will show if user enters wrong values
		Text error = new Text("Name field cannot be empty");
        error.setFill(Color.RED);
        error.setManaged(false);
		
        //add everything to the vbox
        mainVBox.getChildren().addAll(taskLabel, labelsAndInputsHBox, error, submitBtn);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(25);
        
        //add the vbox to the tab and add title 
        this.setContent(mainVBox);
        this.setText("Task Form");
				
        //submit button on-click listener
		submitBtn.setOnAction(e -> {
			//give error if name field is empty
			if(nameInput.getText().equals("")) {
				error.setManaged(true);
			}
			
			//Make a new Task object
			Task task = new Task(project, null, nameInput.getText(), descInput.getText());
		});
		
	}

}