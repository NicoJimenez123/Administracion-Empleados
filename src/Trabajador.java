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
	public Trabajador(long dni, String nombre, String apellido, TipoCargo cargo, Fecha fechaIngreso) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.cargo=cargo;
		this.fechaIngreso=fechaIngreso;
	}
	@Override
	public boolean esEmpleado() {
		return (this.cargo.equals(TipoCargo.JEFES) ||this.cargo.equals(TipoCargo.SUPERVISOR)
				||this.cargo.equals(TipoCargo.OPERARIO));
	}
	@Override
	public boolean esDirectivo() {	
		return (this.cargo.equals(TipoCargo.DIRECTOR_GENERAL)||this.cargo.equals(TipoCargo.DIRECTOR_DEPARTAMENTO));
		
	}
	@Override
	public TipoCargo getCargo() {
		return cargo;
	}
	@Override
	public int getMesesAntiguedad() {
		return fechaIngreso.calcularMeses();
		//obtener fecha actual 
		//calcular actual e ingreso
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
		//if es un operario lanzar excepcion 
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
		return 0;
		//necesito implementar getmesesAntiguedad
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
}