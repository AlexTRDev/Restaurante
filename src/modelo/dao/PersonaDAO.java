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
public class PersonaDAO extends EntidadAD implements metodosDAO<Persona> {

    private List<Persona> registros;
    private boolean resp;
    private Persona oPersona;
    private String query;

    public PersonaDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Persona> listar() {
        try {

            registros = new ArrayList<>();

            query = "{CALL  PERSONA_LISTAR()}"; // Sentencia SQL con la cual recuperamos los datos de la BD
            System.out.println(query);

            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPersona = new Persona();
                oPersona.setDni(rs.getString("dni").toUpperCase());
                oPersona.setNombres(rs.getString("nombre").toUpperCase());
                oPersona.setApellidoPaterno(rs.getString("apellido_paterno").toUpperCase());
                oPersona.setApellidoMaterno(rs.getString("apellido_materno").toUpperCase());
                oPersona.setSexo(rs.getString("sexo").toUpperCase());
                oPersona.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                registros.add(oPersona);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR USUARIOS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Persona Obj) {
        resp = false;
        try {

            query = "{CALL PERSONA_INSERTAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setString(1, Obj.getDni().toUpperCase());
            pc.setString(2, Obj.getNombres().toUpperCase());
            pc.setString(3, Obj.getApellidoPaterno().toUpperCase());
            pc.setString(4, Obj.getApellidoMaterno().toUpperCase());
            pc.setString(5, Obj.getSexo().toUpperCase());
            pc.setString(6, Obj.getFechaNacimiento());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PERSONA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Persona Obj) {
        resp = false;
        try {
            //Sentencia DML con la cual actualizamos los datos en la BD
            query = "{CALL PERSONA_ACTUALIZAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setString(1, Obj.getDni().toUpperCase());
            pc.setString(2, Obj.getNombres().toUpperCase());
            pc.setString(3, Obj.getApellidoPaterno().toUpperCase());
            pc.setString(4, Obj.getApellidoMaterno().toUpperCase());
            pc.setString(5, Obj.getSexo().toUpperCase());
            pc.setString(6, Obj.getFechaNacimiento());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PERSONA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Persona Obj) {
        resp = false;

        try {
            // Sentencia DML con la cual eliminamos datos de la BD
            query = "{CALL PERSONA_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getDni());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PERSONA" + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Persona Obj) {
        return 0;
    }

    @Override
    public Persona getObjeto(Persona Obj) {
        try {
            // Sentencia SQL con la cual recuperamos los datos de la BD
            query = "{CALL PERSONA_BUSCAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setString(1, Obj.getDni());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombres(rs.getString("nombre").toUpperCase());
                Obj.setApellidoPaterno(rs.getString("apellido_paterno").toUpperCase());
                Obj.setApellidoMaterno(rs.getString("apellido_materno").toUpperCase());
                Obj.setSexo(rs.getString("sexo").toUpperCase());
                Obj.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PERSONA CON ESTE CODIGO ");
            }
            
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PERSONA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Persona> listarPorDNI(Persona obj) {
        try {

            registros = new ArrayList<>();

            query = "{CALL  PERSONA_LISTAR_DNI(?)}"; // Sentencia SQL con la cual recuperamos los datos de la BD
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, "%"+obj.getDni()+"%");
            rs = pc.executeQuery();

            while (rs.next()) {
                oPersona = new Persona();
                oPersona.setDni(rs.getString("dni").toUpperCase());
                oPersona.setNombres(rs.getString("nombre").toUpperCase());
                oPersona.setApellidoPaterno(rs.getString("apellido_paterno").toUpperCase());
                oPersona.setApellidoMaterno(rs.getString("apellido_materno").toUpperCase());
                oPersona.setSexo(rs.getString("sexo").toUpperCase());
                oPersona.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                registros.add(oPersona);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR USUARIOS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }
    
}
