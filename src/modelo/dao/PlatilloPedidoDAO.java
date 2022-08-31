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
public class PlatilloPedidoDAO extends EntidadAD implements metodosDAO<PlatilloPedido> {

    private List<PlatilloPedido> registros;
    private PlatilloPedido oPlatilloPedido;
    private String query;
    private boolean resp;
    private final PlatilloLN oPlatilloLN;
    private final PedidoLN oPedidoLN;
    
    public PlatilloPedidoDAO(Connection connection) {
        super(connection);
        oPlatilloLN = new PlatilloLN();
        oPedidoLN = new PedidoLN();
    }

    @Override
    public List<PlatilloPedido> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PLATILLO_PEDIDO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPlatilloPedido = new PlatilloPedido();
                oPlatilloPedido.setoPlatillo(oPlatilloLN.getObjeto(new Platillo(rs.getInt("PLATILLOS_codigo"))));
                oPlatilloPedido.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                oPlatilloPedido.setCantidad(rs.getInt("cantidad"));
                oPlatilloPedido.setImporte(rs.getDouble("importe"));
                registros.add(oPlatilloPedido);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PLATILLO_PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PlatilloPedido Obj) {
        resp = false;
        try {
            query = "{CALL PLATILLO_PEDIDO_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoPlatillo().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            pc.setInt(3, Obj.getCantidad());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PLATILLO_PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PlatilloPedido Obj) {
        resp = false;
        try {
            query = "{CALL PLATILLO_PEDIDO_ACTUALIZAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoPlatillo().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            pc.setInt(3, Obj.getCantidad());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PLATILLO_PEDIDO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PlatilloPedido Obj) {
        resp = false;
        try {
            query = "{CALL PLATILLO_PEDIDO_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoPlatillo().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PLATILLO_PEDIDO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PlatilloPedido Obj) {
        return 0;
    }

    @Override
    public PlatilloPedido getObjeto(PlatilloPedido Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PLATILLO_PEDIDO_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
             pc.setInt(1, Obj.getoPlatillo().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPlatillo(oPlatilloLN.getObjeto(new Platillo(rs.getInt("PLATILLOS_codigo"))));
                Obj.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                Obj.setCantidad(rs.getInt("cantidad"));
                Obj.setImporte(rs.getDouble("importe"));    
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PLATILLO_PEDIDO CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PLATILLO_PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
