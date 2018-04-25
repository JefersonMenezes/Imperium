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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import modelo.Conta;
import modelo.TipoConta;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Argon
 */
public class ContasAdminFXController implements Initializable {

    private List<Conta> contas;
    private Usuario user;

    @FXML
    private TableView<Conta> tbContas;

    @FXML
    private TableColumn<Conta, Integer> tcCodigo;

    @FXML
    private TableColumn<Conta, String> tcDescricao;

    @FXML
    private TableColumn<Conta, Double> tcSaldo;

    @FXML
    private TableColumn<Conta, String> tcTipo;

    @FXML
    private Button btAdd;

    private ObservableList<Conta> listaContas;

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

        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcSaldo.setCellValueFactory(new PropertyValueFactory<>("saldoInicial"));
        //tcTipo.setCellValueFactory(new PropertyValueFactory<>("tipoConta.tipo"));
        tcTipo.setCellValueFactory(new Callback<CellDataFeatures<Conta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Conta, String> param) {
                return new SimpleStringProperty(param.getValue().getTipoConta().getTipo());
            }
        });

        listaContas = FXCollections.observableArrayList(contas);

        tbContas.setItems(listaContas);

    }

}
