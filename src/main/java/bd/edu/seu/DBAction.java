package bd.edu.seu;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBAction {
    public DBAction() {
    }
    public Connection getConnection(){
        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fittrackdb","root","groot");
            
        } catch (SQLException e) {
      
        }
        return connection;

    }
    public void insertTodb (Entry entry){
        Connection connection = getConnection();
        try {
            Statement statement = connection .createStatement();
            String query = String.format("insert into  entry values(\"%s\",\"%s\",%d,%d,%f);",
                    entry.getDate(),
                    entry.getTime(),
                    entry.getSystolic(),
                    entry.getDiastolic(),
                    entry.getWeight());
            statement.execute(query);
            System.out.println(query);
            
        } catch (SQLException e) {
           
        }

    }
    public ArrayList<Entry> retrieveHistory(){
        Connection connection = getConnection();
        ArrayList<Entry> entryList = new ArrayList<>();

        try {
            Statement statement = connection .createStatement();
            String query = "select * from entry;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                
                LocalDate date = LocalDate.parse(resultSet.getString("Date"));
                String time = resultSet.getNString("Time");
                int sys = resultSet.getInt("Systolic");
                int dia = resultSet.getInt("Diastolic");
                float weight = resultSet.getFloat("Weight");
                Entry entry = new Entry(date,time,sys,dia,weight);
                entryList.add(entry);
            }
        } catch (SQLException e) {
            System.out.println("Failed to Retrieve data");
        }
        Collections.sort(entryList);
        return entryList;
    }
}
