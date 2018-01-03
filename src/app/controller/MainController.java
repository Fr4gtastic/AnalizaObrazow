package app.controller;

import app.model.App;
import app.model.Image;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MainController {
    private App app;

    @FXML
    private ImageView imageView;

    @FXML
    public void imageFileButtonClickAction() {
	Image image = new Image(app.getStage());
	image.load();
	this.app.setOriginalImage(image);
	this.imageView.setImage(image.toFXImage());
    }

    @FXML
    public void processImageButtonClickAction() {
	if (this.app.getOriginalImage() != null) {
	    this.app.setProcessedImage(this.app.getOriginalImage().process());
	    this.imageView.setImage(this.app.getProcessedImage().toFXImage());
	}
    }

    @FXML
    public void showOrigImageButtonClickAction() {
	if (this.app.getOriginalImage() != null) {
	    this.imageView.setImage(this.app.getOriginalImage().toFXImage());
	}
    }

    @FXML
    public void showProcessedImageButtonClickAction() {
	if (this.app.getProcessedImage() != null) {
	    this.imageView.setImage(this.app.getProcessedImage().toFXImage());
	}
    }

    @FXML
    public void saveProcessedImageButtonClickAction() {
	if (this.app.getProcessedImage() != null) {
	    this.app.getProcessedImage().save();
	}
    }

    public void setApp(App app) {
	this.app = app;
    }
}
