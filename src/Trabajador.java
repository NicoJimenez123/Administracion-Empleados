import java.util.ArrayList;
import java.util.List;

import ayp3.tp.*;
public class Trabajador implements ITrabajador{
	private long dni;
	private String nombre;
	private String apellido;
	private TipoCargo cargo;
	private Fecha fechaIngreso;
	private String titulo;
	private String titulop;
	private ITrabajador jefe;
	private Empresa TrabajadoresACargo;
	public Trabajador(long dni, String nombre, String apellido, TipoCargo cargo, Fecha fechaIngreso) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.cargo=cargo;
		this.fechaIngreso=fechaIngreso;
		 TrabajadoresACargo=new Empresa();
	}
	public Trabajador(long dni, String nombre, String apellido, TipoCargo cargo, Fecha fechaIngreso, String titulo,
			String tituloPostgrado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.fechaIngreso = fechaIngreso;
		this.titulo = titulo;
		this.titulop = tituloPostgrado;
		TrabajadoresACargo=new Empresa();
	}
	@Override
	public boolean esEmpleado() {
		return (this.cargo.equals(TipoCargo.JEFES) ||this.cargo.equals(TipoCargo.SUPERVISOR)
				||this.cargo.equals(TipoCargo.OPERARIO));
	}
	@Override
	public boolean esDirectivo() {	
		return (this.cargo.equals(TipoCargo.DIRECTOR_GENERAL)
				||this.cargo.equals(TipoCargo.DIRECTOR_DEPARTAMENTO));
		
	}
	@Override
	public TipoCargo getCargo() {
		return cargo;
	}
	@Override
	public int getMesesAntiguedad() {
		return fechaIngreso.calcularMeses();
	}
	@Override
	public void setTituloUniversitario(String titulo) {
		this.titulo=titulo;
	}
	@Override
	public String getTituloUniversitario() {
		return titulo;
	}
	@Override
	public boolean tieneTituloUniversitario() {
		return (titulo!=null);
	}
	@Override
	public void setTituloPostgrado(String titulo) throws ExcepcionOperacionNoPermitida {
		if(!this.tieneTituloUniversitario()) {
			throw new ExcepcionOperacionNoPermitida ("Debe tener titulo universitario");
		}
		this.titulop=titulo;
	}
	@Override
	public String getTituloPostgrado() {
		return titulop;
	}
	@Override
	public boolean tieneTituloPostgrado() {
		return (titulop!=null);
	}
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public String getApellido() {
		return apellido;
	}
	@Override
	public long getDni() {
		return dni;
	}
	@Override
	public void agregarTrabajadorACargo(ITrabajador trabajador) throws ExcepcionOperacionNoPermitida {	
		if(trabajador.equals(TipoCargo.OPERARIO)) {
			throw new ExcepcionOperacionNoPermitida ("Un operario no puede tener trabajador a cargo");
		}
		TrabajadoresACargo.agregarEmpleado(trabajador);
	}

	@Override
	public void setJefe(ITrabajador jefe) {	
		this.jefe=jefe;
	}
	@Override
	public void setSalario(double salario) {
		cargo.setSalario(salario);
	}
	@Override
	public double getSalario() {
		return cargo.getSalario();
	}
	@Override
	public double getPremio() {
		//$100000 a los directivos con, al menos, 12 meses de antig�edad.
		double premio=0;
	if(cargo.equals(TipoCargo.DIRECTOR_DEPARTAMENTO )||cargo.equals(TipoCargo.DIRECTOR_GENERAL)
			&& this.getMesesAntiguedad()>=12)	{
		premio=cargo.getSalario()+100000;
		// $50000 a los directivos sin un m�nimo de 12 meses de antig�edad.
	} if (cargo.equals(TipoCargo.DIRECTOR_DEPARTAMENTO )||cargo.equals(TipoCargo.DIRECTOR_GENERAL)
			&& this.getMesesAntiguedad()<12){
		premio=cargo.getSalario()+50000;
	}
	// $60000 a los no directivos con, al menos, 12 meses de antig�edad.
		if(cargo.equals(TipoCargo.JEFES )||cargo.equals(TipoCargo.SUPERVISOR)||cargo.equals(TipoCargo.OPERARIO)
			&& this.getMesesAntiguedad()>=12) {
		premio=cargo.getSalario()+60000;
	}// $30000 a los no directivos sin un m�nimo de 12 meses de antig�edad.
		if(cargo.equals(TipoCargo.JEFES )||cargo.equals(TipoCargo.SUPERVISOR)||cargo.equals(TipoCargo.OPERARIO)
			&& this.getMesesAntiguedad()<12) {
		premio=cargo.getSalario()+30000;
		// $15000 m�s a los empleados con t�tulo universitario.
		}if(this.tieneTituloUniversitario()) {
			premio=cargo.getSalario()+15000;
		}
		//$25000 m�s a los empleados con t�tulo de postgrado.
		if(this.tieneTituloPostgrado()) {
			premio=cargo.getSalario()+25000;
			}
		// $1000 m�s por empleado a cargo directo
			if(this.getCantidadEmpleadosACargoDirecto()>0) {
				premio=cargo.getSalario()+(1000*this.getCantidadEmpleadosACargoDirecto());
			}
		//$500 m�s por empleado a cargo indirecto
			if(this.getCantidadEmpleadosACargoTotal()>0) {
				premio=cargo.getSalario()+(500*this.getCantidadEmpleadosACargoTotal());
			}
		return premio;
	
	}
	@Override
	public double getMontoACobrar() {
		return cargo.getSalario()+this.getPremio();
	}
	@Override
	public int getCantidadEmpleadosACargoDirecto() {
			
		return 0;
	}
	@Override
	public int getCantidadEmpleadosACargoTotal() {
		return 0;
	}
	@Override
	public String toString() {
		String s = "Nombre del Trabajador: "+this.getNombre()+
				"\n"+"Apellido: "+this.getApellido()+"\n"+
				"DNI: "+this.getDni()+"\n"+
				"�El trabajador es Empleado?: "+this.esEmpleado()+"\n"+
				"�El trabajador es Directivo?: "+this.esDirectivo()+"\n"+"Cargo que lleva a cabo: "+this.getCargo()+"\n"+
				"tiene "+this.getMesesAntiguedad()+" meses de antiguedad"+"\n"+
				"�Tiene titulo universitario?: "+this.tieneTituloUniversitario()+"\n"+
				"Titulo Universitario: "+this.getTituloUniversitario()+"\n"+
				"�Tiene titulo de postgrado?: "+this.tieneTituloPostgrado()+"\n"+
				"Titulo Postgrado: "+this.getTituloPostgrado()+"\n"+
				"Salario: "+this.getSalario()+"\n"+
				"Empleados a cargo (directamente): "+this.getCantidadEmpleadosACargoDirecto()+"\n"+
				"Empleado a cargo (total): "+this.getCantidadEmpleadosACargoTotal();		 
		return s;
	}
}
