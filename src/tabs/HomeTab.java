/*
 * Provide the user with a home screen
 *
 * @author Cordelle Neufeld
 * Creation date: 2019-11-06
 */

package tabs;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import panes.TabsPane;
import tables.TasksTable;

public class HomeTab extends Tab {

    private static HomeTab instance = null;

    private HomeTab() {
    	
    	ImageView homeImage = new ImageView(new Image("resources/sundial_home_500_310.png"));
    	
    	FadeTransition fade = new FadeTransition();  
    	fade.setDuration(Duration.millis(5000));  
    	fade.setFromValue(0);  
        fade.setToValue(10); 
        fade.setNode(homeImage);
        fade.play();
    	
        //Create Buttons for different Tabs
        Button categoriesButton = new Button("Categories");
        Button projectsButton = new Button("Projects");
        Button tasksButton = new Button("Tasks");
        
        categoriesButton.setMinSize(200, 60);
        projectsButton.setMinSize(200, 60);
        tasksButton.setMinSize(200, 60);

        //OnClickListeners to show the new tabs
        categoriesButton.setOnAction(e -> {
            CategoriesTab category = CategoriesTab.getInstance();
            if(!TabsPane.tabPane.getTabs().contains(category)) {
            	TabsPane.tabPane.getTabs().add(category);
            }
            TabsPane.tabPane.getSelectionModel().select(category);
        });

        projectsButton.setOnAction(e -> {
            ProjectsTab project = ProjectsTab.getInstance();
            if(!TabsPane.tabPane.getTabs().contains(project)) {
            	TabsPane.tabPane.getTabs().add(project);
            }
            TabsPane.tabPane.getSelectionModel().select(project);
        });

        tasksButton.setOnAction(e -> {
            TasksTab task = TasksTab.getInstance();
            if(!TabsPane.tabPane.getTabs().contains(task)) {
            	TabsPane.tabPane.getTabs().add(task);
            }
            TabsPane.tabPane.getSelectionModel().select(task);
        });

        //Create VBox to hold the Buttons
        VBox buttonsVBox = new VBox(50);
        buttonsVBox.getChildren().addAll(homeImage, categoriesButton, projectsButton, tasksButton);
        buttonsVBox.setAlignment(Pos.CENTER);

        //Set Content and Styles for the Tab
        setContent(buttonsVBox);
        setText("Home");
        setClosable(false);
    }

    public static HomeTab getInstance() {
        if (instance == null) {
            instance = new HomeTab();
        }

        return instance;
    }
}