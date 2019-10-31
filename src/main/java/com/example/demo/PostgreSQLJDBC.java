// package com.example.demo;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.util.concurrent.atomic.AtomicLong;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;


// @RestController
// public class PostgreSQLJDBC {
//    String word2;
//    int id2;

//    List
//    @RequestMapping("/hello")
//    public Greeting main() {
//       Connection c = null;
//       Statement stmt = null;
//       try {
//          Class.forName("org.postgresql.Driver");
//          c = DriverManager
//             .getConnection("jdbc:postgresql://localhost:5432/spring_boot_dataBase",
//             "johnathanmoes", "");
//          c.setAutoCommit(false);
//          System.out.println("Opened database successfully");

//          stmt = c.createStatement();
//          ResultSet rs = stmt.executeQuery( "SELECT * FROM hello;" );
//          while ( rs.next() ) {
//             int id = rs.getInt("id");
//             String word = rs.getString("word");
//             System.out.println( "ID = " + id );
//             System.out.println( "WORD = " + word );
//             word2 = word;
//             id2 = id;
//             // System.out.println();
//             new Greeting(word);
//             // System.out.println(Greeting);
//          }
//          rs.close();
//          stmt.close();
//          c.close();
//       } catch ( Exception e ) {
//          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//          System.exit(0);
//       }
//       System.out.println("Operation done successfully");
//       return new Greeting(id2, word2);
//    }
// }