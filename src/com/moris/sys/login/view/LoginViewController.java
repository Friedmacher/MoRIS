/**
 * @author FRIEDMACHER, Manuel
 * created on: 2020-11-12
 * 
 */package com.moris.sys.login.view;

 import javax.persistence.EntityManager;

 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;

 import com.moris.app.context.AppContext;
 import com.moris.sys.log.ILogger;
 import com.moris.sys.login.model.User;

 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.PasswordField;
 import javafx.scene.control.ProgressBar;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

 public class LoginViewController {
     private static final Logger systemLogger = LogManager.getLogger(ILogger.SYSTEM_LOGGER);

     @FXML
     private AnchorPane viewLogin;

     @FXML
     private TextField tfUserName;

     @FXML
     private PasswordField tfPassword;

     @FXML
     private Button btnLogin;

     @FXML
     private Text tfStatusMessage;

     @FXML
     private ProgressBar pbInit;

     @FXML
     void initialize() {
	 systemLogger.debug("Login view launched");

	 // Hide status text
	 tfStatusMessage.setVisible(false);
	 
	 // Hide progress bar
	 pbInit.setVisible(false);

     }

     @FXML
     void onLoginBtnClick(ActionEvent event) {
	 processLogin();
     }
     
     /*
      * Process login, check user name and password
      * on success open the main view
      * on failure show and log an error message
      */
     void processLogin() {
	 // Initialize password encoder
	 PasswordEncoder pwEncoder = new BCryptPasswordEncoder();

	 // Get application context and get entity manager
	 AppContext appContext = AppContext.getInstance();
	 EntityManager em = appContext.getEntityManager();

	 // Get user object from database and check if password match
	 em.getTransaction().begin();
	 User myUser = em.find(User.class, tfUserName.getText());
	 em.getTransaction().commit();
	 
	 if (myUser != null) {
	     if (pwEncoder.matches(tfPassword.getText(), myUser.getPassword())) {
		 systemLogger.debug("Login successfull with username: " + tfUserName.getText());
		 tfStatusMessage.setVisible(true);
		 tfStatusMessage.setFill(Color.GREEN);
		 tfStatusMessage.setText("Login successfull!");	     
	     } else {
		 systemLogger.debug("Login failed with username: " + tfUserName.getText());
		 tfStatusMessage.setVisible(true);
		 tfStatusMessage.setFill(Color.RED);
		 tfStatusMessage.setText("Failed to login!");
	     }
	 } else {
	     systemLogger.debug("User not found: " + tfUserName.getText());
	     tfStatusMessage.setVisible(true);
	     tfStatusMessage.setFill(Color.RED);
	     tfStatusMessage.setText("User not found!");
	 }
	 
     }



 }
