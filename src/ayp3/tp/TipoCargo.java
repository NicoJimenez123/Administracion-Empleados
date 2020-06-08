package ayp3.tp;

public enum TipoCargo {
	
	DIRECTOR_GENERAL("Director_general",70000,0),
	DIRECTOR_DEPARTAMENTO("Director_departamento",50000,1), 
	JEFES("Jefes",40000,2),
	SUPERVISOR("Supervisor",30000,3),
	OPERARIO("Operario",25000,4);
	private String cargo;
	private double salario;
	private int valor;
	TipoCargo(String cargo,double salario,int valor) {
	        this.cargo= cargo;
	        this.salario=salario;
	        this.valor = valor;
	        
	    }//constructor

	    public String getCargo() {
	        return cargo;
	    }
	    public void setSalario(double salario) {
	    	this.salario=salario;
	    }
	    public double getSalario() {
	    
			return salario;
	    }
	    public int getValor() {
	    	return this.valor;
	    }
		public boolean esMayor(TipoCargo cargo2) {
			if(this.valor < cargo2.getValor()) {
				return true;
			}
			else {
				return false;
			}
		}
}
