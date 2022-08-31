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
public class ProductoVentaDAO extends EntidadAD implements metodosDAO<ProductoVenta> {

    private List<ProductoVenta> registros;
    private ProductoVenta oProductoVenta;
    private String query;
    private boolean resp;
    private final ProductoLN oProductoLN;
    private final VentaLN oVentaLN;
    
    public ProductoVentaDAO(Connection connection) {
        super(connection);
        oProductoLN = new ProductoLN();
        oVentaLN = new VentaLN();
    }

    @Override
    public List<ProductoVenta> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PRODUCTO_VENTA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProductoVenta = new ProductoVenta();
                oProductoVenta.setoProducto(oProductoLN.getObjeto(new Producto(rs.getInt("codigo"))));
                oProductoVenta.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("codigo"))));
                oProductoVenta.setCantidad(rs.getDouble("cantidad"));
                oProductoVenta.setImporte(rs.getDouble("importe"));
                registros.add(oProductoVenta);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PRODUCTO_VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProductoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(ProductoVenta Obj) {
        resp = false;
        try {
            query = "{CALL PRODUCTO_VENTA_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoProducto().getCodigoProducto());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            pc.setDouble(3, Obj.getCantidad());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PRODUCTO_VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProductoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(ProductoVenta Obj) {
        resp = false;
        try {
            query = "{CALL PRODUCTO_VENTA_ACTUALIZAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getoProducto().getCodigoProducto());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            pc.setDouble(3, Obj.getCantidad());
            pc.setDouble(4, Obj.getImporte());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PRODUCTO_VENTA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProductoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(ProductoVenta Obj) {
        resp = false;
        try {
            query = "{CALL PRODUCTO_VENTA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getoProducto().getCodigoProducto());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PRODUCTO_VENTA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProductoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(ProductoVenta Obj) {
        return 0;
    }

    @Override
    public ProductoVenta getObjeto(ProductoVenta Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PRODUCTO_VENTA_BUSCAR(?,?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getoProducto().getCodigoProducto());
            pc.setInt(2, Obj.getoVenta().getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoProducto(oProductoLN.getObjeto(new Producto(rs.getInt("codigo"))));
                Obj.setoVenta(oVentaLN.getObjeto(new Venta(rs.getInt("codigo"))));
                Obj.setCantidad(rs.getDouble("cantidad"));
                Obj.setImporte(rs.getDouble("importe"));    
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PRODUCTO_VENTA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PRODUCTO_VENTA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProductoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
