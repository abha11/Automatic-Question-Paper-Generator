/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aqpg;

import static aqpg.FxmlConstant.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Abha Suntwal
 */
public class GeneratepaperController implements Initializable {

    @FXML
    private Button btngenerate;
    @FXML
    private ComboBox<?> cmbBox;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*cmbBox = new ComboBox<String>();
        cmbBox.getItems().addAll("a","B","C");*/
        //ObservableList<String> options = FXCollections.observableArrayList("Genetic Algorithm","Second one","Third one");
        //cmbBox = new ComboBox(options);
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btngenerate) {
            try {
                JOptionPane.showMessageDialog(null, "Generating Paper...");
                Parent root = FXMLLoader.load(getClass().getResource(GENERATE_PAPER));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btngenerate.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(USER_PAGE));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btngenerate.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
