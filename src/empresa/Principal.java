package empresa;

import ayp3.tp.ExcepcionOperacionNoPermitida;
import ayp3.tp.ITrabajador;
import ayp3.tp.TipoCargo;
import unpaz.ayp3.Consola;
import empresa.Trabajador;

public class Principal {
	static Empresa empresa = new Empresa();
	public static void main(String[] args) {
		anadirTrabajadoresPredeterminados();
		menu();
	}
	public static void menu() {
		ITrabajador t;
		while(true) {
			for(int i = 0; i < 80; i++) // Default Height of cmd is 300 and Default width is 80
			    System.out.println(); // Prints a backspace
			System.out.println();
			System.out.println("~~ Menu de Alta de Trabajadores ~~");
			System.out.println("Opcion 1) Dar de Alta de un Trabajador.");
			System.out.println("Opcion 2) Dar de Baja de un Trabajador.");
			System.out.println("Opcion 3) Listar Trabajadores.");
			System.out.println("Opcion 4) Listar Trabajadores por Nombre y DNI.");
			System.out.println("Opcion 5) Modificar Datos de un Trabajador.");
			System.out.println("Opcion 6) Listar Trabajadores por Tipo de Cargo");
			System.out.println("Opcion 7) Calcular Total de Salarios a Pagar");
			System.out.println("Opcion 8) Calcular Salario Mínimo, Máximo y Promedio a pagar");
			System.out.println("Opcion 9) Generar la Nómina de un Trabajador por DNI");
			System.out.println("Opcion 10) Obtener Personas a Cargo (Directamente)");
			System.out.println("Opcion 11) Obtener Personas a Cargo (Total)");
			System.out.println("Opcion 12) Liquidar Sueldos");
			int opcion = Consola.pedirEntero("Ingrese una Opcion: ");
			switch(opcion) {
			case 1:
				empresa.agregarEmpleado(altaTrabajador());
				break;
			case 2:
				empresa.quitarTrabajador(ingresarDni());
				break;
			case 3:
				empresa.listarTrabajadores();
				break;
			case 4:
				empresa.listarNombresYDni();
				break;
			case 5:
				modificarDatos();
				break;
			case 6:
				empresa.listaPorTipoCargo();
				break;
			case 7:
				Double m = empresa.obtenerMontoTotalAPagar();
				System.out.println("Se debe Pagar $"+m+" en Salarios");
				break;
			case 8:
				System.out.println("Salario Minimo: "+empresa.obtenerSalarioMinimo());
				System.out.println("Salario Máximo: "+empresa.obtenerSalarioMaximo());
				System.out.println("Salario Promedio: "+empresa.obtenerPromedioSalarios());
				break;
			case 9:
				empresa.generarNomina(ingresarDni());
				break;
			case 10:
				t = empresa.obtenerTrabajador(ingresarDni());
				System.out.println(t.getCantidadEmpleadosACargoDirecto());
				break;
			case 11:
				t = empresa.obtenerTrabajador(ingresarDni());
				System.out.println(t.getCantidadEmpleadosACargoTotal());
				break;
			case 12:
				empresa.liquidarSueldos();
				break;
			default:System.out.println("Opcion Ingresada No Valida");
			}
			Consola.pedirTexto("Presione Enter para Continuar");
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
    	if(trabajador != null) {
//    	ESTE MENU SE MOSTRARA SOLO SI EL TRABAJADOR ES DISTINTO DE NULL
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
    		case 0:
    			break;
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
        			try {
						trabajador.setTituloPostgrado(Consola.pedirTexto("Ingrese el Titulo de Postgrado: "));
					} catch (ExcepcionOperacionNoPermitida e) {
						
						e.printStackTrace();
					}
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
    }
    
    public static void anadirTrabajadoresPredeterminados() {
    	// Este es un metodo para anadir trabajadores sin tener que hacerlo una y otra vez mediante el programa
    	Fecha f1=new Fecha(12,3,2015);
    	Fecha f2 = new Fecha(25,3,2000);
    	Fecha f3 = new Fecha(25,3,2020);
    	Fecha f4 = new Fecha(25,3,2010);
    	Fecha f5 = new Fecha(25,3,2005);
    	Fecha f6 = new Fecha(25,5,2005);
    	
    	Trabajador nico = new Trabajador(123,"Nicolas", "Jimenez", TipoCargo.DIRECTOR_GENERAL, f2, "APU", "Licenciado en la Administracion de la Mantisa");
    	Trabajador trabajador=new Trabajador(1, "Deby", "Villca",TipoCargo.DIRECTOR_DEPARTAMENTO,f1 );
    	Trabajador trabajador2=new Trabajador(2, "Deby2", "Villca",TipoCargo.JEFES,f3 );
    	Trabajador trabajador3=new Trabajador(3, "Deby3", "Villca",TipoCargo.SUPERVISOR,f4 );
    	Trabajador trabajador4=new Trabajador(4, "Deby4", "Villca",TipoCargo.OPERARIO,f5 );
    	Trabajador trabajador5=new Trabajador(5, "Deby5", "Villca",TipoCargo.DIRECTOR_GENERAL,f6 );
    	
		empresa.agregarTrabajador(nico);
		empresa.agregarTrabajador(trabajador);
		empresa.agregarTrabajador(trabajador2);
		empresa.agregarTrabajador(trabajador3);
		empresa.agregarTrabajador(trabajador4);
		empresa.agregarTrabajador(trabajador5);
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




