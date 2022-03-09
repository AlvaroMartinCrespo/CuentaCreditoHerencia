package CuentaCredito;

import java.util.*;

public class Main {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

//		Variables
		int accionMenu, saldo, credito;
		String titular;
		CuentaCredito cuenta;
		boolean excepcion = true;

//		Creacion de cuenta

			try {

//				Datos

				saldo = saldo();
				credito = credito();
				titular = titular();

				cuenta = crearCuenta(saldo, titular, credito);

//				Menu

				do {

					mostrarMenu();
					accionMenu = accionMenu();
					tratarMenu(accionMenu, cuenta);

				} while (accionMenu != 4);

			} catch (CuentaException e) {

				System.out.println(e.getMessage());

			} catch (cuentaCreditoException e) {

				System.out.println(e.getMessage());

			}

	}

	public static CuentaCredito crearCuenta(int saldo, String titular, int credito)
			throws CuentaException, cuentaCreditoException {

		if (saldo == 0 && credito == 0) {

			CuentaCredito cuenta = new CuentaCredito(titular);
			return cuenta;

		} else if (saldo != 0 && credito == 0) {

			CuentaCredito cuenta = new CuentaCredito(titular, saldo);
			return cuenta;

		} else if (saldo == 0 && credito != 0) {

			CuentaCredito cuenta = new CuentaCredito(titular, credito);
			return cuenta;

		} else {

			CuentaCredito cuenta = new CuentaCredito(saldo, titular, credito);
			return cuenta;

		}

	}

	public static int saldo() {

//		Variables
		int saldo;

		System.out.println("Introduce el saldo de la cuenta");
		saldo = entrada.nextInt();

		return saldo;

	}

	public static int credito() {

//		Variables
		int credito;

		System.out.println("Introduce el credito de la cuenta");
		credito = entrada.nextInt();

		return credito;

	}

	public static String titular() {

//		Variables
		String titular;

		System.out.println("Introduce el nombre del titular de la cuenta");
		titular = entrada.next();

		return titular;

	}

	public static void mostrarMenu() {

		System.out.println();
		System.out.println(".:MENU:.");
		System.out.println("1.-Ingresar dinero \n2.-Sacar dinero \n3.-Mostrar saldo y credito \n4.-Salir");
		System.out.println();

	}

	public static int accionMenu() {

//		Variables
		int accion;

		System.out.println("Introduce lo que desea hacer:");
		accion = entrada.nextInt();

		return accion;

	}

	public static void tratarMenu(int accion, CuentaCredito cuenta) throws CuentaException {

//		variables
		double cantidad;

//		Eleccion

		switch (accion) {

		case 1:

			System.out.println("Introduce la cantidad a ingresar:");
			cantidad = entrada.nextDouble();
			cuenta.realizarIngreso(cantidad);

			break;

		case 2:

			System.out.println("Introduce la cantidad a retirar:");
			cantidad = entrada.nextDouble();
			cuenta.realizarReintegro(cantidad);
			break;

		case 3:

			System.out.println(cuenta.toString());
			break;

		case 4:
			System.out.println("Saliendo...");
			break;

		}

	}

}
