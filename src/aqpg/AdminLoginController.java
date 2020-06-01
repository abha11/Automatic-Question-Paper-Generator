/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aqpg;

import QPBean.admin;
import QPDAO.adminDAO;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Abha Suntwal
 */
public class AdminLoginController implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void he(ActionEvent event) {

        if (event.getSource() == loginBtn) {
            try {
                admin m1 = adminDAO.validate_login(txtName.getText(), txtPass.getText(), txtCode.getText());
                if (m1 == null) {
                    JOptionPane.showMessageDialog(null, "Incorrect UserName or Password!");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Succesfully Logged In!");
                Parent root = FXMLLoader.load(getClass().getResource(ADMIN_PAGE));
                Scene scene = new Scene(root);
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == cancelBtn) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(LANDING_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) cancelBtn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
