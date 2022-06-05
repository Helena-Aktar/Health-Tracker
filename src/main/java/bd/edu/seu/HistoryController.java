package bd.edu.seu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {
    @FXML private TableView<Entry> entryTableView;
    @FXML private TableColumn<Entry,String> dateColumn;
    @FXML private TableColumn<Entry,String> timeColumn;
    @FXML private TableColumn<Entry,String> sysColumn;
    @FXML private TableColumn<Entry,String> diaColumn;
    @FXML private TableColumn<Entry,String> weightColumn;
    DBAction dbAction;
    private ObservableList<Entry> entries;

    public HistoryController(){
        entryTableView = new TableView<>();
        dateColumn = new TableColumn<>();
        timeColumn = new TableColumn<>();
        sysColumn= new TableColumn<>();
        diaColumn = new TableColumn<>();
        weightColumn = new TableColumn<>();
        dbAction = new DBAction();
        entries = FXCollections.observableArrayList();
    }


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn .setCellValueFactory(new PropertyValueFactory<>("time"));
        sysColumn.setCellValueFactory(new PropertyValueFactory<>("systolic"));
        diaColumn.setCellValueFactory( new PropertyValueFactory<>("diastolic"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        entries.addAll(dbAction.retrieveHistory());
        entryTableView.setItems(entries);
    }
}
