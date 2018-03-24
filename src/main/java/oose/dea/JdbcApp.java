package oose.dea;

import oose.dea.datasource.util.DatabaseProperties;

public class JdbcApp {

    public static void main(String[] args) {

        DatabaseProperties dbProperties = new DatabaseProperties();



       System.out.println("Connection url: " + dbProperties.getConnectionUrl());
        System.out.println("Driver : " + dbProperties.getDriver());
    }
}
