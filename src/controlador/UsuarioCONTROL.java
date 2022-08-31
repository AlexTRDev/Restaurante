package controlador;


import Util.Util;
import Util.mdlGeneral;
import java.awt.Color;
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
public class UsuarioCONTROL {

    private final UsuarioLN DATOS;
    private final PersonaLN DATOSPERSONA;
    
    private JFrame principal;
    private MantenimientoUsuario mantenimientoUsuario;
    private MantenimientoPersona mantenimientoPersona;
    
    private List<Usuario> lista;
    private List<Persona> listaPersonas;
    private List<JLabel> listaImagenes, listaBotones;

    private JPanel pnlCenterHead, pnlCenterBoddy, pnlCenterFoot;
    private JPanel pnlRightHead, pnlRightBoddy, pnlRightFoot;

    private MouseListener oyenteCenterFoot,oyenteCenterBoddy, oyenteRightFoot;

    private JLabel lblNuevo, lblEditar, lblEliminar;

    private TipoUsuario seleccionPadre;
    private Usuario seleccionHijo;
    
    private boolean isNuevo;
    private JLabel lblCabecera;
    private JLabel lblFiltrar;

    public UsuarioCONTROL() {
        DATOS = new UsuarioLN();
        DATOSPERSONA = new PersonaLN();
    }

    public List<Usuario> ListarUsuarios() {
        return DATOS.listar();
    }
    
    public List<Persona> ListarPersonas() {
        return DATOSPERSONA.listar();
    }
    
    
        
