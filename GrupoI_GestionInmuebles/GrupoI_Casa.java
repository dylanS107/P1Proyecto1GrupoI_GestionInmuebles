package GrupoI_GestionInmuebles;

import java.util.*;

public class GrupoI_Casa extends GrupoI_Inmueble {
	Scanner inputInm = new Scanner(System.in);
	GrupoI_Casa objetsArray[];
	private int numRoom;
	private String tipeGarage;
	public GrupoI_Casa(String locationArea,String address, double price, int squareMeter, String tipePay, int timePayments,
			String propertyLand, int numRoom, String tipeGarage, double PayEstimatedTim) {
		super(locationArea, address, price, squareMeter, tipePay, timePayments, propertyLand, PayEstimatedTim);
		this.numRoom = numRoom;
		this.tipeGarage = tipeGarage;
	}
	
	@Override
	public String toString() { //Retorna todos los valores ingresados o seleccionados.
		return "direccion(CIUDAD) "+address+"\n"+
				"Zona (Rural/Urbana: "+locationArea+"\n"+
				"Precio de disponibilidad: "+price+"\n"+
				"Metros cuadrados: "+squareMeter+"\n"+
				"Tipo de pago necesario(Contado/Crédito): "+tipePay+"\n"+
				"Tiempo de pago: "+timePayments+"\n"+
				"Terreno de la propiedad: "+propertyLand+"\n"+
				"Numero de cuartos: "+numRoom+"\n"+
				"Numero de cuartos del terreno: "+tipeGarage+"\n";
	}
	
	@Override
	public void ObjetStaticInmuebles() {
		 int numeroInmuebles = 10;
	        objetsArray = new GrupoI_Casa[numeroInmuebles];
	        objetsArray[0] = new GrupoI_Casa("urbano", "ibarra", 150580, 12, "contado", 0, "urbanizable", 3, "residencial", 0);
	        objetsArray[1] = new GrupoI_Casa("rural", "loja", 200000, 150, "credito", 36, "rustico", 4, "comercial", 0);
	        objetsArray[2] = new GrupoI_Casa("urbano", "milagro", 15000, 11, "contado", 0, "urbanizable", 2, "residencial", 0);
	        objetsArray[3] = new GrupoI_Casa("rural", "santo domingo", 50000, 85, "contado", 0, "urbanizable", 5, "comercial", 0);
	        objetsArray[4] = new GrupoI_Casa("rural", "cuenca", 250000, 130, "credito", 36, "urbanizable", 6, "residencial", 0);
	        objetsArray[5] = new GrupoI_Casa("urbano", "esmeraldas", 28000, 16, "credito", 12, "urbanizable", 3, "comercial", 0);
	        objetsArray[6] = new GrupoI_Casa("urbano", "portoviejo", 1099, 8, "contado", 0, "urbanizable", 1, "residencial", 0);
	        objetsArray[7] = new GrupoI_Casa("urbano", "ambato", 150000, 15, "credito", 24, "urbanizable", 4, "comercial", 0);
	        objetsArray[8] = new GrupoI_Casa("rural", "tulcan", 10000, 20, "contado", 0, "rustico", 2, "residencial", 0);
	        objetsArray[9] = new GrupoI_Casa("rural", "santa elena", 25000, 13, "credito", 12, "rustico", 3, "comercial", 0);

	        for (int i = 0; i < objetsArray.length; i++) {
	            System.out.println("DATOS DE LA CASA " + (i + 1) + ": ");
	            System.out.println(objetsArray[i].toString());
	            System.out.println("");
	        }
	}
	
	public void inputDatosCasa() {
		tipeGarage = null;
		int optionGarage;
		System.out.println("Ingrese el numero de cuartos del apartamento: ");
		numRoom = inputInm.nextInt();
		inputInm.nextLine();
		while(numRoom < 1 || numRoom > 6) {
			System.out.print("Error, cuartos no disponible. \nVuelva a ingresar: ");
			numRoom = inputInm.nextInt();
			inputInm.nextLine();
		}
		
		do {
            System.out.println("SELECCIONE EL TIPO DE GARAJE DE SU INTERES: ");
            System.out.println("1. Residencial");
            System.out.println("2. Comercial");
            System.out.print("Digite una opción (1-2): ");

            if (inputInm.hasNextInt()) {
                optionGarage = inputInm.nextInt();
                inputInm.nextLine(); // Limpiar el buffer

                switch (optionGarage) {
                    case 1: {
                        tipeGarage = "residencial";
                        break;
                    }
                    case 2: {
                        tipeGarage = "comercial";
                        break;
                    }
                    default: {
                        System.out.println("Opción incorrecta, vuelva a ingresar la opción.");
                        break;
                    }
                }
            } else {
                System.out.println("Error: entrada inválida. Por favor, ingrese un número entero.");
                inputInm.nextLine(); // Limpiar el buffer
            }
        } while (tipeGarage == null);

        System.out.println("Tipo de garaje seleccionado: " + tipeGarage);
	}
		
		@Override
		public void CompararMostrarData() {
			 System.out.println("LOS SDATOS DEL TERRENO SELECCIONADOS SON:");
		        boolean encontrado = false;
		        for (GrupoI_Casa casa : objetsArray) {
		            if (casa != null && casa.getLocationArea().equalsIgnoreCase(locationArea) &&
		                casa.getPrice() == price && casa.getSquareMeter() == squareMeter &&
		                casa.getTipePay().equalsIgnoreCase(tipePay) &&
		                casa.getPropertyLand().equalsIgnoreCase(propertyLand) &&
		                casa.getNumRoom() == numRoom &&
		                casa.getTipeGarage().equalsIgnoreCase(tipeGarage))
		             {
		                System.out.println(casa.toString()); // Mostrar todos los datos del objeto
		                encontrado = true;
		                break; // Detener la búsqueda después de encontrar un resultado
		            }
		        }
		        
		        if (!encontrado) {
		            System.out.println("No se encontraron inmuebles con las características especificadas.");
		        }
		}

	public int getNumRoom() {
		return numRoom;
	}

	public String getTipeGarage() {
		return tipeGarage;
	}	
	
}