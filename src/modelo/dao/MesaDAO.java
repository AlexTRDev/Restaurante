package modelo.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import modelo.AccesoBD.*;
import modelo.Entidades.*;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class MesaDAO extends EntidadAD implements metodosDAO<Mesa> {

    private List<Mesa> registros;
    private Mesa oMesa;
    private String query;
    private boolean resp;
    
    public MesaDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Mesa> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL MESA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oMesa = new Mesa();
                oMesa.setCodigo(rs.getInt("codigo"));
                oMesa.setEstado(rs.getBoolean("estado"));
                oMesa.setNumeroPersonas(rs.getInt("numero_personas"));
                oMesa.setHoraEntrada(rs.getString("hora_entrada"));
                oMesa.setHoraSalida(rs.getString("hora_salida"));
                oMesa.setMesaNumero(rs.getInt("mesa_numero"));
                registros.add(oMesa);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR MESAS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Mesa Obj) {
        resp = false;
        try {
            query = "{CALL MESA_INSERTAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setBoolean(1, Obj.getEstado());
            pc.setInt(2, Obj.getNumeroPersonas());
            pc.setString(3, Obj.getHoraEntrada());
            pc.setString(4, Obj.getHoraSalida());
            pc.setInt(5, Obj.getMesaNumero());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR MESA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Mesa Obj) {
        resp = false;
        try {
            query = "{CALL MESA_ACTUALIZAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setBoolean(2, Obj.getEstado());
            pc.setInt(3, Obj.getNumeroPersonas());
            pc.setString(4, Obj.getHoraEntrada());
            pc.setString(5, Obj.getHoraSalida());
            pc.setInt(6, Obj.getMesaNumero());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR MESA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Mesa Obj) {
        resp = false;
        try {
            query = "{CALL MESA_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR MESA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Mesa Obj) {
        return 0;
    }

    @Override
    public Mesa getObjeto(Mesa Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL MESA_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setCodigo(rs.getInt("codigo"));
                Obj.setEstado(rs.getBoolean("estado"));
                Obj.setNumeroPersonas(rs.getInt("numero_personas"));
                Obj.setHoraEntrada(rs.getString("hora_entrada"));
                Obj.setHoraSalida(rs.getString("hora_salida"));
                Obj.setMesaNumero(rs.getInt("mesa_numero"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE MESA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR MESA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(MesaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
