package modelo.LogicaNegocio;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.*;
import modelo.AccesoBD.Conexion;
import modelo.Entidades.*;
import modelo.dao.*;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class PlatilloPedidoLN implements metodosDAO<PlatilloPedido> {

    private Conexion oConexion;
    private PlatilloPedidoDAO oPlatilloPedidoDAO;

    @Override
    public List<PlatilloPedido> listar() {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPlatilloPedidoDAO = new PlatilloPedidoDAO(oConexion.getConnection());

            return oPlatilloPedidoDAO.listar();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(PlatilloPedido Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPlatilloPedidoDAO = new PlatilloPedidoDAO(oConexion.getConnection());

            return oPlatilloPedidoDAO.insertar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(PlatilloPedido Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPlatilloPedidoDAO = new PlatilloPedidoDAO(oConexion.getConnection());

            return oPlatilloPedidoDAO.actualizar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(PlatilloPedido Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPlatilloPedidoDAO = new PlatilloPedidoDAO(oConexion.getConnection());

            return oPlatilloPedidoDAO.eliminar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscaCodigo(PlatilloPedido obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlatilloPedido getObjeto(PlatilloPedido obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPlatilloPedidoDAO = new PlatilloPedidoDAO(oConexion.getConnection());

            return oPlatilloPedidoDAO.getObjeto(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PlatilloPedidoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
