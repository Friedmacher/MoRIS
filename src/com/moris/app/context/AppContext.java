/*******************************************************************************
 * Copyright (c) 2020 Manuel Friedmacher
 *
 * This program and the accompanying materials
 * are made available under the terms of the GNU General Public License v3.0
 * which accompanies this distribution, and is available at
 * https://github.com/Friedmacher/MoRIS/blob/main/LICENSE
 *
 * Contributors:
 *     Manuel Friedmacher
 *******************************************************************************/
package com.moris.app.context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.moris.app.OpenWindow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class AppContext {
	
	private static AppContext contextInstance = null;
	
	// List of all open windows
	private ObservableList<OpenWindow> openWindows = FXCollections.observableArrayList();
	
	// Database
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	/*
	 * Constructor
	 */
	private AppContext() {}
	
	
	/*
	 * Singleton implementation
	 * only one instance of the context object should be available for the whole application
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
	 * Getter for entity manager factory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
	    return this.emf;
	}
	
	/*
	 * Setter for entity factory
	 */
	public void setEntityManagerFactory(EntityManagerFactory emf) {
	    this.emf = emf;
	}
	
	/*
	 * Getter for entity manager
	 */
	public EntityManager getEntityManager() {
	    return this.em;
	}
	
	/*
	 * Setter for entity manager
	 */
	public void setEntityManager(EntityManager em) {
	    this.em = em;
	}
	
	

}
