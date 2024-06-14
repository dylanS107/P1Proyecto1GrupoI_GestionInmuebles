package GrupoI_GestionInmuebles;

import java.util.*;
import java.io.*;

	public class GrupoI_Cliente {
		Scanner inputC = new Scanner(System.in);
		public String nombreApellido;
		public String ci;
		public String nacionalidad;
		public String estadoCivil;
		public String numeroCuenta;
		
		public GrupoI_Cliente () {
		}
		
		public GrupoI_Cliente (String nombreApellido, String ci, String nacionalidad, String estadoCivil,
				String numeroCuenta) {
			this.nombreApellido = nombreApellido;
			this.ci = ci;
			this.nacionalidad = nacionalidad;
			this.estadoCivil = estadoCivil;
			this.numeroCuenta = numeroCuenta;
		}
		
		public void DatosCliente() {
			System.out.println("PARA SEGUIR CON CON EL PROCESO INGRESE LOS DATOS QUE EL SISTEMA REQUIERE PARA IDENTIFICARLO");
			 // Nombre y Apellido 
	        System.out.print("Nombre y Apellido: ");
	        do {
	            nombreApellido = inputC.nextLine().trim();
	            if (!nombreApellido.matches("[a-zA-Z\\s]+") || nombreApellido.length() < 3) {
	                System.out.print("Error: Ingrese un nombre y apellido válidos (mínimo 3 caracteres): ");
	            }
	        } while (!nombreApellido.matches("[a-zA-Z\\s]+") || nombreApellido.length() < 3);

	        // Cédula de Identidad (CI) 
	        System.out.print("Cédula de Identidad (CI): ");
	        do {
	            ci = inputC.nextLine().trim();
	            if (!ci.matches("\\d{10}")) { // Suponiendo que la CI debe tener 10 dígitos
	                System.out.print("Error: Ingrese un número de cédula válido (10 dígitos): ");
	            }
	        } while (!ci.matches("\\d{10}"));

	        // Nacionalidad
	        System.out.print("Nacionalidad: ");
	        do {
	            nacionalidad = inputC.nextLine().trim();
	            if (!nacionalidad.matches("[a-zA-Z\\s]+") || nacionalidad.length() < 3) {
	                System.out.print("Error: Ingrese una nacionalidad válida (mínimo 3 caracteres): ");
	            }
	        } while (!nacionalidad.matches("[a-zA-Z\\s]+") || nacionalidad.length() < 3);

	        // Estado Civil
	        System.out.print("Estado Civil (soltero/casado): ");
	        do {
	            estadoCivil = inputC.nextLine().trim().toLowerCase();
	            if (!estadoCivil.equals("soltero") && !estadoCivil.equals("casado")) {
	                System.out.print("Error: Ingrese un estado civil válido (soltero/casado): ");
	            }
	        } while (!estadoCivil.equals("soltero") && !estadoCivil.equals("casado"));

	        // Número de Cuenta
	        System.out.print("Número de Cuenta: ");
	        do {
	            numeroCuenta = inputC.nextLine().trim();
	            if (!numeroCuenta.matches("\\d{10}")) { // Suponiendo que el número de cuenta debe tener 10 dígitos
	                System.out.print("Error: Ingrese un número de cuenta válido (10 dígitos): ");
	            }
	        } while (!numeroCuenta.matches("\\d{10}"));
	        
		}
		
		public String toStrin() {
			GenerarJSON();
			 return "Datos del Cliente:\n" +
		               "Nombre y Apellido: " + nombreApellido + "\n" +
		               "Cédula de Identidad (CI): " + ci + "\n" +
		               "Nacionalidad: " + nacionalidad + "\n" +
		               "Estado Civil: " + estadoCivil + "\n" +
		               "Número de Cuenta: " + numeroCuenta;
		}
		
		public void GenerarJSON() {
			try(BufferedWriter JSON = new BufferedWriter(new FileWriter("CLIENTE.Json"))){
				JSON.write("{\n");
	            JSON.write("  \"nombreApellido\": \"" + nombreApellido + "\",\n");
	            JSON.write("  \"ci\": \"" + ci + "\",\n");
	            JSON.write("  \"nacionalidad\": \"" + nacionalidad + "\",\n");
	            JSON.write("  \"estadoCivil\": \"" + estadoCivil + "\",\n");
	            JSON.write("  \"numeroCuenta\": \"" + numeroCuenta + "\"\n");
	            JSON.write("}");
	            JSON.flush();
				System.out.println("DATOS CLIENTE GENERADO EN BASE DE DATOS CORRECTAMENTE.");
			}catch(IOException e) {
				System.out.println("Archivo no guardado en base de datos. ");
			}
		}
	}
