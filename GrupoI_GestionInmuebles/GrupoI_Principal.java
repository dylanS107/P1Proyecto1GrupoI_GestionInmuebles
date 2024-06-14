package GrupoI_GestionInmuebles;

import java.util.*;

public class GrupoI_Principal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcion;
		GrupoI_Casa gestionCasa = new GrupoI_Casa("", "", 0, 0,"", 0, "", 0, "", 0);
		GrupoI_Terreno gestionTerreno = new GrupoI_Terreno("","",0,0,"",0,"",0,"",0,0,0,0);
		GrupoI_Apartamento gestionApartamento = new GrupoI_Apartamento("","",0,0,"",0,"",0,"",0);
		GrupoI_Cliente cliente = new GrupoI_Cliente("","","","","");
		do {
			System.out.println("SISTEMA DE COMPRA DE INMUEBLES DISPONEMOS DE: (TERRENOS-CASAS-APARTAMENOS.) \n"+
		"TODO CON UN PRECIO .");
			System.out.println("SELECCIONE SU INMUELBE DESEADO. ");
			System.out.println("1. CASA");
			System.out.println("2. TERRENO");
			System.out.println("3. APARTAMENTO. ");
			System.out.println("4. Salir. ");
			opcion = input.nextInt();
			input.nextLine();
			switch(opcion) {
			case 1: {
				gestionCasa.IngresarDatosBuscar();
				gestionCasa.inputDatosCasa();
				gestionCasa.CompararMostrarData();
				gestionCasa.HacerCompra();
				gestionCasa.toGenerarFactura();
				cliente.DatosCliente();
				cliente.toStrin();
				break;
			}
			case 2: {
			        gestionTerreno.IngresarDatosBuscar();
			        gestionTerreno.IngresarTipoTopografia();
			        gestionTerreno.CompararMostrarData();
			        gestionTerreno.NegociarPago();
			        gestionTerreno.HacerCompra();
			        gestionTerreno.toGenerarFactura();
			        cliente.DatosCliente();
					cliente.toStrin();
				break;
			}
			case 3: {
					gestionApartamento.IngresarDatosBuscar();
					gestionApartamento.IngresarDatosAdi();
					gestionApartamento.CompararMostrarData();
					gestionApartamento.HacerCompra();
					gestionApartamento.toGenerarFactura();
					cliente.DatosCliente();
					cliente.toStrin();
				break;
			}
			case 4: {
				System.out.println("Saliendo...");
				break;
			}
			default: {
				System.out.print("Error, vuelva a intentar: ");
				break;
			}
			}
			
		}while(opcion != 3);
        
        
       
	}

}
