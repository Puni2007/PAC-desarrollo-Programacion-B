
public class GastoException extends Exception {
	//creamos la clase GastoException que hereda de la clase Exception
	
	public GastoException() {
		//en el constructor le decimos que mensaje queremos que nos lance
		
		super("No hay saldo suficiente en la cuenta\n");
	}

}
