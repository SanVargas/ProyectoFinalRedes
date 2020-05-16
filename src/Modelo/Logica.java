package Modelo;

public class Logica {

	private String[] ip;
	private String mascara;

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
		if(binario.length() != 8) {
			while(binario.length() != 8) {
				binario.insert(0, "0");
			}
			return binario.toString();
		}else {
			return binario.toString();
		}	
	}

	public static String calcularIPBinario(String ip) {
		String[] ipArray = ip.split("\\.");
		String binario="";

		if (ipArray.length != 0) {
			for (int i = 0; i < ipArray.length; i++) {
				binario += convertirDecimalABinarioManual(ipArray[i]) + ".";
			}
		}
		return binario;
	}
	
	public static void main(String[] args) {
		String ip = "192.168.12.5";
		
		String binario = calcularIPBinario(ip);
		
		System.out.println(binario);
	}
}
