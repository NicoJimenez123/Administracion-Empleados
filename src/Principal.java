import java.util.ArrayList;

import ayp3.tp.ExcepcionOperacionNoPermitida;
import ayp3.tp.ITrabajador;
import ayp3.tp.TipoCargo;
import unpaz.ayp3.Consola;

public class Principal {
	static Empresa empresa = new Empresa();
	static Fecha f=new Fecha(12,3,2015);
	static Fecha fechaNico = new Fecha(25,3,2000);
	static Trabajador trabajador=new Trabajador(12345, "Deby", "Villca",TipoCargo.DIRECTOR_DEPARTAMENTO,f );
	static Trabajador nico = new Trabajador(123,"Nicolas", "Jimenez", TipoCargo.DIRECTOR_GENERAL, fechaNico, "APU", "Licenciado en la Administracion de la Mantisa");
	public static void main(String[] args) {
		empresa.agregarTrabajador(nico);
		empresa.agregarTrabajador(trabajador);
		menu();
		
	}
	public static void menu() {
		while(true) {
			System.out.println();
			System.out.println("~~ Menu de Alta de Trabajadores ~~");
			System.out.println("Opcion 1) Dar de Alta de un Trabajador.");
			System.out.println("Opcion 2) Dar de Baja de un Trabajador.");
			System.out.println("Opcion 3) Listar Trabajadores.");
			System.out.println("Opcion 4) Listar Trabajadores por Nombre y DNI.");
			int opcion = Consola.pedirEntero("Ingrese una Opcion: ");
			switch(opcion) {
			case 1:
				empresa.agregarEmpleado(altaTrabajador());
				break;
			case 2:
				empresa.quitarEmpleado(quitarEmpleado());
				break;
			case 3:
				empresa.listarTrabajadores();
				break;
			case 4:
				empresa.listarNombresYDni();
				break;
			default:System.out.println("Opcion Ingresada No Valida");
			}
			System.out.println();
		}
	}
	private static long quitarEmpleado() {
		long dni;
		while(true) {
			try {
				dni = Consola.pedirEntero("Ingrese el Numero de DNI: ");
				break;
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese el Numero de DNI correspondiente.");
			}
		}
		return dni;
	}
	public static ITrabajador altaTrabajador() {
		// Primero voy declarando las variables para usar el constructor de Trabajador
		long dni;
		int dia, mes, anio, opcionListaCargo = -1;
		String nombre, apellido, titulo, tituloPostgrado = null;
		TipoCargo cargo = null;
		Fecha fechaIngreso;
		// Y voy rellenando las variables usando bloques try-
		while(true) {
			try {
				dni = Consola.pedirEntero("Ingrese el Numero de DNI: ");
				break;
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese el Numero de DNI correspondiente.");
			}
		}
		nombre = Consola.pedirTexto("Ingrese el Nombre: ");
		apellido = Consola.pedirTexto("Ingrese el Apellido: ");
		
		// Acá creo una lista con los diferentes tipos de cargos
		TipoCargo[] listaDeCargos = TipoCargo.values();
		listarCargos();
		do{
			try {
				// Al estar listados solo hay que ingresar el numero correspondiente a cada cargo.
				opcionListaCargo = Consola.pedirEntero("Ingrese el Numero correspondiente al Cargo: ");
				// Si no hay una excepcion, Obtengo el cargo dependiendo del numero ingresado.
				cargo = listaDeCargos[opcionListaCargo];
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese una Opcion valida.");
			}
		// Este bloque se ejecutara mientras se ingresen valores menores a 0 y mayores a la cantidad de cargos
		}while(opcionListaCargo < 0 && opcionListaCargo > TipoCargo.values().length);
		
		do {
			// Bloque para ingresar la fecha
			while(true) {
				try {
					dia = Consola.pedirEntero("Ingrese el dia de ingreso: ");
					mes = Consola.pedirEntero("Ingrese el mes de ingreso: ");
					anio = Consola.pedirEntero("Ingrese el anio de ingreso: ");
					break;
				}
				catch(Exception e) {
					System.out.println("Ha ocurrido un error, Ingrese el numero correspondiente.");
				}
			}
			// Creo un obj tipo Fecha con los valores ingresados
			fechaIngreso = new Fecha(dia,mes,anio);
			// Tirar mensaje de error si la fecha no es valida
			if(!fechaIngreso.comprobar_fecha()) {
				System.out.println("La Fecha ingresada no es valida");
			}
		// Ejecuto este bloque hasta que se ingrese una fecha valida
		}while(!fechaIngreso.comprobar_fecha());
		// Ingreso los titulos del trabajador
		titulo = Consola.pedirTexto("Ingrese el Titulo Universitario: ");
		if(cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL) {
			// Al parecer, solo los directores necesitan almacenar el titulo de postgrado
			tituloPostgrado = Consola.pedirTexto("Ingrese el Titulo de Postgrado: ");
		}
		// Creo un nuevo trabajador
		ITrabajador trabajador = new Trabajador(dni,nombre,apellido,cargo,fechaIngreso,titulo,tituloPostgrado);
		// Retorno la instancia del nuevo trabajador
		return trabajador;
	}
	
    public static void listarCargos() {
    	System.out.println("Lista de Cargos: ");
    	TipoCargo[] t = TipoCargo.values();
    	for(int i = 0; i < TipoCargo.values().length; i++) {
    		System.out.println(i + ": " + t[i]);
    	}
    }
    
    /*
    public static void mostrarTrabajadores() {
    	// HACER ESTE METODO EN LA CLASE EMPRESA
    	ArrayList<ITrabajador> listaTrabajadores = empresa.obtenerListaTrabajadores();
    	for(ITrabajador trabajador : listaTrabajadores) {
    		System.out.println(trabajador.toString());
    	}
    }*/
}




