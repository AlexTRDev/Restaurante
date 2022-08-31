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
public class PedidoPersonaDAO extends EntidadAD implements metodosDAO<PedidoPersona> {

    private List<PedidoPersona> registros;
    private PedidoPersona oPedidoPersona;
    private String query;
    private boolean resp;
    private final PersonaLN oPersonaLN;
    private final PedidoLN oPedidoLN;
    
    public PedidoPersonaDAO(Connection connection) {
        super(connection);
        oPersonaLN = new PersonaLN();
        oPedidoLN = new PedidoLN();
    }

    @Override
    public List<PedidoPersona> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PEDIDO_PERSONA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPedidoPersona = new PedidoPersona();
                oPedidoPersona.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                oPedidoPersona.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
                registros.add(oPedidoPersona);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PEDIDO_PERSONA" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(PedidoPersona Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_PERSONA_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PEDIDO_PERSONA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(PedidoPersona Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_PERSONA_ACTUALIZAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PEDIDO_PERSONA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(PedidoPersona Obj) {
        resp = false;
        try {
            query = "{CALL PEDIDO_PERSONA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PEDIDO_PERSONA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(PedidoPersona Obj) {
        return 0;
    }

    @Override
    public PedidoPersona getObjeto(PedidoPersona Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PEDIDO_PERSONA_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoPedido().getCodigo());
            pc.setString(2, Obj.getoPersona().getDni());
            
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoPedido(oPedidoLN.getObjeto(new Pedido(rs.getInt("PEDIDOS_codigo"))));
                Obj.setoPersona(oPersonaLN.getObjeto(new Persona(rs.getString("PERSONAS_dni"))));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PEDIDO_PERSONA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PEDIDO_PERSONA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
