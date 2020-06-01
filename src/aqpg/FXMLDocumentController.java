/*
 * This is the landing page of the application that gives 3 options: Sign in (btnIn), Sign up (btnUp), Admin login (btnAdmin)
 */
package aqpg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Abha Suntwal
 */
public class FXMLDocumentController implements Initializable, FxmlConstant {

    @FXML
    private Label label;
    @FXML
    private Button btnIn;
    @FXML
    private Button btnUp;
    @FXML
    private Button btnAdmin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void he(ActionEvent event) {

        if (event.getSource() == btnIn) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(SIGNIN_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnUp.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == btnUp) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(SIGNUP_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnIn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == btnAdmin) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(ADMIN_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnAdmin.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
