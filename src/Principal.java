import ayp3.tp.TipoCargo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha f=new Fecha(12,3,2015);
		Fecha fechaNico = new Fecha(25,3,2000);
		Trabajador trabajador=new Trabajador(12345, "Deby", "Villca",TipoCargo.DIRECTOR_DEPARTAMENTO,f );
		Trabajador nico = new Trabajador(123,"Nicolas", "Jimenez", TipoCargo.DIRECTOR_GENERAL, fechaNico);
		mostrarInfoTrabajador(nico);
		
	}
	public static void mostrarInfoTrabajador(Trabajador t) {
		// Recibe un trabajador y llama a todos los metodos get de la clase Trabajador
		System.out.println("Nombre del Trabajador: "+t.getNombre());
		System.out.println("Apellido: "+t.getApellido());
		System.out.println("DNI: "+t.getDni());
		System.out.println("¿El trabajador es Empleado?: "+t.esEmpleado());
		System.out.println("¿El trabajador es Directivo?: "+t.esDirectivo());
		System.out.println("Cargo que lleva a cabo: "+t.getCargo());
		System.out.println("tiene "+t.getMesesAntiguedad()+" meses de antiguedad");
		System.out.println("¿Tiene titulo universitario?: "+t.tieneTituloUniversitario());
		System.out.println("Titulo Universitario: "+t.getTituloUniversitario());
		System.out.println("¿Tiene titulo de postgrado?: "+t.tieneTituloPostgrado());
		System.out.println("Titulo Postgrado: "+t.getTituloPostgrado());
		System.out.println("Salario: "+t.getSalario());
		System.out.println("Empleados a cargo (directamente): "+t.getCantidadEmpleadosACargoDirecto());
		System.out.println("Empleado a cargo (total): "+t.getCantidadEmpleadosACargoTotal());		
	}
}
