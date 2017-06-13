package datos;

public class AreaProtegida extends Parque implements Visitable 
{

	private double subvencionGobierno;
	private String nombreONG;
	
	
	
	public double getSubvencionGobierno() {
		return subvencionGobierno;
	}

	public void setSubvencionGobierno(double subvencionGobierno) {
		this.subvencionGobierno = subvencionGobierno;
	}

	public String getNombreONG() {
		return nombreONG;
	}

	public void setNombreONG(String nombreONG) {
		this.nombreONG = nombreONG;
	}

	public AreaProtegida() 
	{
		
	}

	public AreaProtegida(int extension, int numEspecies, String nombre, double subvencionGobierno, String nombreONG) 
	{
		super(extension, numEspecies, nombre);
		this.subvencionGobierno = subvencionGobierno;
		this.nombreONG = nombreONG;
	}

	

	@Override
	public String Visitar() 
	{	
		return "NO VISITABLE";
	}

	@Override
	public String toString() {
		return "AreaProtegida [CUANTIA SUBVENCION GOBIERNO = " + subvencionGobierno + " €, NOMBRE DE LA ONG = " + nombreONG + ", Visitar() = "
				+ Visitar() + ", EXTENSION = " + getExtension() + " M2, NUMERO DE ESPECIES = " + getNumEspecies()
				+ ", NOMBRE DEL PARQUE = " + getNombre() + "]";
	}

	
	
	
}
