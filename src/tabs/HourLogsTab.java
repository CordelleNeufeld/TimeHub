package tabs;

import javabeans.Task;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import panes.TabsPane;

import java.util.ArrayList;

import classes.Database;

public class HourLogsTab extends Tab {

    private static HourLogsTab instance = null;

    private HourLogsTab(ArrayList<Task> tasks) {

        //Create Title
        Text tasksText = new Text("Tasks");
        Button addTask = new Button("Add Task");
        
        addTask.setOnAction(e -> TabsPane.tabPane.getTabs().add(new TaskFormTab(1)));

        //ListView for the Tasks
        ListView<HBox> listView = new ListView<>();

        //Populate the ListView
        for (Task task : tasks) {
            HBox taskInfoHBox = new HBox(30);

            Text taskName = new Text(task.getTitle());
            
            
            
            Text taskHours = new Text("15");
            Text taskDescription = new Text(task.getDescription());
   

            taskInfoHBox.getChildren().addAll(taskName, taskHours, taskDescription);

            listView.getItems().add(taskInfoHBox);
        }

        //Create MainVBox
        VBox mainVBox = new VBox(tasksText, listView, addTask);

        //Set the Content and Styling of the Tab
        setContent(mainVBox);
        setText("Hour Logs");
        setClosable(true);
    }

    public static HourLogsTab getInstance(ArrayList<Task> tasks) {
        if (instance == null) {
            instance = new HourLogsTab(tasks);
        }

        return instance;
    }
}