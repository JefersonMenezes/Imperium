/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContaDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import modelo.Conta;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Argon
 */
public class ContasAdminFXController implements Initializable {

    private List<Conta> contas;
    private Usuario user;

    public ContasAdminFXController(Usuario usuario) {
        this.user = usuario;
    }

    public ContasAdminFXController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaContas();
    }

    private void listaContas() {
        ContaDAO dao = new ContaDAO();
        contas = dao.listaContasUser(user);

        montaTabela();
    }

    private void montaTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
