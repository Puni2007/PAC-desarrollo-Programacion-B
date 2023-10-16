import java.util.regex.Pattern;
//importamos el paquete para poder utilizar las expresiones regulares

public class Usuario {
	
	//ATRIBUTOS
	private String nombre;
	private int edad;
	private String DNI;
	
	//Creamos el constructor vacío para poder entrar la información por pantala en el Main
	public Usuario() {
		
	}
	
	//Creamos los Setter y Getter
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public boolean setDNI(String DNI) {
		
		/*Para comprobar el DNI lo hacemos con expresiones regulares.
		 * Creamos una String para comprobar que se cumplen los requisitos.
		 * Le decimos que los primeros 8 digitos tienen que ser numeros, el
		 * siguiente digito puede haber un guion o no y el siguiente digito
		 * tiene que ser una letra mayuscula de la A a la Z*/
		
		String comprueba = "^[0-9]{8}-?[A-Z]{1}$";
		Pattern cumple = Pattern.compile(comprueba);
		
		if(cumple.matcher(DNI).matches()) { //Comprobamos que el DNI es correcto
		this.DNI=DNI; //si el DNI es correcto lo asignamos al atributo DNI
		return true;
		
		}else {
			
			return false;
		}
	}
	
	//Método que sobreescribe al método toString para que nos devuelva la información
	public String toString() {
		return "Nombre: " +getNombre()+"\n"+
			   "Edad: " +getEdad()+"\n"+
			   "DNI: " + getDNI();
	}

}
