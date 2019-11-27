package tabs;

import javabeans.Project;
import javabeans.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import panes.TabsPane;
import tables.TasksTable;

public class TaskFormTab extends Tab {

    public TaskFormTab(Project project) {

        //Create Task Label
        Label taskLabel = new Label("Task Creation Form");

        //Create Name and Descriptions Labels
        Label nameLabel = new Label("Name: ");
        Label descLabel = new Label("Description:");

        //Create VBox for the Labels
        VBox labelsVBox = new VBox(25);
        labelsVBox.getChildren().addAll(nameLabel, descLabel);
        labelsVBox.setAlignment(Pos.CENTER);

        //Create Name and Description Inputs
        TextField nameInput = new TextField();
        TextField descInput = new TextField();

        //Create VBox for Inputs
        VBox inputsVBox = new VBox(15);
        inputsVBox.getChildren().addAll(nameInput, descInput);
        inputsVBox.setAlignment(Pos.CENTER);

        //Create HBox for Labels and Inputs
        HBox labelsAndInputsHBox = new HBox(15);
        labelsAndInputsHBox.getChildren().addAll(labelsVBox, inputsVBox);
        labelsAndInputsHBox.setAlignment(Pos.CENTER);

        //Create Error Text
        Text error = new Text("Name field cannot be empty");
        error.setFill(Color.RED);
        error.setManaged(false);
        
        //Create the date
        DatePicker date = new DatePicker();

        //Create Submit Button
        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> {
            //Show Error if Necessary
            if (nameInput.getText().equals("")) {
                error.setManaged(true);
            } else {
                Task task = new Task(nameInput.getText(), descInput.getText(), null, 0, project.getId());
                TasksTable taskTable = new TasksTable();
                
                taskTable.createTask(task);
                TabsPane.tabPane.getTabs().remove(TabsPane.tabPane.getSelectionModel().getSelectedIndex());
            }
        });

        //Create MainVBox
        VBox mainVBox = new VBox();
        mainVBox.getChildren().addAll(taskLabel, labelsAndInputsHBox, date, error, submitBtn);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(25);

        //Set Content and Styling of the Tab
        setContent(mainVBox);
        setText("Task Form");
        setClosable(true);
    }
}