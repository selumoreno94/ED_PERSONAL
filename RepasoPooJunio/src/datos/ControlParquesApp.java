package datos;

public class ControlParquesApp {

	public static void main(String[] args) 
	{
		Parque caza = new ReservaDeCaza(200, 15, "CAZAOR", 192.68);
		Parque prot = new AreaProtegida(362, 29, "ANIMAL'S RESORT", 10000.76, "ANIMALITAS");
		
		System.out.println(caza);
		System.out.println();
		System.out.println(prot);

	}

}