    public List<Usuario> listarPorPadre(TipoUsuario obj) {
        return DATOS.listarPorTipoUsuario(obj);
    }
    
   
    public String Insertar(Usuario obj) {
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "ERROR AL INSERTAR EL REGISTRO";
        }
    }

    public String Actualizar(Usuario obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ACTUALIZAR EL REGISTRO";
        }

    }

    public String Eliminar(Usuario obj) {
        if (DATOS.eliminar(obj)) {
            return "OK";
        } else {
            return "ERROR AL ELIMINAR EL REGISTRO";
        }
    }
    
    public JPanel llenarPanelHead(String nombre, JPanel oPanel){
        JPanel lamina = new JPanel();
        lamina.setSize(oPanel.getSize());
        
        lblCabecera = new JLabel(nombre);
        lblFiltrar = new JLabel("|||");
        
        lblCabecera.setHorizontalAlignment(JLabel.CENTER);
        lblFiltrar.setHorizontalAlignment(JLabel.RIGHT);
        Border lineanegra = BorderFactory.createLineBorder(Color.black);
//        leftFoodMouseClick();
        lblCabecera.setBorder(lineanegra);
        lblFiltrar.setBorder(lineanegra);
        lamina.add(lblCabecera);
        lamina.add(lblFiltrar);

        oPanel.removeAll();
        GridLayout disposicion = new GridLayout(1, 2);
        lamina.setLayout(disposicion);
        oPanel.add(lamina);
        oPanel.validate();
        oPanel.repaint();
        return oPanel;
    }
    
    public JPanel llenarPanelCenterBoddy() {
        llenarPanelHead(seleccionPadre.toString(),pnlCenterHead);
        llenarPanelCenterFoot();
        lista = listarPorPadre(seleccionPadre);
        
        int tamañoImagen = 80;
        int sepAlto = 25;
        int tamaño = 0;
        int size = lista.size();
        listaImagenes = new ArrayList<>();
        JLabel imagen;

        tamaño = size % 5 == 0 ? size / 5 : (size / 5) + 1;

        JPanel laminaCentral = new JPanel();
        laminaCentral.setPreferredSize(new Dimension(pnlCenterBoddy.getWidth() - 50, tamaño * tamañoImagen + (tamaño + 1) * sepAlto));

        for (int i = 0; i < size; i++) {
            imagen = new JLabel();
            imagen.setBounds(0, 0, tamañoImagen, tamañoImagen);

            try {
                byte[] imagenBD = lista.get(i).getFoto();
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
            listaImagenes.add(imagen);
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
   
    public JPanel llenarPanelCenterFoot() {
        JPanel laminaBotones = new JPanel();
        laminaBotones.setSize(pnlCenterFoot.getSize());

        lblNuevo = new JLabel("NUEVO");
        lblEliminar = new JLabel("ELIMINAR");
        
        listaBotones = new ArrayList<>(2);
        
        listaBotones.add(lblNuevo);
        listaBotones.add(lblEliminar);
        
        Border lineanegra = BorderFactory.createLineBorder(Color.black);
        centerFootMouseClick();

        for (JLabel button : listaBotones) {
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
    
    public JPanel llenarPanelRightFoot() {

        JPanel laminaBotones = new JPanel();
        laminaBotones.setSize(pnlRightFoot.getSize());

        lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(JLabel.CENTER);
        lblEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Border lineanegra = BorderFactory.createLineBorder(Color.black);
        lblEditar.setBorder(lineanegra);
        rightFootMouseClick();
        lblEditar.addMouseListener(oyenteRightFoot);
        laminaBotones.add(lblEditar);
        
        pnlRightFoot.removeAll();
        FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, pnlRightFoot.getHeight() / 2, 10);
        laminaBotones.setLayout(disposicion);
        pnlRightFoot.add(laminaBotones);
        pnlRightFoot.validate();
        pnlRightFoot.repaint();

        return pnlRightFoot;
    }

    private JPanel llenarPanelRightBoddy() {

        JPanel laminaCentral = new JPanel();
        laminaCentral.setPreferredSize(new Dimension(pnlRightBoddy.getWidth() - 50, pnlRightBoddy.getHeight()));

        List<String> listaCabecera = new ArrayList<>();
        List<String> listaDetalle = new ArrayList<>();

        listaCabecera.add("USER");
        listaDetalle.add(seleccionHijo.getUser());
        listaCabecera.add("DNI");
        listaDetalle.add(seleccionHijo.getoPersona().getDni());
        listaCabecera.add("NOMBRE");
        listaDetalle.add(seleccionHijo.getoPersona().getNombres());
        listaCabecera.add("APELLIDO PATERNO");
        listaDetalle.add(seleccionHijo.getoPersona().getApellidoPaterno());
        listaCabecera.add("APELLIDO MATERNO");
        listaDetalle.add(seleccionHijo.getoPersona().getApellidoMaterno());
        listaCabecera.add("CORREO");
        listaDetalle.add(seleccionHijo.getoPersona().getCorreo());
        listaCabecera.add("CELULAR");
        listaDetalle.add(seleccionHijo.getoPersona().getTelefono());
        listaCabecera.add("SEXO");
        listaDetalle.add(seleccionHijo.getoPersona().getSexo());
        listaCabecera.add("DIRECCION");
        listaDetalle.add(seleccionHijo.getoPersona().getDireccion());
        listaCabecera.add("FECHA DE NACIMIENTO");
        listaDetalle.add(seleccionHijo.getoPersona().getFechaNacimiento().toString());

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

    private void centerFootMouseClick() {
        oyenteCenterFoot = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getSource().equals(lblNuevo)){
                    
                    if (seleccionPadre.getNombre().equals("ADMINISTRADOR") || seleccionPadre.getNombre().equals("OPERADOR")) {
                        isNuevo=true;
                        mantenimientoUsuario = new MantenimientoUsuario(principal, true);
                        mantenimientoUsuario.setTitle("NUEVO USUARIO");
                        mantenimientoUsuario.setIsNuevo(isNuevo);
                        mantenimientoUsuario.setoUsuario(new Usuario(seleccionPadre));
                        mantenimientoUsuario.llenarCampos();
                        mantenimientoUsuario.setVisible(true);
                    } else {
                        isNuevo=true;
                        mantenimientoPersona = new MantenimientoPersona(principal, true);
                        mantenimientoPersona.setTitle("NUEVO CLIENTE");
                        mantenimientoPersona.setIsNuevo(isNuevo);
                        mantenimientoPersona.isModoCliente(true);
                        mantenimientoPersona.setoUsuario(new Usuario(seleccionPadre));
                        mantenimientoPersona.llenarCampos();
                        mantenimientoPersona.setVisible(true);
                    }
                    
                }else if (seleccionHijo != null) {
                    if (JOptionPane.showConfirmDialog(principal, "¿DESEA ELIMINAR ESTE USUARIO?","MENSAJE DEL SISTEMA" , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                        Eliminar(seleccionHijo);
                    }
                }else{
                        JOptionPane.showMessageDialog(null, "SELECCIONE UN USUARIO");
                }
                
                llenarPanelCenterBoddy();
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
                for (int i = 0; i < listaImagenes.size(); i++) {
                    if (listaImagenes.get(i).equals(me.getSource())) {
                        seleccionHijo = lista.get(i);
                        llenarPanelRightBoddy();
                        llenarPanelHead("DETALLE",pnlRightHead);
                        llenarPanelRightFoot();
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
                if (lblEditar.equals(me.getSource())) {
                    if (seleccionPadre.getNombre().equals("ADMINISTRADOR") || seleccionPadre.getNombre().equals("OPERADOR")) {
                        isNuevo=false;
                        mantenimientoUsuario = new MantenimientoUsuario(principal, true);
                        mantenimientoUsuario.setTitle("EDITAR USUARIO");
                        mantenimientoUsuario.setIsNuevo(isNuevo);
                        mantenimientoUsuario.setoUsuario(seleccionHijo);
                        mantenimientoUsuario.llenarCampos();
                        mantenimientoUsuario.setVisible(true);
                        
                    } else {
                        isNuevo=false;
                        mantenimientoPersona = new MantenimientoPersona(principal, true);
                        mantenimientoPersona.setTitle("EDITAR CLIENTE");
                        mantenimientoPersona.setIsNuevo(isNuevo);
                        mantenimientoPersona.isModoCliente(true);
                        mantenimientoPersona.setoUsuario(seleccionHijo);
                        mantenimientoPersona.llenarCampos();
                        mantenimientoPersona.setVisible(true);
                    }
                    
                    
                    
                }
                llenarPanelCenterBoddy();
//                llenarDetalleProducto(seleccionHijo);
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

    public void setSelecion(TipoUsuario seleccionPadre) {
        this.seleccionPadre = seleccionPadre;
    }

    public DefaultComboBoxModel cargarComboPersona(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        listaPersonas = new ArrayList<>();
        listaPersonas = ListarPersonas();
        
        listaPersonas.forEach(model::addElement);
        return model;
    }
    
//    public void modeloTabla(JTable tabla){
//        
//        String []nombreColumnas = {"DNI","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","SEXO","FECHA NACIMIENTO"};
//       
//        tabla.setModel(new mdlGeneral(nombreColumnas));
//        Integer anchos[] = {100,100,125,125,100,175};
//        Integer alineaciones[] = {JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER};
//        String formatos[] = {"Cadena","Cadena","Cadena","Cadena","Cadena","Cadena",};
//        String modos[] = {"RESALTADO","EDITABLE","NORMAL","NORMAL","NORMAL","NORMAL"};
//
//        Util.AplicarEstilos(tabla,anchos,alineaciones,formatos,modos);
//    }
//    
//    public void mostrarTabla(JTable tabla){
//        listaPersonas = ListarPersonas();
//        ((mdlGeneral)(tabla.getModel())).setData(parseVector(listaPersonas));
//        
//    }
//    
//    private List parseVector(List<Persona> lista) {
//        List datos = new ArrayList();
//        Object[] newdata;
//        for(int i = 0; i < lista.size(); i++) {
//            newdata = new Object[6];
//
//            newdata[0] = lista.get(i).getDni();
//            newdata[1] = lista.get(i).getNombres();
//            newdata[2] = lista.get(i).getApellidoPaterno();
//            newdata[3] = lista.get(i).getApellidoMaterno();
//            newdata[4] = lista.get(i).getSexo();
//            newdata[5] = lista.get(i).getFechaNacimiento();
//
//            datos.add(newdata);
//        }
//        return datos;
//    }
    
}
