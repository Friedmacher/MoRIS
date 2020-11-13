/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-13
 * 
 */
package com.moris.sys.login;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moris.app.IMain;
import com.moris.sys.log.ILogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login extends Application {
    /*
     * Initialize Logger
     */
    private static final Logger systemLogger = LogManager.getLogger(ILogger.SYSTEM_LOGGER);

    /**
     * @param args
     */
    public static void main(String[] args) {
	systemLogger.debug("Logion launching");
 	launch(args);
    }
    
    /*
     * JavaFX start method
     */
    @Override
    public void start(Stage primaryStage) {
	systemLogger.debug("Start with login process");
	
	// Start login process
	initLoginView(primaryStage);

    }
    
    @Override
    public void stop() {
	systemLogger.debug("End login process");
    }
    
    /*
     * Initialize application and show Login view
     */
    public void initLoginView(Stage primaryStage) {	
	AnchorPane rootLayout = null;
	
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(this.getClass().getResource(IMain.LOGIN_VIEW));

	try {
	    rootLayout = (AnchorPane) loader.load();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	primaryStage.setTitle(IMain.LOGIN_TITLE);
	primaryStage.setScene(new Scene(rootLayout));
	primaryStage.initStyle(StageStyle.UNDECORATED);
	primaryStage.setResizable(false);
	primaryStage.centerOnScreen();
	primaryStage.show();
    }
    



}
