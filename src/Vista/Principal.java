package Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/co/edu/uniquindio/redes/Principal.fxml"));
		
		Parent p = loader.load();
		Scene s = new Scene(p);
		
		primaryStage.getIcons().add(new Image("/co/edu/uniquindio/redes/736663fe6f9e03fcb39ace9020c42b4c-icono-estacionario-de-la-calculadora-by-vexels.png"));
		primaryStage.setTitle("Calculadora IP");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}

}