package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tds.ifsc.controller.SomarController;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Somar números");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/tds/ifsc/view/soma.fxml"));
			Parent arquivoXML = loader.load();

			Scene somarCena = new Scene(arquivoXML);
			primaryStage.setScene(somarCena);

			SomarController somarController = loader.getController();

			primaryStage.setOnCloseRequest(e-> {

				if(somarController.onCloseQuery()){
					System.exit(0);
				}else{
					e.consume();
				}
			});


			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
