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
public class VentaFacturaDAO extends EntidadAD implements metodosDAO<VentaFactura> {

    private List<VentaFactura> registros;
    private VentaFactura oVentaFactura;
    private String query;
    private boolean resp;
    private final VentaLN oVentaLN;
    private final FacturaLN oFacturaLN;
    
    public VentaFacturaDAO(Connection connection) {
        super(connection);
        oVentaLN = new VentaLN();
        oFacturaLN = new FacturaLN();
    }

    @Override
    public List<VentaFactura> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL VENTA_FACTURA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oVentaFactura = new VentaFactura();
                oVentaFactura.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("VENTAS_codigo"))));
                oVentaFactura.setoFactura(oFacturaLN.getObjeto(new Factura(rs.getInt("FACTURAS_codigo"))));
                oVentaFactura.setDetalle(rs.getString("detalle"));
                oVentaFactura.setImporte(rs.getDouble("importe"));
                registros.add(oVentaFactura);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR VENTA_FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(VentaFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(VentaFactura Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_FACTURA_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoFactura().getCodigo());
            pc.setString(3, Obj.getDetalle());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR VENTA_FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(VentaFactura Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_FACTURA_ACTUALIZAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoFactura().getCodigo());
            pc.setString(3, Obj.getDetalle());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR VENTA_FACTURA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(VentaFactura Obj) {
        resp = false;
        try {
            query = "{CALL VENTA_FACTURA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoFactura().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR VENTA_FACTURA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(VentaFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(VentaFactura Obj) {
        return 0;
    }

    @Override
    public VentaFactura getObjeto(VentaFactura Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL VENTA_FACTURA_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoVenta().getCodigo());
            pc.setInt(2, Obj.getoFactura().getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("codigo"))));
                Obj.setoFactura(oFacturaLN.getObjeto(new Factura(rs.getInt("codigo"))));
                Obj.setDetalle(rs.getString("detalle"));
                Obj.setImporte(rs.getDouble("importe"));
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
                Logger.getLogger(VentaFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
