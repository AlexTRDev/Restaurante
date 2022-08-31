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
public class PedidoVentaDAO extends EntidadAD implements metodosDAO<PedidoVenta> {

    private List<PedidoVenta> registros;
    private PedidoVenta OPedidoVenta;
    private String query;
    private boolean resp;
    private final PedidoLN oPedidoLN;
    private final VentaLN oVentaLN;
    
    public PedidoVentaDAO(Connection connection) {
        super(connection);
        oPedidoLN = new PedidoLN();
        oVentaLN = new VentaLN();
    }

    @Override
    public List<PedidoVenta> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PEDIDO_VENTA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                OPedidoVenta = new PedidoVenta();
                OPedidoVenta.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                OPedidoVenta.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("VENTAS_codigo"))));
                OPedidoVenta.setDetalle(rs.getString("detalles"));
                OPedidoVenta.setImporte(rs.getDouble("importe"));
                registros.add(OPedidoVenta);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PEDIDO_VENTAS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PedidoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PedidoVenta Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_VENTA_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            pc.setString(3, Obj.getDetalle());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PEDIDO_VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PedidoVenta Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_VENTA_ACTUALIZAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            pc.setString(3, Obj.getDetalle());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PEDIDO_VENTA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PedidoVenta Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_VENTA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PEDIDO_VENTA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PedidoVenta Obj) {
        return 0;
    }

    @Override
    public PedidoVenta getObjeto(PedidoVenta Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PEDIDO_VENTA_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                Obj.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("VENTAS_codigo"))));
                Obj.setDetalle(rs.getString("detalles"));
                Obj.setImporte(rs.getDouble("importe"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PEDIDO_VENTA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PEDIDO_VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PedidoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
