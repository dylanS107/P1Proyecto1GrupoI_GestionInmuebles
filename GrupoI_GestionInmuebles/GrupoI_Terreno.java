package GrupoI_GestionInmuebles;

import java.util.*;

public class GrupoI_Terreno extends GrupoI_Inmueble{
	Scanner inputInm = new Scanner(System.in);
	GrupoI_Terreno objetsArray[];
	private String topografia;
	//VARIABLES NUEVAS POR SI EL CLIENTE DESEA NEGOCIAR CON EL SISTEMA
	private int newTimePayments; 
	private double newPayEstimade;
	private double newAmount;
	private int newTime;

	public GrupoI_Terreno(String address,String locationArea, double price, int squareMeter, String tipePay, int timePayments,
			String propertyLand, double PayEstimatedTim, String topografia,int newTimePayments, double newPayEstimade, 
			double newAmount, int newTime) {
		super(locationArea, address, price, squareMeter, tipePay, timePayments, propertyLand, PayEstimatedTim);
		this.topografia = topografia;
		this.newTimePayments = newTimePayments;
		this.newPayEstimade = newPayEstimade;
		this.newAmount = newAmount;
		this.newTime = newTime;
	}
	
	@Override
	public String toString() { //Retorna todos los valores ingresados o seleccionados.
		return "direccion(CIUDAD) "+getAddress()+"\n"+
				"Zona (Rural/Urbana: "+getLocationArea()+"\n"+
				"Precio de disponibilidad: "+getPrice()+"\n"+
				"Metros cuadrados: "+getSquareMeter()+"\n"+
				"Tipo de pago necesario(Contado/Crédito): "+getTipePay()+"\n"+
				"Tiempo de pago: "+getTimePayments()+"\n"+
				"Terreno de la propiedad: "+getPropertyLand()+"\n"+
				"Topografía o estado del terreno: "+topografia+"\n";
	}

