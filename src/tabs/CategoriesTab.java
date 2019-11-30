package tabs;

import javabeans.Category;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import panes.TabsPane;

import java.util.ArrayList;

public class CategoriesTab extends Tab {

    private static CategoriesTab instance = null;

    private CategoriesTab(ArrayList<Category> categories) {
        //Title
        Text projectsTitle = new Text("Projects");
        projectsTitle.setTextAlignment(TextAlignment.CENTER);

        //Set up the List View
        Accordion accordion = new Accordion();

        for (Category category : categories) {
            TitledPane titledPane = new TitledPane(category.getTitle(), new Label(category.getDescription()));
            accordion.getPanes().add(titledPane);
        }

        //New Category Button
        Button newCategoryButton = new Button("Add Category");

        newCategoryButton.setOnAction(e -> {
            CategoryFormTab formTab = new CategoryFormTab();
            TabsPane.tabPane.getTabs().add(formTab);
            TabsPane.tabPane.getSelectionModel().select(formTab);
        });

        //Set up borderPane
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(projectsTitle);
        mainPane.setCenter(accordion);
        mainPane.setBottom(newCategoryButton);

        //Add content to Tab
        setContent(mainPane);
        setText("Categories");
        this.setClosable(true);
    }

    public static CategoriesTab getInstance(ArrayList<Category> categories) {
        if (instance == null) {
            instance = new CategoriesTab(categories);
        }

        return instance;
    }
}