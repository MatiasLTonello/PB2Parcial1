package ar.edu.unlam.parcial;

public class CuerpoTecnico extends Personal {

	private Rol rol;

	public CuerpoTecnico(String nombre, String apellido, Rol rol, Integer edad, String dni) {
		super(nombre, apellido, edad, dni);
		this.rol = rol;

	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
