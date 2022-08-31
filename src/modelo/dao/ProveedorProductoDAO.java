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
public class ProveedorProductoDAO extends EntidadAD implements metodosDAO<ProveedorProducto> {

    private List<ProveedorProducto> registros;
    private ProveedorProducto oProveedorProducto;
    private String query;
    private boolean resp;
    private final ProveedorLN oProveedorLN;
    private final ProductoLN oProductoLN;
    
    public ProveedorProductoDAO(Connection connection) {
        super(connection);
        oProveedorLN = new ProveedorLN();
        oProductoLN = new ProductoLN();
    }

    @Override
    public List<ProveedorProducto> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PROVEEDOR_PRODUCTO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProveedorProducto = new ProveedorProducto();
                oProveedorProducto.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                oProveedorProducto.setoProducto(oProductoLN.getObjeto(new Producto(rs.getInt("PRODUCTOS_codigo"))));
                oProveedorProducto.setFecha(rs.getString("fecha"));
                oProveedorProducto.setDetalle(rs.getString("detalle"));
                registros.add(oProveedorProducto);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PROVEEDOR_PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(ProveedorProducto Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_PRODUCTO_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setInt(2, Obj.getoProducto().getCodigoProducto());
            pc.setString(3, Obj.getFecha());
            pc.setString(4, Obj.getDetalle());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PROVEEDOR_PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(ProveedorProducto Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_PRODUCTO_ACTUALIZAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setInt(2, Obj.getoProducto().getCodigoProducto());
            pc.setString(3, Obj.getFecha());
            pc.setString(4, Obj.getDetalle());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PROVEEDOR_PRODUCTO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(ProveedorProducto Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_PRODUCTO_VENTA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setInt(2, Obj.getoProducto().getCodigoProducto());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PROVEEDOR_PRODUCTO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(ProveedorProducto Obj) {
        return 0;
    }

    @Override
    public ProveedorProducto getObjeto(ProveedorProducto Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PROVEEDOR_PRODUCTO_VENTA_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setInt(2, Obj.getoProducto().getCodigoProducto());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                Obj.setoProducto(oProductoLN.getObjeto(new Producto(rs.getInt("PRODUCTOS_codigo"))));
                Obj.setFecha(rs.getString("fecha"));
                Obj.setDetalle(rs.getString("detalle")); 
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PROVEEDOR_PRODUCTO CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PROVEEDOR_PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
