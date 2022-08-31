package controlador;


import Util.MiScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import modelo.Entidades.*;
import modelo.LogicaNegocio.*;
import modelo.vista.*;

/**
 *
 * @author ALEX
 */
public class ProductoCONTROL implements MouseListener{

    private final ProductoLN DATOS;
    
    private JFrame principal;
    private MantenimientoProducto oMantenimientoProducto;
    
    private List<Producto> listaProductos;
    private List<JLabel> listaProductosImagenes, listaBotones, listaBotonesRight;

    private JPanel pnlCenterHead, pnlCenterBoddy, pnlCenterFoot;
    private JPanel pnlRightHead, pnlRightBoddy, pnlRightFoot;

    private MouseListener oyenteCenterFoot,oyenteCenterBoddy, oyenteRightFoot;

    private JLabel lblNuevoProducto, lblEditarProducto, lblEliminarProducto;

    private Categoria selecionCategoria;
    private Producto seleccionProducto;
    
    private boolean isNuevo;
    private JLabel lblCabecera;
    private JLabel lblFiltrar;

    public ProductoCONTROL() {
        DATOS = new ProductoLN();

    }
    
    public void setFrame(JFrame principal){
        this.principal = principal;
    }
    
    public void setPaneles(JPanel pnlCenterHead, JPanel pnlCenterBoddy, JPanel pnlCenterFoot, JPanel pnlRightHead, JPanel pnlRightBoddy, JPanel pnlRightFoot) {
        this.pnlCenterHead = pnlCenterHead;
        this.pnlCenterBoddy = pnlCenterBoddy;
        this.pnlCenterFoot = pnlCenterFoot;
        this.pnlRightHead = pnlRightHead;
        this.pnlRightBoddy = pnlRightBoddy;
        this.pnlRightFoot = pnlRightFoot;
    }

    public void setSelecionCategoria(Categoria selecionCategoria) {
        this.selecionCategoria = selecionCategoria;
    }


    public List<Producto> Listar() {
        return DATOS.listar();
    }
    
        
    public List<Producto> listarPorCategoria(Categoria oCategoria) {
        return DATOS.listarPorCategoria(oCategoria);
    }
    
   
    public String Insertar(Producto obj) {
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

    public String Actualizar(Producto obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ACTUALIZAR EL REGISTRO";
        }

    }

