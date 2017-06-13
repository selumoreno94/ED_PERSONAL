package datos;

public class Parque 
{
	private int extension; // num M2
	private int numEspecies;
	private String nombre;
	
	
	
	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getNumEspecies() {
		return numEspecies;
	}

	public void setNumEspecies(int numEspecies) {
		this.numEspecies = numEspecies;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Parque() 
	{
		
	}

	public Parque(int extension, int numEspecies, String nombre) {
		super();
		this.extension = extension;
		this.numEspecies = numEspecies;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Parque [extension=" + extension + ", numEspecies=" + numEspecies + ", nombre=" + nombre +  "]";
	}
	
	
	
}
