package fx;

import com.sun.javafx.collections.ObservableSequentialListWrapper;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Browser extends Application implements Initializable {
    public static Stage primaryStage;

    public ObservableList<String> historyStore = FXCollections.observableArrayList();

    public int currentPage = 0;

    @FXML
    public WebView browser;

    @FXML
    public Button find;

    @FXML
    public Button back;

    @FXML
    public Button forward;

    @FXML
    public javafx.scene.control.TextField addressBar;

    @FXML
    public Text stateLabel;

    @FXML
    public ProgressBar progress;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/assets/browser.fxml"));
        primaryStage.setTitle("Browser");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine webEngine = browser.getEngine();

        Worker<Void> worker = webEngine.getLoadWorker();

        worker.stateProperty().addListener((observable, oldValue, newValue) -> {
            stateLabel.setText("Loading state: " + newValue.toString());
            if (newValue == Worker.State.SUCCEEDED) {
                stateLabel.setText("Finish!");
            }
        });

        progress.progressProperty().bind(worker.progressProperty());

        find.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                String url = addressBar.getText();
                historyStore.add(url);
                currentPage = historyStore.size() - 1;
                webEngine.load(url);
            }
        });

        back.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                if (currentPage > 0) {
                    currentPage--;
                    String url = historyStore.get(currentPage);
                    addressBar.setText("");
                    webEngine.load(url);
                }
            }
        });

        forward.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                if (currentPage < historyStore.size() - 1) {
                    currentPage++;
                    String url = historyStore.get(currentPage);
                    addressBar.setText("");
                    webEngine.load(url);
                }
            }
        });
    }

    public void toHistory() {
        FlowPane root = new FlowPane(new ListView<String>(this.historyStore));
        Stage stage = new Stage();
        stage.setTitle("History");
        stage.setScene(new Scene(root, 200, 300));
        stage.show();
    }
}
