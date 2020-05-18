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
	
	private Logica logica;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	public void calcularDireccion(ActionEvent e) {
		String ip = txtDireccionIP.getText();
		String mascara = txtMascara.getText();
		
		if(!ip.isEmpty() && !mascara.isEmpty()) {
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
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!!!!!");
			alert.setHeaderText(null);
			alert.setContentText("Todos los campos deben estar llenos");

			alert.showAndWait();
		}
	}
}
