import ayp3.tp.TipoCargo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha f=new Fecha(12,3,2015);
		
		Trabajador trabajador=new Trabajador(12345, "Deby", "Villca",TipoCargo.DIRECTOR_DEPARTAMENTO,f );
		System.out.println(trabajador.esEmpleado());
		System.out.println(trabajador.esDirectivo());
	}

}
