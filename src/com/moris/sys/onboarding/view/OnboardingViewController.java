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
package com.moris.sys.onboarding.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;


public class OnboardingViewController {
    
    @FXML
    private AnchorPane viewOnboarding;

    @FXML
    private TitledPane pLogin;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfPasswordRepeate;

    @FXML
    private TitledPane pUser;

    @FXML
    private SplitMenuButton ddSalutation;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfMiddleName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TitledPane pCommunication;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfMobilePhone;

    @FXML
    private TitledPane pLicense;

    @FXML
    private TextField tfLicenseKey;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnContinue;

    @FXML
    void onButtonClick(ActionEvent event) {

    }

}
