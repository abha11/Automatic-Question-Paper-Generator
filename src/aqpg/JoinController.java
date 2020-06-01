/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aqpg;

import QPBean.myUser;
import QPDAO.MyuserDAO;
import static aqpg.FxmlConstant.LANDING_FXML;
import static aqpg.FxmlConstant.SIGNIN_FXML;
import static aqpg.FxmlConstant.SIGNUP_FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Abha Suntwal
 */
public class JoinController implements Initializable {

    @FXML
    private Button signInBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField txtConfirm;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtContact;
    @FXML
    private TextField txtSubject;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtDesignation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == signInBtn) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(SIGNIN_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) signInBtn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == registerBtn) {
            try {
                if (txtConfirm.getText() != txtPassword.getText()) {
                    JOptionPane.showMessageDialog(null, "Password don't match!");
                    return;
                }
                myUser m1 = new myUser();
                m1.setName(txtName.getText());
                m1.setDesignation(txtDesignation.getText());
                m1.setSubject(txtSubject.getText());
                m1.setEmail(txtEmail.getText());
                m1.setPhone_no(txtContact.getText());
                m1.setPassword(txtPassword.getText());
                int out = MyuserDAO.insert(m1);
                if (out != 1) {
                    JOptionPane.showMessageDialog(null, "Server Error! Unable to register.");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Registered successfully!");
                Parent root = FXMLLoader.load(getClass().getResource(SIGNIN_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) registerBtn.getScene().getWindow();
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
