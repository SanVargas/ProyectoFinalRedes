package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Logica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrincipalController implements Initializable {

	@FXML
	private Button btnCalcular;

	@FXML
	private TextField txtDireccionIP;

	@FXML
	private TextField txtMascara;

	@FXML
	private Label lblDirRed;

	@FXML
	private Label lblDirBroad;

	@FXML
	private Label lblCantidadHost;

	@FXML
	private Label lblHostMin;

	@FXML
	private Label lblHostMax;

	@FXML
	private TextField txtDecimalBinario;

	@FXML
	private TextField txtDecimalHexadecimal;

	@FXML
	private TextField txtBinarioDecimal;

	@FXML
	private TextField txtBinarioHexadecimal;

	@FXML
	private TextField txtHexadecimalDecimal;

	@FXML
	private TextField txtHexadecimalBinario;

	@FXML
	private Label lblDecimalBinario;

	@FXML
	private Label lblDecimalHexadecimal;

	@FXML
	private Label lblBinarioDecimal;

	@FXML
	private Label lblBinarioHexadecimal;

	@FXML
	private Label lblHexadecimalDecimal;

	@FXML
	private Label lblHexadecimalBinario;

	private Logica logica;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void calcularDireccion(ActionEvent e) {
		String ip = txtDireccionIP.getText();
		String mascara = txtMascara.getText();

		if (!ip.isEmpty() && !mascara.isEmpty()) {
			logica = new Logica(ip, mascara);

			String ipBinario = logica.calcularIPBinario(ip);
			String mascaraBinario = logica.convertirMascaraBinario(mascara);

			String and = logica.realizarAnd(ipBinario, mascaraBinario);
			String broadcastBinario = logica.calcularDireccionBroadcast(and, mascara);

			String direccionRed = logica.convertirBinarioADecimal(and);
			String direccionBroadcast = logica.convertirBinarioADecimal(broadcastBinario);

			String minimo = logica.calcularHostMinimo(direccionRed);
			String maximo = logica.calcularHostMaximo(direccionBroadcast);

			int cantHost = logica.calcularNumerosHost(mascaraBinario);

			lblDirRed.setText(direccionRed + mascara);
			lblCantidadHost.setText(cantHost + "");
			lblDirBroad.setText(direccionBroadcast);
			lblHostMin.setText(minimo);
			lblHostMax.setText(maximo);

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Todos los campos deben estar llenos");

			alert.showAndWait();
		}
	}

	@FXML
	public void convertirDecimalBinario(ActionEvent e) {
		String decimal = txtDecimalBinario.getText();

		if (!decimal.isEmpty()) {
			logica = new Logica(decimal);

			String binario = logica.convertirDecimalABinario(decimal);

			lblDecimalBinario.setText(binario);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe colocar el número a convertir");

			alert.showAndWait();
		}
	}

	@FXML
	public void convertirDecimalHexadecimal(ActionEvent e) {
		String decimal = txtDecimalHexadecimal.getText();

		if (!decimal.isEmpty()) {
			logica = new Logica(decimal);

			String hexadecimal = logica.decimalAHexadecimal(decimal);

			lblDecimalHexadecimal.setText(hexadecimal);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe colocar el número a convertir");

			alert.showAndWait();
		}
	}

	@FXML
	public void convertirBinarioDecimal(ActionEvent e) {
		String binario = txtBinarioDecimal.getText();

		if (!binario.isEmpty()) {
			logica = new Logica(binario);

			int decimal = logica.binarioADecimal(binario);

			lblBinarioDecimal.setText(decimal + "");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe colocar el número a convertir");

			alert.showAndWait();
		}
	}

	@FXML
	public void convertirBinarioHexadecimal(ActionEvent e) {
		String binario = txtBinarioHexadecimal.getText();

		if (!binario.isEmpty()) {
			logica = new Logica(binario);

			String hexadecimal = logica.binarioAHexadecimal(binario);

			lblBinarioHexadecimal.setText(hexadecimal);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe colocar el número a convertir");

			alert.showAndWait();
		}
	}

	@FXML
	public void convertirHexadecimalDecimal(ActionEvent e) {
		String hexadecimal = txtHexadecimalDecimal.getText();

		if (!hexadecimal.isEmpty()) {
			logica = new Logica(hexadecimal);

			long decimal = logica.hexadecimalADecimal(hexadecimal);

			lblHexadecimalDecimal.setText(decimal + "");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe colocar el número a convertir");

			alert.showAndWait();
		}
	}

	@FXML
	public void convertirHexadecimalBinario(ActionEvent e) {
		String hexadecimal = txtHexadecimalBinario.getText();

		if (!hexadecimal.isEmpty()) {
			logica = new Logica(hexadecimal);

			String binario = logica.convertirHexaABinario(hexadecimal);

			lblHexadecimalBinario.setText(binario);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Debe colocar el número a convertir");

			alert.showAndWait();
		}
	}
}
