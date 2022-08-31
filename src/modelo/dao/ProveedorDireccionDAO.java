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
public class ProveedorDireccionDAO extends EntidadAD implements metodosDAO<ProveedorDireccion> {

    private List<ProveedorDireccion> registros;
    private ProveedorDireccion oProveedorDireccion;
    private String query;
    private boolean resp;
    private final ProveedorLN oProveedorLN;
    
    public ProveedorDireccionDAO(Connection connection) {
        super(connection);
        oProveedorLN = new ProveedorLN();
    }

    @Override
    public List<ProveedorDireccion> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PROVEEDOR_DIRECCION_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProveedorDireccion = new ProveedorDireccion();
                oProveedorDireccion.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                oProveedorDireccion.setCalle(rs.getString("calle"));
                oProveedorDireccion.setNumero(rs.getString("numero"));
                oProveedorDireccion.setCiudad(rs.getString("ciudad"));
                oProveedorDireccion.setDepartamento(rs.getString("departamento"));
                oProveedorDireccion.setPais(rs.getString("pais"));
                registros.add(oProveedorDireccion);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PROVEEDOR_DIRECCION" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(ProveedorDireccion Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_DIRECCION_INSERTAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setString(2, Obj.getCalle());
            pc.setString(3, Obj.getNumero());
            pc.setString(4, Obj.getCiudad());
            pc.setString(5, Obj.getDepartamento());
            pc.setString(6, Obj.getPais());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PROVEEDOR_DIRECCION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(ProveedorDireccion Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_DIRECCION_ACTUALIZAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setString(2, Obj.getCalle());
            pc.setString(3, Obj.getNumero());
            pc.setString(4, Obj.getCiudad());
            pc.setString(5, Obj.getDepartamento());
            pc.setString(6, Obj.getPais());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PROVEEDOR_DIRECCION " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(ProveedorDireccion Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_DIRECCION_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PROVEEDOR_DIRECCION " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(ProveedorDireccion Obj) {
        return 0;
    }

    @Override
    public ProveedorDireccion getObjeto(ProveedorDireccion Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PROVEEDOR_DIRECCION_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoProveedor().getRuc());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                Obj.setCalle(rs.getString("calle"));
                Obj.setNumero(rs.getString("numero"));
                Obj.setCiudad(rs.getString("ciudad"));
                Obj.setDepartamento(rs.getString("departamento"));
                Obj.setPais(rs.getString("pais"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PROVEEDOR_DIRECCION CON ESTE DNI ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PROVEEDOR_DIRECCION " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDireccionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