    public String Eliminar(Producto obj) {
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
      
    public JPanel getHead(String title, boolean activo, Dimension d){
        PnlHead head = new PnlHead(title,activo);
        head.setSize(d);
        head.setLocation(0, 0);
        
        return head;
    }

    public JPanel getCenterFoot() {
        listaBotones = new ArrayList<>();

        PnlFoot foot = new PnlFoot();
        extraerComponenetes(foot, true);
        foot.setSize(600, 35);
        foot.setLocation(0, 0);
        
        lblNuevoProducto = listaBotones.get(0);
        lblEditarProducto = listaBotones.get(1);
        lblEliminarProducto = listaBotones.get(2);
        
        listaBotones.remove(lblEditarProducto);
        lblEditarProducto.setVisible(false);
        
        lblNuevoProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNuevoProducto.addMouseListener(this);
        lblEliminarProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblEliminarProducto.addMouseListener(this);
        
        return foot;
    }
    
    public JPanel getRightFoot() {
        listaBotones = new ArrayList<>();

        PnlFoot foot = new PnlFoot();
        extraerComponenetes(foot, true);
        foot.setSize(300, 35);
        foot.setLocation(0, 0);
        
        lblNuevoProducto = listaBotones.get(0);
        lblEditarProducto = listaBotones.get(1);
        lblEliminarProducto = listaBotones.get(2);
        
        lblNuevoProducto.setVisible(false);
        lblEliminarProducto.setVisible(false);

        lblEditarProducto.addMouseListener(this);
        lblEditarProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return foot;
    }
    
    public void pintarPanel(JPanel principal, JPanel head){
        principal.removeAll();
        principal.add(head);
        principal.revalidate();
        principal.repaint();
    }
    
    public JPanel llenarPanelProductos() {

        pintarPanel(pnlCenterHead,getHead(selecionCategoria.toString(), true, new Dimension(600,30)));
//        pintarCenterFoot(getCenterFoot());
        pintarPanel(pnlCenterFoot,getCenterFoot());
        
        listaProductos = listarPorCategoria(selecionCategoria);
        
        int tamañoImagen = 80;
        int sepAlto = 25;
        int tamaño = 0;
        int size = listaProductos.size();
        listaProductosImagenes = new ArrayList<>();
        JLabel imagen;

        tamaño = size % 5 == 0 ? size / 5 : (size / 5) + 1;

        JPanel laminaCentral = new JPanel();
        
        laminaCentral.setPreferredSize(new Dimension(pnlCenterBoddy.getWidth() - tamañoImagen, tamaño * tamañoImagen + (tamaño + 1) * sepAlto));
        laminaCentral.setBackground(new Color(255, 255, 255));        

        for (int i = 0; i < size; i++) {
            imagen = new JLabel();
            imagen.setBounds(0, 0, tamañoImagen, tamañoImagen);

            try {
                byte[] imagenBD = listaProductos.get(i).getFotoProducto();
                BufferedImage oBufferedImage = null;
                InputStream oInputStream = new ByteArrayInputStream(imagenBD);
                oBufferedImage = ImageIO.read(oInputStream);
                ImageIcon miIcono = new ImageIcon(oBufferedImage.getScaledInstance(imagen.getWidth(), imagen.getHeight(), 0));
                imagen.setIcon(miIcono);
            } catch (IOException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            imagen.setHorizontalAlignment(JLabel.CENTER);
            imagen.setVerticalAlignment(JLabel.CENTER);
            Border linea = BorderFactory.createLineBorder(new Color(0, 51, 255));
            imagen.setBorder(linea);
            imagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
//            centerBoddyMouseClick();
            imagen.addMouseListener(this);
            listaProductosImagenes.add(imagen);
            laminaCentral.add(imagen);
        }

        pnlCenterBoddy.removeAll();
        FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT, 25, 25);
        laminaCentral.setLayout(disposicion);
        
        JScrollPane scroll = new JScrollPane();

        scroll.setSize(pnlCenterBoddy.getWidth(), pnlCenterBoddy.getHeight());
        scroll.setViewportView(laminaCentral);
        scroll.getVerticalScrollBar().setUI(MiScrollBar.getScrollPersonalizado(7, 10, Color.WHITE, new Color(0,102,255), new Color(0,51,255)));
        
        pnlCenterBoddy.add(scroll);
        pnlCenterBoddy.revalidate();
        pnlCenterBoddy.repaint();

        return pnlCenterBoddy;
    }
    
    private JPanel llenarPanelDetalle(Producto seleccionProducto) {

        JPanel laminaCentral = new JPanel();

        List<String> listaCabecera = new ArrayList<>();
        List<String> listaDetalle = new ArrayList<>();

        listaCabecera.add("CODIGO");
        listaDetalle.add(seleccionProducto.getCodigoProducto().toString());
        listaCabecera.add("NOMBRE");
        listaDetalle.add(seleccionProducto.getNombreProducto());
        listaCabecera.add("STOCK");
        listaDetalle.add(seleccionProducto.getStockProducto().toString());
        listaCabecera.add("STOCK MINIMO");
        listaDetalle.add(seleccionProducto.getStockMinimo().toString());
        listaCabecera.add("MEDIDA");
        listaDetalle.add(seleccionProducto.getUnidadMedidaProducto());
        listaCabecera.add("CONTENIDO");
        listaDetalle.add(seleccionProducto.getContenidoProducto());
        listaCabecera.add("MONEDA");
        listaDetalle.add(seleccionProducto.getMonedaProducto());
        listaCabecera.add("PRECIO UNITARIO");
        listaDetalle.add(seleccionProducto.getPrecioUnitario().toString());
        listaCabecera.add("PRECIO MEDIDA");
        listaDetalle.add(seleccionProducto.getPrecioMedida().toString());
        listaCabecera.add("PRECIO COMPRA");
        listaDetalle.add(seleccionProducto.getPrecioCompraProducto().toString());
        listaCabecera.add("CATEGORIA");
        listaDetalle.add(seleccionProducto.getoCategoria().getNombre());

        List<JLabel> listaLabelDescripcion = new ArrayList<>();
        List<JTextField> listaTextDescripcion = new ArrayList<>();
        
        int tamaño = 30;
        int espaciosAlto=5;
        int size = listaDetalle.size();

        laminaCentral.setPreferredSize(new Dimension(pnlRightBoddy.getWidth()-tamaño, size*tamaño + (size+1)*espaciosAlto));
        laminaCentral.setBackground(new Color(255, 255, 255));
        
        JLabel imagen;
        JTextField detalle;
        for (int i = 0; i < listaCabecera.size(); i++) {
            imagen = new JLabel(listaCabecera.get(i));
            detalle = new JTextField(listaDetalle.get(i));
            imagen.setSize(80, tamaño);
            detalle.setSize(80, tamaño);
            imagen.setForeground(new Color(0, 51, 255));
            detalle.setForeground(new Color(0, 51, 255));
            imagen.setHorizontalAlignment(JLabel.CENTER);
            detalle.setHorizontalAlignment(JTextField.CENTER);
            detalle.setEditable(false);
            Border linea = BorderFactory.createLineBorder(new Color(0, 51, 255));
            imagen.setBorder(linea);
            detalle.setBorder(linea);
            listaLabelDescripcion.add(imagen);
            listaTextDescripcion.add(detalle);
            laminaCentral.add(imagen);
            laminaCentral.add(detalle);
        }
        
        pnlRightBoddy.removeAll();
        GridLayout disposicion = new GridLayout(listaCabecera.size(), 1, 5, 5);
        laminaCentral.setLayout(disposicion);
        JScrollPane scroll = new JScrollPane();
        scroll.setSize(pnlRightBoddy.getWidth(), pnlRightBoddy.getHeight());
        scroll.setViewportView(laminaCentral);
        scroll.getVerticalScrollBar().setUI(MiScrollBar.getScrollPersonalizado(7, 10, Color.WHITE, new Color(0,102,255), new Color(0,51,255)));
        
        pnlRightBoddy.add(scroll);
        pnlRightBoddy.revalidate();
        pnlRightBoddy.repaint();

        return pnlRightBoddy;
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        // EVENTOS PANEL INFERIOR DERECHO
        if(lblNuevoProducto.equals(me.getSource())){
                isNuevo=true;
                oMantenimientoProducto = new MantenimientoProducto(principal, true);
                oMantenimientoProducto.setTitle("NUEVO PRODUCTO");
                oMantenimientoProducto.setIsNuevo(isNuevo);
                oMantenimientoProducto.setoProducto(new Producto(selecionCategoria));
                oMantenimientoProducto.llenarCampos();
                oMantenimientoProducto.setVisible(true);
        }
        if (lblEliminarProducto.equals(me.getSource())) {
            if (seleccionProducto != null) {
                if (JOptionPane.showConfirmDialog(principal, "¿DESEA ELIMINAR ESTE PRODUCTO?","MENSAJE DEL SISTEMA" , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    Eliminar(seleccionProducto);
                    llenarPanelProductos();
                    limpiarPaneles();
                }
            }else{
                JOptionPane.showMessageDialog(null, "SELECCIONE UN PRODUCTO");
            }
            
        }
        if (lblEditarProducto.equals(me.getSource())) {
            if (seleccionProducto != null) {
                isNuevo =false;
                oMantenimientoProducto = new MantenimientoProducto(principal, true);
                oMantenimientoProducto.setTitle("EDITAR PRODUCTO");
                oMantenimientoProducto.setIsNuevo(isNuevo);
                oMantenimientoProducto.setoProducto(seleccionProducto);
                oMantenimientoProducto.llenarCampos();
                oMantenimientoProducto.setVisible(true);
                llenarPanelProductos();
                llenarPanelDetalle(seleccionProducto);
            }else{
                JOptionPane.showMessageDialog(null, "SELECCIONE UN PRODUCTO");
            }
        }
            //EVENTOS DEL PANEL CUERPO CENTRAL
        for (int i = 0; i < listaProductosImagenes.size(); i++) {
            if (listaProductosImagenes.get(i).equals(me.getSource())) {
                seleccionProducto = listaProductos.get(i);
                pintarPanel(pnlRightHead,getHead("DETALLE PRODUCTO", false, new Dimension(300, 30)));
                llenarPanelDetalle(seleccionProducto);
                pintarPanel(pnlRightFoot,getRightFoot());
            }
        }
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