	@Override
	public void ObjetStaticInmuebles() {
		int numeroInmuebles = 10;
		 objetsArray = new GrupoI_Terreno[numeroInmuebles];
		 objetsArray[0] = new GrupoI_Terreno("azuay", "rural", 5000.0, 10,"contado", 12,"rustico" , 0.0, "montanioso",0, 0, 0, 0);
		 objetsArray[1] = new GrupoI_Terreno("Loja", "urbano", 50000.0, 30, "credito", 16, "urbanizable", 0.0, "plano", 0, 0, 0, 0);
		 objetsArray[2] = new GrupoI_Terreno("galapagos", "rural", 80000.0, 10, "credito", 12, "comercial", 0.0, "plano", 0, 0, 0, 0);
		 objetsArray[3] = new GrupoI_Terreno("napo", "rural", 2500.0, 7, "contado", 0, "industrial", 0.0, "ondulado", 0, 0, 0, 0);
		 objetsArray[4] = new GrupoI_Terreno("pichincha", "rural", 15000.0, 15, "credito", 24, "rustico", 0.0, "plano", 0, 0, 0, 0);
		 objetsArray[5] = new GrupoI_Terreno("santa elena", "urbano", 10000.0, 12, "credito", 24, "comercial", 0.0, "plano", 0 ,0 , 0, 0);
		 objetsArray[6] = new GrupoI_Terreno("guayas", "urbano", 18000.99, 9, "credito", 26, "comercial", 0.0, "plano", 0, 0, 0, 0);
		 objetsArray[7] = new GrupoI_Terreno("tunguragua", "rural", 5000.0, 10, "contado", 0, "rustico", 0.0, "montanioso", 0, 0, 0, 0);
		 objetsArray[8] = new GrupoI_Terreno("cotopaxi", "rural", 3900.99, 8, "contado", 0, "industrial", 0.0, "ondulado", 0, 0, 0, 0);
		 objetsArray[9] = new GrupoI_Terreno("manabi", "urbano", 150000.84, 20, "credito", 60, "comercial", 0.0, "plano", 0, 0, 0, 0);
		 
		 for (int i = 0; i < (objetsArray.length);i++) {
			 System.out.println("DATOS DEL TERRENO "+(i+1)+": ");
			 System.out.println(objetsArray[i].toString());
			 System.out.println("");
		 }
	}
	@Override
	public void IngresarDatosBuscar() {
		int opcionAddress;
		int opcionPay;
		int opcionPropertLand;
		 locationArea = null; // Inicialización para evitar null en el do-while
	     propertyLand = null; 
	     tipePay = null;
		
		System.out.println("");
		System.out.println("");
		System.out.println("BIENVENID@ A LA GESTION DE COMPRAS DE TERRENOS");
		System.out.println("EN ESTE APARTADO SE MOSTRARÁN UNA SERIE DE TERRENOS. \n"+
		"SEGUN EL QUE MAS SE ACERQUE A SU PREFERENCIA, INDIQUE EN EL INGRESO DE VALORES TAL CUAL LOS DATOS MOSTRADOS");
		ObjetStaticInmuebles();
		System.out.println("");
		System.out.println("");
		System.out.println("A continuacion, ingresara la preferencia del terreno de su agrado. ");
		System.out.println("Ingrese las caracteristicas: ");
		System.out.print("Ubicacion del terreno(CIUDAD): ");
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
		
		do {
            System.out.print("Ingrese el precio de su preferencia: \nLos precios rondan entre (2,500 - 150,002 dólares): ");
            
            // Verificar si la entrada es un número válido
            while (!inputInm.hasNextDouble()) {
                System.out.println("Error: entrada inválida. Por favor, ingrese un número válido.");
                inputInm.next(); // Limpiar la entrada inválida
            }
            
            price = inputInm.nextDouble();

            // Verificar si el precio está dentro del rango válido
            if (price < 2500 || price > 150002) {
                System.out.println("Precio no disponible, vuelva a ingresar el precio.");
            }
            
        } while (price < 2500 || price > 150002);

        System.out.println("El precio ingresado es: " + price);
		
        do {
            System.out.print("Metros cuadrados (7-20 metros): ");
            // Verificar si la entrada es un número válido
            while (!inputInm.hasNextInt()) {
                System.out.println("Error: entrada inválida. Por favor, ingrese un número válido.");
                inputInm.next(); // Limpiar la entrada inválida
            }
            
            squareMeter = inputInm.nextInt();
            inputInm.nextLine(); // Limpiar el buffer

            // Verificar si los metros cuadrados están dentro del rango válido
            if (squareMeter < 7 || squareMeter > 20) {
                System.out.println("Error: los metros cuadrados deben estar entre 7 y 20.");
            } 
        } while (squareMeter < 7 || squareMeter > 20);

        System.out.println("Los metros cuadrados ingresados son: " + squareMeter);
        
        do {
            System.out.println("Seleccione tipo de pago de preferencia:");
            System.out.println("1. Crédito");
            System.out.println("2. Contado");
            System.out.print("Opción: ");

            // Verificar si la entrada es un número válido
            while (!inputInm.hasNextInt()) {
                System.out.println("Error: entrada inválida. Por favor, ingrese un número válido.");
                inputInm.next(); // Limpiar la entrada inválida
            }

            opcionPay = inputInm.nextInt();
            inputInm.nextLine(); // Limpiar el buffer

            switch(opcionPay) {
                case 1: {
                    tipePay = "credito";
                    System.out.print("Ingrese el tiempo de pago en meses: ");

                    // Verificar si la entrada es un número válido para el tiempo de pago
                    while (!inputInm.hasNextInt()) {
                        System.out.println("Error: entrada inválida. Por favor, ingrese un número válido.");
                        inputInm.next(); // Limpiar la entrada inválida
                    }

                    timePayments = inputInm.nextInt();

                    // Verificar si el tiempo de pago está dentro del rango válido
                    while (timePayments < 12 || timePayments > 60) {
                        System.out.println("Error: ingrese nuevamente el tiempo de pago (de 12 a 60 meses).");
                        timePayments = inputInm.nextInt();
                    }
                    
                    inputInm.nextLine();
                    // Aquí iría el cálculo del precio estimado para el crédito
                    // PayEstimatedTim = CalculatorPriceCredito();
                    break;
                }
                case 2: {
                    tipePay = "contado";
                    timePayments = 0; // No aplica tiempo de pago para la opción de contado
                    // Aquí iría el cálculo del precio estimado para el pago al contado
                    // PayEstimatedTim = CalculatorPriceContado();
                    break;
                }
                default: {
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
                }
            }
        } while (tipePay == null);
		
		
        do {
            System.out.println("Seleccione el tipo de terreno que desea:");
            System.out.println("1. Urbanizable");
            System.out.println("\tDescripción: Área con desarrollo urbano existente o planeado.");
            System.out.println("2. Rústico");
            System.out.println("\tDescripción: Área destinada a actividades agrícolas o naturales.");
            System.out.println("3. Industrial");
            System.out.println("\tDescripción: Área destinada a actividades industriales y de manufactura.");
            System.out.println("4. Comercial");
            System.out.println("\tDescripción: Área destinada a actividades comerciales y de servicios.");
            System.out.print("Opción: ");

            // Verificar si la entrada es un número válido
            while (!inputInm.hasNextInt()) {
                System.out.println("Error: entrada inválida. Por favor, ingrese un número válido.");
                inputInm.next(); // Limpiar la entrada inválida
            }

            opcionPropertLand = inputInm.nextInt();
            inputInm.nextLine(); // Limpiar el buffer

            switch (opcionPropertLand) {
                case 1: {
                    propertyLand = "urbanizable";
                    break;
                }
                case 2: {
                    propertyLand = "rustico";
                    break;
                }
                case 3: {
                    propertyLand = "industrial";
                    break;
                }
                case 4: {
                    propertyLand = "comercial";
                    break;
                }
                default: {
                    System.out.println("Opción no existente, vuelva a intentar.");
                    break;
                }
            }
        } while (propertyLand == null);
		
		System.out.println("\tGracias por ingresar datos, buscando propiedades con respecto a su preferencia...");
		
	}
	
