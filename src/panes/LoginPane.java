package panes;

import classes.Database;
import home.Main;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import scenes.TabsScene;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


/**
 * This class is for the login screen
 *
 * @author Hasan Muslemani
 */
public class LoginPane extends VBox {

    public static boolean failedLogin = false;

    /**
     * LoginPane no-arg constructor
     */
    public LoginPane() {

        ImageView loginImage = new ImageView(new Image("resources/sundial_500_525.png"));
        loginImage.setFitHeight(250);
        loginImage.setFitWidth(250);

        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(0);
        fade.setToValue(10);
        fade.setNode(loginImage);
        fade.play();

        Text introText = new Text("Welcome to TimeHub!");
        introText.setFont(new Font(50));

        //Set up labels
        Label promptLabel = new Label("Please enter your database login credentials");

        VBox labelsVBox = new VBox(25);

        Label hostLabel = new Label("Database Host");
        Label nameLabel = new Label("Database Name");
        Label userLabel = new Label("Database User");
        Label passwordLabel = new Label("Database Password");

        labelsVBox.getChildren().addAll(hostLabel, nameLabel, userLabel, passwordLabel);
        labelsVBox.setAlignment(Pos.CENTER);


        //Set up login Fields
        VBox textFieldVBox = new VBox(15);

        TextField hostTextField = new TextField();
        TextField nameTextField = new TextField();
        TextField userTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();


        textFieldVBox.getChildren().addAll(hostTextField, nameTextField, userTextField, passwordTextField);
        textFieldVBox.setAlignment(Pos.CENTER);


        //Put Labels and Login Fields Together
        HBox labelsAndInputHBox = new HBox(15);
        labelsAndInputHBox.getChildren().addAll(labelsVBox, textFieldVBox);
        labelsAndInputHBox.setAlignment(Pos.CENTER);


        //Errors (Setting Managed to false, if there is no error to display)
        Text error = new Text();
        error.setFill(Color.RED);
        if (failedLogin) {
            error.setText("Stored Database Credentials failed. Please re-enter your credentials.");
        } else {
            error.setManaged(false);
        }


        //Login Button
        Button loginBtn = new Button("Login");


        //Put everything on the screen
        getChildren().addAll(loginImage, introText, promptLabel, labelsAndInputHBox, error, loginBtn);
        setSpacing(35);
        setAlignment(Pos.CENTER);


        //Button Listener
        loginBtn.setOnMouseClicked(e -> {

            // TODO: This section was commented out by Hasan 2019-11-13
            // to provide a temporary bypass of the login screen direct to HomeTab


            try {
                List<String> lines = Arrays.asList(hostTextField.getText(), nameTextField.getText(), userTextField.getText(), passwordTextField.getText());
                Path file = Paths.get("config.txt");
                Files.write(file, lines, StandardCharsets.UTF_8);
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            if (Database.getInstance().getConnection() == null) {
                error.setText("Login failed. Please Check your database credentials.");
                error.setManaged(true);
            } else {
                Main.mainStage.setScene(new TabsScene());
                failedLogin = false;
            }

        });

        getStyleClass().add("root");
    }
}