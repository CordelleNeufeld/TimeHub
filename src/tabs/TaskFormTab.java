package tabs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javabeans.Task;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import panes.TabsPane;
import tables.TasksTable;

public class TaskFormTab extends Tab {

    public TaskFormTab(Task task, int projectID) {

        //Create Task Label
        Label taskLabel = new Label("Task Creation Form");

        //Create Name and Descriptions Labels
        Label nameLabel = new Label("Name: ");
        Label descLabel = new Label("Description:");
        Label hourLabel = new Label("Hours:");

        //Create VBox for the Labels
        VBox labelsVBox = new VBox(25);
        labelsVBox.getChildren().addAll(nameLabel, descLabel, hourLabel);
        labelsVBox.setAlignment(Pos.CENTER);

        //Create Name and Description Inputs
        TextField nameInput = new TextField();
        TextField descInput = new TextField();
        TextField hourInput = new TextField();

        //Create VBox for Inputs
        VBox inputsVBox = new VBox(15);
        inputsVBox.getChildren().addAll(nameInput, descInput, hourInput);
        inputsVBox.setAlignment(Pos.CENTER);

        //Create HBox for Labels and Inputs
        HBox labelsAndInputsHBox = new HBox(15);
        labelsAndInputsHBox.getChildren().addAll(labelsVBox, inputsVBox);
        labelsAndInputsHBox.setAlignment(Pos.CENTER);

        //Create Error Text
        Text error = new Text("Name Field cannot be empty");
        error.setFill(Color.TRANSPARENT);
        error.setManaged(false);
        
        Text errorHours = new Text("Hour Field cannot be empty");
        errorHours.setFill(Color.TRANSPARENT);
        errorHours.setManaged(false);
        
        Text errorDate = new Text("Date Field cannot be empty");
        errorDate.setFill(Color.TRANSPARENT);
        errorDate.setManaged(false);
        
      //Create the date
        DatePicker date = new DatePicker();
        
        if(task != null) {
	        nameInput.setText(task.getTitle());
	        descInput.setText(task.getDescription());
	        hourInput.setText(task.getHours() + "");
	        LocalDate localDate = LocalDate.parse(task.getDate());
	        date.setValue(localDate);
        }

        //Create Submit Button
        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> {
            //Show Error if Necessary
            if (nameInput.getText().equals("")) {
            	error.setFill(Color.RED);
                error.setManaged(true);
            } else if (hourInput.getText().equals("")) {
            	error.setManaged(false);
                error.setFill(Color.TRANSPARENT);
            	errorHours.setFill(Color.RED);
            	errorHours.setManaged(true);
            } else if (date.getValue() == null) {
            	errorHours.setManaged(false);
            	errorHours.setFill(Color.TRANSPARENT);
            	errorDate.setFill(Color.RED);
            	errorDate.setManaged(true);
            }
            else if(task != null) {   	
            	Task updateTask = new Task(task.getId(), nameInput.getText(), descInput.getText(), date.getValue().toString(), Double.parseDouble(hourInput.getText()), projectID);
            	TasksTable taskTable = new TasksTable();
            	
            	taskTable.updateTask(updateTask);
            	TabsPane.tabPane.getTabs().remove(this);
            	
            	TasksTab.getInstance().refreshTable();
                TabsPane.tabPane.getSelectionModel().select(TasksTab.getInstance());
            }
            else {
                Task createTask = new Task(nameInput.getText(), descInput.getText(), date.getValue().toString(), Double.parseDouble(hourInput.getText()), projectID);
                TasksTable taskTable = new TasksTable();

                taskTable.createTask(createTask);
                TabsPane.tabPane.getTabs().remove(this);
                TasksTab.getInstance().refreshTable();
                TabsPane.tabPane.getSelectionModel().select(TasksTab.getInstance());
            }
        });

        //Create MainVBox
        VBox mainVBox = new VBox();
        mainVBox.getChildren().addAll(taskLabel, labelsAndInputsHBox, date, error, errorHours, errorDate, submitBtn);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(25);

        //Set Content and Styling of the Tab
        getStyleClass().add("root"); //stylesheet
        setContent(mainVBox);
        setText("Task Form");
        setClosable(true);
    }
}