/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Abha Suntwal
 */
public class UtilityFunctions {
    
    public static <T> TableColumn<T, ?> getTableColumnByName(TableView<T> tableView, String name) {
        for (TableColumn<T, ?> col : tableView.getColumns())
            if (col.getText().equalsIgnoreCase(name)) return col ;
        return null ;
    }
    public static String getSelColValue(String col, TableView tableView) {
        String res = null;
        try {
            int rowIndex = tableView.getSelectionModel().getSelectedIndex();
            TableColumn column = getTableColumnByName(tableView, col);
            if(column!=null && column.getCellData(rowIndex)!=null){
                res = column.getCellData(rowIndex).toString();                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
