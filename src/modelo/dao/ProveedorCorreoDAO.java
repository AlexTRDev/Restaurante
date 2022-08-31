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
public class ProveedorCorreoDAO extends EntidadAD implements metodosDAO<ProveedorCorreo> {

    private List<ProveedorCorreo> registros;
    private ProveedorCorreo oProveedorCorreo;
    private String query;
    private boolean resp;
    private final ProveedorLN oProveedorLN;
    
    public ProveedorCorreoDAO(Connection connection) {
        super(connection);
        oProveedorLN = new ProveedorLN();
    }

    @Override
    public List<ProveedorCorreo> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PROVEEDOR_CORREO_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProveedorCorreo = new ProveedorCorreo();
                oProveedorCorreo.setCodigo(rs.getInt("codigo"));
                oProveedorCorreo.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                oProveedorCorreo.setCorreo(rs.getString("correo").toUpperCase());
                registros.add(oProveedorCorreo);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PROVEEDOR_CORREO" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(ProveedorCorreo Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_CORREO_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setString(2, Obj.getCorreo().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PROVEEDOR_CORREO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(ProveedorCorreo Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_CORREO_ACTUALIZAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setInt(2, Obj.getoProveedor().getRuc());
            pc.setString(3, Obj.getCorreo().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PROVEEDOR_CORREO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(ProveedorCorreo Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_CORREO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PROVEEDOR_CORREO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(ProveedorCorreo Obj) {
        return 0;
    }

    @Override
    public ProveedorCorreo getObjeto(ProveedorCorreo Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PROVEEDOR_CORREO_CORREO_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                Obj.setCorreo(rs.getString("correo").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PROVEEDOR_CORREO CON ESTE RUC ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PROVEEDOR_CORREO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCorreoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
