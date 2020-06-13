package empresa;
import java.lang.reflect.Array;
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
	private List <ITrabajador> TrabajadoresACargo;
	private double MontoACobrar;
	public Trabajador(long dni, String nombre, String apellido, TipoCargo cargo, Fecha fechaIngreso) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.cargo=cargo;
		this.fechaIngreso=fechaIngreso;
		 TrabajadoresACargo=new ArrayList<>();
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
		TrabajadoresACargo=new ArrayList<>();
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
		if(!this.tieneTituloUniversitario()) {
			return "No Posee Titulo Universitario";
		}
		return titulo;
	}
	@Override
	public boolean tieneTituloUniversitario() {
		if(titulo == null || titulo.length() == 0) {
			return false;
		}else {
			return true;
		}
	 
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
		if(!this.tieneTituloPostgrado()) {
			return "No Posee Titulo de Postgrado";
		}
		return titulop;
	}
	@Override
	public boolean tieneTituloPostgrado() {
		if(titulop == null || titulop.length() == 0) {
			return false;
		}else {
			return true;
		}
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
		if(trabajador.getCargo().equals(TipoCargo.OPERARIO)) {
			throw new ExcepcionOperacionNoPermitida ("Un operario no puede tener trabajador a cargo");
		}
		TrabajadoresACargo.add(trabajador);
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
		boolean esDirectivo = cargo.equals(TipoCargo.DIRECTOR_DEPARTAMENTO )||cargo.equals(TipoCargo.DIRECTOR_GENERAL);
		boolean esEmpleado = cargo.equals(TipoCargo.JEFES) || cargo.equals(TipoCargo.SUPERVISOR) || cargo.equals(TipoCargo.OPERARIO);
		double premio = 0;

		if (esDirectivo && this.getMesesAntiguedad() >= 12) {
			premio += 100000;
		}
		if (esDirectivo && this.getMesesAntiguedad() < 12) {
			premio += 50000;
		}
		if (esEmpleado && this.getMesesAntiguedad() >= 12) {
			premio += 60000;
		}
		if (esEmpleado && this.getMesesAntiguedad() < 12) {
			premio += 30000;
		}
		if (this.tieneTituloUniversitario()) {
			premio += 15000;
		}
		if (this.tieneTituloPostgrado()) {
			premio += 25000;
		}
		if (this.getCantidadEmpleadosACargoDirecto() > 0) {
			premio += (1000 * this.getCantidadEmpleadosACargoDirecto());
		}
		if (this.getCantidadEmpleadosACargoTotal() > 0) {
			premio += (500 * this.getCantidadEmpleadosACargoTotal());
		}
		return premio;
	
	}
	@Override
	public double getMontoACobrar() {
		return cargo.getSalario()+this.getPremio();
	}

	@Override
	public int getCantidadEmpleadosACargoDirecto() {
		if(cargo.equals(TipoCargo.OPERARIO)) {
			return 0;
		}
		return this.TrabajadoresACargo.size();
	}
	@Override
	public int getCantidadEmpleadosACargoTotal() {
		/*int s=0;
		for(int i=0;i<this.TrabajadoresACargo.size();i++) {
			s+=1;
		}
		return s;*/
		return this.cantidad();
	}
	public int cantidad() {
		List<ITrabajador> listaTrabajadores = new ArrayList<>();
		for(ITrabajador t: this.TrabajadoresACargo) {
			// Acá recorro los directores de departamento, en caso de que sea un director general esta hecho
			if(!listaTrabajadores.contains(t)) {
				listaTrabajadores.add(t);
			}
			for(ITrabajador t2: t.getListaACargo()) {
				// Acá recorro los jefes
				if(!listaTrabajadores.contains(t2)) {
					listaTrabajadores.add(t2);
				}
				for(ITrabajador t3: t2.getListaACargo()) {
					// Acá recorro los supervisores
					if(!listaTrabajadores.contains(t3)) {
						listaTrabajadores.add(t3);
					}
					for(ITrabajador t4: t3.getListaACargo()) {
						// Acá recorro los operarios
						if(!listaTrabajadores.contains(t4)) {
							listaTrabajadores.add(t4);
						}
					}
				}
			}
		}
		return listaTrabajadores.size();
	}
	@Override
	public List<ITrabajador> getListaACargo(){
		return this.TrabajadoresACargo;
	}
	
	@Override
	public String toString() {
		String tieneTituloU;
		String tieneTituloP;
		String tipoTrabajador;
		if(this.tieneTituloUniversitario()) { tieneTituloU = "Si"; }
		else{ tieneTituloU = "No"; }
		
		if(this.tieneTituloPostgrado()) { tieneTituloP = "Si"; }
		else{ tieneTituloP = "No"; }
		
		if(this.esEmpleado()) { tipoTrabajador = "El Trabajador es Empleado"; }
		else { tipoTrabajador = "El Trabajador es Directivo"; } 
		
		String s = "Nombre del Trabajador: "+this.getNombre()+
				"\n"+"Apellido: "+this.getApellido()+"\n"+
				"DNI: "+this.getDni()+"\n"+
				tipoTrabajador+"\n"+"Cargo que lleva a cabo: "+this.getCargo()+"\n"+
				"tiene "+this.getMesesAntiguedad()+" meses de antiguedad"+"\n"+
				"Tiene titulo universitario?: "+tieneTituloU+"\n"+
				"Titulo Universitario: "+this.getTituloUniversitario()+"\n"+
				"Tiene titulo de postgrado?: "+tieneTituloP+"\n"+
				"Titulo Postgrado: "+this.getTituloPostgrado()+"\n"+
				"Salario: "+this.getSalario()+"\n"+
				"Empleados a cargo (directamente): "+this.getCantidadEmpleadosACargoDirecto()+"\n"+
				"Empleado a cargo (total): "+this.getCantidadEmpleadosACargoTotal();	
		
		return s;
	}
	@Override
	public void setMontoACobrar(double d) {
		this.MontoACobrar=d;
		
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCargo(TipoCargo cargo) {
		this.cargo = cargo;
	}
	public void setFechaIngreso(Fecha fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setTitulop(String titulop) {
		this.titulop = titulop;
	}
	@Override
	public void setTrabajadoresACargo(ITrabajador trabajador) {
		if(this.TrabajadoresACargo.contains(trabajador)) {
			System.out.println("Este Trabajador ya se Encuentra a Cargo");
		}
		else {
			this.TrabajadoresACargo.add(trabajador);
		}
	}
	@Override
	public Fecha getFechaIngreso() {
		return this.fechaIngreso;
	}
	public void quitarTrabajadorACargo(ITrabajador t) {
		this.TrabajadoresACargo.remove(t);
	}
	public boolean tieneACargo(ITrabajador t) {
		return this.TrabajadoresACargo.contains(t);
	}
	
}
