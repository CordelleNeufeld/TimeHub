package tabs;

import java.util.ArrayList;

import javabeans.Task;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HourLogsTab extends Tab{
	
	public HourLogsTab(ArrayList<Task> tasks) {
		Text tasksText = new Text("Tasks");
		
		//listview for all the tasks
		ListView<HBox> listView = new ListView<>();
		
		//for each to loop through the tasks arraylist
		for(Task task : tasks) {
			//hbox for the tasks information
			HBox taskInfosHBox = new HBox(30);
			
			//texts for the tasks info
			Text dateText = new Text("Monday");
			Text hoursText = new Text("5");
			Text projectText = new Text("Project");
			
			//add all the tasks info to the hbox
			taskInfosHBox.getChildren().addAll(dateText, hoursText, projectText);
			
			//add the hbox to the listview
			listView.getItems().add(taskInfosHBox);
		}
		
		//set the content of the tab to the listview and the title to Hour Logs
		this.setContent(listView);
		this.setText("Hour Logs");
	}

}
