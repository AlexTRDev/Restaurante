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
public class MesaPedidoDAO extends EntidadAD implements metodosDAO<MesaPedido> {

    private List<MesaPedido> registros;
    private MesaPedido oMesaPedido;
    private String query;
    private boolean resp;
    private final MesaLN oMesaLN;
    private final PedidoLN oPedidoLN;
    
    public MesaPedidoDAO(Connection connection) {
        super(connection);
        oMesaLN = new MesaLN();
        oPedidoLN = new PedidoLN();
    }

    @Override
    public List<MesaPedido> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL MESA_PEDIDO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oMesaPedido = new MesaPedido();
                oMesaPedido.setoMesa(oMesaLN.getObjeto(new Mesa(rs.getInt("MESAS_codigo"))));
                oMesaPedido.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                registros.add(oMesaPedido);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR MESA_PEDIDOS" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(MesaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(MesaPedido Obj) {
        resp = false;
        try {
            query = "{CALL MESA_PEDIDO_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoMesa().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR MESA_PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MesaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(MesaPedido Obj) {
        resp = false;
        try {
            query = "{CALL MESA_PEDIDO_ACTUALIZAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoMesa().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR MESA_PEDIDO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MesaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(MesaPedido Obj) {
        resp = false;
        try {
            query = "{CALL MESA_PEDIDO_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoMesa().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR MESA_PEDIDO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(MesaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(MesaPedido Obj) {
        return 0;
    }

    @Override
    public MesaPedido getObjeto(MesaPedido Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL MESA_PEDIDO_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoMesa().getCodigo());
            pc.setInt(2, Obj.getoPedido().getCodigo());
            
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoMesa(oMesaLN.getObjeto(new Mesa(rs.getInt("MESAS_codigo"))));
                Obj.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE MESA_PEDIDO CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR MESA_PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(MesaPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
