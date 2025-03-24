package es.ies.puerto.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroController extends AbstractController{
    
    @FXML TextField textFiledUsuario;

    @FXML Text textMensaje;

    @FXML Button buttonRegistrar;

    @FXML PasswordField textFieldPassword;

    @FXML PasswordField textFieldPasswordRepit;
    
    @FXML TextField textFieldNombre;

    @FXML TextField textFieldEmail;

    @FXML TextField textFieldEmailRepit;

    @FXML
    protected void onClickRegistar() {
        if (textFiledUsuario == null || textFiledUsuario.getText().isEmpty()) {
            textMensaje.setText("¡El nombre de usuario no puede ser nulo o vacio!");
            return;
        }
        if (textFieldNombre == null || textFieldNombre.getText().isEmpty()) {
            textMensaje.setText("");
            return;
        }
        if (textFieldEmail == null ||  textFieldEmail.getText().isEmpty()
                || textFieldEmailRepit == null || textFieldEmailRepit.getText().isEmpty()) {
            textMensaje.setText("");
            return;
        }

        if (textFieldPassword == null ||  textFieldPassword.getText().isEmpty() 
            || textFieldPasswordRepit == null || textFieldPasswordRepit.getText().isEmpty()
                || textFieldEmailRepit == null || textFieldEmailRepit.getText().isEmpty()) {
            textMensaje.setText("¡El password no puede ser nulo o vacio!");
            return;
        }

        if (textFieldPassword.getText().equals(textFieldPasswordRepit.getText())) {
            textMensaje.setText("¡El password es correcto");
            return;
        }

        textMensaje.setText("Valores no validos");
    }
}
