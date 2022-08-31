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
public class CajaDAO extends EntidadAD implements metodosDAO<Caja> {

    private List<Caja> registros;
    private Caja oCaja;
    private String query;
    private boolean resp;
    private final UsuarioLN oUsuarioLN;
    
    public CajaDAO(Connection connection) {
        super(connection);
        oUsuarioLN = new UsuarioLN();
    }

    @Override
    public List<Caja> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL CAJA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oCaja = new Caja();
                oCaja.setCodigo(rs.getInt("codigo"));
                oCaja.setSaldoInicial(rs.getDouble("saldo_inicial"));
                oCaja.setSaldoFinal(rs.getDouble("saldo_final"));
                oCaja.setEstado(rs.getBoolean("estado"));
                oCaja.setFechaOpen(rs.getString("fecha_open"));
                oCaja.setFechaClose(rs.getString("fecha_close"));
                oCaja.setDetalle(rs.getString("detalle"));
                oCaja.setoUsuario(oUsuarioLN.getObjeto(new Usuario(new Persona(rs.getString("USUARIOS_PERSONAS_dni")),new TipoUsuario(rs.getInt("USUARIOS_TIPO_USUARIOS_codigo")))));
                registros.add(oCaja);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR CAJA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(CajaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Caja Obj) {
        resp = false;
        try {
            query = "{CALL CAJA_INSERTAR(?,?,?,?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setDouble(1, Obj.getSaldoInicial());
            pc.setDouble(2, Obj.getSaldoFinal());
            pc.setBoolean(3, Obj.getEstado());
            pc.setString(4, Obj.getFechaOpen());
            pc.setString(5, Obj.getFechaClose());
            pc.setString(6, Obj.getDetalle());
            pc.setString(7, Obj.getoUsuario().getoPersona().getDni());
            pc.setInt(8, Obj.getoUsuario().getoTipoUsuarios().getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CAJA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CajaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Caja Obj) {
        resp = false;
        try {
            query = "{CALL CAJA_ACTUALIZAR(?,?,?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setInt(1, Obj.getCodigo());
            pc.setDouble(2, Obj.getSaldoFinal());
            pc.setBoolean(3, Obj.getEstado());
            pc.setString(4, Obj.getFechaClose());
            pc.setString(5, Obj.getDetalle());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR CAJA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CajaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Caja Obj) {
        resp = false;
        try {
            query = "{CALL CAJA_ELIMINAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR CAJA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CajaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Caja Obj) {
        return 0;
    }

    @Override
    public Caja getObjeto(Caja Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL CAJA_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setSaldoInicial(rs.getDouble("saldo_inicial"));
                Obj.setSaldoFinal(rs.getDouble("saldo_final"));
                Obj.setEstado(rs.getBoolean("estado"));
                Obj.setFechaOpen(rs.getString("fecha_open"));
                Obj.setFechaClose(rs.getString("fecha_close"));
                Obj.setDetalle(rs.getString("detalle"));
                Obj.setoUsuario(oUsuarioLN.getObjeto(new Usuario(new Persona(rs.getString("USUARIOS_PERSONAS_dni")), new TipoUsuario(rs.getInt("USUARIOS_TIPO_USUARIOS_codigo")))));
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE CAJA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR MESA_PEDIDO " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(CajaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
