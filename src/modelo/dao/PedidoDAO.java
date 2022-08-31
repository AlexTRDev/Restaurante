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
public class PedidoDAO extends EntidadAD implements metodosDAO<Pedido> {

    private List<Pedido> registros;
    private Pedido oPedido;
    private String query;
    private boolean resp;
    
    public PedidoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Pedido> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PEDIDO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPedido = new Pedido();
                oPedido.setCodigo(rs.getInt("codigo"));
                oPedido.setFecha(rs.getString("fecha"));
                oPedido.setDetalle(rs.getString("detalle").toUpperCase());
                oPedido.setTipoPedido(rs.getString("tipo_pedidos").toUpperCase());
                oPedido.setDireccionDelivery(rs.getString("direccion_delivery").toUpperCase());
                registros.add(oPedido);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PEDIDOS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Pedido Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getFecha());
            pc.setString(2, Obj.getDetalle().toUpperCase());
            pc.setString(3, Obj.getTipoPedido().toUpperCase());
            pc.setString(4, Obj.getDireccionDelivery().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Pedido Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_ACTUALIZAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getFecha());
            pc.setString(3, Obj.getDetalle().toUpperCase());
            pc.setString(4, Obj.getTipoPedido().toUpperCase());
            pc.setString(5, Obj.getDireccionDelivery().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PEDIDO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Pedido Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PEDIDO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Pedido Obj) {
        return 0;
    }

    @Override
    public Pedido getObjeto(Pedido Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PEDIDO_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setCodigo(rs.getInt("codigo"));
                Obj.setFecha(rs.getString("fecha"));
                Obj.setDetalle(rs.getString("detalle").toUpperCase());
                Obj.setTipoPedido(rs.getString("tipo_pedidos").toUpperCase());
                Obj.setDireccionDelivery(rs.getString("direccion_delivery").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PEDIDO CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
