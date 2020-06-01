/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aqpg;

import QPBean.myUser;
import QPDAO.MyuserDAO;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Abha Suntwal
 */
public class EditUserController implements Initializable {

    public static String id = null;
    @FXML
    private TextField txtContact;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSubject;
    @FXML
    private TextField txtDesignation;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //populating the text fields with the previous data of the user
        populateOldData();
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnUpdate) {
            try {
                myUser m1 = new myUser();
                m1.setId(id);
                m1.setName(txtName.getText());
                m1.setSubject(txtSubject.getText());
                m1.setEmail(txtEmail.getText());
                m1.setDesignation(txtDesignation.getText());
                m1.setPhone_no(txtContact.getText());
                MyuserDAO.update(m1);
                JOptionPane.showMessageDialog(null, "Information successfully updated!");
                Parent root = FXMLLoader.load(getClass().getResource(USER_PAGE));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
            }

        } else if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(USER_PAGE));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void populateOldData() {
        myUser m1 = MyuserDAO.searchById(id);
        txtName.setText(m1.getName());
        txtSubject.setText(m1.getSubject());
        txtEmail.setText(m1.getEmail());
        txtContact.setText(m1.getPhone_no());
        txtDesignation.setText(m1.getDesignation());
    }

}
