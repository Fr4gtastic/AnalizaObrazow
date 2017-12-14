package app.model;

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

    public BufferedImage get()
    {
        return this.image;
    }
}
