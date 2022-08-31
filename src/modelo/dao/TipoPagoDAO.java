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
public class TipoPagoDAO extends EntidadAD implements metodosDAO<TipoPago> {

    private List<TipoPago> registros;
    private TipoPago oTipoPago;
    private String query;
    private boolean resp;
    
    public TipoPagoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<TipoPago> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL TIPO_PAGO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oTipoPago = new TipoPago();
                oTipoPago.setCodigo(rs.getInt("codigo"));
                oTipoPago.setNombre(rs.getString("nombre").toUpperCase());
                oTipoPago.setDescripcion(rs.getString("descripcion").toUpperCase());
                registros.add(oTipoPago);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR TIPO_PAGOS" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(TipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(TipoPago Obj) {
        resp = false;
        try {
            query = "{CALL TIPO_PAGO_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getNombre().toUpperCase());
            pc.setString(2, Obj.getDescripcion().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR TIPO_PAGO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(TipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(TipoPago Obj) {
        resp = false;
        try {
            query = "{CALL TIPO_PAGO_ACTUALIZAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getNombre().toUpperCase());
            pc.setString(3, Obj.getDescripcion().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR TIPO_PAGO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(TipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(TipoPago Obj) {
        resp = false;
        try {
            query = "{CALL TIPO_PAGO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR TIPO_PAGO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(TipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(TipoPago Obj) {
        return 0;
    }

    @Override
    public TipoPago getObjeto(TipoPago Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL TIPO_PAGO_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombre(rs.getString("nombre").toUpperCase());
                Obj.setDescripcion(rs.getString("descripcion").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE TIPO_PAGO CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR TIPO_PAGO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(TipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
