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
			System.out.println("Opcion 5) Modificar Datos de un Trabajador.");
			int opcion = Consola.pedirEntero("Ingrese una Opcion: ");
			switch(opcion) {
			case 1:
				empresa.agregarEmpleado(altaTrabajador());
				break;
			case 2:
				empresa.quitarEmpleado(ingresarDni());
				break;
			case 3:
				empresa.listarTrabajadores();
				break;
			case 4:
				empresa.listarNombresYDni();
				break;
			case 5:
				modificarDatos();
			default:System.out.println("Opcion Ingresada No Valida");
			}
			System.out.println();
		}
	}
	private static long ingresarDni() {
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
		String nombre, apellido, titulo, tituloPostgrado = null;
		TipoCargo cargo = null;
		Fecha fechaIngreso;
		// Y voy rellenando las variables
		dni = ingresarDni();
		nombre = Consola.pedirTexto("Ingrese el Nombre: ");
		apellido = Consola.pedirTexto("Ingrese el Apellido: ");
		
		cargo = ingresarCargo();
		boolean elCargoEsDirectivo = cargo == TipoCargo.DIRECTOR_DEPARTAMENTO || cargo == TipoCargo.DIRECTOR_GENERAL;
		
		fechaIngreso = ingresarFecha();
		
		// Ingreso los titulos del trabajador
		titulo = Consola.pedirTexto("Ingrese el Titulo Universitario: ");
		if(elCargoEsDirectivo) {
			// Al parecer, solo los directores necesitan almacenar el titulo de postgrado
			tituloPostgrado = Consola.pedirTexto("Ingrese el Titulo de Postgrado: ");
		}
		// Creo un nuevo trabajador
		ITrabajador trabajador = new Trabajador(dni,nombre,apellido,cargo,fechaIngreso,titulo,tituloPostgrado);
		// Retorno la instancia del nuevo trabajador
		return trabajador;
	}
	
    private static TipoCargo ingresarCargo() {
    	int opcionListaCargo = -1;
    	TipoCargo cargo = null;
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
		return cargo;
	}
    
    private static Fecha ingresarFecha() {
		int dia, mes, anio;
		Fecha fechaIngreso;
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
    	return fechaIngreso;
    }
    
	public static void listarCargos() {
    	System.out.println("Lista de Cargos: ");
    	TipoCargo[] t = TipoCargo.values();
    	for(int i = 0; i < TipoCargo.values().length; i++) {
    		System.out.println(i + ": " + t[i]);
    	}
    }
    
    public static void modificarDatos() {
    	long dni = ingresarDni();
    	int opcion = 0;
    	ITrabajador trabajador = empresa.obtenerTrabajador(dni);
    	boolean trabajadorEsDirectivo = trabajador.getCargo() == TipoCargo.DIRECTOR_DEPARTAMENTO || trabajador.getCargo() == TipoCargo.DIRECTOR_GENERAL;
    	do{
    		System.out.println("~~ Menu de Modificacion de Datos");
    		System.out.println("Opcion 1): DNI");
    		System.out.println("Opcion 2): Nombre");
    		System.out.println("Opcion 3): Apellido");
    		System.out.println("Opcion 4): Cargo");
    		System.out.println("Opcion 5): Fecha de Ingreso");
    		System.out.println("Opcion 6): Titulo Universitario");
    		if(trabajadorEsDirectivo) {
    			// Los empleados no deberian de tener titulo de postgrado
    			System.out.println("Opcion 7): Titulo de Postgrado");
    		}
    		System.out.println("Opcion 9): Salir");
    		try {
    			opcion = Consola.pedirEntero("Ingrese una Opcion: ");
    		}
    		catch(Exception e) {
    			System.out.println("Por Favor, Ingrese un numero");
    		}
    		switch(opcion) {
    		case 1:
    			trabajador.setDni(ingresarDni());
    			break;
    		case 2:
    			trabajador.setNombre(Consola.pedirTexto("Ingrese el Nombre: "));
    			break;
    		case 3:
    			trabajador.setApellido(Consola.pedirTexto("Ingrese el Apellido: "));
    			break;
    		case 4:
    			trabajador.setCargo(ingresarCargo());
    			break;
    		case 5:
    			trabajador.setFechaIngreso(ingresarFecha());
    			break;
    		case 6:
    			trabajador.setTituloUniversitario(Consola.pedirTexto("Ingrese el Titulo Universitario: "));
    			break;
    		case 7:
    			if(!trabajadorEsDirectivo) {
    				System.out.println("Solo los Directivos tienen titulo de Postgrado");
    			}
    			else {
        			trabajador.setTituloPostgrado(Consola.pedirTexto("Ingrese el Titulo de Postgrado: "));
    			}
    			break;
    		case 9:
    			break;
    		default:
    			System.out.println("Numero Ingresado no Valido");
    			break;
    		}
    	}while(opcion != 9);
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




