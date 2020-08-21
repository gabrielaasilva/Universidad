package presentacion; 
 

import aplicacion.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import java.util.*;

/**
 * @version ECI 2016
 */
public class SinapGUI extends JFrame{

    private static final int ANCHO_PREFERIDO = 450;
    private static final int ALTO_PREFERIDO= 450;
    private static final Dimension DIMENSION_PREFERIDA =
                         new Dimension(ANCHO_PREFERIDO,ALTO_PREFERIDO);

    private final Sinap areas;

    /* Panel botonListar */
    private JButton botonListar;
    private JButton botonReiniciarListar;
    private JTextArea textoDetalles;

    /* Panel botonAdicionar */
    private JTextField textoOriginal;
    private JTextField textoEspa_ol;
    private JTextField textoPais;
    private JTextField textoDirector;
    private JTextArea textoDescripcion;

    private JButton botonAdicionar;
    private JButton botonReiniciarAdicionar;

    /* Panel buscar */
    private JTextField busquedaTexto;
    private JTextArea resultadosTexto;

    /**
     * Create un marco para el catalogo de areas de arte
     */

    private SinapGUI() throws SINAPExcepcion {
        areas = new Sinap();
        areas.adicioneCinco();
        prepareElementos();
        prepareAcciones();
    }

    private void prepareElementos() {
        setTitle("Sinap. Areas.");
        textoOriginal = new JTextField(50);
        textoEspa_ol = new JTextField(50);
        textoPais = new JTextField(50);
        textoDirector = new JTextField(4);
        textoDescripcion = new JTextArea(10, 50);
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setWrapStyleWord(true);
        final JTabbedPane etiquetas = new JTabbedPane();
        etiquetas.add("Listar", prepareAreaListar());
        etiquetas.add("Adicionar", prepareAreaAdicionar());
        etiquetas.add("Buscar", prepareAreaBuscar());
        getContentPane().add(etiquetas);
        setSize(DIMENSION_PREFERIDA);

    }

