package controlador;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import modelo.Entidades.*;
import modelo.LogicaNegocio.*;
import modelo.vista.*;

/**
 *
 * @author ALEX
 */
public class CategoriaCONTROL implements MouseListener{

    private final CategoriaLN DATOS;
    private ProductoCONTROL oProductoCONTROL;
    
    private JFrame principal;
    
    private MantenimientoCategoria oMantenimientoCategoria;
    
    private List<Categoria> listaCategorias;
    private List<JLabel> listaCategoriasImagenes,listaBotones;

    private JPanel pnlLeftHead, pnlLeftBoddy, pnlLeftFoot;
    private JPanel pnlCenterHead, pnlCenterBoddy, pnlCenterFoot;
    private JPanel pnlRightHead, pnlRightBoddy, pnlRightFoot;

    private MouseListener oyenteLeftFood, oyenteLeftBoody;

    private JLabel lblNuevaCategoria, lblEditarCategoria, lblEliminarCategoria;
    
    private Categoria selecionCategoria;
  
    private boolean isNuevo;
    private JLabel lblFiltrar;
    private int size;

    public CategoriaCONTROL() {
        DATOS = new CategoriaLN();
    }
    
    public void setFrame(JFrame principal){
        this.principal = principal;
    }
    
    public void setPaneles(JPanel pnlLeftHead, JPanel pnlLeftBoddy, JPanel pnlLeffFoot, JPanel pnlCenterHead, JPanel pnlCenterBoddy, JPanel pnlCenterFoot, JPanel pnlRightHead, JPanel pnlRightBoddy, JPanel pnlRightFoot) {
        this.pnlLeftHead = pnlLeftHead;
        this.pnlLeftBoddy = pnlLeftBoddy;
        this.pnlLeftFoot = pnlLeffFoot;
        this.pnlCenterHead = pnlCenterHead;
        this.pnlCenterBoddy = pnlCenterBoddy;
        this.pnlCenterFoot = pnlCenterFoot;
        this.pnlRightHead = pnlRightHead;
        this.pnlRightBoddy = pnlRightBoddy;
        this.pnlRightFoot = pnlRightFoot;
        
    }
    
    
    public List<Categoria> Listar() {
        return DATOS.listar();
    }
    
    public int getTamañoLista(){
        return listaCategorias.size();
    }
    
