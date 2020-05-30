
public class NodoTrabajador {
	Trabajador persona;
	NodoTrabajador siguiente;
	NodoTrabajador anterior;
	public NodoTrabajador(Trabajador p) {
		this.persona = p;
		this.siguiente = null;
		this.anterior = null;
	}
	// Getters and Setters
	public void setPersona(Trabajador p) {
		this.persona = p;
	}
	public void setSiguiente(NodoTrabajador n) {
		this.siguiente = n;
	}
	public void setAnterior(NodoTrabajador n) {
		this.anterior = n;
	}
	public Trabajador getPersona() {
		return this.persona;
	}
	public NodoTrabajador getSiguiente() {
		return this.siguiente;
	}
	public NodoTrabajador getAnterior() {
		return this.anterior;
	}
}
