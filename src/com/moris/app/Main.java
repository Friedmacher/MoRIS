/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-12
 * 
 */
package com.moris.app;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moris.sys.log.ILogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    /*
     * Initialize Logger
     */
    private static final Logger mainLogger = LogManager.getLogger(ILogger.MAIN_LOGGER);
    private static final Logger dbLogger = LogManager.getLogger(ILogger.DB_LOGGER);

    /*
     * Constructor
     */
    public Main() {}
    
    /*
     * Main method
     */
    public static void main(String[] args) {
	mainLogger.debug("Application launching");
 	launch(args);
     }

    /*
     * JavaFX start method
     */
    @Override
    public void start(Stage primaryStage) {
	mainLogger.debug("Open Login view");
	
	initLoginView(primaryStage);

    }
    
    @Override
    public void stop() {
	mainLogger.debug("Application shutdown!");
    }

    /*
     * Initialize application and show Login view
     */
    public void initLoginView(Stage primaryStage) {	
	BorderPane rootLayout = null;
	
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(this.getClass().getResource(IMain.MAIN_APP_VIEW));

	try {
	    rootLayout = (BorderPane) loader.load();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	primaryStage.setTitle(IMain.MAIN_APP_TITLE);
	primaryStage.setScene(new Scene(rootLayout));
	primaryStage.centerOnScreen();
	primaryStage.show();
    }
    

}

 
