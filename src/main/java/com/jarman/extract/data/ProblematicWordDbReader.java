package com.jarman.extract.data;

import com.jarman.pojos.ProblematicWord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblematicWordDbReader implements ProblematicWordReader {

// TODO try jdbc template to reduce boilerplate

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "MySQL.5678";

    @Override
    public List<ProblematicWord> getAllProblematicWords() {
        List<ProblematicWord> problematicWords = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // TODO move this somewhere else and pass in the connection
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from grmmr.problematic_words";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                String x = resultSet.getString("problematicWord");
                String y = resultSet.getString("suggestion");
                String z = resultSet.getString("explanation");
                ProblematicWord problematicWord = new ProblematicWord(x, y, z);
                problematicWords.add(problematicWord);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return problematicWords;
    }

}