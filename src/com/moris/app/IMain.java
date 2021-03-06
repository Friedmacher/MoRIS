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
package com.moris.app;

public interface IMain {
    
    public static final String MAIN_APP_VIEW = "/com/moris/app/view/MainView.fxml";
    public static final String VIEW_APP_VIEW_ID = "viewMain";
    public static final String MAIN_APP_TITLE = "MoRIS";
    
    public static final String ONBOARD_VIEW = "/com/moris/sys/onboarding/view/OnboardingView.fxml";
    public static final String ONBOARD_VIEW_ID = "viewOnboarding";
    public static final String ONBOARD_TITLE = "Onboarding";

    
    public static final String LOGIN_VIEW = "/com/moris/sys/login/view/LoginView.fxml";
    public static final String LOGIN_VIEW_ID = "viewLogin";
    public static final String LOGIN_TITLE = "Login";
    
    public static final String VIEW_BUPA_OVERVIEW = "/com/moris/bupa/view/BusinessPartnerOverviewView.fxml";
    public static final String VIEW_BUPA_OVERVIEW_ID = "viewBusinessPartner";
    public static final String VIEW_BUPA_OVERVIEW_NAME = "Business Partner";
    
    public static final String VIEW_MM_OVERVIEW = "/com/moris/mm/view/MaterialMasterOverviewView.fxml";
    public static final String VIEW_MM_OVERVIEW_ID = "viewMaterialMaster";
    public static final String VIEW_MM_OVERVIEW_NAME = "Material Master";



}
