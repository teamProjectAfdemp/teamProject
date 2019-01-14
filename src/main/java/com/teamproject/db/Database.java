package com.teamproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    //Method create URL for connecting
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

    //Method creating connection to DB
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

//Method execute UPDATE or INSERT
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

//Method execute SELECT
    public ResultSet execSelect(Connection conn, String query) {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Execute query did not work!");
        }
        return rs;
    }

    public ResultSet execPrepSelect(Connection conn, String query, Map<String, String> paramMap) {
        Connection conn2 = createConnection();
        ResultSet rs = null;
        PreparedStatement prest = null;

        try {
            prest = conn2.prepareStatement(query);
//        prest.setString();
//        rs = st.executeQuery(query);
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Execute query did not work!");
        }
        return rs;
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

    public int genericInsert(String table, ArrayList<String> fields, ArrayList<String[]> values) {

        int rowsInserted = 0;

        StringBuilder query = new StringBuilder()
                .append("INSERT INTO `" + table + "` (");

        for (int i = 0; i < fields.size(); i++) {
            query.append("`" + fields.get(i) + "`");
            if (i < (fields.size() - 1)) {
                query.append(",");
            }
        }
        query.append(") VALUES ");

        for (int i = 0; i < values.size(); i++) {
            query.append("(");

            for (int j = 0; j < values.get(i).length; j++) {
                query.append("'" + values.get(i)[j] + "'");
                if (j < (values.get(i).length - 1)) {
                    query.append(",");
                }
            }
            if (i < values.size() - 1) {
                query.append(") ,");
            } else {
                query.append(");");
            }
        }
        rowsInserted = execUpdateInsert(query.toString());

        return rowsInserted;
    }
}
