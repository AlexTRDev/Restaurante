package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import modelo.Entidades.*;
import modelo.vista.*;

/**
 *
 * @author ALEX
 */
public class MenuCONTROL {

    private ProductoCONTROL oProductoCONTROL;
    private CategoriaCONTROL oCategoriaCONTROL;
    private JFrame principal;
    
    private MantenimientoCategoria oMantenimientoCategoria;
    private MantenimientoProducto oMantenimientoProducto;
    
    private List<Categoria> listaCategorias;
    private List<Producto> listaProductos;

    private List<JLabel> listaCategoriasImagenes, listaProductosImagenes, listaBotonesLef, listaBotonesCenter, listaBotonesRight;

    private JPanel pnlLeftHead, pnlLeftBoddy, pnlLeftFoot;
    private JPanel pnlCenterHead, pnlCenterBoddy, pnlCenterFoot;
    private JPanel pnlRightHead, pnlRightBoddy, pnlRightFoot;

    private MouseListener oyenteLeftFood, oyenteLeftBoody;
    private MouseListener oyenteCenterFoot,oyenteCenterBoddy;
    private MouseListener oyenteRightFoot;

    private JLabel lblNuevaCategoria, lblEditarCategoria, lblNuevoProducto, lblEditarProducto, lblEliminarProducto, lblEliminarCategoria;

    private boolean isNuevo;
    
    private Categoria selecionCategoria;
    private Producto seleccionProducto;

    public MenuCONTROL() {
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

    public JPanel llenarPanelBotonesLeft() {
        JPanel laminaBotones = new JPanel();
        laminaBotones.setSize(pnlLeftFoot.getSize());
        
        lblNuevaCategoria = new JLabel("NUEVO");
        lblEditarCategoria = new JLabel("EDITAR");
        lblEliminarCategoria = new JLabel("ELIMINAR");
        
        listaBotonesLef = new ArrayList<>(3);
        
        listaBotonesLef.add(lblNuevaCategoria);
        listaBotonesLef.add(lblEditarCategoria);
        listaBotonesLef.add(lblEliminarCategoria);
        
        Border lineanegra = BorderFactory.createLineBorder(Color.black);
        leftFoodMouseClick();
        
        for (JLabel listaBotonesLef1 : listaBotonesLef) {
            listaBotonesLef1.setHorizontalAlignment(JLabel.CENTER);
            listaBotonesLef1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            listaBotonesLef1.setBorder(lineanegra);
            listaBotonesLef1.addMouseListener(oyenteLeftFood);
            laminaBotones.add(listaBotonesLef1);
        }
        
        pnlLeftFoot.removeAll();
        FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, pnlLeftFoot.getHeight() / 2, 10);
        laminaBotones.setLayout(disposicion);

        pnlLeftFoot.add(laminaBotones);
        pnlLeftFoot.validate();
        pnlLeftFoot.repaint();
        return pnlLeftFoot;
    }

    public JPanel llenarPanelBotonesCenter() {
        JPanel laminaBotones = new JPanel();
        laminaBotones.setSize(pnlCenterFoot.getSize());

        lblNuevoProducto = new JLabel("NUEVO");
        lblEliminarProducto = new JLabel("ELIMINAR");
        
        listaBotonesCenter = new ArrayList<>(2);
        
        listaBotonesCenter.add(lblNuevoProducto);
        listaBotonesCenter.add(lblEliminarProducto);
        
        Border lineanegra = BorderFactory.createLineBorder(Color.black);
        centerFootMouseClick();

        for (JLabel button : listaBotonesCenter) {
            button.setHorizontalAlignment(JLabel.CENTER);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setBorder(lineanegra);
            button.addMouseListener(oyenteCenterFoot);
            laminaBotones.add(button);
        }
        
        pnlCenterFoot.removeAll();
        FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, pnlCenterFoot.getHeight() / 2, 10);
        laminaBotones.setLayout(disposicion);

