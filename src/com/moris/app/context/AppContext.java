/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-12
 * 
 */
package com.moris.app.context;

import javax.persistence.EntityManager;

import com.moris.app.OpenWindow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class AppContext {
	
	private static AppContext contextInstance = null;
	
	// List of all open windows
	private ObservableList<OpenWindow> openWindows = FXCollections.observableArrayList();
	
	// Database 
	private EntityManager entityManager = null;
	
	/*
	 * Constructor
	 */
	private AppContext() {}
	
	
	/*
	 * Singleton implementation
	 * only one instance of the context object should be availabe for the whole application
	 */
	public static AppContext getInstance() {
		if (contextInstance == null) {
			contextInstance = new AppContext();
		}
		return contextInstance;
	}
	
	/*
	 * Add new window to the open windows list
	 */
	public OpenWindow addOpenWindow(String windowName, Stage dialogStage) {
		OpenWindow openWindow = new OpenWindow("First", dialogStage);
		openWindows.add(openWindow);
		return openWindow;
	}
	
	/*
	 * remove window from open windows list when closed
	 */
	public void removeOpenWindow(OpenWindow openWindow) {
		openWindows.remove(openWindow);
	}
	
	/*
	 * return a list of all open windows
	 */
	public ObservableList<OpenWindow> getOpenWindows() {
		return openWindows;
	}
	
	
	/*
	 * Getter for entity manager
	 */
	public EntityManager getEntityManager() {
	    return this.entityManager;
	}
	
	/*
	 * Setter for entity manager
	 */
	public void setEntityManager(EntityManager em) {
	    this.entityManager = em;
	}
	
	
	

}
