package bd.edu.seu;

import javafx.fxml.FXML;

import java.io.IOException;

public class DetailsController {
    public DetailsController() {
    }

    @FXML
    private void switchToPrimary() throws IOException {
          App.setRoot("primary");
    }
}
