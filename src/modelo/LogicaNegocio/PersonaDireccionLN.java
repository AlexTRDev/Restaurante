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
public class PersonaDireccionLN implements metodosDAO<PersonaDireccion> {

    private Conexion oConexion;
    private PersonaDireccionDAO oPersonaDireccionDAO;

    @Override
    public List<PersonaDireccion> listar() {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaDireccionDAO = new PersonaDireccionDAO(oConexion.getConnection());

            return oPersonaDireccionDAO.listar();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(PersonaDireccion Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaDireccionDAO = new PersonaDireccionDAO(oConexion.getConnection());

            return oPersonaDireccionDAO.insertar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(PersonaDireccion Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaDireccionDAO = new PersonaDireccionDAO(oConexion.getConnection());

            return oPersonaDireccionDAO.actualizar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(PersonaDireccion Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaDireccionDAO = new PersonaDireccionDAO(oConexion.getConnection());

            return oPersonaDireccionDAO.eliminar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscaCodigo(PersonaDireccion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaDireccion getObjeto(PersonaDireccion obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaDireccionDAO = new PersonaDireccionDAO(oConexion.getConnection());

            return oPersonaDireccionDAO.getObjeto(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDireccionLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
