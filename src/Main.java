import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws GastoException{
		// TODO Auto-generated method stub
		
		//Creamos usuario
		Usuario usu1=new Usuario();
		//Creamos objeto de la clase Scanner para entrar datos por teclado
		Scanner entrada= new Scanner(System.in);
		
		//Llamamos al método que crea al usuario
		crearUsuario(usu1,entrada);
			
		//Creamos la cuenta
		Cuenta nCuenta=new Cuenta(usu1);
		
		/*Mostramos el menú, lo ponemos en un Do While para que se
		 *  repita hasta que el usuario
		 * introduce el 0*/
		int opcion;
		
		do {
			System.out.println("Realiza una nueva acción\n1 Introduce un nuevo gasto\n"
					+ "2 Introduce un nuevo ingreso\n3 Mostrar gastos\n4 Mostrar ingresos\n"
					+"5 Mostrar saldo\n0 Salir");
					
			opcion=entrada.nextInt();
						
			switch(opcion) {
					
			case 1: //entramos el gasto y lo añadimos a la lista de gastos
				
				entrarGasto(nCuenta,entrada);
				break;				
			case 2: //entramos el ingreso y lo añadimos a la lista de ingresos
				
				entrarIngreso(nCuenta, entrada);
				break;		
			case 3://mostramos todo lo que hay en la lista de gastos
							
				mostrarGastos(nCuenta);
				break;						
			case 4: //mostramos todo lo que hay en la lista de ingresos
				
				mostrarIngresos(nCuenta);
				break;
			case 5://mostramos el saldo actual de la cuenta
			
				System.out.println(nCuenta.toString().replace('.',','));
				
				break;
			case 0://fin de programa
				System.out.println("Fin del programa.\nGracias por utilizar la aplicación de M03B"
						+ " en el curso 1s2223.");
				entrada.close(); //Cerramos en archivo Scanner para liberar recursos
				break;
			default://en caso de introducir otro número saldrá que es incorrecto
				System.err.println("Opción incorrecta");
				break;
			}
				
		}while(opcion!=0);
		
	}
	
	//MÉTODOS
	/*Creamos un método para crear al usuario
	 * pidiendo los datos por teclado al usuario
	 * y comprobamos que el DNI tiene el formato correcto*/
	public static void crearUsuario(Usuario usu1, Scanner entrada) {
	
		
		System.out.println("Introduce tu nombre");
		
		usu1.setNombre(entrada.nextLine());		
		
		/*Para introducir la edad he creado un método para que
		 * si por error introducimos un dato que no sea un
		 * entero, el programa no de error y no nos deje continuar*/
		datoIncorrecto(usu1,entrada);
		
		System.out.println("Introduce tu DNI");
		
		//Comprobamos que el DNI es correcto antes de que el usuario quede registrado
		String DNI=entrada.nextLine();		
		
		if(!usu1.setDNI(DNI)) {
		while(!usu1.setDNI(DNI)) {//mientras el DNI sea falso se repite
			
			System.out.println("Formato DNI incorrecto");
			System.out.println("Por favor introduce un DNI correcto");
			
			DNI=entrada.nextLine();
			usu1.setDNI(DNI);
			//se vuelve a comprobar que el DNI es true
			if(usu1.setDNI(DNI)) System.out.println("Usuario:\n"+usu1.toString()+"\nRegistrado correctamente\n");
			
		}
		}else System.out.println("Usuario:\n"+usu1.toString()+"\nRegistrado correctamente\n");
		
	}
	
	
	
	/*Creamos un método para entra los gastos y vamos a
	 * solicitar al usuario los datos de descripción y importe*/
	public static void entrarGasto(Cuenta nCuenta, Scanner entrada)throws GastoException {
		System.out.println("Introduce la descripción del gasto");
		entrada.nextLine();
		String descripcion=entrada.nextLine();
		System.out.println("Introduce el importe");
		double importe=entrada.nextDouble();
		nCuenta.addGastos(descripcion, importe);
		System.out.println(nCuenta.toString().replace('.',','));
		
	}
	
	/*Creamos un método para entrar los ingresos y solicitamos
	 * al usuario los datos de descripción y importe*/
	public static void entrarIngreso(Cuenta nCuenta, Scanner entrada) {
		System.out.println("Introduce la descripción del ingreso");
		entrada.nextLine();
		String descripcion=entrada.nextLine();
		System.out.println("Introduce el importe");
		double importe=entrada.nextDouble();
		nCuenta.addIngresos(descripcion, importe);
		System.out.println(nCuenta.toString().replace('.',','));
		
	}
	
	//Creamos método para mostrar los gastos por consola
	public static void mostrarGastos(Cuenta nCuenta) {
		for(Gasto gasto:nCuenta.getGastos()) {
			System.out.println(gasto.toString().replace('.', ','));
			}
	}
	
	//Cremaos método para mostrar los ingresos por consola
	public static void mostrarIngresos(Cuenta nCuenta) {
		for(Ingreso ingreso:nCuenta.getIngresos()) {
			System.out.println(ingreso.toString().replace('.', ','));
			}
	}
	
	/*He creado este método para poder controlar la excepción 
	 * que nos lanza, cuando el usuario introduce un
	 * dato que no es un entero*/
	public static void datoIncorrecto(Usuario usu1, Scanner entrada) {
		
		boolean comprobarDato=false;
		do {
		try {
			System.out.println("Introduce la edad");
			comprobarDato=true;
			usu1.setEdad(entrada.nextInt());
			entrada.nextLine();
			
		}catch (java.util.InputMismatchException error) {
			comprobarDato=false;
			System.err.println("Dato incorrecto, debes introducir un número entero");
			entrada.nextLine();
			
			
		}
		}while(!comprobarDato);
	}
	

}