	public String IngresarTipoTopografia() {
	    int opcionTopografia;
	    do {
	        System.out.println("MENU DE SELECCION PARA EL ESTADO DEL TERRENO O TOPOGRAFIA:");
	        System.out.println("1. PLANO");
	        System.out.println("2. ONDULADO");
	        System.out.println("3. MONTAÑOSO");
	        System.out.print("Opción: ");

	        // Verificar si la entrada es un número válido
	        while (!inputInm.hasNextInt()) {
	            System.out.println("Error: entrada inválida. Por favor, ingrese un número válido.");
	            inputInm.next(); // Limpiar la entrada inválida
	        }

	        opcionTopografia = inputInm.nextInt();
	        inputInm.nextLine(); // Limpiar el buffer

	        if (opcionTopografia < 1 || opcionTopografia > 3) {
	            System.out.println("Error: opción no válida. Por favor, ingrese un número válido (1-3).");
	        }

	        switch (opcionTopografia) {
	            case 1: {
	                topografia = "plano";
	                break;
	            }
	            case 2: {
	                topografia = "ondulado";
	                break;
	            }
	            case 3: {
	                topografia = "montañoso";
	                break;
	            }
	        }
	    } while (topografia == null);
	    return topografia;
	}

	
	@Override
	public void CompararMostrarData() {
		 System.out.println("LOS DATOS DEL TERRENO SELECCIONADOS SON:");
	        boolean encontrado = false;
	        for (GrupoI_Terreno terreno : objetsArray) {
	            if (terreno != null && terreno.getLocationArea().equalsIgnoreCase(locationArea) &&
	            	terreno.getPrice() == price && terreno.getSquareMeter() == squareMeter &&
	            	terreno.getTipePay().equalsIgnoreCase(tipePay) &&
	            	terreno.getPropertyLand().equalsIgnoreCase(propertyLand)) {
	                System.out.println(terreno.toString()); // Mostrar todos los datos del objeto
	                encontrado = true;
	                break; // Detener la búsqueda después de encontrar un resultado
	            }
	        }
	        
	        if (!encontrado) {
	            System.out.println("No se encontraron inmuebles con las características especificadas.");
	        }
	}
	
