package home;
import classes.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import panes.LoginPane;
import scenes.LoginScene;
import scenes.TabsScene;

import java.io.File;

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
 * Modification date: 2019-11-01 by Hasan for the panes.LoginPane
 */

public class Main extends Application {
	
	public static Stage mainStage;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		if(new File("config.txt").exists()) {
			if(Database.getInstance().getConnection() != null) {
				mainStage.setScene(new TabsScene());
			} else {
				LoginPane.failedLogin = true;
				mainStage.setScene(new LoginScene());
			}
		} else {
			mainStage.setScene(new LoginScene());
		}

		mainStage.show();
	}
}

