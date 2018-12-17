import javax.swing.*;
import java.lang.*;
import java.util.Arrays;
import java.awt.Color;
import java.awt.event.*;
public class Lista extends JFrame implements ItemListener, ActionListener
{
	private JComboBox combo1;
	private JComboBox combo2;
	private JButton calculo;
	public String orig;
	public String destino;
	private int lineaOrigen=0;
	private int lineaDestino=0;
	CargaDatos d;
	public Lista() 
	{
		this.d=new CargaDatos();
		String todosdatos[]=new String[d.lineaAzul.length+d.lineaVerde.length+d.lineaRoja.length+d.lineaAmirTemurHiyoboniYunusRajabiy.length+d.lineaMingUrikOybek.length+d.lineaPakhtakorAlisherNavoi.length];//un array que guarda TODAS las estaciones
		setLayout(null);
		String l1[]=new String[d.lineaAzul.length];
		for (int a=0;a<d.lineaAzul.length;a++)
		{
			l1[a]=d.lineaAzul[a].dameNombre();
		}
		////////////////////////////////////////
		String l2[]=new String[d.lineaVerde.length];
		for (int a=0;a<d.lineaVerde.length;a++)
		{
			l2[a]=d.lineaVerde[a].dameNombre();
		}
		////////////////////////////////////////
		String l3[]=new String[d.lineaRoja.length];
		for (int a=0;a<d.lineaRoja.length;a++)
		{
			l3[a]=d.lineaRoja[a].dameNombre();
		}
		////////////////////////////////////////
		String l4[]=new String[d.lineaAmirTemurHiyoboniYunusRajabiy.length];
		for (int a=0;a<d.lineaAmirTemurHiyoboniYunusRajabiy.length;a++)
		{
			l4[a]=d.lineaAmirTemurHiyoboniYunusRajabiy[a].dameNombre();
		}
		////////////////////////////////////////
		String l5[]=new String[d.lineaMingUrikOybek.length];
		for (int a=0;a<d.lineaMingUrikOybek.length;a++)
		{
			l5[a]=d.lineaMingUrikOybek[a].dameNombre();
		}
		////////////////////////////////////////
		String l6[]=new String[d.lineaPakhtakorAlisherNavoi.length];
		for (int a=0;a<d.lineaPakhtakorAlisherNavoi.length;a++)
		{
			l6[a]=d.lineaPakhtakorAlisherNavoi[a].dameNombre();
		}
		////////////////
		String[] p1= concat(l1,l2);
		String[] p2=concat(l3,l4);
		String[] p3=concat(l5,l6);
		todosdatos=concat(p1,p2);
		todosdatos=concat(todosdatos, p3);
		
		Arrays.sort(todosdatos);
		//creamos ventana y menú desplegable que contiene todas las estaciones. 

		combo1=new JComboBox();
		combo2=new JComboBox();
		combo1.setBounds(50,65,200,20);//posicion y dimensiones del menú desplegable: (x,y,ancho,alto) donde x e y son la posición del desplegable en la ventan
		combo2.setBounds(50,150,200,20);
		this.setTitle("Seleccion de estaciones");
		this.getContentPane().setBackground(Color.white);//color del fondo de la ventana
		//creamos dos etiquetas de texto y las introducimos
		JLabel or=new JLabel("Estacion de origen");
		or.setBounds(90, 35, 150, 20);
		JLabel des=new JLabel("Estacion de destino");
		des.setBounds(90, 120, 150, 20);
		this.getContentPane().add(or);
		this.getContentPane().add(des);
		//ponemos que la ventana sea visible
		this.setVisible(true);
		add(combo1);
		int i=0;
		for (i=0;i<todosdatos.length;i++)//metemos los datos de la línea 1
		{
			combo1.addItem(todosdatos[i]);
		}
		add(combo2);
		for (i=0;i<todosdatos.length;i++)//metemos los datos de la línea 1
		{
			combo2.addItem(todosdatos[i]);
		}


		// JPanel pnlButton = new JPanel();
		this.calculo = new JButton("Calcular trayecto");
		calculo.setBounds(90, 200, 140, 20);
		add(calculo);	
		combo1.addItemListener(this);
		combo2.addItemListener(this);
		calculo.addActionListener(this);
		calculo.setActionCommand("algoritmo aest");

	}

	public void itemStateChanged(ItemEvent e) 
	{
		if (e.getSource()==combo1) //origen
		{
			this.orig=(String)combo1.getSelectedItem();

			if(conTransbordo(this.orig)==true)
			{
				//System.out.println("origen con transbordo");

				this.lineaOrigen=dameLinea(this.orig);
			}

		}
		if (e.getSource()==combo2) //se utilizó combo 2 (destino)
		{
			this.destino=(String)combo2.getSelectedItem();
			if(conTransbordo(this.destino))//si tiene transbordo
			{
				//System.out.println("Destino con transbordo");
				this.lineaDestino=dameLinea(this.destino);
			}
		}

	}
	public void actionPerformed(ActionEvent ae) 
	{

		String action = ae.getActionCommand();

		if (action.equals("algoritmo aest")) 
		{
			A_Est algo=new A_Est(this.orig,this.destino,this.lineaOrigen,this.lineaDestino);
			algo.algoritmoa_est();
		}

	}

	public String[] concat(String[] a, String[] b) {
		int aLen = a.length;
		int bLen = b.length;
		String[] c= new String[aLen+bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}
	public String[] concat(String[] a, String[] b,String[] d) {
		int aLen = a.length;
		int bLen = b.length;
		int dLen = d.length;
		String[] c= new String[aLen+bLen+dLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		System.arraycopy(d, 0, c, bLen, dLen);
		return c;
	}
	private boolean conTransbordo(String estacion)
	{
		boolean tiene=false;
		//metodo que determina si el nombre de una estacion tiene paréntesis (9significa que tiene transbordo)
		for(int i=0;i<estacion.length();i++)
		{
			if(estacion.charAt(i)=='(')
			{
				tiene=true;
				break;
			}
		}
		return tiene;
	}

	/*
	 * Método que busca un dígito en una cadena de caracteres en formato: NombreEstacion (Linea X) y devuelve el valor X.
	 */
	private int dameLinea(String estacion)
	{
		int est=0;
		for(int y=0;y<estacion.length();y++)
		{
			if(Character.isLetter(estacion.charAt(y)))
			{
				continue;
			}
			if(estacion.charAt(y)=='(') 
			{
				continue;
			}
			
			if(Character.isWhitespace(estacion.charAt(y)) )
			{
				continue;
			}
			
			if(Character.isDigit(estacion.charAt(y)) )
			{
				est=Character.getNumericValue(estacion.charAt(y));		
			}
		}
		return est;

	}
}