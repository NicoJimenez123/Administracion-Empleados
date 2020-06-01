import ayp3.tp.ITrabajador;
import ayp3.tp.TipoCargo;
import unpaz.ayp3.Consola;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha f=new Fecha(12,3,2015);
		Fecha fechaNico = new Fecha(25,3,2000);
		Trabajador trabajador=new Trabajador(12345, "Deby", "Villca",TipoCargo.DIRECTOR_DEPARTAMENTO,f );
		Trabajador nico = new Trabajador(123,"Nicolas", "Jimenez", TipoCargo.DIRECTOR_GENERAL, fechaNico, "APU", "Licenciado en la Administracion de la Mantisa");
		Trabajador nuevo = altaTrabajador();
		System.out.println(nuevo);
		
	}
	public static Trabajador altaTrabajador() {
		long dni = Consola.pedirEntero("Ingrese el Numero de DNI: ");
		String nombre = Consola.pedirTexto("Ingrese el Nombre: ");
		String apellido = Consola.pedirTexto("Ingrese el Apellido: ");
		String nombreCargo = Consola.pedirTexto("Ingrese el Tipo de Cargo: ");
		// Reviso el nombre del cargo ingresado con las constantes de la clase TipoCargo
		TipoCargo cargo = null;
		for(TipoCargo t : TipoCargo.values()) {
			if(t.getCargo().compareTo(nombreCargo) == 0) {
				cargo = t;
			}
		}
		int dia = Consola.pedirEntero("Ingrese el dia de ingreso: ");
		int mes = Consola.pedirEntero("Ingrese el mes de ingreso: ");
		int anio = Consola.pedirEntero("Ingrese el anio de ingreso: ");;
		Fecha fechaIngreso = new Fecha(dia,mes,anio);
		String titulo = Consola.pedirTexto("Ingrese el Titulo Universitario: ");
		String tituloPostgrado = Consola.pedirTexto("Ingrese el Titulo de Postgrado: ");
		return new Trabajador(dni,nombre,apellido,cargo,fechaIngreso,titulo,tituloPostgrado);
	}
	/*
	public static void menu() {
		while(true) {
			System.out.println("~~ Menu de Alta de Trabajadores ~~");
			System.out.println();
		}
	}*/
}
