import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.util.ArrayList;
public class VentanaPU extends JPanel {
	public JPopupMenu popup;
	public VentanaPU()
	{

		popup = new JPopupMenu();
		ActionListener

		menuListener = new ActionListener()
		{

			public void actionPerformed(ActionEvent event) 
			{
				if(event.getActionCommand().equals("Ayuda"))
				{
					muestrAyuda();
				}
			}

		};
		JMenuItem item;
		popup.add(item = new JMenuItem("Ayuda", new ImageIcon("2.gif")));
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		popup.setLabel("Justification");
		popup.setBorder(new BevelBorder(BevelBorder.RAISED));
		addMouseListener(

				new MousePopupListener());
	}
	// An inner class to check whether mouse events are the popup trigger
	class MousePopupListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			checkPopup(

					e);
		}

		public void mouseClicked(MouseEvent e) {
			checkPopup(

					e);
		}

		public void mouseReleased(MouseEvent e) {
			checkPopup(

					e);
		}

		private void checkPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
				popup.show(VentanaPU.this, e.getX(), e.getY());
			}

		}

	}

	static void muestrAyuda()
	{
		String p1="Este programa calcula para el usuario el trayecto más corto entre\n la estación de destino y la de origen elegida";
		String p2=" en el metro de Bucarest.\n Para ello, se utiliza el algoritmo de búsqueda de caminos A*.\n";
		String p3="Para utilizarlo, haga click en el menú Cálculo de trayectos en la parte superior\n de la ventana principal y posteriormente";
		String p4="en SelecciÃ³n de estaciones de origen y destino.\n";
		String p5="Ahí­ deberá elegir las respectivas estaciones de destino y origen y se calculará el trayecto.";
		String tex=p1+p2+p3+p4+p5;
		JOptionPane.showMessageDialog(null,tex,"Ayuda", JOptionPane.INFORMATION_MESSAGE);		  	
	}
	public static void main(String argumentos[]) throws IOException
	{
		//crear la ventana general
		MenuBar barra = new MenuBar();//creamos la barra superior
		Menu programa = new Menu("Calculo de trayectos");
		Menu ayuda = new Menu("Ayuda");
		//se aÃ±aden elementos a la barra superior.
		barra.add(programa);
		barra.add(ayuda);
		//elementos del menÃº de ayuda
		ayuda.add("¿Cómo utilizar este programa?");
		ayuda.addSeparator();
		ayuda.add("Acerca de...");
		//elementos del menu de calculo trayecto
		programa.add("Seleccion de estaciones de origen y destino");
		
		//escucha de eventos cuando se da click sobre los menÃºs
		ayuda.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				if(evento.getActionCommand().equals("¿Cómo utilizar este programa?"))
				{
					muestrAyuda();
				}
				else  //"Se selecciono sobre nosotros"
				{

					JOptionPane.showMessageDialog(null,"Metro de Toshkent: Calculo del mejor trayecto utilizando el algoritmo A* \n "       
							+ "*******************************************************************************\n"
							+ "Creado para la asignatura de Inteligencia Artificial por los alumnos:\n"
							+ "Juan Antonio Manso Millán Oscar MiLLie Serrano\n Pablo Torres Dominguez\n Tania Orellana Ordoñez Diego Montañez Soria\n");
				}


			}
		});
		programa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) //seleccion de estaciones
			{
				if(evento.getActionCommand().equals("Seleccion de estaciones de origen y destino"))
				{
					Lista formulario1=new Lista();
					formulario1.setBounds(0,0,325,290);
					formulario1.setVisible(true);
				}
			}
		});

		//imagen de fondo
		String foto = "metrothoskent.jpg";
		File

		file = new File(foto);
		BufferedImage

		image = ImageIO.read(file);;
		JLabel

		label = new JLabel(new ImageIcon(image));
		JFrame

		ventana = new JFrame();
		ventana.setTitle("Calculo del mejor trayecto en el metro de Toshkent");
		//SELECCIONAMOS LA BARRA DE MENUS
		ventana.setMenuBar(barra);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//que se cierre al hacer click
		ventana.setContentPane(new VentanaPU());
		ventana.setSize(700, 700);//tamañ¯ ¤e la ventana
		ventana.getContentPane().add(label);
		ventana.setVisible(true);
	}

}