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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWindow {

    private StringProperty windowName;
    private Stage dialogStage;

    /*
     * Protected constructor, not to be used
     */
    protected OpenWindow() {}

    /*
     * Constructor
     */
    public OpenWindow(String windowName, Stage dialogStage) {
	this.windowName = new SimpleStringProperty(windowName);
	this.dialogStage = dialogStage;
    }

}
