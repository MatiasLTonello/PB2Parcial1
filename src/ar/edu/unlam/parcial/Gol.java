package ar.edu.unlam.parcial;

public class Gol extends Evento {
	
	String nombreDelEquipo;
	

    public Gol(int tiempoMinutos, Jugador jugador, String nombreDelEquipo) {
        super(tiempoMinutos, jugador);
        tipoDeEvento = "gol";
        this.nombreDelEquipo = nombreDelEquipo;
       
        
    }
    
    
	public String getNombreDelEquipo() {
		return nombreDelEquipo;
	}



	public void setNombreDelEquipo(String nombreDelEquipo) {
		this.nombreDelEquipo = nombreDelEquipo;
	}












	@Override
    public void ejecutar() {}
}
