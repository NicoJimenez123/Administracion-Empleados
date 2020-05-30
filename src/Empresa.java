import ayp3.tp.*;
public class Empresa implements IEmpresa{
	NodoTrabajador primero;
	NodoTrabajador ultimo;
	public Empresa() {
		this.primero = null;
	}
	@Override
	public void agregarEmpleado(ITrabajador trabajador) {
		// Primero creo un nodo con el trabajador a insertar
		NodoTrabajador nuevoTrabajador = new NodoTrabajador(trabajador);
		// Me fijo si hay algun trabajador en la lista
		if(this.primero == null) {
			// Si no lo hay, tomo al nuevo trabajador y lo seteo como primero y ultimo en la lista
			this.primero = nuevoTrabajador;
			this.ultimo = nuevoTrabajador;
		}
		else {
			// Enlazo al nuevo trabajador con el ultimo en la lista
			this.ultimo.setSiguiente(nuevoTrabajador);
			// Tambien enlazo al ultimo de la lista con el nuevo
			nuevoTrabajador.setAnterior(this.ultimo);
			// Ahora el nuevo pasa a ser el ultimo
			this.ultimo = nuevoTrabajador;
		}
	}
	@Override
	public void agregarDirectivo(ITrabajador trabajador) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void quitarEmpleado(ITrabajador trabajador) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void quitarDirectivo(ITrabajador trabajador) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void quitarEmpleado(long dni) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void quitarDirectivo(long dni) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ITrabajador obtenerTrabajador(long dni) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void liquidarSueldos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double obtenerMontoTotalAPagar() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ITrabajador obtenerTrabajadorSalarioMinimo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ITrabajador obtenerTrabajadorSalarioMaximo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double obtenerPromedioSalarios() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ITrabajador obtenerTrabajadorMasAntiguo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ITrabajador obtenerTrabajadorMasReciente() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
