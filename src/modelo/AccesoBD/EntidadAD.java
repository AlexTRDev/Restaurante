package modelo.AccesoBD;

import java.sql.*;

/**
 *
 * @author ALEX
 */
public abstract class EntidadAD {
    private Connection connection;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected CallableStatement pc;
    
    protected enum sentencia{
        SQL,
        DML,
        SPC
    }
    
    public EntidadAD(Connection connection) {
        this.connection = connection;
    }

    protected void ejecutarSentenciaSQL(String sentenciaSQL) throws SQLException{
        try {
            ps = connection.prepareStatement(sentenciaSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    protected void ejecutarSentenciaDML(String sentenciaDML) throws SQLException{
     
        try {
            ps = connection.prepareStatement(sentenciaDML);
//            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    protected void ejecutarProcedimientoAlmacenado(String sentenciaDML) throws SQLException{
     
        try {
            pc = connection.prepareCall(sentenciaDML);
            
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
        
    protected void cerrarPR(String sentencia) throws SQLException{
        try {
            switch (sentencia) {
                case "DML" :
                    if (ps != null) {
                    ps.close();
                    }
                     break;
                case "SQL":
                    if (rs != null){
                        rs.close(); 
                    if (ps != null) {
                        ps.close();
                    }
                    }
                    break;
                case "SPC":
                    if (rs != null){
                        rs.close(); 
                    if (pc != null) {
                        pc.close();
                    }
                    }
                    if (pc != null) {
                        pc.close();
                    }
                    break; 
            }
        } catch (SQLException e) {
            throw e;
        }

    }
    
}
