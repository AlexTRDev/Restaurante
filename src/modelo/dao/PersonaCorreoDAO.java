package modelo.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import modelo.AccesoBD.*;
import modelo.Entidades.*;
import modelo.LogicaNegocio.*;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class PersonaCorreoDAO extends EntidadAD implements metodosDAO<PersonaCorreo> {

    private List<PersonaCorreo> registros;
    private PersonaCorreo oPersonaCorreo;
    private String query;
    private boolean resp;
    private final PersonaLN oPersonaLN;
    
    public PersonaCorreoDAO(Connection connection) {
        super(connection);
        oPersonaLN = new PersonaLN();
    }

    @Override
    public List<PersonaCorreo> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PERSONA_CORREO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPersonaCorreo = new PersonaCorreo();
                oPersonaCorreo.setCodigo(rs.getInt("codigo"));
                oPersonaCorreo.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                oPersonaCorreo.setCorreo(rs.getString("correo").toUpperCase());
                registros.add(oPersonaCorreo);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PERSONA_CORREO" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PersonaCorreo Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_CORREO_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getoPersona().getDni());
            pc.setString(2, Obj.getCorreo().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PERSONA_CORREO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PersonaCorreo Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_CORREO_ACTUALIZAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.setString(3, Obj.getCorreo().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PERSONA_CORREO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PersonaCorreo Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_CORREO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PERSONA_CORREO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PersonaCorreo Obj) {
        return 0;
    }

    @Override
    public PersonaCorreo getObjeto(PersonaCorreo Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PERSONA_CORREO_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                Obj.setCorreo(rs.getString("correo").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PERSONA_CORREO CON ESTE DNI ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PERSONA_CORREO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
