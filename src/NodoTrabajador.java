import ayp3.tp.*;
public class NodoTrabajador {
	ITrabajador persona;
	NodoTrabajador siguiente;
	NodoTrabajador anterior;
	public NodoTrabajador(ITrabajador p) {
		this.persona = p;
		this.siguiente = null;
		this.anterior = null;
	}
	// Getters and Setters
	public void setPersona(ITrabajador p) {
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
