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
public class PersonaDireccionDAO extends EntidadAD implements metodosDAO<PersonaDireccion> {

    private List<PersonaDireccion> registros;
    private PersonaDireccion oPersonaDireccion;
    private String query;
    private boolean resp;
    private final PersonaLN oPersonaLN;
    
    public PersonaDireccionDAO(Connection connection) {
        super(connection);
        oPersonaLN = new PersonaLN();
    }

    @Override
    public List<PersonaDireccion> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PERSONA_DIRECCION_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPersonaDireccion = new PersonaDireccion();
                oPersonaDireccion.setCodigo(rs.getInt("codigo"));
                oPersonaDireccion.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                oPersonaDireccion.setCalle(rs.getString("calle"));
                oPersonaDireccion.setNumero(rs.getString("numero"));
                oPersonaDireccion.setCiudad(rs.getString("ciudad"));
                oPersonaDireccion.setDepartamento(rs.getString("departamento"));
                oPersonaDireccion.setPais(rs.getString("pais"));
                registros.add(oPersonaDireccion);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PERSONA_DIRECCION" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PersonaDireccion Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_DIRECCION_INSERTAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getoPersona().getDni());
            pc.setString(2, Obj.getCalle());
            pc.setString(3, Obj.getNumero());
            pc.setString(4, Obj.getCiudad());
            pc.setString(5, Obj.getDepartamento());
            pc.setString(6, Obj.getPais());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PERSONA_DIRECCION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PersonaDireccion Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_DIRECCION_ACTUALIZAR(?,?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.setString(3, Obj.getCalle());
            pc.setString(4, Obj.getNumero());
            pc.setString(5, Obj.getCiudad());
            pc.setString(6, Obj.getDepartamento());
            pc.setString(7, Obj.getPais());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PERSONA_DIRECCION " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PersonaDireccion Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_DIRECCION_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setString(1, Obj.getoPersona().getDni());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PERSONA_DIRECCION " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PersonaDireccion Obj) {
        return 0;
    }

    @Override
    public PersonaDireccion getObjeto(PersonaDireccion Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PERSONA_DIRECCION_BUSCAR(?);";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, Obj.getoPersona().getDni());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                Obj.setCalle(rs.getString("calle"));
                Obj.setNumero(rs.getString("numero"));
                Obj.setCiudad(rs.getString("ciudad"));
                Obj.setDepartamento(rs.getString("departamento"));
                Obj.setPais(rs.getString("pais"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PERSONA_DIRECCION CON ESTE DNI ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PERSONA_DIRECCION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
