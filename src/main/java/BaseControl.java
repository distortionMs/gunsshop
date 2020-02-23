/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willy
 */
import java.sql.*;
import java.util.ArrayList;

public class BaseControl {

    //public class MainClass {
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://localhost:3306/test";
    private String login = "";
    private String password = "";
    private Connection connection = null;
    private ResultSet rs = null;
//    private equipmentRow CurrentRow = new equipmentRow();

    public void createConnection(String login, String pwd) throws Exception {
        this.login = login;
        this.password = pwd;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            throw new Exception("Can't get class. No driver found");
//            System.out.println("Can't get class. No driver found");
//            e.printStackTrace();
//            return;
        }
        try {
            connection = DriverManager.getConnection(connectionString, login, password);
        } catch (SQLException ex) {
            throw new Exception("Can't get connection. Incorrect URL" + "/" + login + "/" + password);
//            System.out.println("Can't get connection. Incorrect URL");
//            e.printStackTrace();
//            return;
        }
    }

    public void closeConnection() throws Exception {
        try {
            rs.getStatement().close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Can't close connection");
//            System.out.println("Can't close connection");
//            e.printStackTrace();
//            return;
        }
    }

    public ArrayList<EquipmentRow> getFullData() throws Exception {

        ArrayList<EquipmentRow> fullData = new ArrayList<EquipmentRow>();

        try {
            Statement stmt = connection.createStatement();
            String myQuery = "SELECT * FROM test.equipment";
            rs = stmt.executeQuery(myQuery);
            while (rs.next()) {
                EquipmentRow CurrentRow = new EquipmentRow();
                CurrentRow.id = rs.getInt("id");
                CurrentRow.name = rs.getString("name");
                CurrentRow.unit = rs.getString("unit");
                CurrentRow.quantity = rs.getFloat("quantity");
                fullData.add(CurrentRow);
            }
            return fullData;
        } catch (SQLException ex) {
            throw new Exception("Can't RUN QUERY");
        }
    }

    public void SaveChanges(DataState data) throws Exception {

//У нас заполнены (или не заполнены) три коллекции - для Update, для Insert и для Delete команд SQL. 
        if (((data.toUpdate.isEmpty()) && (data.toInsert.isEmpty()) && (data.toDelete.isEmpty()))) {
            throw new Exception("Нечего менять!");
        }

        try {
            for (EquipmentRow update : data.toUpdate) { //UPDATE Table
                String updQuery = "UPDATE test.equipment SET name = ?, unit = ?, quantity = ? WHERE id = ?"; //UPDATE test.equipment Set name = "AKСУ-74", unit = "АВТ", quantity = 7.8 WHERE id = 7
                PreparedStatement preparedStatement = connection.prepareStatement(updQuery);
                preparedStatement.setString(1, update.name);
                preparedStatement.setString(2, update.unit);
                preparedStatement.setFloat(3, update.quantity);
                preparedStatement.setInt(4, update.id);
                preparedStatement.executeUpdate(); //need to close?
            }

            for (EquipmentRow insert : data.toInsert) { //INSERT new values       
                String insQuery = "INSERT INTO test.equipment VALUES(0, ?, ?, ?)"; //INSERT into test.equipment VALUES(0,"Пластид", "КГ", 8.4)
                PreparedStatement preparedStatement = connection.prepareStatement(insQuery);
                preparedStatement.setString(1, insert.name);
                preparedStatement.setString(2, insert.unit);
                preparedStatement.setFloat(3, insert.quantity);
                preparedStatement.execute();
            }

            for (EquipmentRow delete : data.toDelete) { //Delete values
                String delQuery = "DELETE FROM test.equipment WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(delQuery);
                preparedStatement.setInt(1, delete.id);
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
