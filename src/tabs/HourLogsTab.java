package tabs;

import javabeans.Task;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class HourLogsTab extends Tab {

    private static HourLogsTab instance = null;

    private HourLogsTab(ArrayList<Task> tasks) {

        //Create Title
        Text tasksText = new Text("Tasks");

        //ListView for the Tasks
        ListView<HBox> listView = new ListView<>();

        //Populate the ListView
        for (Task task : tasks) {
            HBox taskInfoHBox = new HBox(30);

            Text dateText = new Text("Monday");
            Text hoursText = new Text("5");
            Text projectText = new Text("Project");

            taskInfoHBox.getChildren().addAll(dateText, hoursText, projectText);

            listView.getItems().add(taskInfoHBox);
        }

        //Create MainVBox
        VBox mainVBox = new VBox(tasksText, listView);

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