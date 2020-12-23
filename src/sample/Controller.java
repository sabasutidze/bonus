package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private PasswordField enterPasswordField;




    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextfield.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) { validateLogin();


        } else {
            loginMessageLabel.setText("please enter username and password");

        }


    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(){
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection cconnectDB = connectnow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextfield.getText() + "' AND password ='" + enterPasswordField.getText() + "''";

        try {

            Statement statement = cconnectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Congrats!");
                }else {
                    loginMessageLabel.setText("try again");
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        )
    }
}
