/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-12
 * 
 */
package com.moris.app.view;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moris.app.IMain;
import com.moris.app.Main;
import com.moris.app.OpenWindow;
import com.moris.app.context.AppContext;
import com.moris.sys.log.ILogger;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainViewController {
    
    private static final Logger logger = LogManager.getLogger(ILogger.MAIN_LOGGER);

    @FXML
    private ImageView viewBusinessPartner;

    @FXML
    private ImageView viewMaterialMaster;

    @FXML
    private ImageView viewPreferences;


    /*
     * Handler for left menu bar
     * open module application windows
     */
    @FXML
    void onLeftBarClicked(MouseEvent event) {
	if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
	    ImageView leftBarSource = (ImageView) event.getSource();
	    switch (leftBarSource.getId()) {
	    case IMain.VIEW_BUPA_OVERVIEW_ID:
		System.out.println(IMain.VIEW_BUPA_OVERVIEW_NAME);
		openWindow(IMain.VIEW_BUPA_OVERVIEW, IMain.VIEW_BUPA_OVERVIEW_NAME);
		break;
	    case IMain.VIEW_MM_OVERVIEW_ID:
		System.out.println(IMain.VIEW_MM_OVERVIEW_NAME);
		openWindow(IMain.VIEW_MM_OVERVIEW, IMain.VIEW_MM_OVERVIEW_NAME);
		break;
	    default:
		break;
	    }
	}
    }

    /*
     * Generic method to open new application windows
     * store the window instance in an list
     * keep open window list up-to-date if an module window is closed
     */
    public void openWindow(String ressourceToOpen, String windowName) {
	AppContext appContext = AppContext.getInstance();
	FXMLLoader loader = new FXMLLoader();

	try {
	    loader.setLocation(Main.class.getResource(ressourceToOpen));
	    AnchorPane page = (AnchorPane) loader.load();
	    Stage dialogStage = new Stage();
	    OpenWindow openWindow = appContext.addOpenWindow(windowName, dialogStage);
	    dialogStage.setTitle(windowName);
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(page));
	    dialogStage.show();
	    dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		public void handle(WindowEvent we) {
		    logger.info(openWindow);
		    System.out.println(openWindow);
		    appContext.removeOpenWindow(openWindow);
		    
		    logger.info(appContext.getOpenWindows());
		    System.out.println(appContext.getOpenWindows());
		}
	    }); 
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	logger.info(appContext.getOpenWindows());
	System.out.println(appContext.getOpenWindows());

    }



}
