package Modelo;

public class Logica {

	private String[] ip;
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

	public static void main(String[] args) {

		System.out.println(andBinario("11111101", "11101101"));
	}
}
