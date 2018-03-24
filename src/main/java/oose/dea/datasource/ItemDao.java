package oose.dea.datasource;

import oose.dea.datasource.util.DatabaseProperties;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ListResourceBundle;

public class ItemDao {

    private Connection connection;
    public ItemDao(){

    }


    private void loadJdbcDriver(){
        DatabaseProperties dbProperties = new DatabaseProperties();
        try{
            Class.forName(dbProperties.getDriver());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(dbProperties.getConnectionUrl());
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public List findAll() {

        ResultSet resultSet = null;
        try{
            resultSet = connection.prepareStatement("SELECT *  FROM item").executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List allList = new List();
        try {
            while(resultSet.next() ){
                allList.add(resultSet.getString("name")); ;

            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return allList;
    }
}
