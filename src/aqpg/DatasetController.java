/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//The fxml file for this controller is Questionbank.fxml
package aqpg;

import QPDAO.tableDAO;
import java.net.URL;
import Utils.BaseDAO;
import static Utils.BaseDAO.getCon;
import static Utils.BaseDAO.closeCon;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.*;
import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;
import QPBean.table;
import Utils.BaseDAO;
import static aqpg.FxmlConstant.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Abha Suntwal
 */
public class DatasetController implements Initializable {

    @FXML
    private Button btnImport;
    @FXML
    private Button btnBack;
    @FXML
    private TableColumn<table, String> col_ID;
    @FXML
    private TableColumn<table, String> col_question;
    @FXML
    private TableColumn<table, String> col_dd;
    @FXML
    private TableColumn<table, String> col_Time;
    @FXML
    private TableColumn<table, String> col_difficulty;
    @FXML
    private TableColumn<table, String> col_marks;
    @FXML
    private TableColumn<table, String> col_relevancy;
    @FXML
    private TableColumn<table, String> col_frequency;
    @FXML
    private TableColumn<table, String> col_year;
    @FXML
    private TableView<table> table_question;

    private ObservableList<table> data;
    @FXML
    private Button btnLoad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnImport) {
            try {
                //to open folder
                Stage stage = (Stage) btnImport.getScene().getWindow();
                FileChooser chooser = new FileChooser();
                File selectedFile = chooser.showOpenDialog(stage);
                //The variable "selectedFile" stores the address location of the file in the system
                if (selectedFile == null) {
                    return;
                } else {
                    System.out.println(selectedFile.toString());

                    //inserting the content into the database
                    tableDAO.importTable(selectedFile.toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnLoad) {
            //this button populates the data of the database into the tableview
            Connection con = null;
            try {
                con = getCon();
                data = FXCollections.observableArrayList();
                String sql = "select * from question_bank";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    do {
                        data.add(new table(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
                    } while (rs.next());
                    //col_ID; col_question; col_dd; col_Time; col_difficulty;col_marks;col_relevancy;col_frequency;col_year;

                    //The string used in the propertyValueFactory are the members of QPBean.table.java class
                    col_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
                    col_question.setCellValueFactory(new PropertyValueFactory<>("question"));
                    col_dd.setCellValueFactory(new PropertyValueFactory<>("discrimination"));
                    col_Time.setCellValueFactory(new PropertyValueFactory<>("time"));
                    col_difficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
                    col_marks.setCellValueFactory(new PropertyValueFactory<>("marks"));
                    col_relevancy.setCellValueFactory(new PropertyValueFactory<>("relevancy"));
                    col_frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));
                    col_year.setCellValueFactory(new PropertyValueFactory<>("year"));

                    table_question.setItems(null);
                    table_question.setItems(data);

                    //JOptionPane.showMessageDialog(null, "Success!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Import the data first!");

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeCon(con);
            }
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(ADMIN_PAGE));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();
                //Process process = Runtime.getRuntime().exec("python F:\\NIT Notes\\8th sem\\Major\\Reports\\GA_QP_Generate.py");
                //System.out.println("Executed");           
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
