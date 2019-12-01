package tabs;

import javabeans.Category;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import tables.CategoriesTable;

import java.util.ArrayList;

public class CategoriesTab extends Tab {

    private static CategoriesTab instance = null;

    private CategoriesTab() {
    	
    	ArrayList<Category> categories = new CategoriesTable().getAllCategories();

        //Set up the List View
        Accordion accordion = new Accordion();
        accordion.setMaxHeight(200);

        for (Category category : categories) {
            TitledPane titledPane = new TitledPane(category.getTitle(), new Label(category.getDescription()));
            accordion.getPanes().add(titledPane);
        }

        //New Category Button
        Button newCategoryButton = new Button("Add Category");

        //Set up borderPane
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(accordion);
        mainPane.setBottom(newCategoryButton);

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
}