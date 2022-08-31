package modelo.LogicaNegocio;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AccesoBD.Conexion;
import modelo.Entidades.TipoUsuario;
import modelo.dao.TipoUsuarioDAO;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class TipoUsuarioLN implements metodosDAO<TipoUsuario> {

    private Conexion oConexion;
    private TipoUsuarioDAO oTipoUsuariosDAO;

    @Override
    public List<TipoUsuario> listar() {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oTipoUsuariosDAO = new TipoUsuarioDAO(oConexion.getConnection());

            return oTipoUsuariosDAO.listar();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(TipoUsuario Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oTipoUsuariosDAO = new TipoUsuarioDAO(oConexion.getConnection());

            return oTipoUsuariosDAO.insertar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(TipoUsuario Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oTipoUsuariosDAO = new TipoUsuarioDAO(oConexion.getConnection());

            return oTipoUsuariosDAO.actualizar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(TipoUsuario Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oTipoUsuariosDAO = new TipoUsuarioDAO(oConexion.getConnection());

            return oTipoUsuariosDAO.eliminar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscaCodigo(TipoUsuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoUsuario getObjeto(TipoUsuario obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oTipoUsuariosDAO = new TipoUsuarioDAO(oConexion.getConnection());

            return oTipoUsuariosDAO.getObjeto(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int buscarNombre(TipoUsuario obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oTipoUsuariosDAO = new TipoUsuarioDAO(oConexion.getConnection());

            return oTipoUsuariosDAO.buscarNombre(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(TipoUsuarioLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1;
    }
}
