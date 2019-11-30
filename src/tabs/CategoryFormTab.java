package tabs;

import javabeans.Category;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import panes.TabsPane;
import tables.CategoriesTable;

public class CategoryFormTab extends Tab {

    public CategoryFormTab() {
        //Task Label
        Label taskLabel = new Label("Category Creation Form");

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

        //Error Text if no name is entered
        Text error = new Text("Name field cannot be empty");
        error.setFill(Color.RED);
        error.setManaged(false);

        //Create and Populate the Main VBox
        VBox mainVBox = new VBox();
        mainVBox.getChildren().addAll(taskLabel, labelsAndInputsHBox);

        //Create the SubmitButton
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            //Show Error if needed
            if (nameInput.getText().equals("")) {
                error.setManaged(true);
            } else {
                CategoriesTable categoriesTable = new CategoriesTable();
                Category newCategory = new Category(0, nameInput.getText(), descInput.getText());

                categoriesTable.createCategory(newCategory);
                TabsPane.tabPane.getTabs().add(CategoriesTab.getInstance(categoriesTable.getAllCategories()));
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