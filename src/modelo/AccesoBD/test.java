package modelo.AccesoBD;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Entidades.TipoUsuario;

/**
 *
 * @author ALEX
 */
public class test {

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        TipoUsuario oTipoUsuarios;
        List<TipoUsuario> registros = new ArrayList<>();
        
        try {
            con.abrirConnection();
            Connection c = con.getConnection();
            String query = "select* From tipo_usuarios";
            ps = c.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            rs.beforeFirst();
            
            while (rs.next()) {
                oTipoUsuarios = new TipoUsuario();
                oTipoUsuarios.setCodigo(rs.getInt(1));
                oTipoUsuarios.setNombre(rs.getString(2).toUpperCase());
                registros.add(oTipoUsuarios);
            }
            System.out.println(Arrays.toString(registros.toArray()));
            
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
