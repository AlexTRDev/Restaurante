
package modelo.AccesoBD;

import java.sql.*;

/**
 *
 * @author ALEX
 */
public class Conexion {
    private Connection connection;
    
    public void abrirConnection() throws SQLException{
        try {
            String driver = "jdbc:mysql://";
            String servidor  = "localhost:";
            String puerto = "3306/";
            String nombreBD = "restaurante_bd" ;
            String user = "root";
            String pass = "root";

            String url = driver+servidor+puerto+nombreBD;

            connection = DriverManager.getConnection(url, user, pass);
                
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public Connection getConnection(){
        return connection;
    }
    
        public Boolean isCerrada() throws SQLException{
        try {
            Boolean cerrada;

            if (connection != null) {
                cerrada = connection.isClosed();
            } else {
                cerrada = true;
            }    
            return cerrada;

        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void cerrarConnection() throws SQLException{
        try {
            if (!isCerrada()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
