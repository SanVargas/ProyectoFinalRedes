package Modelo;

import java.util.ArrayList;
import java.util.Stack;

public class Logica {

	// Direccion IP
	private String ip;

	// Mascara de la direccion IP
	private String mascara;

	private String numero;

	public Logica(String ip, String mascara) {
		this.ip = ip;
		this.mascara = mascara;
	}

	public Logica(String numero) {
		this.numero = numero;
	}

	/**
	 * Permite convertir un numero decimal a binario
	 * 
	 * @param decimal numero a convertir
	 * @return numero en binario
	 */
	public String convertirDecimalABinario(String decimal) {
		int numero = Integer.parseInt(decimal);
		if (numero <= 0) {
			return "00000000";
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
	public String calcularIPBinario(String ip) {
		String[] ipArray = ip.split("\\.");
		String binario = "";

		if (ipArray.length != 0) {
			for (int i = 0; i < ipArray.length; i++) {
				binario += convertirDecimalABinario(ipArray[i]) + ".";
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
	public String andBinario(String n1, String n2) {

		String resul = "";

		if (n1.length() == n2.length()) {
			for (int i = 0; i < n1.length(); i++) {
				if (n1.charAt(i) == '1' && n2.charAt(i) == '1') {
					resul += "1";
				} else
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
	public String decimalAHexadecimal(String numero) {
		int decimal = Integer.parseInt(numero);
		String hexa = "";
		String caracteresHexa = "0123456789ABCDEF";
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
	public String convertirMascaraBinario(String mascara) {
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

		for (int i = 0; i < binario.length(); i++) {
			if (i % 9 == 0) {
				binario.insert(i, ".");
			}
		}
		String binarioIP = binario.toString();
		binarioIP = binarioIP.substring(1, binarioIP.length());
		return binarioIP;
	}

	/**
	 * Permite convertir un numero hexadecimal a binario
	 * 
	 * @param hexa numero hexadecimal
	 * @return numero binario
	 */
	public String convertirHexaABinario(String hexa) {
		int numHex = Integer.parseInt(hexa, 16);
		String binario = Integer.toBinaryString(numHex);
		return binario;
	}

	/**
	 * Realizar la operacion and entre la ip y la mascara
	 * 
	 * @param ip      Direccion ip del host
	 * @param mascara Mascara de la subred
	 * @return la operacion and realizada
	 */
	public String realizarAnd(String ip, String mascara) {
		String[] ipArray = ip.split("\\.");
		String[] mascaraArray = mascara.split("\\.");

		String and = "";

		for (int i = 0; i < ipArray.length; i++) {
			and += andBinario(ipArray[i], mascaraArray[i]) + ".";
		}

		and = and.substring(0, and.length() - 1);
		return and;
	}

	/**
	 * Convierte un numero binario a decimal
	 * 
	 * @param binario Numero binario a convertir
	 * @return El numero binario convertido a decimal
	 */
	public int binarioADecimal(String binario) {
		int decimal = 0;
		int posicion = 0;
		for (int x = binario.length() - 1; x >= 0; x--) {
			short digito = 1;
			if (binario.charAt(x) == '0') {
				digito = 0;
			}
			double multiplicador = Math.pow(2, posicion);
			decimal += digito * multiplicador;
			posicion++;
		}
		return decimal;
	}

	/**
	 * Convertir la direccion completa en binario a decimal
	 * 
	 * @param direccion Direccion a convertir a decimal
	 * @return Direccion convertida a decimal
	 */
	public String convertirBinarioADecimal(String direccion) {
		String[] array = direccion.split("\\.");

		String decimal = "";

		for (int i = 0; i < array.length; i++) {
			decimal += binarioADecimal(array[i]) + ".";
		}
		decimal = decimal.substring(0, decimal.length() - 1);
		return decimal;
	}

	/**
	 * Metodo para calcular el numero de host en la red
	 * 
	 * @param mascara La direccion de la mascara en binario
	 * @return el numero de host en la red
	 */
	public int calcularNumerosHost(String mascara) {
		String[] array = mascara.split("\\.");

		int host = 0;
		int con = 0;

		for (int i = 0; i < array.length; i++) {
			String cadena = array[i];
			for (int j = 0; j < cadena.length(); j++) {
				if (cadena.charAt(j) == '0') {
					con++;
				}
			}
		}

		host = (int) Math.pow(2, con);
		return host - 2;
	}

	/**
	 * Metodo para calcular la direccion de broadcast de la red
	 * 
	 * @param and     Operacion and de la direccion de red con la mascara
	 * @param mascara Mascara de la subred
	 * @return Direccion de broadcast de la red
	 */
	public String calcularDireccionBroadcast(String and, String mascara) {
		StringBuilder broadcast = new StringBuilder();
		mascara = mascara.substring(1, mascara.length());
		int mascaraEntero = Integer.parseInt(mascara);

		and = and.replaceAll("\\.", "");

		char[] array = new char[and.length()];

		for (int i = 0; i < array.length; i++) {
			if (i > mascaraEntero - 1) {
				array[i] = '1';
			} else {
				array[i] = and.charAt(i);
			}
		}

		broadcast.append(array);

		for (int i = 0; i < broadcast.length(); i++) {
			if (i % 9 == 0) {
				broadcast.insert(i, ".");
			}
		}

		String binarioIP = broadcast.toString();
		binarioIP = binarioIP.substring(1, binarioIP.length());

		return binarioIP;
	}

	/**
	 * Metodo para calcular la direccion minima asignable
	 * 
	 * @param Direccion de la red
	 * @return Direccion minima asignable
	 */
	public String calcularHostMinimo(String direccion) {
		StringBuilder hostminimo = new StringBuilder();
		String[] array = direccion.split("\\.");

		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				int ultimo = Integer.parseInt(array[i]);
				ultimo = ultimo + 1;
				hostminimo.append(ultimo);
				hostminimo.append(".");
			} else {
				hostminimo.append(array[i]);
				hostminimo.append(".");
			}
		}

		String minimo = hostminimo.toString();
		minimo = minimo.substring(0, minimo.length() - 1);

		return minimo;
	}

	/**
	 * Metodo para calcular la direccion maxima asignable
	 * 
	 * @param Direccion de broadcast de la red
	 * @return Direccion maxima asignable
	 */
	public String calcularHostMaximo(String broadcast) {
		StringBuilder hostmaximo = new StringBuilder();
		String[] array = broadcast.split("\\.");

		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				int ultimo = Integer.parseInt(array[i]);
				ultimo = ultimo - 1;
				hostmaximo.append(ultimo);
				hostmaximo.append(".");
			} else {
				hostmaximo.append(array[i]);
				hostmaximo.append(".");
			}
		}

		String maximo = hostmaximo.toString();
		maximo = maximo.substring(0, maximo.length() - 1);

		return maximo;
	}

	/**
	 * Metodo Sobreescrito para convertir un numero binario a decimal
	 * 
	 * @param binario Numero binario a convertir
	 * @return Numero convertido a decimal
	 */
	public int binarioADecimal(int binario) {
		int decimal = 0;
		int posicion = 0;
		for (int x = String.valueOf(binario).length() - 1; x >= 0; x--) {
			short digito = 1;
			if (String.valueOf(binario).charAt(x) == '0') {
				digito = 0;
			}
			double multiplicador = Math.pow(2, posicion);
			decimal += digito * multiplicador;
			posicion++;
		}
		return decimal;
	}

	/**
	 * Metodo para convertir un numero binario a hexadecimal
	 * 
	 * @param numero Numero binario a convertir
	 * @return Numero binario convertido a hexadecimal
	 */
	public String binarioAHexadecimal(String numero) {
		int binario = Integer.parseInt(numero);
		String hexadecimal = "";
		String digitosHexa = "0123456789ABCDEF";

		while (binario > 0) {
			hexadecimal = digitosHexa.charAt((int) binarioADecimal(binario % 10000)) + hexadecimal;
			binario = binario / 10000;
		}

		return hexadecimal;
	}

	/**
	 * Metodo para convertir un caracter hexadecimal a decimal
	 * 
	 * @param caracter Caracter hexadecimal a convertir
	 * @return Caracter convertido a decimal
	 */
	public int caracterHexadecimalADecimal(char caracter) {
		switch (caracter) {
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		default:
			return Integer.parseInt(String.valueOf(caracter));
		}
	}

	/**
	 * Metodo para convertir un numero hexadecimal a decimal
	 * 
	 * @param hexadecimal Numero hexadecimal a convertir a decimal
	 * @return Numero hexadecimal convertido a decimal
	 */
	public long hexadecimalADecimal(String hexadecimal) {
		long decimal = 0;

		int potencia = 0;

		for (int x = hexadecimal.length() - 1; x >= 0; x--) {
			int valor = caracterHexadecimalADecimal(hexadecimal.charAt(x));
			long elevado = (long) Math.pow(16, potencia) * valor;
			decimal += elevado;

			potencia++;
		}
		return decimal;
	}

	/**
	 * Permite calcular el numero de direcciones disponibles para los host de una
	 * red
	 * 
	 * @param direccion direccion de la red
	 * @return numero de direcciones disponibles
	 */
	public int calcularNumeroDireccionesParaHostEnLaRed(String mascara) {
		String aux2 = mascara.substring(1, mascara.length());
		;
		int mascaraRed = Integer.parseInt(aux2);

		int numBits = 32 - mascaraRed;
		double numDirHost = Math.pow(2, numBits) - 2;
		int direcciones = (int) numDirHost;

		return direcciones;
	}

	/**
	 * Permite calcular el rango de direcciones disponibles para una red partiendo
	 * de la direccion IP
	 * 
	 * @param direccion direccion IP
	 */
	public ArrayList<String> calcularRangoDireccionesDirRedDirBroadcast(String direccion, String mascara) {
		ArrayList<String> direcciones = new ArrayList<>();

		String binarioMascara = convertirMascaraBinario(mascara);
		String binarioIp = calcularIPBinario(direccion);
		String and = realizarAnd(binarioIp, binarioMascara);

		String broadcast = calcularDireccionBroadcast(and, mascara);

		String p = "";
		int k = and.length() - 1;
		while (and.charAt(k) != '.') {
			p += and.charAt(k);
			k--;
		}
		String ad = convertirBinarioADecimal(and);

		int contador = 0, m = 0;
		String pri = "";
		while (contador < 3) {
			pri += and.charAt(m);
			m++;
			if (and.charAt(m) == '.')
				contador++;
		}

		String[] startParts = convertirBinarioADecimal(and).split("\\.");
		String[] endParts = convertirBinarioADecimal(broadcast).split("\\.");

		int primeroOctetoRed = Integer.parseInt(startParts[0]);
		int segundoOctetoRed = Integer.parseInt(startParts[1]);
		int tercerOctetoRed = Integer.parseInt(startParts[2]);
		int cuartoOctetoRed = Integer.parseInt(startParts[3]);

		int primeroOctetoBroad = Integer.parseInt(endParts[0]);
		int segundoOctetoBroad = Integer.parseInt(endParts[1]);
		int tercerOctetoBroad = Integer.parseInt(endParts[2]);
		int cuartoOctetoBroad = Integer.parseInt(endParts[3]);

		direcciones.add(convertirBinarioADecimal(and) + " Direccion De Red");
		while (!(primeroOctetoRed == primeroOctetoBroad && segundoOctetoRed == segundoOctetoBroad
				&& tercerOctetoRed == tercerOctetoBroad && cuartoOctetoRed == cuartoOctetoBroad)) {
			while (cuartoOctetoRed != cuartoOctetoBroad) {
				cuartoOctetoRed += 1;
				startParts[3] = cuartoOctetoRed + "";
				String host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
				direcciones.add(host);
			}

			while (tercerOctetoRed != tercerOctetoBroad) {
				tercerOctetoRed += 1;
				startParts[2] = tercerOctetoRed + "";
				String host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
				int cuartoOcteto = -1;
				while (cuartoOcteto != 255) {
					cuartoOcteto += 1;
					startParts[3] = cuartoOcteto + "";
					host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
					direcciones.add(host);
				}
			}

			while (segundoOctetoRed != segundoOctetoBroad) {
				segundoOctetoRed += 1;
				startParts[1] = segundoOctetoRed + "";
				String host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
				int tercerOcteto = -1;
				while (tercerOcteto != tercerOctetoBroad) {
					tercerOcteto += 1;
					startParts[2] = tercerOcteto + "";
					host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
					int cuartoOcteto = -1;
					while (cuartoOcteto != 255) {
						cuartoOcteto += 1;
						startParts[3] = cuartoOcteto + "";
						host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
						direcciones.add(host);
					}
				}
			}

			while (primeroOctetoRed != primeroOctetoBroad) {
				primeroOctetoRed += 1;
				startParts[1] = primeroOctetoRed + "";
				String host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
				int segundoOcteto = -1;
				while (segundoOcteto != segundoOctetoBroad) {
					segundoOcteto += 1;
					startParts[1] = segundoOcteto + "";
					host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
					int tercerOcteto = -1;
					while (tercerOcteto != tercerOctetoBroad) {
						tercerOcteto += 1;
						startParts[2] = tercerOcteto + "";
						host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
						int cuartoOcteto = -1;
						while (cuartoOcteto != 255) {
							cuartoOcteto += 1;
							startParts[3] = cuartoOcteto + "";
							host = startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3];
							direcciones.add(host);
						}
					}
				}
			}
		}
		direcciones.remove(direcciones.size() - 1);
		direcciones.add(convertirBinarioADecimal(broadcast) + " Direccion de Broadcast");
		return direcciones;
	}

	// Getters y Setters
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}