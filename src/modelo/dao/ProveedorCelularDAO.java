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
public class ProveedorCelularDAO extends EntidadAD implements metodosDAO<ProveedorCelular> {

    private List<ProveedorCelular> registros;
    private ProveedorCelular oProveedorCelular;
    private String query;
    private boolean resp;
    private final ProveedorLN oProveedorLN;
    
    public ProveedorCelularDAO(Connection connection) {
        super(connection);
        oProveedorLN = new ProveedorLN();
    }

    @Override
    public List<ProveedorCelular> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL PROVEEDOR_CELULAR_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oProveedorCelular = new ProveedorCelular();
                oProveedorCelular.setCodigo(rs.getInt("codigo"));
                oProveedorCelular.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                oProveedorCelular.setCelular(rs.getString("celular"));
                registros.add(oProveedorCelular);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PROVEEDOR_CELULAR" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(ProveedorCelular Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_CELULAR_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getoProveedor().getRuc());
            pc.setString(2, Obj.getCelular());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PROVEEDOR_CELULAR " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(ProveedorCelular Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_CELULAR_ACTUALIZAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setInt(2, Obj.getoProveedor().getRuc());
            pc.setString(3, Obj.getCelular().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PROVEEDOR_CELULAR " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(ProveedorCelular Obj) {
        resp = false;
        try {
            query = "{CALL PROVEEDOR_CELULAR_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PROVEEDOR_CELULAR " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(ProveedorCelular Obj) {
        return 0;
    }

    @Override
    public ProveedorCelular getObjeto(ProveedorCelular Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL PROVEEDOR_CELULAR_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setoProveedor(oProveedorLN.getObjeto(new Proveedor(rs.getInt("PROVEEDORES_ruc"))));
                Obj.setCelular(rs.getString("celular"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PROVEEDOR_CELULAR CON ESTE DNI ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PROVEEDOR_CELULAR " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(ProveedorCelularDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
