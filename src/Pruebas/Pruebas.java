package Pruebas;

import org.junit.jupiter.api.Test;

import Modelo.Logica;

public class Pruebas {

	private Logica logica;

	/**
	 * Permite convertir un numero decimal a binario
	 */
	@Test
	public void convertirDecimalABinario() {

		String decimal = "0";

		logica = new Logica(decimal);

		String binario = logica.convertirDecimalABinario(decimal);

		System.out.println(binario);
	}

	/**
	 * Test para calcular la direccion IP en binario
	 */
	@Test
	public void calcularIPBinario() {
		String ip = "173.34.64.0";

		logica = new Logica(ip);

		String ipBinario = logica.calcularIPBinario(ip);

		System.out.println(ipBinario);
	}

	/**
	 * Test para realizar la operacion AND entre dos numeros binarios
	 */
	@Test
	public void andBinario() {
		String n1 = "11000000";
		String n2 = "11111111";

		logica = new Logica(n1, n2);

		String and = logica.andBinario(n1, n2);

		System.out.println(and);
	}

	/**
	 * Test para convertir un numero decimal a hexadecimal
	 */
	@Test
	public void decimalAHexadecimal() {
		String decimal = "184";

		logica = new Logica(decimal);

		String hexadecimal = logica.decimalAHexadecimal(decimal);

		System.out.println(hexadecimal);
	}

	/**
	 * Test para convertir la mascara de decimal a binario
	 */
	@Test
	public void convertirMascaraBinario() {
		String mascara = "/19";

		logica = new Logica(mascara);

		String mascaraBinario = logica.convertirMascaraBinario(mascara);

		System.out.println(mascaraBinario);
	}

	/**
	 * Test para convertir un numero hexadecimal a binario
	 */
	@Test
	public void convertirHexaABinario() {
		String hexadecimal = "C0";

		logica = new Logica(hexadecimal);

		String binario = logica.convertirHexaABinario(hexadecimal);

		System.out.println(binario);
	}

	/**
	 * Test para realizar la operacion and entre la ip y la mascara
	 */
	@Test
	public void realizarAnd() {
		String ip = "10101101.00100010.01000000.00000000";
		String mascara = "11111111.11111111.11100000.00000000";

		logica = new Logica(ip, mascara);

		String and = logica.realizarAnd(ip, mascara);

		System.out.println(and);
	}

	/**
	 * Test para convertir un numero binario a decimal
	 */
	@Test
	public void binarioADecimalString() {
		String binario = "11000000";

		logica = new Logica(binario);

		int decimal = logica.binarioADecimal(binario);

		System.out.println(decimal);
	}

	/**
	 * Test para convertir la direccion completa en binario a decimal
	 */
	@Test
	public void convertirBinarioADecimal() {
		String binario = "10101101.00100010.01000000.00000000";

		logica = new Logica(binario);

		String decimal = logica.convertirBinarioADecimal(binario);

		System.out.println(decimal);
	}

	/**
	 * Test para calcular el numero de host en la red
	 */
	@Test
	public void calcularNumerosHost() {
		String mascara = "11111111.11111111.11100000.00000000";

		logica = new Logica(mascara);

		int numeroHost = logica.calcularNumerosHost(mascara);

		System.out.println(numeroHost);
	}

	/**
	 * Test para calcular la direccion de broadcast de la red
	 */
	@Test
	public void calcularDireccionBroadcast() {
		String and = "10101101.00100010.01000000.00000000";
		String mascara = "/19";

		logica = new Logica(and, mascara);

		String broadcast = logica.calcularDireccionBroadcast(and, mascara);

		System.out.println(broadcast);
	}

	/**
	 * Test para calcular la direccion minima asignable
	 */
	@Test
	public void calcularHostMinimo() {
		String direccion = "173.34.64.0";

		logica = new Logica(direccion);

		String minimo = logica.calcularHostMinimo(direccion);

		System.out.println(minimo);
	}

	/**
	 * Test para calcular la direccion maxima asignable
	 */
	@Test
	public void calcularHostMaximo() {
		String broadcast = "173.34.95.255";

		logica = new Logica(broadcast);

		String maximo = logica.calcularHostMaximo(broadcast);

		System.out.println(maximo);
	}

	/**
	 * Test del metodo sobreescrito para convertir un numero binario a decimal
	 */
	@Test
	public void binarioADecimal() {
		int binario = 11000000;
		
		logica = new Logica(binario + "");
		
		int decimal = logica.binarioADecimal(binario);
		
		System.out.println(decimal);
	}

	/**
	 * Test para convertir un numero binario a hexadecimal
	 */
	@Test
	public void binarioAHexadecimal() {
		String binario = "10101101";
		
		logica = new Logica(binario);
		
		String hexadecimal = logica.binarioAHexadecimal(binario);
		
		System.out.println(hexadecimal);
	}

	/**
	 * Test para convertir un caracter hexadecimal a decimal
	 */
	@Test
	public void caracterHexadecimalADecimal() {
		String caracter = "AC";
		
		logica = new Logica(caracter);
		
		int decimal = logica.caracterHexadecimalADecimal(caracter.charAt(1));
		
		System.out.println(decimal);
	}

	/**
	 * Test para convertir un numero hexadecimal a decimal
	 */
	@Test
	public void hexadecimalADecimal() {
		String hexadecimal = "AC";
		
		logica = new Logica(hexadecimal);
		
		long decimal = logica.hexadecimalADecimal(hexadecimal);
		
		System.out.println(decimal);
	}
}
