import ayp3.tp.ExcepcionOperacionNoPermitida;
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
		menu();
		
	}
	public static void menu() {
		while(true) {
			ITrabajador t;
			System.out.println("~~ Menu de Alta de Trabajadores ~~");
			System.out.println();
			int opcion = Consola.pedirEntero("Ingrese una Opcion: ");
			switch(opcion) {
			case 1:t= altaTrabajador();System.out.println(t.toString());break;
			default:System.out.println("Opcion Ingresada No Valida");
			}
		}
	}
	public static ITrabajador altaTrabajador() {
		long dni;
		int dia, mes, anio, opcionListaCargo = -1;
		String nombre, apellido, titulo, tituloPostgrado;
		TipoCargo cargo = null;
		Fecha fechaIngreso;
		
		while(true) {
			try {
				dni = Consola.pedirEntero("Ingrese el Numero de DNI: ");
				break;
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese el Numero de DNI correspondiente.");
			}
		}
		
		while(true) {
			try {
				nombre = Consola.pedirTexto("Ingrese el Nombre: ");
				break;
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese el Nombre correctamente");
			}
		}
		
		while(true) {
			try {
				apellido = Consola.pedirTexto("Ingrese el Apellido: ");
				break;
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese el Apellido correctamente");
			}
		}
		
		TipoCargo[] listaDeCargos = listarCargos();
		do{
			try {
				opcionListaCargo = Consola.pedirEntero("Ingrese el Numero correspondiente al Cargo: ");
				cargo = listaDeCargos[opcionListaCargo];
			}
			catch(Exception e) {
				System.out.println("Por favor, Ingrese una Opcion valida.");
			}
		}while(opcionListaCargo < 0 && opcionListaCargo > TipoCargo.values().length);
		
		do {
			while(true) {
				try {
					dia = Consola.pedirEntero("Ingrese el dia de ingreso: ");
					break;
				}
				catch(Exception e) {
					System.out.println("Ha ocurrido un error, Ingrese el numero correspondiente.");
				}
			}
			while(true) {
				try {
					mes = Consola.pedirEntero("Ingrese el mes de ingreso: ");
					break;
				}
				catch(Exception e) {
					System.out.println("Ha ocurrido un error, Ingrese el numero correspondiente.");
				}
			}
			while(true) {
				try {
					anio = Consola.pedirEntero("Ingrese el anio de ingreso: ");
					break;
				}
				catch(Exception e) {
					System.out.println("Ha ocurrido un error, Ingrese el numero correspondiente.");
				}
			}
			fechaIngreso = new Fecha(dia,mes,anio);
			// Tirar mensaje de error si la fecha no es valida
			if(!fechaIngreso.comprobar_fecha()) {
				System.out.println("La Fecha ingresada no es valida");
			}
		}while(!fechaIngreso.comprobar_fecha());
		titulo = Consola.pedirTexto("Ingrese el Titulo Universitario: ");
		tituloPostgrado = Consola.pedirTexto("Ingrese el Titulo de Postgrado: ");
		System.out.println(cargo);
		return new Trabajador(dni,nombre,apellido,cargo,fechaIngreso,titulo,tituloPostgrado);
	}

    public static TipoCargo[] listarCargos() {
    	System.out.println("Lista de Cargos: ");
    	TipoCargo[] t = TipoCargo.values();
    	for(int i = 0; i < TipoCargo.values().length; i++) {
    		System.out.println(i + ": " + t[i]);
    	}
    	return t;
    }
}
