package tabs;

import javabeans.Category;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import panes.TabsPane;
import tables.CategoriesTable;

import java.util.ArrayList;

public class CategoriesTab extends Tab {

    private static CategoriesTab instance = null;

    private CategoriesTab() {
    	ArrayList<Category> categories = new CategoriesTable().getAllCategories();

    	ImageView catImage = new ImageView(new Image("resources/sundial_nav_400_280.png"));
    	catImage.setFitWidth(240);
    	catImage.setFitHeight(168);
    	
        Text title = new Text("Categories");
        title.setFont(Font.font("Courier New",FontWeight.BOLD, 30));
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
        VBox mainPane = new VBox(45);
        mainPane.getChildren().addAll(catImage, title, newCategoryButton, accordion);
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setPadding(new Insets(20, 0, 0, 0));

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