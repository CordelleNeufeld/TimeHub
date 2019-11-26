package tabs;

import javabeans.Project;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProjectOverviewTab extends Tab {

    public ProjectOverviewTab(Project project) {

        //Create Form Fields
        Text projectName = new Text(project.getTitle());
        TextArea projectDesc = new TextArea(project.getDescription());
        Button addProject = new Button("Add Project");

        //Create the LeftVBox
        VBox leftVBox = new VBox(30);
        leftVBox.getChildren().addAll(projectName, projectDesc, addProject);

        //Create tabPane
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(new Tab("Tab 1"), new Tab("Tab 2"));

        //Create MainHBox
        HBox mainHBox = new HBox(30);
        mainHBox.getChildren().addAll(leftVBox, tabPane);

        //Set Content and Styling of the Tab
        setContent(mainHBox);
        setText("Project Overview");
        setClosable(true);
    }
}