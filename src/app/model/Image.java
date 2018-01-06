package app.model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    private Stage stage;

    private BufferedImage image;

    private ImageProcessor processor;

    public Image(Stage stage) {
	this.stage = stage;
	this.processor = new ImageProcessor();
    }

    public void load() {
	FileChooser chooser = new FileChooser();
	setChooserFilters(chooser);
	File file = chooser.showOpenDialog(this.stage);

	try {
	    this.image = ImageIO.read(file);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    public void save() {
	FileChooser chooser = new FileChooser();
	setChooserFilters(chooser);
	File file = chooser.showSaveDialog(stage);

	try {
	    ImageIO.write(SwingFXUtils.fromFXImage(this.toFXImage(), null), "png", file);
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}
    }

    public Image process(int segmentsNumber) {
	Image processedImage = new Image(this);
	processedImage.image = this.processor.segmentate(processedImage.image, segmentsNumber);
	return processedImage;
    }

    public BufferedImage toBufferedImage() {
	return this.image;
    }

    public javafx.scene.image.Image toFXImage() {
	return SwingFXUtils.toFXImage(this.image, null);
    }

    /**
     * Image copy constructor, is private cuz we want to use it only inside class
     * definition
     * 
     * @param other
     *            - other Image object
     */
    private Image(Image other) {
	this.stage = other.stage;
	this.image = other.image;
    }

    // this method is used to set extension filters for a file chooser

    private static void setChooserFilters(FileChooser chooser) {
	chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
		new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
    }
}
