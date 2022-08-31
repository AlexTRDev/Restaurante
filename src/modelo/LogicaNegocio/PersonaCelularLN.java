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
public class PersonaCelularLN implements metodosDAO<PersonaCelular> {

    private Conexion oConexion;
    private PersonaCelularDAO oPersonaCelularDAO;

    @Override
    public List<PersonaCelular> listar() {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaCelularDAO = new PersonaCelularDAO(oConexion.getConnection());

            return oPersonaCelularDAO.listar();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(PersonaCelular Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaCelularDAO = new PersonaCelularDAO(oConexion.getConnection());

            return oPersonaCelularDAO.insertar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(PersonaCelular Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaCelularDAO = new PersonaCelularDAO(oConexion.getConnection());

            return oPersonaCelularDAO.actualizar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(PersonaCelular Obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaCelularDAO = new PersonaCelularDAO(oConexion.getConnection());

            return oPersonaCelularDAO.eliminar(Obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscaCodigo(PersonaCelular obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaCelular getObjeto(PersonaCelular obj) {
        try {
            oConexion = new Conexion(); //abrimos la conexion
            oConexion.abrirConnection();

            oPersonaCelularDAO = new PersonaCelularDAO(oConexion.getConnection());

            return oPersonaCelularDAO.getObjeto(obj);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                oConexion.cerrarConnection();   //cerramos la conexion
            } catch (SQLException ex) {
                Logger.getLogger(PersonaCelularLN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
