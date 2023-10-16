
public abstract class Dinero {
	/*creamos la clase abstracta dinero la cual no se podrá instanciar*/
	
	//ATRIBUTOS
	protected double dinero;
	protected String description;
	
	//MÉTODOS GETTER Y SETTER
	public double getDinero() {
		return dinero;
	}
	
	public void setDinero(double dinero) {
		this.dinero=dinero;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

}
