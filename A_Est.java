import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
public class A_Est 
{
	//clase que implementa el algoritmo A estrella
	double gtr=0.200;
	Punto punto=new Punto();
	DNode origen;
	DNode destino;
	CargaDatos CargDat=new CargaDatos();//carga datos solo para tener los datos disponibles
	ArrayList <Estacion> abierta=new ArrayList <Estacion>();
	ArrayList <Estacion> cerrada=new ArrayList <Estacion>();
	ArrayList <Estacion> trayectoria=new ArrayList <Estacion>();
	public A_Est(String inicial, String destino,int lineaorigen,int lineadestino)
	{
		this.origen=buscar(inicial,lineaorigen);
		this.destino=buscar(destino,lineadestino);
		//System.out.println("la est inicial es: "+ this.origen.dameNombre());
		//System.out.println("la est destino es: "+ this.destino.dameNombre());
	}
	public void algoritmoa_est()
	{
		Estacion aux=new Estacion();
		Estacion orig=new Estacion(origen,null,null,null,0,0,punto.distancia(origen.getCoord(),destino.getCoord()),0);
		Estacion actual1=orig;
		Estacion anterior=new Estacion();
		abierta.add(orig);
		Iterator<Estacion> puntero;
		while(!abierta.isEmpty()){//EMPEZAMOS BUCLE
			double menorf=0;
			puntero=abierta.iterator();
			while(puntero.hasNext()){//obtiene las f
				aux=puntero.next();
				aux.setF(aux.getG()+aux.getH());
			}
			puntero=abierta.iterator();
			while(puntero.hasNext()){
				aux=puntero.next();
			}
			puntero=abierta.iterator();
			while(puntero.hasNext()){//Menorf y adyacente?
				aux=puntero.next();	
				if(menorf==0||menorf>=(aux.getF())){
					menorf=aux.getF();
					actual1=aux;//actualizamos nodo actual
				}
			}
			abierta.remove(actual1);
			cerrada.add(actual1);
			if(actual1.getEstacion().dameNombre().equals(destino.dameNombre())){//es el destino?
				System.out.println("¡Se ha encontrado el camino!");
				break;
			}
			actual1.setHijos(adyacentes(actual1));//inicializamos hijos------------------------------------------------------------------------------------------------
			for(int i=0;i<actual1.getHijos().length;i++){//QUE HACEMOS CON CADA NUEVO NODO ADYACENTE? comprobamos su validez y si =0 ó 1 ó 2 sera una cosa cada uno 
				if(actual1.getHijos()[i]==null)continue;
				if(valido(actual1.getHijos()[i])==2){//NO ESTA NI EN ABIERTA NI CERRADA
					actual1.getHijos()[i].setG(queG(actual1,actual1.getHijos()[i]));
					actual1.getHijos()[i].setPadre(actual1);//asigno padre hasta que se encuentre un camino mejor
					abierta.add(actual1.getHijos()[i]);
				}
				else if(valido(actual1.getHijos()[i])==1){//SI YA ESTA EN ABIERTA
					actual1.getHijos()[i]=devuelvea(actual1.getHijos()[i]);
					double gaux=queG(actual1.getHijos()[i].getPadre(),actual1.getHijos()[i]);
					double gactualaux=actual1.getG()+queG(actual1,actual1.getHijos()[i]);
					if(gaux>gactualaux){//si al comparar las g vemos que vamos bien	
						actual1.getHijos()[i].setPadre(actual1);//NUEVO MEJOR PADRE ENCONTRADO
						actual1.getHijos()[i].setG(queG(actual1,actual1.getHijos()[i]));//NUEVA G mejor
						continue;
					}
				}else {//CASO 0
					actual1.getHijos()[i]=devuelvec(actual1.getHijos()[i]);
					if(actual1.getHijos()[i]==actual1.getPadre())continue;
					double gaux=queG(actual1.getHijos()[i].getPadre(),actual1.getHijos()[i]);
					double gactualaux=actual1.getG()+queG(actual1,actual1.getHijos()[i]);
					if(gaux>gactualaux){//si al comparar las g vemos que vamos bien, propagamos MEJORA DE G---------------------------------PROPAGACION-------------------------------
						anterior=actual1;
						aux=actual1;
						aux.setPaso(0);
						while(aux.getPaso()<4||aux!=anterior){
							if(aux.getPaso()>3||aux.getHijos()==null){//hay que subir?
								aux=aux.getPadre();
								continue;
							}if(aux.getHijos()[aux.getPaso()]==null){
								aux.setPaso(aux.getPaso()+1);
								continue;
							}
							if(aux.getHijos()[aux.getPaso()].getPadre()==aux){// SI SOMOS EL PADRE DEL HIJO
								aux.getHijos()[aux.getPaso()].setG(queG(aux,aux.getHijos()[aux.getPaso()]));//actualizamos G
								aux.setPaso(aux.getPaso()+1);
								aux=aux.getHijos()[aux.getPaso()];//avanzamos al siguiente hijo
								aux.setPaso(0);//ponemos paso a 0
							}else {
								gaux=queG(aux.getHijos()[aux.getPaso()].getPadre(),aux.getHijos()[aux.getPaso()]);
								gactualaux=aux.getG()+queG(aux,aux.getHijos()[aux.getPaso()]);
								if(gaux>gactualaux){//un nuevo mejor camino!!
									aux.getHijos()[aux.getPaso()].setPadre(aux);//actualizamos padre
									aux.getHijos()[aux.getPaso()].setG(queG(aux,aux.getHijos()[aux.getPaso()]));//actualizamos G
									aux.setPaso(aux.getPaso()+1);
									aux=aux.getHijos()[aux.getPaso()];//avanzamos al siguiente hijo
									aux.setPaso(0);//ponemos paso a 0
								}
							}
						}
					}
					continue;
				}
			}
		}if(abierta.isEmpty()) System.out.println("Error: no se encuentra un camino correcto(lista abierta vacía)");
		//System.out.println(imprimirRuta(actual1));
		muestraRes(imprimirRuta(actual1));

	}
	public Estacion devuelvea (Estacion a){
		Estacion b;
		Iterator <Estacion> iterador;
		iterador=abierta.iterator();
		while (iterador.hasNext()){
			b=iterador.next();
			if (b.getEstacion().dameNombre().equals(a.getEstacion().dameNombre()))
				return b;
		}return b=null;
	}
	public Estacion devuelvec (Estacion a){
		Estacion b;
		Iterator <Estacion> iterador;
		iterador=cerrada.iterator();
		while (iterador.hasNext()){
			b=iterador.next();
			if (b.getEstacion().dameNombre().equals(a.getEstacion().dameNombre()))
				return b;
		}return b=null;
	}
	public String imprimirRuta(Estacion fin){
		trayectoria.add(fin);
		Iterator<Estacion> puntero;
		Estacion aux=new Estacion();
		while(fin.getPadre()!=null){//trayectoria al reves
			fin=fin.getPadre();
			trayectoria.add(fin);
		}
		String ruta="La trayectoria calculada es: ";
		while(!trayectoria.isEmpty()){
			puntero=trayectoria.iterator();
			while(puntero.hasNext()){
				aux=puntero.next();
			}
			ruta=ruta+" - "+"\n"+aux.getEstacion().dameNombre();
			trayectoria.remove(aux);
		}
		return ruta;
	}
	public int valido(Estacion a){//si esta en cerrada=0, si ya esta en abierto =1, si no esta en abierta ni cerrada=2
		Iterator <Estacion> iterador;
		iterador=cerrada.iterator();
		while (iterador.hasNext()){
			if (iterador.next().getEstacion().dameNombre().equals(a.getEstacion().dameNombre()))
				return 0;
		}
		iterador=abierta.iterator();
		while (iterador.hasNext()){
			if (iterador.next().getEstacion().dameNombre().equals(a.getEstacion().dameNombre()))
				return 1;
		}

		return 2;
	}
	public Estacion[] adyacentes(Estacion padre)//funcion que devuelve array con las estaciones adyacentes
	{
		Estacion[]ady=new Estacion[4];
		if(padre.getEstacion().getNext()!=null){
			Estacion sig=new Estacion(padre.getEstacion().getNext(),null,null,null,0,0,punto.distancia(padre.getEstacion().getNext().getCoord(),destino.getCoord()),0);
			ady[0]=sig;
		}
		if(padre.getEstacion().getPrev()!=null){
			Estacion prev=new Estacion(padre.getEstacion().getPrev(),null,null,null,0,0,punto.distancia(padre.getEstacion().getPrev().getCoord(),destino.getCoord()),0);
			ady[1]=prev;
		}
		if(padre.getEstacion().tieneuntransbordo()){
			Estacion trans1=new Estacion(padre.getEstacion().transbordo1(),null,null,null,0,0,punto.distancia(padre.getEstacion().transbordo1().getCoord(),destino.getCoord()),0);
			ady[2]=trans1;
			if(padre.getEstacion().tienedostransbordo()){
				Estacion trans2=new Estacion(padre.getEstacion().transbordo2(),null,null,null,0,0,punto.distancia(padre.getEstacion().transbordo2().getCoord(),destino.getCoord()),0);
				ady[3]=trans2;
			}
		}	
		return ady;
	}
	public double queG(Estacion a,Estacion b){//nos sirve para saber la g desde un nodo a otro(distancia entre medias)
		double g=0;
		if(a.getHijos()[0]==b){
			g=a.getEstacion().getG();
		}else if(a.getHijos()[1]==b){
			g=a.getEstacion().getPrev().getG();
		}else if(a.getHijos()[2]==b||a.getHijos()[3]==b){
			g=gtr;
		}
		return g;
	}
	public DNode buscar(String nombre,int numerolinea)//funcion que busca un nodo en todas las líneas del metro en función de solo su nombre
	{

		int pos=0;
		DNode nodo=new DNode();
		CargaDatos aux=new CargaDatos();//carga datos solo para tener los datos disponibles
		//buscamos en la primera línea
		switch (numerolinea){
		case 1:
			for(pos=0;pos<aux.lineaAzul.length;pos++)
			{
				if(nombre.equals(aux.lineaAzul[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaAzul[pos];

					System.out.println("Encontrado en la linea Azul(Uzbekistan)");
					return nodo;
				}
			}
			//linea Verde
		case 2:
			for(pos=0;pos<aux.lineaVerde.length;pos++)
			{
				if(nombre.equals(aux.lineaVerde[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaVerde[pos];

					System.out.println("Encontrado en la linea Verde(Yunusabad)");
					return nodo;
				}
			}
			//linea Roja
		case 3:
			for(pos=0;pos<aux.lineaRoja.length;pos++)
			{
				if(nombre.equals(aux.lineaRoja[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaRoja[pos];

					System.out.println("Encontrado en la linea Roja(Chilonzor)");
					return nodo;
				}
			}
		case 4:
			for(pos=0;pos<aux.lineaAmirTemurHiyoboniYunusRajabiy.length;pos++)
			{
				if(nombre.equals(aux.lineaAmirTemurHiyoboniYunusRajabiy[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaAmirTemurHiyoboniYunusRajabiy[pos];

					System.out.println("Encontrado en El transbordo a pie Amir Temur Hiyoboni con Yunus Rajabiy");
					return nodo;
				}
			}
		case 5:
			for(pos=0;pos<aux.lineaMingUrikOybek.length;pos++)
			{
				if(nombre.equals(aux.lineaMingUrikOybek[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaMingUrikOybek[pos];

					System.out.println("Encontrado en El transbordo a pie Ming Urik con Oybek");
					return nodo;
				}
			}
		case 6:
			for(pos=0;pos<aux.lineaPakhtakorAlisherNavoi.length;pos++)
			{
				if(nombre.equals(aux.lineaPakhtakorAlisherNavoi[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaPakhtakorAlisherNavoi[pos];

					System.out.println("Encontrado en El transbordo a pie Pakhtakor con Alisher Navoi");
					return nodo;
				}
			}

		default :

			for(pos=0;pos<aux.lineaAzul.length;pos++)
			{
				if(nombre.equals(aux.lineaAzul[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaAzul[pos];

					System.out.println("Encontrado en la linea Azul(Uzbekistan)");
					return nodo;
				}
			}
			for(pos=0;pos<aux.lineaVerde.length;pos++)
			{
				if(nombre.equals(aux.lineaVerde[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaVerde[pos];

					System.out.println("Encontrado en la linea Verde(Yunusabad)");
					return nodo;
				}
			}
			for(pos=0;pos<aux.lineaRoja.length;pos++)
			{
				if(nombre.equals(aux.lineaRoja[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaRoja[pos];

					System.out.println("Encontrado en la linea Roja(Chilonzor)");
					return nodo;
				}
			}
			for(pos=0;pos<aux.lineaAmirTemurHiyoboniYunusRajabiy.length;pos++)//linea AmirTemurHiyoboni/YunusRajabiy
			{
				if(nombre.equals(aux.lineaAmirTemurHiyoboniYunusRajabiy[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaAmirTemurHiyoboniYunusRajabiy[pos];

					System.out.println("Encontrado en El transbordo a pie Amir Temur Hiyoboni con Yunus Rajabiy");
					return nodo;
				}
			}
			for(pos=0;pos<aux.lineaMingUrikOybek.length;pos++)//linea Ming Urik con Oybek
			{
				if(nombre.equals(aux.lineaMingUrikOybek[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaMingUrikOybek[pos];

					System.out.println("Encontrado en El transbordo a pie Ming Urik con Oybek");
					return nodo;
				}
			}
			for(pos=0;pos<aux.lineaPakhtakorAlisherNavoi.length;pos++)//linea Pakhtakor con Alisher Navoi
			{
				if(nombre.equals(aux.lineaPakhtakorAlisherNavoi[pos].dameNombre()))//es que hemos encontrado el nodo correpsondiente al string nombre
				{
					nodo= aux.lineaPakhtakorAlisherNavoi[pos];

					System.out.println("Encontrado en El transbordo a pie Pakhtakor con Alisher Navoi");
					return nodo;
				}
			}

			return nodo;
		}	
	}
	private void muestraRes(String res)
	{
		JOptionPane.showMessageDialog(null,res);
	}

}
