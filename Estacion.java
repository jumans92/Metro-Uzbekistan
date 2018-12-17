
public class Estacion {
	private DNode estacion;
	private Estacion padre;
	private Estacion anterior;
	private Estacion [] hijos;
	int paso;
	private double g;
	private double h;
	private double f;
	Estacion(){}
	Estacion(DNode estacion,Estacion padre,Estacion anterior,Estacion [] hijos,int paso,double g,double h,double f){
		this.estacion=estacion;
		this.padre=padre;
		this.hijos=hijos;
		this.anterior=anterior;
		this.paso=paso;
		this.g=g;
		this.h=h;
		this.f=f;
	}
	public DNode getEstacion() {
		return estacion;
	}
	public void setEstacion(DNode estacion) {
		this.estacion = estacion;
	}
	public Estacion getPadre() {
		return padre;
	}
	public void setPadre(Estacion padre) {
		this.padre = padre;
	}
	public Estacion[] getHijos() {
		return hijos;
	}
	public void setHijos(Estacion[] hijos) {
		this.hijos = hijos;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	public Estacion getAnterior() {
		return anterior;
	}
	public void setAnterior(Estacion anterior) {
		this.anterior = anterior;
	}
	public int getPaso() {
		return paso;
	}
	public void setPaso(int paso) {
		this.paso = paso;
	}
}
