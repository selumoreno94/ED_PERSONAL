package datos;

public class ReservaDeCaza extends Parque implements Visitable {

	
	private double costeLicencia;
	private String tipoArma;
	
	
	public double getCosteLicencia() {
		return costeLicencia;
	}

	public void setCosteLicencia(double costeLicencia) {
		this.costeLicencia = costeLicencia;
	}

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) 
	{
		this.tipoArma = tipoArma;
	}

	public ReservaDeCaza() {
		// TODO Auto-generated constructor stub
	}

	public ReservaDeCaza(int extension, int numEspecies, String nombre, double costeLicencia) {
		super(extension, numEspecies, nombre);
		this.costeLicencia = costeLicencia;
		this.tipoArma =  "PISTOLA DE AGUA";
	}

	@Override
	public String Visitar() 
	{
		return "VISITABLE CON PISTOLA DE AGUA";
	}

	@Override
	public String toString() {
		return "ReservaDeCaza [COSTE DE LICENCIA = " + costeLicencia + ", TIPO DE ARMA = " + tipoArma + ", Visitar() = " + Visitar()
				+ ", EXTENSION = " + getExtension() + ", NUMERO DE ESPECIES = " + getNumEspecies() + ", NOMBRE DEL PARQUE = "
				+ getNombre() + "]";
	}

	
}
