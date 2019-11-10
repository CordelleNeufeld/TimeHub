package panes;

import classes.Database;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is for the login screen
 *
 * @author Hasan Muslemani
 */
public class LoginPane extends VBox {

    private Pattern alphaNumericPattern = Pattern.compile("^[a-zA-Z0-9 ]*$");
    private Pattern hostPattern = Pattern.compile("^[a-zA-Z .]*$");

    /**
     * LoginPane no-arg constructor
     */
    public LoginPane() {

        //Set up labels
        Label promptLabel = new Label("Please enter your database login credentials");

        VBox labelsVBox = new VBox(25);

        Label hostLabel = new Label("Database Host");
        Label userLabel = new Label("Database User");
        Label passwordLabel = new Label("Database Password");
        Label nameLabel = new Label("Database Name");

        labelsVBox.getChildren().addAll(hostLabel, userLabel, passwordLabel, nameLabel);
        labelsVBox.setAlignment(Pos.CENTER);


        //Set up login Fields
        VBox textFieldVBox = new VBox(15);

        TextField hostTextField = new TextField();
        TextField userTextField = new TextField();
        TextField passwordTextField = new TextField();
        TextField nameTextField = new TextField();

        textFieldVBox.getChildren().addAll(hostTextField, userTextField, passwordTextField, nameTextField);
        textFieldVBox.setAlignment(Pos.CENTER);


        //Put Labels and Login Fields Together
        HBox labelsAndInputHBox = new HBox(15);
        labelsAndInputHBox.getChildren().addAll(labelsVBox, textFieldVBox);
        labelsAndInputHBox.setAlignment(Pos.CENTER);


        //Errors (Make sure to set 'Managed' to false)
        Text error = new Text();
        error.setFill(Color.RED);
        error.setManaged(false);


        //Login Button
        Button loginBtn = new Button("Login");


        //Put everything on the screen
        getChildren().addAll(promptLabel, labelsAndInputHBox, error, loginBtn);
        setSpacing(35);
        setAlignment(Pos.CENTER);


        //Button Listener
        loginBtn.setOnMouseClicked(e -> {
            Matcher hostMatch = hostPattern.matcher(hostTextField.getText());
            Matcher userMatch = alphaNumericPattern.matcher(userTextField.getText());
            Matcher passwordMatch = alphaNumericPattern.matcher(passwordTextField.getText());
            Matcher nameMatch = alphaNumericPattern.matcher(nameTextField.getText());

            if (!hostMatch.matches()) {
                error.setText("Please check that the host field contains only letters and periods.");
                error.setManaged(true);
            } else if (!userMatch.matches()) {
                error.setText("Please check that the user field contains only letters and numbers.");
                error.setManaged(true);
            } else if (!passwordMatch.matches()) {
                error.setText("Please check that the database password field contains only letters and numbers");
                error.setManaged(true);
            } else if (!nameMatch.matches()) {
                error.setText("Please check that the database name field does not contain any invalid characters.");
                error.setManaged(true);
            } else {
                try {
                    List<String> lines = Arrays.asList(hostTextField.getText(), userTextField.getText(), passwordTextField.getText(), nameTextField.getText());
                    Path file = Paths.get("config.txt");
                    Files.write(file, lines, StandardCharsets.UTF_8);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

                if (Database.getInstance() == null) {
                    error.setText("Login failed. Please Check your database credentials.");
                    error.setManaged(true);
                }
            }
        });
    }
}