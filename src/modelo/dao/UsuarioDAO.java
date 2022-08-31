package modelo.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import modelo.AccesoBD.*;
import modelo.Entidades.*;
import modelo.LogicaNegocio.PersonaLN;
import modelo.LogicaNegocio.TipoUsuarioLN;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class UsuarioDAO extends EntidadAD implements metodosDAO<Usuario> {

    private List<Usuario> registros;
    private Usuario oUsuario;
    private String query;
    private boolean resp;
    private final PersonaLN oPersonaLN;
    private final TipoUsuarioLN oTipoUsuariosLN;
    
    public UsuarioDAO(Connection connection) {
        super(connection);
        oPersonaLN = new PersonaLN();
        oTipoUsuariosLN = new TipoUsuarioLN();
    }

    @Override
    public List<Usuario> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL USUARIO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oUsuario = new Usuario();
                oUsuario.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni").toUpperCase())));
                oUsuario.setoTipoUsuarios(oTipoUsuariosLN.getObjeto(new TipoUsuario(rs.getInt("TIPO_USUARIOS_codigo"))));
                oUsuario.setUser(rs.getString("user").toUpperCase());
                oUsuario.setPassword(rs.getString("password").toUpperCase());
                oUsuario.setFoto(rs.getBytes("foto"));
                registros.add(oUsuario);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR USUARIOS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Usuario Obj) {
        resp = false;
        try {
            query = "{CALL USUARIO_INSERTAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getoPersona().getDni().toUpperCase());
            pc.setInt(2, Obj.getoTipoUsuarios().getCodigo());
            pc.setString(3, Obj.getUser().toUpperCase());
            pc.setString(4, Obj.getPassword().toUpperCase());
            pc.setBytes(5, Obj.getFoto());
            
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR USUARIO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Usuario Obj) {
        resp = false;
        try {
            query = "{CALL USUARIO_ACTUALIZAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoTipoUsuarios().getCodigo());
            pc.setString(2, Obj.getUser().toUpperCase());
            pc.setString(3, Obj.getPassword().toUpperCase());
            pc.setBytes(4, Obj.getFoto());
            pc.setString(5, Obj.getoPersona().getDni().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR USUARIO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Usuario Obj) {
        resp = false;
        try {
            query = "{CALL USUARIO_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setString(1, Obj.getoPersona().getDni().toUpperCase());
            pc.setInt(2, Obj.getoTipoUsuarios().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR USUARIO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Usuario Obj) {
        return 0;
    }

    @Override
    public Usuario getObjeto(Usuario Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL USUARIO_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, Obj.getoPersona().getDni());
            pc.setInt(2, Obj.getoTipoUsuarios().getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni").toUpperCase())));
                Obj.setoTipoUsuarios(oTipoUsuariosLN.getObjeto(new TipoUsuario(rs.getInt("TIPO_USUARIOS_codigo"))));
                Obj.setUser(rs.getString("user").toUpperCase());
                Obj.setPassword(rs.getString("password").toUpperCase());
                Obj.setFoto(rs.getBytes("foto"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE USUARIO CON ESTE CODIGO ");
            }
            
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL RECUPERAR USUARIO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public List<Usuario> listarPorTipoUsuario(TipoUsuario obj) {
        try {
            registros = new ArrayList<>();
            query = "{CALL USUARIO_LISTAR_TIPO(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, obj.getCodigo());
            rs = pc.executeQuery();

            while (rs.next()) {
                oUsuario = new Usuario();
                oUsuario.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni").toUpperCase())));
                oUsuario.setoTipoUsuarios(oTipoUsuariosLN.getObjeto(new TipoUsuario(rs.getInt("TIPO_USUARIOS_codigo"))));
                oUsuario.setUser(rs.getString("user").toUpperCase());
                oUsuario.setPassword(rs.getString("password").toUpperCase());
                oUsuario.setFoto(rs.getBytes("foto"));
                registros.add(oUsuario);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR USUARIOS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

}
