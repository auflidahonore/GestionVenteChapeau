
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connecter {
    Connection connect;
    
     public Connecter(){
        
     try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("CONNECTER");
      }catch(ClassNotFoundException e){
          System.err.println(e);
         //pour afficher l'erreur
      } 
      try{
          connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionventechapeau","root","");
          System.out.println("Connection reussite");
      }catch(SQLException e){System.err.println(e);}
    
    }
    
    Connection obtenirConnection(){
        return connect;
    }

    PreparedStatement prepareStatement(String Sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
