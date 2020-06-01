package ayp3.tp;

public enum TipoCargo {
	
	DIRECTOR_GENERAL("Director_general",70000),
	DIRECTOR_DEPARTAMENTO("Director_departamento",50000), 
	JEFES("Jefes",40000),
	SUPERVISOR("Supervisor",30000),
	OPERARIO("Operario",25000);
	private String cargo;
	private double salario;
	TipoCargo(String cargo,double salario) {
	        this.cargo= cargo;
	        this.salario=salario;
	        
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
}
