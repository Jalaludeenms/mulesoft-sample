package movie_project;

import java.sql.*;  

public class Sample {
  static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
  static final String USER = "root";
  static final String PASS = "root";
  static final String QUERY1 = "SELECT movie_id,movie_name,lead_actor,actress,year_of_release,director_name  FROM MOVIES";
  static final String QUERY2 = "SELECT movie_id,movie_name,lead_actor,actress,year_of_release,director_name  FROM MOVIES where lead_actor='Renton'";;
public static void main(String[] args)  {

try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();


         String create_table_movie = "CREATE TABLE MOVIES " +
                 "(movie_id INTEGER not NULL, " +
                 " movie_name VARCHAR(255), " +
                 " lead_actor VARCHAR(255), " +
                 " actress VARCHAR(255), " +
                 " year_of_release DATE" +
                 "  director_name VARCHAR(255))";

       stmt.executeUpdate(create_table_movie);
       System.out.println("Created movies table in given database...");    
         

       System.out.println("Inserting records into the table...");          
       String sql = "INSERT INTO MOVIES VALUES (100, 'Vertigo','Renton', 'Katherine', '2018-05-07','Stephen')";
       stmt.executeUpdate(sql);
       sql = "INSERT INTO MOVIES VALUES (101, 'Blade Runner','Rose DeWitt Bukater', 'Lopez','1978-12-29','Woody' )";
       stmt.executeUpdate(sql);
       sql = "INSERT INTO MOVIES VALUES (102, 'The Deer Hunter','Renton', 'Maria', '2000-10-05','Jack')";
       stmt.executeUpdate(sql);
       sql = "INSERT INTO MOVIES VALUES(103, 'Eyes Wide Shut','Ripley', 'Eugenia','1995-10-20','Mark' )";
       stmt.executeUpdate(sql);
       System.out.println("Inserted records into the table...");
   
       System.out.println("Fetching records without condition...");
       ResultSet rs = stmt.executeQuery(QUERY1);
       while(rs.next()){
          //Display values
          System.out.print("ID: " + rs.getInt("movie_id"));
          System.out.print(", Movie Name: " + rs.getString("movie_name"));
          System.out.print(", Lead Actor: " + rs.getString("lead_actor"));
          System.out.println(", Actress: " + rs.getString("actress"));
          System.out.println(", Year of release: " + rs.getDate("year_of_release"));
          System.out.println(", Director: " + rs.getString("director_name"));
       }
       
       System.out.println("Fetching records with condition...");
       
       rs = stmt.executeQuery(QUERY2);

       while(rs.next()){
          //Display values
           System.out.print("ID: " + rs.getInt("movie_id"));
           System.out.print(", Movie Name: " + rs.getString("movie_name"));
           System.out.print(", Lead Actor: " + rs.getString("lead_actor"));
           System.out.println(", Actress: " + rs.getString("actress"));
           System.out.println(", Year of release: " + rs.getDate("year_of_release"));
           System.out.println(", Director: " + rs.getString("director_name"));
       }
       
conn.close();
}
catch (Exception e) {
        e.printStackTrace();
     }
}

}
