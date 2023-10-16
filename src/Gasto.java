
public class Gasto extends Dinero {
	// Gasto hereda de la clase Dinero
	
	
	//Creamos el constructor para entrar los gastos
	public Gasto(double gasto, String description) {
		this.dinero=gasto;
		this.description=description;
	}
	
	//Método que sobreescribe el método toString para que nos devuelva la información
	@Override
	public String toString() {
		return "Movimiento: "+description+ " importe: " + dinero+"€";
	}

}