    /**
     * Prepara el panel para listar areas
     * 
     * @return el panel para listar areas
     */
    private JPanel prepareAreaListar() {

        textoDetalles = new JTextArea(10, 50);
        textoDetalles.setEditable(false);
        textoDetalles.setLineWrap(true);
        textoDetalles.setWrapStyleWord(true);
        final JScrollPane scrollArea = new JScrollPane(textoDetalles, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        final JPanel botones = new JPanel();
        botonListar = new JButton("Listar");
        botonReiniciarListar = new JButton("Limpiar");
        botones.add(botonListar);
        botones.add(botonReiniciarListar);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollArea, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Prepara el area de adición
     * 
     * @return El area de adición
     */
    private JPanel prepareAreaAdicionar() {

        final Box textoOriginalArea = Box.createHorizontalBox();
        textoOriginalArea.add(new JLabel("Nombre", JLabel.LEFT));
        textoOriginalArea.add(Box.createGlue());
        final Box OriginalArea = Box.createVerticalBox();
        OriginalArea.add(textoOriginalArea);
        OriginalArea.add(textoOriginal);

        final Box textoEspa_olArea = Box.createHorizontalBox();
        textoEspa_olArea.add(new JLabel("Nombre internacional", JLabel.LEFT));
        textoEspa_olArea.add(Box.createGlue());
        final Box Espa_olArea = Box.createVerticalBox();
        Espa_olArea.add(textoEspa_olArea);
        Espa_olArea.add(textoEspa_ol);

        final Box textoPaisArea = Box.createHorizontalBox();
        textoPaisArea.add(new JLabel("Ubicación", JLabel.LEFT));
        textoPaisArea.add(Box.createGlue());
        final Box PaisArea = Box.createVerticalBox();
        PaisArea.add(textoPaisArea);
        PaisArea.add(textoPais);

        final Box textoDirectorArea = Box.createHorizontalBox();
        textoDirectorArea.add(new JLabel("Area", JLabel.LEFT));
        textoDirectorArea.add(Box.createGlue());
        final Box a_oArea = Box.createVerticalBox();
        a_oArea.add(textoDirectorArea);
        a_oArea.add(textoDirector);

        final Box textoDescripcionArea = Box.createHorizontalBox();
        textoDescripcionArea.add(new JLabel("Descripción", JLabel.LEFT));
        textoDescripcionArea.add(Box.createGlue());
        final Box descripcionArea = Box.createVerticalBox();
        descripcionArea.add(textoDescripcionArea);
        descripcionArea.add(textoDescripcion);

        final Box singleLineFields = Box.createVerticalBox();
        singleLineFields.add(OriginalArea);
        singleLineFields.add(Espa_olArea);
        singleLineFields.add(PaisArea);
        singleLineFields.add(a_oArea);

        final JPanel textoDetallesPanel = new JPanel();
        textoDetallesPanel.setLayout(new BorderLayout());
        textoDetallesPanel.add(singleLineFields, BorderLayout.NORTH);
        textoDetallesPanel.add(descripcionArea, BorderLayout.CENTER);

        final JPanel botones = new JPanel();
        botonAdicionar = new JButton("Adicionar");
        botonReiniciarAdicionar = new JButton("Limpiar");

        botones.add(botonAdicionar);
        botones.add(botonReiniciarAdicionar);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textoDetallesPanel, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Prepara el area de liatar
     * 
     * @return El panel para buscar areass
     */
    private JPanel prepareAreaBuscar() {

        final Box busquedaEtiquetaArea = Box.createHorizontalBox();
        busquedaEtiquetaArea.add(new JLabel("Buscar", JLabel.LEFT));
        busquedaEtiquetaArea.add(Box.createGlue());
        busquedaTexto = new JTextField(50);
        final Box busquedaArea = Box.createHorizontalBox();
        busquedaArea.add(busquedaEtiquetaArea);
        busquedaArea.add(busquedaTexto);

        resultadosTexto = new JTextArea(10, 50);
        resultadosTexto.setEditable(false);
        resultadosTexto.setLineWrap(true);
        resultadosTexto.setWrapStyleWord(true);
        final JScrollPane scrollArea = new JScrollPane(resultadosTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        final JPanel botonListarArea = new JPanel();
        botonListarArea.setLayout(new BorderLayout());
        botonListarArea.add(busquedaArea, BorderLayout.NORTH);
        botonListarArea.add(scrollArea, BorderLayout.CENTER);

        return botonListarArea;
    }

    private void prepareAcciones() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent ev) {
                setVisible(false);
                System.exit(0);
            }
        });

        /* Listar */
        botonListar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                try{
					accionListar();
				}catch(Exception e){
					Registro.registre(e);
					JOptionPane.showMessageDialog(null,"Ocurrio un error al listar");
					System.exit(0);
				}
            }
        });

        botonReiniciarListar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                textoDetalles.setText("");
            }
        });

        /* Adicionar */
        botonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                try{
					accionAdicionar();
				} catch(Exception e){
					Registro.registre(e);					
					JOptionPane.showMessageDialog(null,e.getMessage());
					System.exit(0);
				}
            }
        }
		);

        botonReiniciarAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                textoOriginal.setText("");
                textoEspa_ol.setText("");
                textoPais.setText("");
                textoDirector.setText("");
                textoDescripcion.setText("");
            }
        });

        /* Buscarr */
        busquedaTexto.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(final DocumentEvent ev) {
				try{
					accionBuscar();
				}catch(Exception e){
					Registro.registre(e);
					JOptionPane.showMessageDialog(null,"Ocurrio un error al momento de buscar");	
					//System.exit(0);
				}
            }

            public void insertUpdate(final DocumentEvent ev) {
                try{
					accionBuscar();
				}catch(Exception e){
					Registro.registre(e);
					JOptionPane.showMessageDialog(null,"Ocurrio un error al momento de buscar");	
					//System.exit(0);
				}
           }

            public void removeUpdate(final DocumentEvent ev) {
                try{
					accionBuscar();
				}catch(Exception e){
					Registro.registre(e);
					JOptionPane.showMessageDialog(null,"Ocurrio un error al momento de buscar");	
					//System.exit(0);
				}
            }

        });
    }

    private void accionListar() throws SINAPExcepcion {
		try{
        textoDetalles.setText(areas.toString());
		}catch(Exception e){
			throw e;
		}
    }

    private void accionAdicionar() throws SINAPExcepcion {
		try{
        areas.adicione(textoOriginal.getText(), textoEspa_ol.getText(), textoPais.getText(), textoDirector.getText(),
                textoDescripcion.getText());
		}catch (Exception e){
			throw e;
		}	
    }

    private void accionBuscar() {
        final String patronBusqueda = busquedaTexto.getText();
        final StringBuffer buffer = new StringBuffer();
        if (patronBusqueda.length() > 0) {
            final ArrayList<Area> results = areas.busque(patronBusqueda);
            for (int i = 0; i < results.size(); i++) {
                buffer.append(results.get(i).toString());
                buffer.append('\n');
                buffer.append('\n');
            }
        }
        resultadosTexto.setText(buffer.toString());
    }

    public static void main(final String args[])throws SINAPExcepcion {
        final SinapGUI gui = new SinapGUI();
       gui.setVisible(true);
   }    
}
