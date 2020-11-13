/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-13
 * 
 */
package com.moris.app.init;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moris.app.context.AppContext;
import com.moris.sys.log.ILogger;
import com.moris.sys.login.Login;
import com.moris.sys.onboarding.Onboarding;

import javafx.application.Application;

public class Initialize {
    
    // Initialize Logger
    private static final Logger systemLogger = LogManager.getLogger(ILogger.SYSTEM_LOGGER);
    private static final Logger dbLogger = LogManager.getLogger(ILogger.DB_LOGGER);
    
    // Load application context
    private static final AppContext appContext = AppContext.getInstance();

    /**
     * Constructor
     */
    public Initialize() {
	systemLogger.debug("Application initialization started");
	
	// Initialize database
	initDatabase();
	
	// check if onboarding was already done
	if (isOnboarded()) {
	    systemLogger.debug("Onboarding done, start main application");
	    Application.launch(Login.class);
	} else {
	    systemLogger.debug("Onboarding missing, run onboarding process");
	    Application.launch(Onboarding.class);
	}
	
    }





    /**
     * Initialize database connection
     */
    private void initDatabase() {
	
//	AppContext appContext = AppContext.getInstance();
	
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MoRIS-Desktop");
	appContext.setEntityManagerFactory(emFactory);
	
	EntityManager entityManager = emFactory.createEntityManager();
	appContext.setEntityManager(entityManager);
	
	dbLogger.debug("Database connection established");

    }
    
    /**
     * Check if onboarding was already done
     */
    private Boolean isOnboarded() {
	
//	 EntityManager em = appContext.getEntityManager();
	
//	 // Get user object from database and check if password match
//	 em.getTransaction().begin();
//	 User myUser = em.find(User.class, tfUserName.getText());
//	 em.getTransaction().commit();

	return false;
    }


}
