package app.controller;

import app.model.App;
import app.model.Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MainController
{
    public ImageView origImage;
    private App app;

    @FXML
    public void fileButtonClickAction()
    {
        Image image = new Image(app.getStage());
        image.load();
        this.app.setImage(image);

        javafx.scene.image.Image im = SwingFXUtils.toFXImage(image.get(), null);
        this.origImage.setImage(im);
    }

    public void setApp(App app)
    {
        this.app = app;
    }
}
