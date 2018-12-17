public class DNode
{
	public DNode ant;
	public DNode sig;
	public String nombre;
	public DNode transbordo1; //Si tiene trasbordo a otra linea esta estacion, valdrá distinto de 0.
	//y tendrá el identificador de esa linea con la que conecta.
	public DNode transbordo2;
	public Punto coordenada;
	private double g;
	 public DNode(DNode anterior, DNode siguiente, String nombre, DNode transbordo1, DNode  transbordo2,Punto coord,double g)
	 {
	  this.ant = anterior;
	  this.sig = siguiente;
	  this.nombre = nombre;
	  this.transbordo1=transbordo1;//ojo: un transbordo1 con valor=0 significa que no existe transbordo a ninguna línea. en otro caso el valor de la linea con
	  //la que hace transbordo
	  this.coordenada=coord;
	  this.transbordo2=transbordo2;
	  this.g=g;
	 }
	public DNode (){
			
	}

	public String dameNombre()
	{
		return this.nombre;
	}

	public DNode getNext()
	{
		return this.sig;
	}

	public DNode getPrev()
	{
		return this.ant;
	}

	public void setNext(DNode consecutivo)
	{
		this.sig = consecutivo;
	}

	public void setPrev(DNode previo)
	{
		this.ant = previo;
	}

	public void setElement(String nombreestacion)
	{
		this.nombre = nombreestacion;
	}
	public boolean tieneuntransbordo(){
		if(this.transbordo1==null)
			return false;
		else
			return true;
	}
	public boolean tienedostransbordo(){
		if(this.transbordo2==null)
			return false;
		else
			return true;
	} 
	public DNode transbordo2 (){ //llamar si se ha comprobado primero si tiene linea
		return this.transbordo2;
	}
	public DNode transbordo1 (){ 
		return this.transbordo1;
	}
	public Punto getCoord(){
		return this.coordenada;
	}
	public double getG(){
		return this.g;
	}

}
