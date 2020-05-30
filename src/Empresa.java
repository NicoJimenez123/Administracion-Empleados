import ayp3.tp.*;
public class Empresa implements IEmpresa{
	NodoTrabajador primero;
	public Empresa() {
		this.primero = null;
	}
	@Override
	public void agregarEmpleado(ITrabajador trabajador) {
		// TODO Auto-generated method stub
		
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
