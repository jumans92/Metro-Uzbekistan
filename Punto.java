public class Punto {
	private double x;
	private double y;
	final private double R= 6378.137;
	
	 public Punto() {}
	 public Punto(double x,double y){
		this.x=x;
		this.y=y;
	}
	 double rad(double t) {return t*Math.PI/180;}
	 double distancia (Punto a, Punto b){
		//return Math.sqrt(Math.pow(c1,2)+ Math.pow(c2,2));
		 double dx=rad(a.x-b.x);
		 double dy=rad(a.y-b.y);
		 double o1 = Math.sin(dy/2) * Math.sin(dy/2) + Math.cos(rad(a.y)) * Math.cos(rad(b.y)) * Math.sin(dx/2) * Math.sin(dx/2);
		 double o2 = 2 * Math.atan2(Math.sqrt(o1), Math.sqrt(1-o1));
		 return R * o2;//en KM
	 }
	 public static void main(String args[] ){
		 Punto a=new Punto(44.440572,26.192479);
		 Punto b=new Punto(44.434392,26.185927);
		 System.out.println(a.distancia(a,b));
	 }
}