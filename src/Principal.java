import ayp3.tp.TipoCargo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha f=new Fecha(12,3,2015);
		Fecha fechaNico = new Fecha(25,3,2000);
		Trabajador trabajador=new Trabajador(12345, "Deby", "Villca",TipoCargo.DIRECTOR_DEPARTAMENTO,f );
		Trabajador nico = new Trabajador(123,"Nicolas", "Jimenez", TipoCargo.DIRECTOR_GENERAL, fechaNico);
		nico.toString();
		
	}
}
