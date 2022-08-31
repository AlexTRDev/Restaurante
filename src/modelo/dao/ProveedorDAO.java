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
public class ProveedorDAO extends EntidadAD implements metodosDAO<Proveedor> {

    private List<Proveedor> registros;
    private Proveedor oProveedor;
    private String query;
    private boolean resp;
    
    public ProveedorDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Proveedor> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PROVEEDOR_LISTAR}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProveedor = new Proveedor();
                oProveedor.setRuc(rs.getInt("ruc"));
                oProveedor.setNombre(rs.getString("nombre").toUpperCase());
                oProveedor.setPagina_web(rs.getString("pagina_web").toUpperCase());
                registros.add(oProveedor);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PROVEEDORES" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Proveedor Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_INSERTAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getRuc());
            pc.setString(2, Obj.getNombre().toUpperCase());
            pc.setString(3, Obj.getPagina_web().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PROVEEDOR " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Proveedor Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_ACTUALIZAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getRuc());
            pc.setString(2, Obj.getNombre().toUpperCase());
            pc.setString(3, Obj.getPagina_web().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PROVEEDOR " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Proveedor Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getRuc());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PROVEEDOR " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Proveedor Obj) {
        return 0;
    }

    @Override
    public Proveedor getObjeto(Proveedor Obj) {
        try {
            registros = new ArrayList<>();
            // SELECT * FROM `usuarios` WHERE 1
            query = "CALL PROVEEDOR_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getRuc());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombre(rs.getString("nombre").toUpperCase());
                Obj.setPagina_web(rs.getString("pagina_web").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PROVEEDOR CON ESTE RUC ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PROVEEDOR " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
