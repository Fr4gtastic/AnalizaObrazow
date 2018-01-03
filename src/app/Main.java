package app;

import app.controller.MainController;
import app.model.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private App app;

    @Override
    public void start(Stage primaryStage) throws Exception {
	this.app = new App();
	this.app.setStage(primaryStage);

	FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main.fxml"));
	Parent root = loader.load();

	MainController controller = loader.getController();
	controller.setApp(this.app);

	primaryStage.setTitle("Image Color Segmentation");
	primaryStage.setScene(new Scene(root, 1600, 1000));
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
