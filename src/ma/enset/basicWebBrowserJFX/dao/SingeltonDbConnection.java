package ma.enset.basicWebBrowserJFX.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

public class SingeltonDbConnection {
  private static Connection connection = null;

  
  private static String url = "jdbc:mysql://localhost:3306/basicWebBrowser";
  private static String user = "java";
  private static String password = "password";
  

  private SingeltonDbConnection() {}
  
  public static Connection getConnection() {
    if (connection == null)
      return createConnection();
    return connection;
  }

  private static Connection createConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static String genID() {
    return UUID.randomUUID().toString().substring(0, 30);
  }
}
