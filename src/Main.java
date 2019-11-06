import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * TimeHub App
 * 
 * JAVA PROGRAMMING 3 FINAL PROJECT for Câi Filiault, Professor
 * 
 * Project Approval Date: 2019-10-22
 * Project Start Date: 2019-10-23
 * 
 * Project Partners:
 * Abel Anderson
 * Hasan Muslemani
 * Cordelle Neufeld
 * 
 * 
 */


public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//TODO: Check if config.txt exists, and try to access DB if it does
		primaryStage.setScene(new LoginScene());
		primaryStage.show();
	}

}

