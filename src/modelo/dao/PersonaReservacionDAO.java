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
public class PersonaReservacionDAO extends EntidadAD implements metodosDAO<PersonaReservacion> {

    private List<PersonaReservacion> registros;
    private PersonaReservacion oPersonaReservacion;
    private String query;
    private boolean resp;
    private final PersonaLN oPersonaLN;
    private final MesaLN oMesaLN;
    
    public PersonaReservacionDAO(Connection connection) {
        super(connection);
        oPersonaLN = new PersonaLN();
        oMesaLN = new MesaLN();
    }

    @Override
    public List<PersonaReservacion> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PERSONA_RESERVACION_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPersonaReservacion = new PersonaReservacion();
                oPersonaReservacion.setCodigo(rs.getInt("codigo"));
                oPersonaReservacion.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                oPersonaReservacion.setoMesa(oMesaLN.getObjeto(new Mesa(rs.getInt("MESAS_codigo"))));
                oPersonaReservacion.setFechaReservacion(rs.getString("fecha_reservacion"));
                oPersonaReservacion.setFechaReservada(rs.getString("fecha_reservada"));
                registros.add(oPersonaReservacion);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PERSONA_RESERVACION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaReservacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PersonaReservacion Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_RESERVACION_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getoPersona().getDni());
            pc.setInt(2, Obj.getoMesa().getCodigo());
            pc.setString(3, Obj.getFechaReservacion());
            pc.setString(4, Obj.getFechaReservada());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PERSONA_RESERVACION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaReservacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PersonaReservacion Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_RESERVACION_ACTUALIZAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.setInt(3, Obj.getoMesa().getCodigo());
            pc.setString(4, Obj.getFechaReservacion());
            pc.setString(5, Obj.getFechaReservada());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PERSONA_RESERVACION " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaReservacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PersonaReservacion Obj) {
        resp = false;
        try {
            query = "{CALL PERSONA_RESERVACION_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PERSONA_RESERVACION " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PersonaReservacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PersonaReservacion Obj) {
        return 0;
    }

    @Override
    public PersonaReservacion getObjeto(PersonaReservacion Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PERSONA_RESERVACION_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                Obj.setoMesa(oMesaLN.getObjeto(new Mesa(rs.getInt("MESAS_codigo"))));
                Obj.setFechaReservacion(rs.getString("fecha_reservacion"));
                Obj.setFechaReservada(rs.getString("fecha_reservada"));    
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PERSONA_RESERVACION CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PERSONA_RESERVACION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaReservacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
