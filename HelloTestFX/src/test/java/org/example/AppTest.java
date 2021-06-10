package org.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

import javax.swing.*;
import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
public class AppTest {
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    @Start
    private void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    @Test
    void testLableEmpty(FxRobot robot){
        FxAssert.verifyThat("#textField", TextInputControlMatchers.hasText(""));
    }

    @Test
    void testButtonText(FxRobot robot){
        FxAssert.verifyThat(".button", LabeledMatchers.hasText("Say Hello"));
    }
    @Test
    void testButtonClick(FxRobot robot){
        robot.clickOn(".button");
        FxAssert.verifyThat("#textField",TextInputControlMatchers.hasText("Hello World"));
    }
}
