package oose.dea;

import oose.dea.datasource.ItemDao;
import oose.dea.datasource.util.DatabaseProperties;

import java.awt.*;

public class JdbcApp {

    public static void main(String[] args) {

        DatabaseProperties dbProperties = new DatabaseProperties();



       System.out.println("Connection url: " + dbProperties.getConnectionUrl());
        System.out.println("Driver : " + dbProperties.getDriver());


        ItemDao itemDao = new ItemDao();
        List allItems  =  itemDao.findAll();

        for (String myItem: allItems.getItems()) {
        System.out.println(myItem);
        }

    }
}
