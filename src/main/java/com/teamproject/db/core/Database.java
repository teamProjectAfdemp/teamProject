package com.teamproject.db.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Database {
    protected static Class dbClass;
    protected String server = "188.166.121.77:3306";
    protected static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    protected static final String PREFACE = "jdbc:mysql://";
    protected String database = "teamproject";
    protected String username = "remoteuser";
    protected String password = "password321";
    protected String options = "?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true";
    protected String urlDB;

    public void createURL() {
        urlDB = (PREFACE + server + "/" + database + options);
    }

    public void registerDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not registered!");
            e.printStackTrace();
        }
    }

    public Connection createConnection() {
        Connection conn = null;
        registerDriver();
        createURL();
        try {
            conn = DriverManager.getConnection(urlDB, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println((conn != null) ? "You made it, take control your database now!" : "Failed to make connection!");
        return conn;
    }

    public int execUpdateInsert(String query) {
        Connection con = createConnection();
        Statement st = null;
        int rowsAffected = 0;
        try {
            st = con.createStatement();
            rowsAffected = st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public Collection<Map<String, Object>> getGenericSelect(String query) {
        Connection con = createConnection();
        Statement st = null;
        ResultSet rs = null;
        Collection<Map<String, Object>> answer = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> eachRow = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    eachRow.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                answer.add(eachRow);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
