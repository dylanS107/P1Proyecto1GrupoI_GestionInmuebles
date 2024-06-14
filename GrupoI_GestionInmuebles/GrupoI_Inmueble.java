package GrupoI_GestionInmuebles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class GrupoI_Inmueble {
	Scanner inputInm = new Scanner(System.in);
	GrupoI_Inmueble objetsArray[];
	//ArrayList<GrupoI_Inmueble> listInm = new ArrayList<>();
	protected String address; //Ubicacion del inmueble 
	protected String locationArea;  //Variable del tipo de zona (rural/urbano)
	protected double price; //Precio del inmuelbe
	protected int squareMeter; //Metros cuadrados
	protected String tipePay; //Tipo de pago credito o al contado
    protected int timePayments; //Por meses
    protected String propertyLand; //Esta variable referencia el tipo de terreno (Urbano, urbanizable, rústico).
    protected double PayEstimatedTim; //VALOR DEL PAGO FINAL MENSUAL
    

    
 // Constructor con parámetros para inicializar los atributos.
	public GrupoI_Inmueble( String locationArea, String address, double price, int squareMeter, String tipePay, int timePayments,
			String propertyLand, double PayEstimatedTim) {
		this.address = address;
		this.locationArea = locationArea;
		this.price = price;
		this.squareMeter = squareMeter;
		this.tipePay = tipePay;
		this.timePayments = timePayments;
		this.propertyLand = propertyLand;
		this.PayEstimatedTim =PayEstimatedTim;
	}

	
	public String toString() { //Retorna todos los valores ingresados o seleccionados.
		return "direccion(CIUDAD) "+address+"\n"+
				"Zona (Rural/Urbana: "+locationArea+"\n"+
				"Precio de disponibilidad: "+price+"\n"+
				"Metros cuadrados: "+squareMeter+"\n"+
				"Tipo de pago necesario(Contado/Crédito): "+tipePay+"\n"+
				"Tiempo de pago: "+timePayments+"\n"+
				"Terreno de la propiedad: "+propertyLand+"\n";
	}

	// Método para calcular el precio de una propiedad pagada a crédito.
	public double CalculatorPriceCredito() { //Si el pago corresponde a un tipo de crédito, se añadirá el método.
		double impuesto = 0.12;
        return (price / timePayments) + (price * impuesto);
	}
	
	// Método para calcular el precio de una propiedad pagada al contado.
	public double CalculatorPriceContado() { //Si el pago corresponde a un pago directo, se le añade un descuento
		double descuento = 0.12; // Descuento por pago al contado
        return price - (price * descuento);
	}

	
	 // Método para inicializar datos de inmuebles estáticos.
	public void ObjetStaticInmuebles() {
		int numeroInmuebles = 10;
		 objetsArray = new GrupoI_Inmueble[numeroInmuebles];
		 objetsArray[0] = new GrupoI_Inmueble("urbano", "quito norte", 150580, 12, "contado", 0, "urbanizable", 0);
		 objetsArray[1] = new GrupoI_Inmueble("rural", "riobamba", 200000, 150, "credito", 36, "rustico, 0", 0);
		 objetsArray[2] = new GrupoI_Inmueble("urbano", "santo domingo", 15000, 11, "contado", 24, "urbanizable", 0);
		 objetsArray[3] = new GrupoI_Inmueble("rural", "machala", 50000, 85, "contado", 26, "urbanizable", 0);
		 objetsArray[4] = new GrupoI_Inmueble("rural", "paztasa", 250000, 130, "credito", 36, "urbanizable", 0);
		 objetsArray[5] = new GrupoI_Inmueble("urbano", "guayaquil", 28000, 16, "credito", 12, "urbanizable", 0);
		 objetsArray[6] = new GrupoI_Inmueble("urbano", "loja", 1099, 8, "contado", 0, "urbanizable", 0);
		 objetsArray[7] = new GrupoI_Inmueble("urbano", "manabi", 150000, 15, "credito", 24, "urbanizable", 0);
		 objetsArray[8] = new GrupoI_Inmueble("rural", "esmeraldas", 10000, 20, "contado", 0, "rustico", 0);
		 objetsArray[9] = new GrupoI_Inmueble("rural", "latacunga", 25000, 13, "credito", 12, "rustico", 0);
		 
		 for (int i = 0; i < (objetsArray.length);i++) {
			 System.out.println("DATOS DEL INMUEBLE "+(i+1)+": ");
			 System.out.println(objetsArray[i].toString());
			 System.out.println("______________________________________");
		 }
	}
	
	// Método para ingresar y buscar datos de propiedades.
	public void IngresarDatosBuscar() {
		int opcionAddress;
		int opcionPay;
		int opcionPropertLand;
		 locationArea = null; // Inicialización para evitar null en el do-while
	     propertyLand = null; 
	     tipePay = null;
	     
		System.out.println("________________________________________________");
		System.out.println("");
		System.out.println("BIENVENID@ A LA GESTION DE COMPRAS DE INMUELBES");
		System.out.println("EN ESTE APARTADO SE MOSTRARÁN UNA SERIE DE INMUEBLES. \n"+
		"SEGUN EL QUE MAS SE ACERQUE A SU PREFERENCIA, INDIQUE EN EL INGRESO DE VALORES TAL CUAL LOS DATOS MOSTRADOS");
		
		ObjetStaticInmuebles();

		
		System.out.println("________________________________________________");
		System.out.println("");
		System.out.println("A continuacion, ingresara la preferencia del inmueble de su agrado. ");
		System.out.println("Ingrese las caracteristicas: ");
		System.out.print("Ubicacion del inmuelbe(CIUDAD): ");
		address = inputInm.nextLine().toLowerCase();
		do {	//	MENU DEL TIPO DE ZONA
		 System.out.println("Seleccione tipo de zona preferible: ");
         System.out.println("1. RURAL");
         System.out.println("2. URBANA");
         System.out.print("Opción: ");
         opcionAddress = inputInm.nextInt();
         inputInm.nextLine(); // Limpiar archivos basura
         
         switch(opcionAddress) {
             case 1:
                 locationArea = "rural";
                 break;
             case 2:
                 locationArea = "urbano";
                 break;
             default:
                 System.out.print("Opción no válida, por favor intente nuevamente: ");
                 break;
         }
     } while(locationArea == null);
		
		System.out.print("Ingrese el precio de su preferencia: "+
		"\nLos precios rondan entre (10 000 - 300 000 dólares): ");
		price = inputInm.nextDouble();
		while(price < 10000.0 || price > 300000) {
			System.out.print("Precio no disponible, vuelva a ingresar el precio: ");
			price = inputInm.nextDouble();
		}
		
		System.out.print("Metros cuadrados (8-150 metros): ");
		squareMeter = inputInm.nextInt();
		inputInm.nextLine();
		while (squareMeter < 8 || squareMeter > 150) {
		    System.out.println("Error: los metros cuadrados deben estar entre 8 y 150.");
		    System.out.print("Ingrese nuevamente los metros cuadrados: ");
		    squareMeter = inputInm.nextInt();
		}
		do {	//MENU DEL TIPO DE CREDITO
			System.out.println("Seleccione tipo de pago de preferencia. ");
			System.out.println("1. Credito. ");
			System.out.println("2. Contado. ");
			opcionPay = inputInm.nextInt();
			inputInm.nextLine();
			switch(opcionPay) {
			case 1: {
				 tipePay = "credito";
                 System.out.print("Ingrese el tiempo de pago en meses: ");
                 timePayments = inputInm.nextInt();
                 while(timePayments < 12|| timePayments > 48) {
                	 System.out.println("Error, ingrese nuevamente el tiempo de pago(DE 12 A 48 MESES)");
                	 timePayments = inputInm.nextInt();
                 }
                 inputInm.nextLine();
                 PayEstimatedTim = CalculatorPriceCredito();
				break;
			}
			case 2: {
				tipePay = "contado";
                timePayments = 0; // No el aplica tiempo de pago.
                PayEstimatedTim = CalculatorPriceContado();
				break;
			}
			default: {
				System.out.print("Opción no válida, por favor intente nuevamente: ");
				break;
			}
			}
			
		}while(tipePay == null);
		
		
		do {	//MENU DEL TIPO DE TERRENO Y SU UBICACION
			System.out.println("___________________________________________________________________");
			System.out.println("Seleccione el tipo de terreno que desea (Urbanizable, rustico): ");
			System.out.println("1. Urbanizable. ");
			System.out.println("\tDescripcion: Area con potencial de desarrollo urbano futuro.");
			
			System.out.println("2. Rustico. ");
			System.out.println("\tDescripcion: Area destinada a actividades agrícolas o naturales.");
			System.out.println("___________________________________________________________________");
			 System.out.print("Opción: ");
			opcionPropertLand = inputInm.nextInt();
			inputInm.nextLine();
			switch(opcionPropertLand) {
			case 1: {
				propertyLand = "urbanizable";
				break;
				
			}
			case 2: {
				propertyLand = "rustico";
				break;
				
			}
			default: {
				System.out.print("Opcion no existente, vuelva a intentar: ");
				break;
				
			}
			}
		}while(propertyLand == null);
		System.out.println("\tGracias por ingresar datos, buscando propiedades con respecto a su preferencia...");
		
	}
	
	public void CompararMostrarData() {
		 System.out.println("LOS DATOS DEL TERRENO SELECCIONADOS SON:");
	        boolean encontrado = false;
	        for (GrupoI_Inmueble inmueble : objetsArray) {
	            if (inmueble != null && inmueble.getLocationArea().equalsIgnoreCase(locationArea) &&
	                inmueble.getPrice() == price && inmueble.getSquareMeter() == squareMeter &&
	                inmueble.getTipePay().equalsIgnoreCase(tipePay) &&
	                inmueble.getPropertyLand().equalsIgnoreCase(propertyLand)) {
	                System.out.println(inmueble.toString()); // Mostrar todos los datos del objeto
	                encontrado = true;
	                break; // Detener la búsqueda después de encontrar un resultado
	            }
	        }
	        
	        if (!encontrado) {
	            System.out.println("No se encontraron inmuebles con las características especificadas.");
	        }
	}
	
	public void HacerCompra() {
		char optionCompra;
		do {
			System.out.println("¿DESEA REALIZAR SU COMPRA?\nINGRESE(S/N):");
			optionCompra = inputInm.next().toLowerCase().charAt(0);
			switch(optionCompra) {
			case 's': {
				System.out.println(toGenerarFactura());
				toGenerateCSV();
				break;
			}
			case 'n': {
				System.out.println("GRACIAS POR PREFERIRNOS.");
				System.out.println("Saliendo del programa...");
				break;
			}
			default: {
				System.out.println("Error. vuelva intentar: ");
				break;
			}
			}
			
		}while(optionCompra != 's' && optionCompra != 'n');
	}
	
	public String toGenerarFactura() {
		return "*****_____FACTURA FINAL DE SU COMPRA_____***** \n"+"direccion "+address+"\n"+
				"Zona (Rural/Urbana: "+locationArea+"\n"+
				"Precio de pago: "+price+"\n"+
				"Metros cuadrados del inmueble: "+squareMeter+"\n"+
				"Tipo de pago: "+tipePay+"\n"+
				"Tiempo estimado del pago: "+timePayments+"\n"+
				"Terreno de la propiedad: "+propertyLand+"\n"+
				"Mensualidad estimada a pagar: "+PayEstimatedTim+"\n";
	}
	
	public void toGenerateCSV() {
		try(BufferedWriter CSV = new BufferedWriter(new FileWriter("Archivo.csv"))){
			CSV.append(toGenerarFactura());
			CSV.flush();
			CSV.close();
			System.out.println("FRACTURA GENERADA EN BASE DE DATOS CORRECTAMENTE.");
		}catch(IOException e) {
			System.out.println("Archivo no guardado en base de datos. ");
		}
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getLocationArea() {
		return locationArea;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getSquareMeter() {
		return squareMeter;
	}
	
	public String getTipePay() {
		return tipePay;
	}
	
	public int getTimePayments() {
		return timePayments;
	}
	
	public String getPropertyLand() {
		return propertyLand;
	}

	
}