    public String Insertar(Categoria obj) {
        if (DATOS.buscarNombre(obj) == 1) {
            return "EL NOMBRE INGRESADO YA EXISTE";
        } else {
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "ERROR AL INSERTAR EL REGISTRO";
            }
        }
    }

    public String Actualizar(Categoria obj) {
        if (DATOS.buscarNombre(obj) == 1) {
            return "EL NOMBRE INGRESADO YA EXISTE";
        }  else {
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "ERROR AL ACTUALIZAR EL REGISTRO";
            }
        }
    }

    public String Eliminar(Categoria obj) {
        if (DATOS.eliminar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ELIMINAR EL REGISTRO";
        }
    }
    
    public void limpiarPaneles(){
        pnlRightBoddy.removeAll();
        pnlRightBoddy.revalidate();
        pnlRightBoddy.repaint();
        
        pnlRightFoot.removeAll();
        pnlRightFoot.revalidate();
        pnlRightFoot.repaint();
    }
    
    public DefaultComboBoxModel cargarComboBox(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        listaCategorias = DATOS.listar();
        listaCategorias.forEach(items::addElement);
        return items;
    }
    
    public JPanel getLeftBoddy() {
        listaCategorias = Listar();
        int tamaño = 80;
        int espaciosAlto=5;
        int size = listaCategorias.size();
        listaCategoriasImagenes = new ArrayList<>();
        JLabel imagen;

        JPanel boddy = new JPanel();
        boddy.setPreferredSize(new Dimension(pnlLeftBoddy.getWidth()-tamaño, size*tamaño + (size+1)*espaciosAlto));
        boddy.setBackground(new Color(255, 255, 255));
        
        for (int i = 0; i < size; i++) {
            imagen = new JLabel(listaCategorias.get(i).getNombre());
            imagen.setSize(tamaño, tamaño);
            imagen.setHorizontalAlignment(JLabel.CENTER);
            imagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Border linea = BorderFactory.createLineBorder(new Color(0, 51, 255));
            imagen.setBorder(linea);
            imagen.addMouseListener(this);
            listaCategoriasImagenes.add(imagen);
            boddy.add(imagen);
        }
        return boddy;
    }
    
    public void extraerComponenetes(Container container, Boolean activado){
        Component[] components = container.getComponents();

        for (int i = 0; i < components.length; i++) {
                
            if (components[i] instanceof JLabel) {
                ((JLabel) components[i]).setEnabled(activado);
                listaBotones.add((JLabel) components[i]);
            } else 
            if (components[i] instanceof Container) {
                extraerComponenetes((Container) components[i], activado);
            }
        }
    }
    
    public JPanel getLeftHead(){
        PnlHead head = new PnlHead("CATEGORIAS", true);
        head.setSize(264, 30);
        head.setLocation(0, 0);
        return head;
    }
    
    public JPanel getLeftFoot() {
        listaBotones = new ArrayList<>();

        PnlFoot foot = new PnlFoot();
        extraerComponenetes(foot, true);
        foot.setSize(264,35);
        foot.setLocation(0, 0);
        
        lblNuevaCategoria = listaBotones.get(0);
        lblEditarCategoria = listaBotones.get(1);
        lblEliminarCategoria = listaBotones.get(2);
  
        listaBotones.clear();
        listaBotones.add(lblNuevaCategoria);
        listaBotones.add(lblEditarCategoria);
        listaBotones.add(lblEliminarCategoria);
        
        for (JLabel listaBotonesLef1 : listaBotones) {
            listaBotonesLef1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            listaBotonesLef1.addMouseListener(this);
        }
        return foot;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
        //EVENTOS DEL PANEL INFERIOR
        if (lblNuevaCategoria.equals(me.getSource()) ) {
            isNuevo=true;
            oMantenimientoCategoria = new MantenimientoCategoria(principal, true);
            oMantenimientoCategoria.setTitle("NUEVA CATEGORIA");
            oMantenimientoCategoria.setIsNuevo(isNuevo);
            oMantenimientoCategoria.setVisible(true);
        }
        
        if (lblEditarCategoria.equals(me.getSource())) {
            if (selecionCategoria != null) {
                isNuevo =false;
                oMantenimientoCategoria = new MantenimientoCategoria(principal, true);
                oMantenimientoCategoria.setTitle("EDITAR CATEGORIA");
                oMantenimientoCategoria.setIsNuevo(isNuevo);
                oMantenimientoCategoria.setoCategoria(selecionCategoria);
                oMantenimientoCategoria.llenarCampos();
                oMantenimientoCategoria.setVisible(true);

            }else{
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA CATEGORIA");
            }
        }
        
        if (lblEliminarCategoria.equals(me.getSource())) {
            if (selecionCategoria != null) {
                if (JOptionPane.showConfirmDialog(principal, "¿DESEA ELIMINAR ESTA CATEGORIA?","MENSAJE DEL SISTEMA" , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    Eliminar(selecionCategoria);
                }
            }else{
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA CATEGORIA");
            }
        }
        
            // EVENTOS DEL PANEL CENTRAL

        for (int i = 0; i < listaCategoriasImagenes.size(); i++) {
            if (listaCategoriasImagenes.get(i).equals(me.getSource())) {
                oProductoCONTROL = new ProductoCONTROL();
                oProductoCONTROL.setPaneles(pnlCenterHead, pnlCenterBoddy, pnlCenterFoot, pnlRightHead, pnlRightBoddy, pnlRightFoot);
                oProductoCONTROL.setFrame(principal);
                
                selecionCategoria = listaCategorias.get(i);
                oProductoCONTROL.setSelecionCategoria(selecionCategoria);
                oProductoCONTROL.llenarPanelProductos();
            }
        }
        
        limpiarPaneles();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    
    }

    @Override
    public void mouseExited(MouseEvent me) {
    
    }
    
}
