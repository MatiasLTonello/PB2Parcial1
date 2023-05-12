package ar.edu.unlam.parcial;

public class Jugador extends Personal {
	
	public Integer numeroDorsal;
	public Integer numeroTelefono;
	public Integer amarillas;
	
	public Jugador(String nombre, String apellido, Integer numeroDorsal, Integer numeroTelefono, Integer edad, Integer dni){
		super(nombre, apellido, edad, dni);
		this.numeroDorsal = numeroDorsal;
		this.numeroTelefono = numeroTelefono;
		
	}

	public Integer getNumeroDorsal() {
		return numeroDorsal;
	}

	public void setNumeroDorsal(Integer numeroDorsal) {
		this.numeroDorsal = numeroDorsal;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDorsal == null) ? 0 : numeroDorsal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (numeroDorsal == null) {
			if (other.numeroDorsal != null)
				return false;
		} else if (!numeroDorsal.equals(other.numeroDorsal))
			return false;
		return true;
	}

	public Integer getAmarillas() {
		return amarillas;
	}

	public void setAmarillas(Integer amarillas) {
		this.amarillas = amarillas;
	}
	

}
