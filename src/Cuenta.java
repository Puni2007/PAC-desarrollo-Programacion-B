import java.util.LinkedList;
import java.util.List;

public class Cuenta {
	
	//ATRIBUTOS
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	//CONSTRUCTOR
	public Cuenta(Usuario usuario){
		
		this.usuario=usuario;
		saldo=0;
		//Creamos las listas LinkedList
		gastos=new LinkedList<>();
		ingresos=new LinkedList<>();
	}
	
	//Métodos SETTERS y GETTERS
	public double getSaldo() {
		return Math.round(saldo*100.0)/100.0;//Con clase Math redondeamos para que salgan 2 decimales solo
	}
	
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	public double addIngresos(String description, double cantidad) {
		//añadimos a la lista cada ingreso realizado
		Ingreso ingreso = new Ingreso(cantidad,description);
		ingresos.add(ingreso);
		setSaldo(this.saldo+cantidad);
		
		return getSaldo();
	}
	
	public double addGastos (String descripcion, double cantidad)throws GastoException  {
		//añadimos a la lista cada gasto realizado
		try {
		if(getSaldo()<cantidad) { //comprobamos que el saldo de la cuenta sea superior al gasto
			
			GastoException miExcepcion=new GastoException(); 
			
			throw miExcepcion;//si el gasto el mayor se crea la excepción
		}else {
				
				Gasto gasto=new Gasto(cantidad,descripcion); //si hay suficiente saldo se resta el gasto
				gastos.add(gasto);
				setSaldo(this.saldo-cantidad);
				
				return getSaldo();
				}
		}
		catch(GastoException error){ //si no hay suficiente saldo saltará la excepción
			
			System.err.println(error.getMessage());
			
		}
		return getSaldo();
		
	}
	
	public List<Ingreso> getIngresos(){ //nos devuelve la lista de ingresos
		return ingresos;
	}
	
	public List<Gasto> getGastos(){ //nos devulve la lista de gastos
		return gastos;
	}
	
	
	//Método que sobreescribe al método toString para que nos devuelva la información
	@Override
	public String toString() {
		return getUsuario() + " Saldo actual: "+getSaldo()+"€";
	}
	
	
}
