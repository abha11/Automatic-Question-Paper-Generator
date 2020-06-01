/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aqpg;

import static aqpg.FxmlConstant.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abha Suntwal
 */
public class AdminPageController implements Initializable {

    @FXML
    private Button btnData;
    @FXML
    private Button btnLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnData) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(DATASET));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnData.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == btnLogout) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(LANDING_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnData.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