        pnlCenterFoot.add(laminaBotones);
        pnlCenterFoot.validate();
        pnlCenterFoot.repaint();
        return pnlCenterFoot;
    }

    public JPanel llenarPanelBotonesRight() {

        JPanel laminaBotones = new JPanel();
        laminaBotones.setSize(pnlRightFoot.getSize());

        lblEditarProducto = new JLabel("EDITAR");
        lblEditarProducto.setHorizontalAlignment(JLabel.CENTER);
        lblEditarProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Border lineanegra = BorderFactory.createLineBorder(Color.black);
        lblEditarProducto.setBorder(lineanegra);
        rightFootMouseClick();
        lblEditarProducto.addMouseListener(oyenteRightFoot);
        laminaBotones.add(lblEditarProducto);
        
        pnlRightFoot.removeAll();
        FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, pnlRightFoot.getHeight() / 2, 10);
        laminaBotones.setLayout(disposicion);
        pnlRightFoot.add(laminaBotones);
        pnlRightFoot.validate();
        pnlRightFoot.repaint();

        return pnlRightFoot;
    }

    public JPanel llenarPanelCategorias() {
        oCategoriaCONTROL = new CategoriaCONTROL();
        listaCategorias = oCategoriaCONTROL.Listar();

        int tamaño = 80;
        int size = listaCategorias.size();
        listaCategoriasImagenes = new ArrayList<>();
        JLabel imagen;

        JPanel laminaCentral = new JPanel();
        laminaCentral.setPreferredSize(new Dimension(pnlLeftBoddy.getWidth() - 50, (size - 1) * tamaño));
      
        for (int i = 0; i < size; i++) {
            imagen = new JLabel(listaCategorias.get(i).getNombre());
            imagen.setSize(tamaño, tamaño);
            imagen.setHorizontalAlignment(JLabel.CENTER);
            imagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Border lineanegra = BorderFactory.createLineBorder(Color.black);
            imagen.setBorder(lineanegra);
            leftBoddyMouseClick();
            imagen.addMouseListener(oyenteLeftBoody);
            listaCategoriasImagenes.add(imagen);
            laminaCentral.add(imagen);
        }

        pnlLeftBoddy.removeAll();
        GridLayout disposicion = new GridLayout(size, 1, 10, 10);
        laminaCentral.setLayout(disposicion);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(0, 0, pnlLeftBoddy.getWidth(), pnlLeftBoddy.getHeight());
        scroll.setViewportView(laminaCentral);
        pnlLeftBoddy.add(scroll);
        pnlLeftBoddy.revalidate();
        pnlLeftBoddy.repaint();

        return pnlLeftBoddy;
    }

    private JPanel llenarPanelProductos(Categoria oCategoria) {
        oProductoCONTROL = new ProductoCONTROL();
        listaProductos = oProductoCONTROL.listarPorCategoria(oCategoria);

        int tamañoImagen = 80;
        int sepAlto = 25;
        int tamaño = 0;
        int size = listaProductos.size();
        listaProductosImagenes = new ArrayList<>();
        JLabel imagen;

        tamaño = size % 5 == 0 ? size / 5 : (size / 5) + 1;

        JPanel laminaCentral = new JPanel();
        laminaCentral.setPreferredSize(new Dimension(pnlCenterBoddy.getWidth() - 50, tamaño * tamañoImagen + (tamaño + 1) * sepAlto));

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
            Border lineanegra = BorderFactory.createLineBorder(Color.black);
            imagen.setBorder(lineanegra);
            imagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
            centerBoddyMouseClick();
            imagen.addMouseListener(oyenteCenterBoddy);
            listaProductosImagenes.add(imagen);
            laminaCentral.add(imagen);
        }

        pnlCenterBoddy.removeAll();
        FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT, 25, 25);
        laminaCentral.setLayout(disposicion);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(0, 0, pnlCenterBoddy.getWidth(), pnlCenterBoddy.getHeight());
        scroll.setViewportView(laminaCentral);
        pnlCenterBoddy.add(scroll);
        pnlCenterBoddy.revalidate();
        pnlCenterBoddy.repaint();

        return pnlCenterBoddy;
    }

    private JPanel llenarDetalleProducto(Producto oProducto) {

        JPanel laminaCentral = new JPanel();
        laminaCentral.setPreferredSize(new Dimension(pnlRightBoddy.getWidth() - 50, pnlRightBoddy.getHeight()));

        List<String> listaCabecera = new ArrayList<>();
        List<String> listaDetalle = new ArrayList<>();

        listaCabecera.add("CODIGO");
        listaDetalle.add(oProducto.getCodigoProducto().toString());
        listaCabecera.add("NOMBRE");
        listaDetalle.add(oProducto.getNombreProducto());
        listaCabecera.add("STOCK");
        listaDetalle.add(oProducto.getStockProducto().toString());
        listaCabecera.add("STOCK MINIMO");
        listaDetalle.add(oProducto.getStockMinimo().toString());
        listaCabecera.add("MEDIDA");
        listaDetalle.add(oProducto.getUnidadMedidaProducto());
        listaCabecera.add("CONTENIDO");
        listaDetalle.add(oProducto.getContenidoProducto());
        listaCabecera.add("MONEDA");
        listaDetalle.add(oProducto.getMonedaProducto());
        listaCabecera.add("PRECIO UNITARIO");
        listaDetalle.add(oProducto.getPrecioUnitario().toString());
        listaCabecera.add("PRECIO MEDIDA");
        listaDetalle.add(oProducto.getPrecioMedida().toString());
        listaCabecera.add("PRECIO COMPRA");
        listaDetalle.add(oProducto.getPrecioCompraProducto().toString());
        listaCabecera.add("CATEGORIA");
        listaDetalle.add(oProducto.getoCategoria().getNombre());

        List<JLabel> listaLabelDescripcion = new ArrayList<>();
        List<JTextField> listaTextDescripcion = new ArrayList<>();

        JLabel imagen;
        JTextField detalle;
        for (int i = 0; i < listaCabecera.size(); i++) {
            imagen = new JLabel(listaCabecera.get(i));
            detalle = new JTextField(listaDetalle.get(i));
            imagen.setHorizontalAlignment(JLabel.CENTER);
            detalle.setHorizontalAlignment(JTextField.CENTER);
            detalle.setEditable(false);
            Border lineanegra = BorderFactory.createLineBorder(Color.black);
            imagen.setBorder(lineanegra);
            detalle.setBorder(lineanegra);
            listaLabelDescripcion.add(imagen);
            listaTextDescripcion.add(detalle);
            laminaCentral.add(imagen);
            laminaCentral.add(detalle);
        }

        pnlRightBoddy.removeAll();
        GridLayout disposicion = new GridLayout(listaCabecera.size(), 1, 5, 5);
        laminaCentral.setLayout(disposicion);
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(0, 0, pnlRightBoddy.getWidth(), pnlRightBoddy.getHeight());
        scroll.setViewportView(laminaCentral);
        pnlRightBoddy.add(scroll);
        pnlRightBoddy.revalidate();
        pnlRightBoddy.repaint();

        return pnlRightBoddy;
    }

    private void leftBoddyMouseClick() {
        oyenteLeftBoody = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for (int i = 0; i < listaCategoriasImagenes.size(); i++) {
                    if (listaCategoriasImagenes.get(i).equals(me.getSource())) {
                        selecionCategoria = listaCategorias.get(i);
                        llenarPanelProductos(selecionCategoria);
                        pnlCenterFoot = llenarPanelBotonesCenter();
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
        };
    }
    
    private void leftFoodMouseClick() {
        oyenteLeftFood = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (lblNuevaCategoria.equals(me.getSource()) ) {
                    isNuevo=true;
                    oMantenimientoCategoria = new MantenimientoCategoria(principal, true);
                    oMantenimientoCategoria.setTitle("NUEVA CATEGORIA");
                    oMantenimientoCategoria.setIsNuevo(isNuevo);
                    oMantenimientoCategoria.setVisible(true);
                    
                }else if (lblEditarCategoria.equals(me.getSource())) {
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
                } else if (lblEliminarCategoria.equals(me.getSource())) {
                    if (selecionCategoria != null) {
                        if (JOptionPane.showConfirmDialog(principal, "¿DESEA ELIMINAR ESTA CATEGORIA?","MENSAJE DEL SISTEMA" , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                            oProductoCONTROL.Eliminar(seleccionProducto);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE UNA CATEGORIA");
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

        };
    }
    
    private void centerBoddyMouseClick() {
        oyenteCenterBoddy = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for (int i = 0; i < listaProductosImagenes.size(); i++) {
                    if (listaProductosImagenes.get(i).equals(me.getSource())) {
                        llenarDetalleProducto(listaProductos.get(i));
                        seleccionProducto = listaProductos.get(i);
                        pnlRightFoot = llenarPanelBotonesRight();
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
        };
    }

    public void centerFootMouseClick() {
        oyenteCenterFoot = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getSource().equals(lblNuevoProducto)){
                    isNuevo=true;
                    oMantenimientoProducto = new MantenimientoProducto(principal, true);
                    oMantenimientoProducto.setTitle("NUEVO PRODUCTO");
                    oMantenimientoProducto.setIsNuevo(isNuevo);
                    oMantenimientoProducto.setoProducto(new Producto(selecionCategoria));
                    oMantenimientoProducto.llenarCampos();
                    oMantenimientoProducto.setVisible(true);
                }else                
                if (lblEditarProducto.equals(me.getSource())) {
                        isNuevo =false;
                        oMantenimientoProducto = new MantenimientoProducto(principal, true);
                        oMantenimientoProducto.setTitle("EDITAR PRODUCTO");
                        oMantenimientoProducto.setIsNuevo(isNuevo);
                        oMantenimientoProducto.setoProducto(seleccionProducto);
                        oMantenimientoProducto.llenarCampos();
                        oMantenimientoProducto.setVisible(true);
                }else if (lblEliminarProducto.equals(me.getSource())) {
                    if (selecionCategoria != null) {
                        if (JOptionPane.showConfirmDialog(principal, "¿DESEA ELIMINAR ESTE PRODUCTO?","MENSAJE DEL SISTEMA" , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                            oCategoriaCONTROL.Eliminar(selecionCategoria);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE UN PRODUCTO");
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
        };
    }
    
    public void rightFootMouseClick() {
        oyenteRightFoot = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {           
                if (lblEditarProducto.equals(me.getSource())) {
                    isNuevo =false;
                    oMantenimientoProducto = new MantenimientoProducto(principal, true);
                    oMantenimientoProducto.setTitle("EDITAR PRODUCTO");
                    oMantenimientoProducto.setIsNuevo(isNuevo);
                    oMantenimientoProducto.setoProducto(seleccionProducto);
                    oMantenimientoProducto.llenarCampos();
                    oMantenimientoProducto.setVisible(true);
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
        };
    }

}
