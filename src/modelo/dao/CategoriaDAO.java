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
public class CategoriaDAO extends EntidadAD implements metodosDAO<Categoria> {

    private List<Categoria> registros;
    private Categoria oCategoria;
    private String query;
    private boolean resp;
    
    public CategoriaDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Categoria> listar() {
        try {
            registros = new ArrayList<>();
            query = "{CALL CATEGORIA_LISTAR()}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            rs = pc.executeQuery();

            while (rs.next()) {
                oCategoria = new Categoria();
                oCategoria.setCodigo(rs.getInt("codigo"));
                oCategoria.setNombre(rs.getString("nombre").toUpperCase());
                oCategoria.setDescripcion(rs.getString("descripcion").toUpperCase());
                registros.add(oCategoria);
            }
            return registros;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LISTAR CATEGORIAS" + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    @Override
    public boolean insertar(Categoria Obj) {
        resp = false;
        try {
            query = "{CALL CATEGORIA_INSERTAR(?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            
            pc.setString(1, Obj.getNombre().toUpperCase());
            pc.setString(2, Obj.getDescripcion().toUpperCase());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CATEGORIA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean actualizar(Categoria Obj) {
        resp = false;
        try {
            query = "{CALL CATEGORIA_ACTUALIZAR(?,?,?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
           
            pc.setString(1, Obj.getNombre().toUpperCase());
            pc.setString(2, Obj.getDescripcion().toUpperCase());
            pc.setInt(3, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR CATEGORIA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public boolean eliminar(Categoria Obj) {
        resp = false;
        try {
            query = "{CALL CATEGORIA_ELIMINAR(?)}";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);

            pc.setInt(1, Obj.getCodigo());
            pc.executeUpdate();

            return resp = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR CATEGORIA " + ex.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int buscaCodigo(Categoria Obj) {
        return 0;
    }

    @Override
    public Categoria getObjeto(Categoria Obj) {
        try {
            registros = new ArrayList<>();
            query = "CALL CATEGORIA_BUSCAR(?);";
            System.out.println(query);
            
            ejecutarProcedimientoAlmacenado(query);
            pc.setInt(1, Obj.getCodigo());
            rs = pc.executeQuery();

            if (rs.next() && !rs.wasNull()) {
                Obj.setNombre(rs.getString("nombre").toUpperCase());
                Obj.setDescripcion(rs.getString("descripcion").toUpperCase());
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE CATEGORIA CON ESTE CODIGO ");
            }
            return Obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR CATEGORIA " + e.getMessage());
        } finally {
            try {
                cerrarPR(sentencia.SPC.toString());

            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int buscarNombre(Categoria obj) {
        try {
            query = "CALL CATEGORIA_BUSCAR_NOMBRE(?);";
            System.out.println(query);
            ejecutarProcedimientoAlmacenado(query);
            pc.setString(1, obj.getNombre());
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
