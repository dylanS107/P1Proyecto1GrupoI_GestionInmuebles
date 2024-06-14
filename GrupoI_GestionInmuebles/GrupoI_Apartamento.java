package GrupoI_GestionInmuebles;

import java.util.*;

public class GrupoI_Apartamento extends GrupoI_Inmueble{
	Scanner inputInm = new Scanner(System.in); 
	GrupoI_Apartamento objetsArray[];
	private int numBalconies;
	private String tipeWindow;
	public GrupoI_Apartamento(String locationArea, String address, double price, int squareMeter, String tipePay, int timePayments,
			String propertyLand, int numBalconies, String tipeWindow,double PayEstimatedTim) {
		super(locationArea, address, price, squareMeter, tipePay, timePayments, propertyLand,PayEstimatedTim);
		this.numBalconies = numBalconies;
		this.tipeWindow = tipeWindow;
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
				"Tipo de ventana: "+tipeWindow+"\n"+
				"Numero de balcones: "+numBalconies+"\n";
	}

	
	@Override
	 public void ObjetStaticInmuebles() {
        int numeroInmuebles = 10;
        objetsArray = new GrupoI_Apartamento[numeroInmuebles];
        objetsArray[0] = new GrupoI_Apartamento("urbano", "ibarra", 150580, 12, "contado", 0, "urbanizable", 3, "doble", 0);
        objetsArray[1] = new GrupoI_Apartamento("rural", "loja", 200000, 150, "credito", 36, "rustico", 4, "simple", 0);
        objetsArray[2] = new GrupoI_Apartamento("urbano", "milagro", 15000, 11, "contado", 0, "urbanizable", 2, "doble", 0);
        objetsArray[3] = new GrupoI_Apartamento("rural", "santo domingo", 50000, 85, "contado", 0, "urbanizable", 5, "simple", 0);
        objetsArray[4] = new GrupoI_Apartamento("rural", "cuenca", 250000, 130, "credito", 36, "urbanizable", 6, "doble", 0);
        objetsArray[5] = new GrupoI_Apartamento("urbano", "esmeraldas", 28000, 16, "credito", 12, "urbanizable", 3, "simple", 0);
        objetsArray[6] = new GrupoI_Apartamento("urbano", "portoviejo", 1099, 8, "contado", 0, "urbanizable", 1, "simple", 0);
        objetsArray[7] = new GrupoI_Apartamento("urbano", "ambato", 150000, 15, "credito", 24, "urbanizable", 4, "doble", 0);
        objetsArray[8] = new GrupoI_Apartamento("rural", "tulcan", 10000, 20, "contado", 0, "rustico", 2, "simple", 0);
        objetsArray[9] = new GrupoI_Apartamento("rural", "santa elena", 25000, 13, "credito", 12, "rustico", 3, "doble", 0);

        for (int i = 0; i < objetsArray.length; i++) {
            System.out.println("DATOS DEL INMUEBLE " + (i + 1) + ": ");
            System.out.println(objetsArray[i].toString());
            System.out.println("");
        }
    }

	
	public void IngresarDatosAdi() {
		int optionWind;
		System.out.println("Ingrese el número de balcones preferible para su apartamento: ");
		int numBalconies;
		while (true) {
		    try {
		        numBalconies = Integer.parseInt(inputInm.nextLine());
		        if (numBalconies < 1 || numBalconies > 6) {
		            System.out.print("Número de balcones no disponible, ingrese un valor entre 1 y 6: ");
		            continue;
		        }
		        break; // Salir del bucle si la entrada es válida
		    } catch (NumberFormatException e) {
		        System.out.print("Error: Por favor, ingrese un número válido: ");
		    }
		}
		do {
		    System.out.println("SELECCIONE EL TIPO DE GARAJE DE SU INTERES:");
		    System.out.println("1. Simple");
		    System.out.println("2. Doble");
		    System.out.print("Digite una opción (1-2): ");
		    while (!inputInm.hasNextInt()) {
		        System.out.print("Error: Por favor, ingrese un número válido (1 o 2): ");
		        inputInm.next(); // Limpiar la entrada inválida
		    }
		    optionWind = inputInm.nextInt();
		    inputInm.nextLine(); // Limpiar el buffer
		    if (optionWind < 1 || optionWind > 2) {
		        System.out.println("Opción incorrecta, por favor ingrese 1 para Simple o 2 para Doble.");
		    }
		} while (optionWind < 1 || optionWind > 2);
	}

	
	@Override
	public void CompararMostrarData() {
		 System.out.println("LOS DATOS DEL TERRENO SELECCIONADOS SON:");
	        boolean encontrado = false;
	        for (GrupoI_Apartamento apartamento : objetsArray) {
	            if (apartamento != null && apartamento.getLocationArea().equalsIgnoreCase(locationArea) &&
	                apartamento.getPrice() == price && apartamento.getSquareMeter() == squareMeter &&
	                apartamento.getTipePay().equalsIgnoreCase(tipePay) &&
	                apartamento.getPropertyLand().equalsIgnoreCase(propertyLand) &&
	                apartamento.getNumBalconies() == numBalconies &&
	                apartamento.getTipeWindow().equalsIgnoreCase(tipeWindow)) {
	                System.out.println(apartamento.toString()); // Mostrar todos los datos del objeto
	                encontrado = true;
	                break; // Detener la búsqueda después de encontrar un resultado
	            }
	        }

		
	        if (!encontrado) {
	            System.out.println("No se encontraron inmuebles con las características especificadas.");
	        }
	}

	public int getNumBalconies() {
		return numBalconies;
	}

	public String getTipeWindow() {
		return tipeWindow;
	}

}
