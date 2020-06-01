/*
 * This is the SigiIn page for the users.
 * For information about any method, bring the cursor over it, press ctrl and click it. It wiil take you to its definition.
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
public class SignInController implements Initializable {

    @FXML
    private Button signinBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button joinBtn;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtpass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // No initialization required
    }

    @FXML
    private void he(ActionEvent event) {
        //The controls enters to this IF when signIn button is clicked
        if (event.getSource() == signinBtn) {
            try {
                //The below method validates the user credentials
                myUser m1 = MyuserDAO.validate_login(txtname.getText(), txtpass.getText());
                if (m1 == null) {
                    JOptionPane.showMessageDialog(null, "Incorrect UserName or Password!");
                    return;
                }
                String id = m1.getId();

                //The id of the user is being transferred to UserPageController for further requirements
                UserPageController.id = id;
                JOptionPane.showMessageDialog(null, "Succesfully Logged In!");
                Parent root = FXMLLoader.load(getClass().getResource(USER_PAGE));
                Scene scene = new Scene(root);
                Stage stage = (Stage) signinBtn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (event.getSource() == joinBtn) {
            try {
                //This code takes the user to the register page, where he can register and generate username and password
                Parent root = FXMLLoader.load(getClass().getResource(SIGNUP_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) joinBtn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == cancelBtn) {
            try {
                //This button takes the user back to the landing page
                Parent root = FXMLLoader.load(getClass().getResource(LANDING_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) joinBtn.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
