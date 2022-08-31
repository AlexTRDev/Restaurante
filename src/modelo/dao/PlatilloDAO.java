package modelo.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import modelo.AccesoBD.EntidadAD;
import modelo.Entidades.*;
import modelo.dao.interfaces.metodosDAO;

/**
 *
 * @author ALEX
 */
public class PlatilloDAO extends EntidadAD implements metodosDAO<Platillo> {

    private List<Platillo> registros;
    private boolean resp;
    private Platillo oPlatillo;
    private String query;

    public PlatilloDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Platillo> listar() {
        try {

            registros = new ArrayList<>();

            query = "{CALL  PLATILLO_LISTAR()}"; // Sentencia SQL con la cual recuperamos los datos de la BD
            System.out.println(query);

            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oPlatillo = new Platillo();
                oPlatillo.setCodigo(rs.getInt("codigo"));
                oPlatillo.setNombre(rs.getString("nombre").toUpperCase());
                oPlatillo.setPrecio(rs.getDouble("precio"));
                oPlatillo.setDetalle(rs.getString("detalle").toUpperCase());
                oPlatillo.setFoto(rs.getString("foto"));
                registros.add(oPlatillo);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR PLATILLOS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Platillo Obj) {
        resp = false;
        try {

            query = "{CALL PLATILLO_INSERTAR(?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setString(1, Obj.getNombre().toUpperCase());
            pc.setDouble(2, Obj.getPrecio());
            pc.setString(3, Obj.getDetalle().toUpperCase());
            pc.setString(4, Obj.getFoto());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR PLATILLO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Platillo Obj) {
        resp = false;
        try {
            //Sentencia DML con la cual actualizamos los datos en la BD
            query = "{CALL PLATILLO_ACTUALIZAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getNombre().toUpperCase());
            pc.setDouble(3, Obj.getPrecio());
            pc.setString(4, Obj.getDetalle().toUpperCase());
            pc.setString(5, Obj.getFoto());
            pc.executeUpdate();
            
            return resp = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR PLATILLO " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Platillo Obj) {
        resp = false;

        try {
            // Sentencia DML con la cual eliminamos datos de la BD
            query = "{CALL PLATILLO_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR PLATILLO" + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Platillo Obj) {
        return 0;
    }

    @Override
    public Platillo getObjeto(Platillo Obj) {
        try {
            // Sentencia SQL con la cual recuperamos los datos de la BD
            query = "{CALL PLATILLO_BUSCAR(?)}";

            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombre(rs.getString("nombre").toUpperCase());
                Obj.setPrecio(rs.getDouble("precio"));
                Obj.setDetalle(rs.getString("detalle").toUpperCase());
                Obj.setFoto(rs.getString("foto"));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PLATILLO CON ESTE CODIGO ");
            }
            
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR PLATILLO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(PlatilloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
