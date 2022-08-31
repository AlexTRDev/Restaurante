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
public class ProveedorCorreoLN implements metodosDAO<ProveedorCorreo> {

    private Conexion oConexion;
    private ProveedorCorreoDAO oProveedorCorreoDAO;

    @Override
    public List<ProveedorCorreo> listar() {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oProveedorCorreoDAO = new ProveedorCorreoDAO(oConexion.getConnection());

            return oProveedorCorreoDAO.listar();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(ProveedorCorreo Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oProveedorCorreoDAO = new ProveedorCorreoDAO(oConexion.getConnection());

            return oProveedorCorreoDAO.insertar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(ProveedorCorreo Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oProveedorCorreoDAO = new ProveedorCorreoDAO(oConexion.getConnection());

            return oProveedorCorreoDAO.actualizar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(ProveedorCorreo Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oProveedorCorreoDAO = new ProveedorCorreoDAO(oConexion.getConnection());

            return oProveedorCorreoDAO.eliminar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscaCodigo(ProveedorCorreo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProveedorCorreo getObjeto(ProveedorCorreo obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oProveedorCorreoDAO = new ProveedorCorreoDAO(oConexion.getConnection());

            return oProveedorCorreoDAO.getObjeto(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
