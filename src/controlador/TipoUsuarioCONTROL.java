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
import modelo.vista.MantenimientoTipoUsuario;
import modelo.vista.PnlFoot;
import modelo.vista.PnlHead;

/**
 *
 * @author ALEX
 */
public class TipoUsuarioCONTROL {

    private final TipoUsuarioLN DATOS;
    private UsuarioCONTROL oUsuarioCONTROL;
    
    private JFrame principal;
    
    private MantenimientoTipoUsuario mantenimineto;
    
    private List<TipoUsuario> lista;
    private List<JLabel> listaImagenes,listaBotones, listaBotonesLef;

    private JPanel pnlLeftHead, pnlLeftBoddy, pnlLeftFoot;
    private JPanel pnlCenterHead, pnlCenterBoddy, pnlCenterFoot;
    private JPanel pnlRightHead, pnlRightBoddy, pnlRightFoot;

    private MouseListener oyenteLeftFood, oyenteLeftBoody;

    private JLabel lblNuevo, lblEditar, lblEliminar, lblCabecera;
    
    private TipoUsuario seleccionPadre;
  
    private boolean isNuevo;
    private JLabel lblFiltrar;

    public TipoUsuarioCONTROL() {
        DATOS = new TipoUsuarioLN();
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

    public List<TipoUsuario> Listar() {
        return DATOS.listar();
    }
    
    public int getTamañoLista(){
        return lista.size();
    }
    
    public String Insertar(TipoUsuario obj) {
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

    public String Actualizar(TipoUsuario obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ACTUALIZAR EL REGISTRO";
        }
    }

    public String Eliminar(TipoUsuario obj) {
        if (DATOS.eliminar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ELIMINAR EL REGISTRO";
        }
    }
    
    public DefaultComboBoxModel cargarComboBox(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        lista = new ArrayList<>();
        lista = DATOS.listar();
        lista.forEach(items::addElement);
        return items;
    }
    
    public JPanel getLeftHead(){
//        JPanel lamina = new JPanel();
        PnlHead lamina = new PnlHead("TIPOS DE USUARIOS",true);
        lamina.setSize(264, 30);
        lamina.setLocation(0, 0);
        
//        lblCabecera = new JLabel("TIPOS DE USUARIOS");
//        lblFiltrar = new JLabel("|||");
        
//        lblCabecera.setHorizontalAlignment(JLabel.CENTER);
//        lblFiltrar.setHorizontalAlignment(JLabel.RIGHT);
//        Border lineanegra = BorderFactory.createLineBorder(Color.black);
//        leftFoodMouseClick();
//        lblCabecera.setBorder(lineanegra);
//        lblFiltrar.setBorder(lineanegra);
//        lamina.add(lblCabecera);
//        lamina.add(lblFiltrar);

//        pnlCenterHead.removeAll();
//        GridLayout disposicion = new GridLayout(1, 2);
//        lamina.setLayout(disposicion);
//        pnlLeftHead.add(lamina);
//        pnlLeftHead.validate();
//        pnlLeftHead.repaint();
        return lamina;
    }
    
    public JPanel getLeftBoddy() {
        lista = Listar();

        int tamaño = 80;
        int espaciosAlto=5;
        int size = lista.size();
        listaImagenes = new ArrayList<>();
        JLabel imagen;

        JPanel boddy = new JPanel();
        boddy.setPreferredSize(new Dimension(pnlLeftBoddy.getWidth()-tamaño, size*tamaño + (size+1)*espaciosAlto));
        boddy.setBackground(new Color(255, 255, 255));
        
        for (int i = 0; i < size; i++) {
            imagen = new JLabel(lista.get(i).getNombre());
            imagen.setSize(tamaño, tamaño);
            imagen.setHorizontalAlignment(JLabel.CENTER);
            imagen.setCursor(new Cursor(Cursor.HAND_CURSOR));
            Border linea = BorderFactory.createLineBorder(new Color(0, 51, 255));
            imagen.setBorder(linea);
            leftBoddyMouseClick();
            imagen.addMouseListener(oyenteLeftBoody);
            listaImagenes.add(imagen);
            boddy.add(imagen);
        }
        return boddy;
    }
    
    public void extraerComponenetes(Container container, Boolean activado){
        Component[] components = container.getComponents();

        for (int i = 0; i < components.length; i++) {
                
            if (components[i] instanceof JLabel) {
                ((JLabel) components[i]).setEnabled(activado);
                listaBotonesLef.add((JLabel) components[i]);
            } else 
            if (components[i] instanceof Container) {
                extraerComponenetes((Container) components[i], activado);
            }
        }
    }
    
    public JPanel getLeftFoot() {
        listaBotonesLef = new ArrayList<>();

        PnlFoot foot = new PnlFoot();
        extraerComponenetes(foot, true);
        foot.setSize(264,35);
        foot.setLocation(0, 0);
        
        lblNuevo = listaBotonesLef.get(0);
        lblEditar = listaBotonesLef.get(1);
        lblEliminar = listaBotonesLef.get(2);
        
        leftFoodMouseClick();
        
        for (JLabel listaBotonesLef1 : listaBotonesLef) {
            listaBotonesLef1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            listaBotonesLef1.addMouseListener(oyenteLeftFood);
        }
        
        return foot;
    }
    
    private void leftBoddyMouseClick() {
        oUsuarioCONTROL = new UsuarioCONTROL();
        oUsuarioCONTROL.setPaneles(pnlCenterHead, pnlCenterBoddy, pnlCenterFoot, pnlRightHead, pnlRightBoddy, pnlRightFoot);
        oUsuarioCONTROL.setFrame(principal);
        oyenteLeftBoody = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for (int i = 0; i < listaImagenes.size(); i++) {
                    if (listaImagenes.get(i).equals(me.getSource())) {
                        seleccionPadre = lista.get(i);
                        oUsuarioCONTROL.setSelecion(seleccionPadre);
                        oUsuarioCONTROL.llenarPanelCenterBoddy();
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
                if (lblNuevo.equals(me.getSource()) ) {
                    isNuevo=true;
                    mantenimineto = new MantenimientoTipoUsuario(principal, true);
                    mantenimineto.setTitle("NUEVO TIPO DE USUARIO");
                    mantenimineto.setIsNuevo(isNuevo);
                    mantenimineto.setVisible(true);
                    
                }else if (lblEditar.equals(me.getSource())) {
                    if (seleccionPadre != null) {
                        isNuevo =false;
                        mantenimineto = new MantenimientoTipoUsuario(principal, true);
                        mantenimineto.setTitle("EDITAR TIPO DE USUARIO");
                        mantenimineto.setIsNuevo(isNuevo);
                        mantenimineto.setTipoUsuario(seleccionPadre);
                        mantenimineto.llenarCampos();
                        mantenimineto.setVisible(true);
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE UNA TIPO DE USUARIO");
                    }
                } else if (lblEliminar.equals(me.getSource())) {
                    if (seleccionPadre != null) {
                        if (JOptionPane.showConfirmDialog(principal, "¿DESEA ELIMINAR ESTE TIPO DE USUARIO?","MENSAJE DEL SISTEMA" , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                            Eliminar(seleccionPadre);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE UN TIPO DE USUARIO");
                    }
                }
                getLeftBoddy();
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
