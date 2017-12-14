package app.model;

import javafx.stage.Stage;

public class App
{
    private Stage stage;

    private Image image;

    public void setImage(Image image)
    {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }
}
