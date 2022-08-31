package modelo.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import modelo.AccesoBD.EntidadAD;
import modelo.Entidades.*;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class TipoUsuarioDAO extends EntidadAD implements metodosDAO<TipoUsuario> {

    private List<TipoUsuario> registros;
    private TipoUsuario oTipoUsuarios;
    private String query;
    private boolean resp;

    public TipoUsuarioDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<TipoUsuario> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL TIPO_USUARIO_LISTAR()}"; // Sentencia SQL con la cual recuperamos los datos de la BD
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oTipoUsuarios = new TipoUsuario();
                oTipoUsuarios.setCodigo(rs.getInt("codigo"));
                oTipoUsuarios.setNombre(rs.getString("nombre").toUpperCase());
                oTipoUsuarios.setDescripcion(rs.getString("descripcion").toUpperCase());
                registros.add(oTipoUsuarios);
            }

            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR TIPO DE USUARIOS  " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(TipoUsuario Obj) {
        resp = false;
        try {
            query = "{call TIPO_USUARIO_INSERTAR(?,?)}"; // Sentencia SQL con la cual INSERTAMOS datos a la BD
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, Obj.getNombre().toUpperCase());
            pc.setString(2, Obj.getDescripcion().toUpperCase());
            pc.executeUpdate();

            return resp = true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "EROOR AL INSERTAR TIPO DE USUARIO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

 
        }
        return resp;
    }

    @Override
    public boolean actualizar(TipoUsuario Obj) {
        resp = false;
        try {
            query = "{call TIPO_USUARIO_ACTUALIZAR(?,?,?)}"; // Sentencia SQL con la cual ACTUALIZAMOS datos de la BD
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getNombre().toUpperCase());
            pc.setString(3, Obj.getDescripcion().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR TIPO DE USUARIO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(TipoUsuario Obj) {
        resp = false;
        try {
            query = "{CALL TIPO_USUARIO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR TIPO DE USUARIO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(TipoUsuario Obj) {
        return 0;
    }

    @Override
    public TipoUsuario getObjeto(TipoUsuario Obj) {
        try {
            query = "{CALL TIPO_USUARIO_BUSCAR(?)}"; // Sentencia SQL con la cual RECUPERAMOS datos de la BD
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombre(rs.getString("nombre").toUpperCase());
                Obj.setDescripcion(rs.getString("descripcion").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE TIPO DE USUARIO CON ESTE CODIGO ");
            }
            
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR UN TIPO DE USUARIO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
                
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Obj;
    }

    public int buscarNombre(TipoUsuario obj) {
        try{    
            query = "CALL TIPO_USUARIO_BUSCAR_NOMBRE(?);";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, obj.getNombre());
            rs = pc.executeQuery();
            if (rs.next()) {
                return 1;
            }else{
                return -1;
            }
        } catch (SQLException e) {
            return -1;
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
