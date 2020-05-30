
public class NodoTrabajador {
	Trabajador persona;
	NodoTrabajador siguiente;
	NodoTrabajador anterior;
	public NodoTrabajador(Trabajador p) {
		this.persona = p;
		this.siguiente = null;
		this.anterior = null;
	}
}
