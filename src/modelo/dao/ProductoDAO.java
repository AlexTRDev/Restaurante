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
public class ProductoDAO extends EntidadAD implements metodosDAO<Producto> {

    private List<Producto> registros;
    private Producto oProducto;
    private String query;
    private boolean resp;
    private final CategoriaLN oCategoriaLN;
    
    public ProductoDAO(Connection connection) {
        super(connection);
        oCategoriaLN = new CategoriaLN();
    }

    @Override
    public List<Producto> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL `PRODUCTO_LISTAR`()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProducto = new Producto();
                oProducto.setCodigoProducto(rs.getInt("codigo"));
                oProducto.setNombreProducto(rs.getString("nombre"));
                oProducto.setStockProducto(rs.getDouble("stock"));
                oProducto.setUnidadMedidaProducto(rs.getString("unidad_medida"));
                oProducto.setContenidoProducto(rs.getString("contenido"));
                oProducto.setMonedaProducto(rs.getString("moneda"));
                oProducto.setPrecioUnitario(rs.getDouble("precio_unitario"));
                oProducto.setPrecioMedida(rs.getDouble("precio_medida"));
                oProducto.setStockMinimo(rs.getDouble("stock_minimo"));
                oProducto.setPrecioCompraProducto(rs.getDouble("precio_compra"));
                oProducto.setFotoProducto(rs.getBytes("foto"));
                oProducto.setoCategoria(oCategoriaLN.getObjeto(new Categoria(rs.getInt("CATEGORIAS_codigo"))));
                registros.add(oProducto);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Producto Obj) {
        resp = false;
        try {
            query = "{CALL PRODUCTO_INSERTAR(?,?,?,?,?,?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, Obj.getNombreProducto().toUpperCase());
            pc.setDouble(2, Obj.getStockProducto());
            pc.setString(3, Obj.getUnidadMedidaProducto().toUpperCase());
            pc.setString(4, Obj.getContenidoProducto().toUpperCase());
            pc.setString(5, Obj.getMonedaProducto());
            pc.setDouble(6, Obj.getPrecioUnitario());
            pc.setDouble(7, Obj.getPrecioMedida());
            pc.setDouble(8, Obj.getStockMinimo());
            pc.setDouble(9, Obj.getPrecioCompraProducto());
            pc.setBytes(10, Obj.getFotoProducto());
            pc.setInt(11, Obj.getoCategoria().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Producto Obj) {
        resp = false;
        try {

            query = "{CALL PRODUCTO_ACTUALIZAR(?,?,?,?,?,?,?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            
            pc.setInt(1, Obj.getCodigoProducto());
            pc.setString(2, Obj.getNombreProducto().toUpperCase());
            pc.setDouble(3, Obj.getStockProducto());
            pc.setString(4, Obj.getUnidadMedidaProducto().toUpperCase());
            pc.setString(5, Obj.getContenidoProducto().toUpperCase());
            pc.setString(6, Obj.getMonedaProducto());
            pc.setDouble(7, Obj.getPrecioUnitario());
            pc.setDouble(8, Obj.getPrecioMedida());
            pc.setDouble(9, Obj.getStockMinimo());
            pc.setDouble(10, Obj.getPrecioCompraProducto());
            pc.setBytes(11, Obj.getFotoProducto());
            pc.setInt(12, Obj.getoCategoria().getCodigo());
          
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PRODUCTO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Producto Obj) {
        resp = false;
        try {
            query = "{call PRODUCTO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigoProducto());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PRODUCTO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Producto Obj) {
        return 0;
    }

    @Override
    public Producto getObjeto(Producto Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PRODUCTO_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigoProducto());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombreProducto(rs.getString("nombre"));
                Obj.setStockProducto(rs.getDouble("stock"));
                Obj.setUnidadMedidaProducto(rs.getString("unidad_medida"));
                Obj.setContenidoProducto(rs.getString("contenido"));
                Obj.setMonedaProducto(rs.getString("moneda"));
                Obj.setPrecioUnitario(rs.getDouble("precio_unitario"));
                Obj.setPrecioMedida(rs.getDouble("precio_medida"));
                Obj.setStockMinimo(rs.getDouble("stock_minimo"));
                Obj.setPrecioCompraProducto(rs.getDouble("precio_compra"));
                Obj.setFotoProducto(rs.getBytes("foto"));
                Obj.setoCategoria(oCategoriaLN.getObjeto(new Categoria(rs.getInt("CATEGORIAS_codigo"))));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PRODUCTO CON ESTE CODIGO ");
            }
            
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Producto> listarPorCategoria(Categoria oCategoria){
       try {
            registros = new ArrayList<>();
            query = "{CALL `PRODUCTO_LISTAR_CATEGORIA`(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, oCategoria.getCodigo());
            rs = pc.executeQuery();

            while (rs.next()) {
                oProducto = new Producto();
                oProducto.setCodigoProducto(rs.getInt("codigo"));
                oProducto.setNombreProducto(rs.getString("nombre"));
                oProducto.setStockProducto(rs.getDouble("stock"));
                oProducto.setUnidadMedidaProducto(rs.getString("unidad_medida"));
                oProducto.setContenidoProducto(rs.getString("contenido"));
                oProducto.setMonedaProducto(rs.getString("moneda"));
                oProducto.setPrecioUnitario(rs.getDouble("precio_unitario"));
                oProducto.setPrecioMedida(rs.getDouble("precio_medida"));
                oProducto.setStockMinimo(rs.getDouble("stock_minimo"));
                oProducto.setPrecioCompraProducto(rs.getDouble("precio_compra"));
                oProducto.setFotoProducto(rs.getBytes("foto"));
                oProducto.setoCategoria(oCategoria);
                registros.add(oProducto);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PRODUCTO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    public int buscarNombre(Producto obj) {
        try {
            query = "CALL PRODUCTO_BUSCAR_NOMBRE(?)";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, obj.getNombreProducto());
            rs = pc.executeQuery();
            if (rs.next()) {
                return 1;
            }else{
                return -1;
            }
        } catch (SQLException e) {
            return -1;
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
