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
public class VentaTipoPagoDAO extends EntidadAD implements metodosDAO<VentaTipoPago> {

    private List<VentaTipoPago> registros;
    private VentaTipoPago oVentaTipoPago;
    private String query;
    private boolean resp;
    private final VentaLN oVentaLN;
    private final TipoPagoLN oTipoPagoLN;
    
    public VentaTipoPagoDAO(Connection connection) {
        super(connection);
        oVentaLN = new VentaLN();
        oTipoPagoLN = new TipoPagoLN();
    }

    @Override
    public List<VentaTipoPago> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL VENTA_FACTURA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oVentaTipoPago = new VentaTipoPago();
                oVentaTipoPago.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("VENTAS_codigo"))));
                oVentaTipoPago.setoTipoPago(oTipoPagoLN.getObjeto(new TipoPago(rs.getInt("TIPO_PAGOS_codigo"))));
                registros.add(oVentaTipoPago);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR VENTA_FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(VentaTipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(VentaTipoPago Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_FACTURA_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoTipoPago().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR VENTA_FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaTipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(VentaTipoPago Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_FACTURA_ACTUALIZAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoTipoPago().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR VENTA_FACTURA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaTipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(VentaTipoPago Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_FACTURA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoTipoPago().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR VENTA_FACTURA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaTipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(VentaTipoPago Obj) {
        return 0;
    }

    @Override
    public VentaTipoPago getObjeto(VentaTipoPago Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL VENTA_FACTURA_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoTipoPago().getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("VENTAS_codigo"))));
                Obj.setoTipoPago(oTipoPagoLN.getObjeto(new TipoPago(rs.getInt("TIPO_PAGOS_codigo"))));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE VENTA_FACTURA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR VENTA_FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(VentaTipoPagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
