package ayp3.tp;

import java.util.List;

import empresa.Fecha;

public interface ITrabajador {



	public boolean esEmpleado();
	
	public boolean esDirectivo();
	
	public TipoCargo getCargo();
	
	public int getMesesAntiguedad();
	
	public void setTituloUniversitario(String titulo);
	
	public String getTituloUniversitario();
	
	public boolean tieneTituloUniversitario();
	
	public void setTituloPostgrado(String titulo) throws ExcepcionOperacionNoPermitida;
	
	public String getTituloPostgrado();
	
	public boolean tieneTituloPostgrado();
	
	public String getNombre();
	
	public String getApellido();
	
	public long getDni();
	
	public void agregarTrabajadorACargo(ITrabajador trabajador) throws ExcepcionOperacionNoPermitida;
	
	public void setJefe(ITrabajador jefe);
	
	public void setSalario(double salario);
	
	public double getSalario();
	
	public double getPremio();
	
	/* salario más premio*/
	public double getMontoACobrar();
	
	public int getCantidadEmpleadosACargoDirecto();
	
	/*los suyos más lo de sus empleados a cargo directo y asi*/
	public int getCantidadEmpleadosACargoTotal();

	public void setMontoACobrar(double d);

	public void setDni(long ingresarDni);

	public void setNombre(String pedirTexto);

	public void setApellido(String pedirTexto);

	public void setCargo(TipoCargo ingresarCargo);

	public void setFechaIngreso(Fecha ingresarFecha);

	void setTrabajadoresACargo(ITrabajador trabajadoresACargo);

	List<ITrabajador> getListaACargo();
	
	public Fecha getFechaIngreso();

	public boolean tieneACargo(ITrabajador t);

	public void quitarTrabajadorACargo(ITrabajador t);


	
	
	
	
	
	
	

}
