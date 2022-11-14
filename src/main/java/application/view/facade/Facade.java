package application.view.facade;

import application.ViewModel;
import application.model.Scoreboard;
import application.view.ViewEditor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Facade extends Application {
    private String name;

    //Facade facade = new facade()
    //facade.setName("Editor");


    @Override
    public void start(Stage stage) throws Exception {
        if (Objects.equals(getName(), "Editor.fxml")) {
            loadEditor();
        }
        loadScoreboard();
    }

    public ViewEditor loadEditor() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Editor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();

        return loader.getController();
    }

    //public Scoreboard loadScoreboard() throws IOException {
    public void loadScoreboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Scoreboard.fxml"));
        Parent root = loader.load();

        ViewModel scoreBoard = loader.getController();
        scoreBoard.displayValues();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Scoreboard");
        stage.setScene(scene);
        stage.show();

        //return loader.getController();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