	public void NegociarPago() {
		char eleptionPay;
		int eleptionTypePay;
		
		do {
		System.out.println("EL SISTEMA BRINDA LA FACILIDAD DE QUE EL PAGO SEA ACCESIBLE PARA SUS BOLSILLOS. ");
		System.out.println("¿DESEA CAMBIAR EL TIEMPO DE SU PAGO Y LAS CUOTAS?");
		System.out.println("Ingrese: \n'S' para elegir si. \n'N' para elegir no. \n'Z' Para cancelar.");
		eleptionPay = inputInm.next().toLowerCase().charAt(0);
		switch(eleptionPay) {
		case 's': {
			System.out.println("Dependiendo del precio el sistema puede brindarle en un rango de tiempo determinado para su pago \n"+
		"automaticamente segun la eleccion de si desea ingresar el tiempo de pago o la cuota mensual que mas se adapte \n"+
					" a su bolsillo el programa le hara la propuesta del saldo mensual, y el tiempo.");
			do {
				System.out.println("1. Ajustar meses de pago. ");
				System.out.println("2. Ajustar precio mensual de pago. ");
				System.out.println("3. Salir. ");
				System.out.print("Ingrese su eleccion: ");
				eleptionTypePay = inputInm.nextInt();
				inputInm.nextLine();
				switch(eleptionTypePay) {
				case 1: {
					System.out.println("Ingrese tiempo propuesto de pagos mensuales: ");
					newTimePayments = inputInm.nextInt();
					while(newTimePayments < 10 || newTimePayments > 120) {
						System.out.print("El programa cuenta con un limite de meses para poder pagar, "+
					"usted no puede pagar en menos de 10 meses o mas de 120 meses. \n"+
								"Por favor vuelva a ingresar el tiempo de pago: ");
						newTimePayments = inputInm.nextInt();
					}
					newAmount = getPrice()/newTimePayments;
					System.out.println(toGenerarNuevaFactura());
					break;
				}
				case 2: {
					System.out.println("Ingrese la propuesta del pago mensual: ");
					newPayEstimade = inputInm.nextDouble();
					while(newPayEstimade < 150 || newPayEstimade > getPrice()) {
						System.out.println("El programa cuenta con un limite de pago, el cliente no puede pagar menos de "+
					"150 dolares mensuales o mas del precio adquirible. ");
						newPayEstimade = inputInm.nextDouble();
					}
					newTime = (int) (getPrice()/newPayEstimade);
					System.out.println(toGenerarNuevaFactura());
					break;
				}
				case 3: {
					
					break;
				}
				default: {
					System.out.println("");
					break;
				}
				}
				
			}while(eleptionTypePay != 3);
			
			break;
		}
		case 'n': {
			System.out.println("¡Gracias por preferirnos!");
			System.out.println("Redirigiendose a otro apartado. ");
			break;
		}
		case 'z': {
			System.out.println("Cancelado con exito.");
			System.out.println("Redirigiendose a otro apartado...");
			break;
		}
		default: {
			System.out.println("OPCION NO EXISTENTE, INTENTE INGRESAR NUEVAMENTE: ");
			break;
		}
		}
		
		}while(eleptionPay != 's' ||  eleptionPay != 'n');
	}
	
	public String toGenerarNuevaFactura() {  //GENERA NUEVA FACTURA CON RESPECTO A LOS NUEVOS PAGOS NEGOCIADOS
		return "FACTURA DE SU COMPRA____**** \n"+"direccion "+address+"\n"+
				"Zona : "+locationArea+"\n"+
				"Precio de pago: "+price+"\n"+
				"Metros cuadrados del inmueble: "+squareMeter+"\n"+
				"Tipo de pago: "+tipePay+"\n"+
				"Tiempo estimado del pago anterior: "+timePayments+"\n"+
				"Terreno de la propiedad: "+propertyLand+"\n"+
				"Mensualidad anterior estimada a pagar: "+PayEstimatedTim+"\n"+
				"\n"+
				"Nuevo pago mensual negociado: "+newAmount+"\n"+
				"Pago mensual negociado: "+newTime+".\n";
	}
	
}