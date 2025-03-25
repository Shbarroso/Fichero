package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RecuperarController {
    private final String email = "samuelaurix2@gmail.com";
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textEmail;
    @FXML
    private Button buttonRegistrar;
    @FXML
    private TextField textFieldMensajeRecover;

    @FXML
    protected void onRecoverButtonClick(){
        if (textFieldEmail == null || textFieldEmail.getText().isEmpty()) {
            textFieldMensajeRecover.setText("¡El Email no puede ser nulo o vacio!");
            return;
        }
        if (!textFieldEmail.getText().equals(email)){
            textFieldMensajeRecover.setText("Credenciales invalidas");
            return;
        }
        textFieldMensajeRecover.setText("¡Mensaje enviado!, revisa el email");
    }

}
