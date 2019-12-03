package tabs;

import javabeans.Category;
import javabeans.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import panes.TabsPane;
import tables.CategoriesTable;
import tables.ProjectCategoriesTable;
import tables.ProjectsTable;

import java.util.ArrayList;

public class ProjectFormTab extends Tab {

    public ProjectFormTab() {

        CategoriesTable catTable = new CategoriesTable();
        ArrayList<Category> categories = catTable.getAllCategories();

        //Task Label
        Label taskLabel = new Label("Project Creation Form");

        //Name and Description Labels
        Label nameLabel = new Label("Name: ");
        Label descLabel = new Label("Description:");

        //Create VBox for the Labels
        VBox labelsVBox = new VBox(25);
        labelsVBox.getChildren().addAll(nameLabel, descLabel);
        labelsVBox.setAlignment(Pos.CENTER);

        //Name and Description Input
        TextField nameInput = new TextField();
        TextField descInput = new TextField();

        //Create VBox for the Inputs
        VBox inputsVBox = new VBox(15);
        inputsVBox.getChildren().addAll(nameInput, descInput);
        inputsVBox.setAlignment(Pos.CENTER);

        //Create HBox for Labels and Inputs
        HBox labelsAndInputsHBox = new HBox(15);
        labelsAndInputsHBox.getChildren().addAll(labelsVBox, inputsVBox);
        labelsAndInputsHBox.setAlignment(Pos.CENTER);
        
        //Create ComboBox for all the categories
        
        ArrayList<Category> categoriesList = new CategoriesTable().getAllCategories();
        ArrayList<String> categoriesStrings = new ArrayList<>();
        
        for(Category category : categoriesList) {
        	categoriesStrings.add(category.getTitle());
        }
        
        ComboBox<String> categoriesCombo = new ComboBox<>(FXCollections.observableArrayList(categoriesStrings));
        
        
        //Error Text if no name is entered
        Text error = new Text("Name field cannot be empty");
        error.setFill(Color.TRANSPARENT);
        error.setManaged(false);

        //Create and Populate the Main VBox
        VBox mainVBox = new VBox();
        mainVBox.getChildren().addAll(taskLabel, labelsAndInputsHBox, categoriesCombo);

        //Create the SubmitButton
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            //Show Error if needed
            if (nameInput.getText().equals("")) {
            	error.setFill(Color.RED);
                error.setManaged(true);
            } else {
                ProjectsTable projectTable = new ProjectsTable();
                Project project = new Project(categories, null, nameInput.getText(), descInput.getText());
                
                ProjectCategoriesTable projectCategoriesTable = new ProjectCategoriesTable();
                
                int projectID = projectTable.createProject(project);
                if (categoriesCombo.getSelectionModel().getSelectedItem() != null) {
                	projectCategoriesTable.insertProjectCategory(categoriesList.get(categoriesCombo.getSelectionModel().getSelectedIndex()).getId(), projectID);
                }

                TabsPane.tabPane.getTabs().remove(this);
                TabsPane.tabPane.getTabs().remove(ProjectsTab.getInstance());
                TabsPane.tabPane.getTabs().add(ProjectsTab.refresh());
                TabsPane.tabPane.getSelectionModel().select(ProjectsTab.getInstance());
            }
        });

        //Add the Error and Submit Nodes and Style the VBox
        mainVBox.getChildren().addAll(error, submitButton);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setSpacing(25);

        //Set Content and Styling for the Tab
        setContent(mainVBox);
        setText("Project Form");
        setClosable(true);
    }
}