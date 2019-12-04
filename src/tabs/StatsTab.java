/*
 * Provide the user with statistics
 *
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import java.util.ArrayList;

import javabeans.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import tables.ProjectsTable;
import tables.TasksTable;

public class StatsTab extends Tab {

    private static StatsTab instance = null;
    private PieChart chart;

    private StatsTab() {
    	
    	BorderPane pane = new BorderPane();
    	chart = new PieChart();
    	chart.setTitle("Project Hours");
    	chart.setLabelsVisible(true);
    	generateChart();
    	pane.setCenter(chart);
    	
    	setContent(pane);
        setText("Stats");
        setClosable(false);
    }

    public static StatsTab getInstance() {
        if (instance == null) {
            instance = new StatsTab();
        }

        return instance;
    }
    
    public void generateChart() {
    	
    	ProjectsTable projectTable = new ProjectsTable();
    	TasksTable taskTable = new TasksTable();
    	
    	
    	ArrayList<Project> projects = projectTable.getAllProjects();
    	
    	chart.getData().clear();
    	ArrayList<PieChart.Data> data = new ArrayList<>();
    	
    	for(Project project : projects) {
    		double hours = taskTable.getAllHours(project.getId());
    		if(hours != 0) {
    			data.add(new PieChart.Data(project.getTitle(), hours));
    		}
    	}
    	
    	ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(data);
    	chart.setData(chartData);
    	
    }
    
}