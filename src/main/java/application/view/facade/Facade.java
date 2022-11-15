package application.view.facade;

import application.ViewModel.ViewModel;
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

    /**
     * Switches between the two views available IFF Editor.Fxml is present
     * Otherwise loads the scoreboard view
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        if (Objects.equals(getName(), "Editor.fxml")) {
            loadEditor();
        }
        loadScoreboard();
    }

    /***
     * Displays Editor.fxml Scene and returns the corresponding controller from Parent root
     * @return
     * @throws IOException
     */
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

    /***
     * Displays Scoreboard.fxml scene and prints the current list of teams
     * @return
     * @throws IOException
     */
    public void loadScoreboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Scoreboard.fxml"));
        Parent root = loader.load();

        ViewModel viewModel = loader.getController();
        viewModel.displayValues();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Scoreboard");
        stage.setScene(scene);
        stage.show();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
