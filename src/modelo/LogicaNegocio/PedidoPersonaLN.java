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
public class PedidoPersonaLN implements metodosDAO<PedidoPersona> {

    private Conexion oConexion;
    private PedidoPersonaDAO oPedidoPersonaDAO;

    @Override
    public List<PedidoPersona> listar() {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPedidoPersonaDAO = new PedidoPersonaDAO(oConexion.getConnection());

            return oPedidoPersonaDAO.listar();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(PedidoPersona Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPedidoPersonaDAO = new PedidoPersonaDAO(oConexion.getConnection());

            return oPedidoPersonaDAO.insertar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(PedidoPersona Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPedidoPersonaDAO = new PedidoPersonaDAO(oConexion.getConnection());

            return oPedidoPersonaDAO.actualizar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(PedidoPersona Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPedidoPersonaDAO = new PedidoPersonaDAO(oConexion.getConnection());

            return oPedidoPersonaDAO.eliminar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscaCodigo(PedidoPersona obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoPersona getObjeto(PedidoPersona obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPedidoPersonaDAO = new PedidoPersonaDAO(oConexion.getConnection());

            return oPedidoPersonaDAO.getObjeto(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PedidoPersonaLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
