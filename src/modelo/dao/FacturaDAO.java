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
public class FacturaDAO extends EntidadAD implements metodosDAO<Factura> {

    private List<Factura> registros;
    private boolean resp;
    private Factura oFactura;
    private String query;

    public FacturaDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Factura> listar() {
        try {

            registros = new ArrayList<>();

            query = "{CALL  FACTURA_LISTAR()}"; // Sentencia SQL con la cual recuperamos los datos de la BD
            System.out.println(query);

            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oFactura = new Factura();
                oFactura.setCodigo(rs.getInt("codigo"));
                oFactura.setNumeroFactura(rs.getString("numero_factura").toUpperCase());
                oFactura.setNumeroBoleta(rs.getString("numero_boleta").toUpperCase());
                oFactura.setIGV(rs.getDouble("IGV"));
                oFactura.setFechaFacturacion(rs.getString("fecha_facturacion"));
                oFactura.setTipo(rs.getString("tipo").toUpperCase());
                registros.add(oFactura);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR FACTURAS " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Factura Obj) {
        resp = false;
        try {

            query = "{CALL FACTURA_INSERTAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getNumeroFactura().toUpperCase());
            pc.setString(3, Obj.getNumeroBoleta().toUpperCase());
            pc.setDouble(4, Obj.getIGV());
            pc.setString(5, Obj.getFechaFacturacion());
            pc.setString(6, Obj.getTipo().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Factura Obj) {
        resp = false;
        try {
            //Sentencia DML con la cual actualizamos los datos en la BD
            query = "{CALL FACTURA_ACTUALIZAR(?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.setString(2, Obj.getNumeroFactura());
            pc.setString(3, Obj.getNumeroBoleta());
            pc.setDouble(4, Obj.getIGV());
            pc.setString(5, Obj.getFechaFacturacion());
            pc.setString(6, Obj.getTipo().toUpperCase());
            pc.executeUpdate();
            
            return resp = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR FACTURA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Factura Obj) {
        resp = false;

        try {
            // Sentencia DML con la cual eliminamos datos de la BD
            query = "{CALL FACTURA_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR FACTURA" + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Factura Obj) {
        return 0;
    }

    @Override
    public Factura getObjeto(Factura Obj) {
        try {
            // Sentencia SQL con la cual recuperamos los datos de la BD
            query = "{CALL FACTURA_BUSCAR(?)}";

            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNumeroFactura(rs.getString("numero_factura").toUpperCase());
                Obj.setNumeroFactura(rs.getString("numero_boleta").toUpperCase());
                Obj.setIGV(rs.getDouble("IGV"));
                Obj.setFechaFacturacion(rs.getString("fecha_facturacion"));
                Obj.setTipo(rs.getString("tipo").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE PLATILLO CON ESTE CODIGO ");
            }
            
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR FACTURA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
