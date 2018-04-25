/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxVisao;

import controller.ContasAdminFXController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 *
 * @author Argon
 */
public class ContasAdminFX extends Application {

    private static Usuario user;

    public static void setUser(Usuario usuario) {
        ContasAdminFX.user = usuario;
    }

    public static Usuario getUser() {
        return ContasAdminFX.user;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxVisao/ContasAdminFX.fxml"));
        fxmlloader.setController(new ContasAdminFXController(user));
        stage.setScene(new Scene(fxmlloader.load()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
