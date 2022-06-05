package bd.edu.seu;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToEntry() throws IOException {
        App.setRoot("entry");
    }
    @FXML
    private void switchToHistory() throws IOException {
        App.setRoot("history");
    }
    @FXML
    private void switchToDetails() throws IOException {
        App.setRoot("details");
    }
}
