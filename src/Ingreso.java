
public class Ingreso extends Dinero{
	//Ingreso hereda de la clase Dinero
	
	
	//Creamos el constructor para entrar lso ingresos
	public Ingreso(double ingreso, String description) {
		this.dinero=ingreso;
		this.description=description;
	}
	
	
	//Método que sobreescribe el método toString para que nos devuelva la información
	@Override
	public String toString() {
		return "Movimiento: "+description+" importe: "+dinero+"€";
	}

}
