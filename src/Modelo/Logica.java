package Modelo;

public class Logica {

	//Direccion IP
	private String ip;
	
	//Mascara de la direccion IP
	private String mascara;

	/**
	 * Permite convertir un numero decimal a binario
	 * 
	 * @param decimal numero a convertir
	 * @return numero en binario
	 */
	public static String convertirDecimalABinarioManual(String decimal) {
		int numero = Integer.parseInt(decimal);
		if (numero <= 0) {
			return "0";
		}
		StringBuilder binario = new StringBuilder();
		while (numero > 0) {
			short residuo = (short) (numero % 2);
			numero = numero / 2;
			binario.insert(0, String.valueOf(residuo));
		}
		if (binario.length() != 8) {
			while (binario.length() != 8) {
				binario.insert(0, "0");
			}
			return binario.toString();
		} else {
			return binario.toString();
		}
	}

	/**
	 * Permite calcular la direccion IP en binario
	 * 
	 * @param ip direccion ip
	 * @return cadena con la direccion IP en binario
	 */
	public static String calcularIPBinario(String ip) {
		String[] ipArray = ip.split("\\.");
		String binario = "";

		if (ipArray.length != 0) {
			for (int i = 0; i < ipArray.length; i++) {
				binario += convertirDecimalABinarioManual(ipArray[i]) + ".";
			}
		}
		binario = binario.substring(0, binario.length() - 1);
		return binario;
	}

	/**
	 * Permite realizar la operacion AND entre dos numeros binarios
	 * 
	 * @param n1 primer numero
	 * @param n2 segundo numero
	 * @return
	 */
	public static String andBinario(String n1, String n2) {

		String resul = "";

		if (n1.length() == n2.length()) {
			for (int i = 0; i < n1.length(); i++) {
				if (n1.charAt(i) == '1' && n2.charAt(i) == '1') {
					resul += "1";
				} else if (n1.charAt(i) == '1' && n2.charAt(i) == '0' || n1.charAt(i) == '0' && n2.charAt(i) == '1'
						|| n1.charAt(i) == '0' && n2.charAt(i) == '0')
					resul += "0";
			}
		}
		return resul;
	}

	/**
	 * Permite convertir un numero decimal a hexadecimal
	 * 
	 * @param decimal numero decimal a convertir
	 * @return numero hexadecimal (String)
	 */
	public static String decimalAHexadecimal(int decimal) {
		String hexa = "";
		String caracteresHexa = "0123456789abcdef";
		while (decimal > 0) {
			int residuo = decimal % 16;
			hexa = caracteresHexa.charAt(residuo) + hexa; // Agregar a la izquierda
			decimal /= 16;
		}
		return hexa;
	}

	/**
	 * Metodo para convertir la mascara de decimal a binario
	 * 
	 * @param mascara Mascara en decimal
	 * @return Mascara en binario
	 */
	public static String convertirMascaraBinario(String mascara) {
		mascara = mascara.substring(1, mascara.length());
		int mascaraIp = Integer.parseInt(mascara);
		StringBuilder binario = new StringBuilder();

		if (binario.length() != mascaraIp) {
			while (binario.length() != mascaraIp) {
				binario.insert(0, "1");
			}
		}
		if (binario.length() != 32) {
			while (binario.length() != 32) {
				binario.insert(binario.length(), "0");
			}
		}
		return binario.toString();
	}

	public static void main(String[] args) {

		String ip = "192.168.12.1";
		String mascara = "/24";

		String IpBinario = calcularIPBinario(ip);
		String mascaraBinario = convertirMascaraBinario(mascara);

		System.out.println(IpBinario);
		System.out.println(mascaraBinario);
		System.out.println(decimalAHexadecimal(11));
	}
}