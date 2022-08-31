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
public class PersonaCelularDAO extends EntidadAD implements metodosDAO<PersonaCelular> {

    private List<PersonaCelular> registros;
    private PersonaCelular oPersonaCelular;
    private String query;
    private boolean resp;
    private final PersonaLN oPersonaLN;
    
    public PersonaCelularDAO(Connection connection) {
        super(connection);
        oPersonaLN = new PersonaLN();
    }

    @Override
    public List<PersonaCelular> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PERSONA_CELULAR_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPersonaCelular = new PersonaCelular();
                oPersonaCelular.setCodigo(rs.getInt("codigo"));
                oPersonaCelular.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                oPersonaCelular.setCelular(rs.getString("celular").toUpperCase());
                registros.add(oPersonaCelular);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PERSONA_CELULAR" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PersonaCelular Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_CELULAR_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getoPersona().getDni());
            pc.setString(2, Obj.getCelular());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PERSONA_CELULAR " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PersonaCelular Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_CELULAR_ACTUALIZAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.setString(3, Obj.getCelular().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PERSONA_CELULAR " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PersonaCelular Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_CELULAR_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PERSONA_CELULAR " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PersonaCelular Obj) {
        return 0;
    }

    @Override
    public PersonaCelular getObjeto(PersonaCelular Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PERSONA_CELULAR_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                Obj.setCelular(rs.getString("celular").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PERSONA_CELULAR CON ESTE DNI ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PERSONA_CORREO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
