package app.model;

import javafx.embed.swing.SwingFXUtils;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image
{
    private Stage stage;

    private BufferedImage image;

    public Image(Stage stage)
    {
        this.stage = stage;
    }

    public void load()
    {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(this.stage);

        try {
            this.image = ImageIO.read(file);
            System.out.print(this.image.getWidth());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Image process()
    {
        Image processedImage = new Image(this);
        //For testing
        processedImage.image = processedImage.image.getSubimage(0, 0, 100, 100);
        return processedImage;
    }

    public BufferedImage toBufferedImage()
    {
        return this.image;
    }

    public javafx.scene.image.Image toFXImage()
    {
        return SwingFXUtils.toFXImage(this.image, null);
    }

    /**
     * Image copy constructor,
     * is private cuz we want to use it only inside class definition
     * @param other - other Image object
     */
    private Image(Image other)
    {
        this.stage = other.stage;
        this.image = other.image;
    }
}
