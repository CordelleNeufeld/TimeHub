import Objects.Database;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LoginPane extends VBox{

	public LoginPane() {
		Label promptLabel = new Label("Please enter your database login credentials");
	
		VBox labelsVBox = new VBox(25);
		
		Label hostLabel = new Label("Database Host");
		Label userLabel = new Label("Database User");
		Label passwordLabel = new Label("Database Password");
		Label nameLabel = new Label("Database Name");
		
		labelsVBox.getChildren().addAll(hostLabel, userLabel, passwordLabel, nameLabel);
		labelsVBox.setAlignment(Pos.CENTER);
		
		VBox textFieldVBox = new VBox(15);
		
		TextField hostTextField = new TextField();
		TextField userTextField = new TextField();
		TextField passwordTextField = new TextField();
		TextField nameTextField = new TextField();
		
		textFieldVBox.getChildren().addAll(hostTextField, userTextField, passwordTextField, nameTextField);
		textFieldVBox.setAlignment(Pos.CENTER);
		
		HBox labelsAndInputHBox = new HBox(15);
		labelsAndInputHBox.getChildren().addAll(labelsVBox, textFieldVBox);
		labelsAndInputHBox.setAlignment(Pos.CENTER);
		
		Button loginBtn = new Button("Login");

		//Error Text
		Text error = new Text("Login failed. Please Check your credentials.");
		error.setFill(Color.RED);
		error.setVisible(false);
		
		getChildren().addAll(promptLabel, labelsAndInputHBox, loginBtn);
		setSpacing(35);
		setAlignment(Pos.CENTER);

		//Button Listener
		loginBtn.setOnMouseClicked(e -> {
			if (Database.getInstance() == null) {
				error.setVisible(true);
			}
		});
	}
	
}