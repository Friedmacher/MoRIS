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
