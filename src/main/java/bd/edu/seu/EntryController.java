package bd.edu.seu;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import java.time.LocalDate;

public class EntryController {
    @FXML private DatePicker datepicker;
    @FXML private TextField timeField;
    @FXML private TextField sysField;
    @FXML private TextField diaField;
    @FXML private TextField weightField;
    DBAction dbAction;

    public EntryController() {
        datepicker = new DatePicker();
        timeField = new TextField();
        sysField = new TextField();
        diaField = new TextField();
        weightField = new TextField();
        dbAction = new DBAction();
    }
    private void clearForm(){
        datepicker.setValue(null);
        timeField.clear();
        sysField.clear();
        diaField.clear();
        weightField.clear();
    }
    @FXML
    private void handleSaveAction(){
        LocalDate date = datepicker.getValue();
       String time = timeField.getText();
        int sys = Integer.parseInt(sysField.getText());
        int dia = Integer.parseInt(diaField.getText());
        float weight = Float.parseFloat(weightField.getText());
        Entry entry = new Entry(date,time,sys,dia,weight);
      
        dbAction.insertTodb(entry);
        clearForm();
    }
    @FXML
    private void handleCancelAction(){
        clearForm();
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
