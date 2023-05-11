package ar.edu.unlam.parcial;

public class CuerpoTecnico extends Personal {

	private String rol;
	
	public CuerpoTecnico(String nombre, String apellido, String rol) {
		super(nombre, apellido);
		this.rol = rol;

	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
