/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-12
 * 
 */
package com.moris.app;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moris.app.context.AppContext;
import com.moris.sys.log.ILogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

	initDatabase();
	
	initLoginView(primaryStage);

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
    
    /*
     * Initialize database connection
     */
    public void initDatabase() {
	
	AppContext appContext = AppContext.getInstance();
	
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MoRIS-Desktop");
	EntityManager entityManager = emFactory.createEntityManager();
	appContext.setEntityManager(entityManager);
	dbLogger.debug("Database connection established");

    }

}

 
