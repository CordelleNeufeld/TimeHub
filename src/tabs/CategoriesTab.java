package tabs;

import javabeans.Category;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import panes.TabsPane;
import tables.CategoriesTable;

import java.util.ArrayList;

public class CategoriesTab extends Tab {

    private static CategoriesTab instance = null;

    private CategoriesTab() {
    	ArrayList<Category> categories = new CategoriesTable().getAllCategories();

        Text title = new Text("Categories");
        title.setTextAlignment(TextAlignment.CENTER);

        //Set up the List View
        Accordion accordion = new Accordion();
        accordion.setMaxHeight(300);
        accordion.setMaxWidth(500);

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

        //Set up VBox
        VBox mainPane = new VBox();
        mainPane.getChildren().addAll(title, newCategoryButton, accordion);
        mainPane.setSpacing(100);
        mainPane.setAlignment(Pos.CENTER);

        //Add content to Tab
        setContent(mainPane);
        setText("Categories");
		setClosable(false);

    }

    public static CategoriesTab getInstance() {
        if (instance == null) {
            instance = new CategoriesTab();
        }

        return instance;
    }

    public static CategoriesTab refresh() {
        instance = new CategoriesTab();
        return instance;
    }
}