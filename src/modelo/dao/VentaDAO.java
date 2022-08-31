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
public class VentaDAO extends EntidadAD implements metodosDAO<Venta> {

    private List<Venta> registros;
    private Venta oVenta;
    private String query;
    private boolean resp;
    private final CajaLN oCajaLN;
    
    public VentaDAO(Connection connection) {
        super(connection);
        oCajaLN = new CajaLN();
    }

    @Override
    public List<Venta> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL VENTA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oVenta = new Venta();
                oVenta.setCodigo(rs.getInt("codigo"));
                oVenta.setFecha(rs.getString("fecha"));
                oVenta.setSubTotal(rs.getDouble("subtotal"));
                oVenta.setDescuento(rs.getDouble("descuento"));
                oVenta.setMontoFinal(rs.getDouble("monto_final"));
                oVenta.setoCaja(oCajaLN.getObjeto(new Caja((rs.getInt("CAJA_codigo")))));
                registros.add(oVenta);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR VENTAS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Venta Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_INSERTAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getFecha());
            pc.setDouble(2, Obj.getSubTotal());
            pc.setDouble(3, Obj.getDescuento());
            pc.setDouble(4, Obj.getMontoFinal());
            pc.setInt(5, Obj.getoCaja().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Venta Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_ACTUALIZAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getFecha());
            pc.setDouble(3, Obj.getSubTotal());
            pc.setDouble(4, Obj.getDescuento());
            pc.setDouble(5, Obj.getMontoFinal());
            pc.setInt(6, Obj.getoCaja().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR VENTA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Venta Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR VENTA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Venta Obj) {
        return 0;
    }

    @Override
    public Venta getObjeto(Venta Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL VENTA_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setFecha(rs.getString("fecha"));
                Obj.setSubTotal(rs.getDouble("subtotal"));
                Obj.setDescuento(rs.getDouble("descuento"));
                Obj.setMontoFinal(rs.getDouble("monto_final"));
                Obj.setoCaja(oCajaLN.getObjeto(new Caja((rs.getInt("CAJA_codigo")))));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE VENTA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
