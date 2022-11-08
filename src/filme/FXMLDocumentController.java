/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filme;

import dao.filmeDAO;
import model.Filme;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Kayn Malícias
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtClassificacao;

    @FXML
    private TextField txtDuracao;

    @FXML
    private TableView<Filme> tableFilme;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableColumn<?, ?> colunaId;

    @FXML
    private TableColumn<?, ?> colunaGenero;

    @FXML
    private TableColumn<?, ?> colunaAno;

    @FXML
    private TableColumn<?, ?> colunaClassificacao;

    @FXML
    private TableColumn<?, ?> colunaDuracao;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btConfirmar;
  
    @FXML
    private Button btAtualizar;
    
    @FXML
    private Button btEditar;

    private int idFilmeAlterado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        carregarDadosTabela();
        btConfirmar.setDisable(true);

    }

    public void carregarDadosTabela() {
        tableFilme.getItems().clear();
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));

        filmeDAO filmeDao = new filmeDAO();
        ArrayList<Filme> filmes = filmeDao.buscarTodos();
        System.out.println("˜˜carregando dados----" + filmes.size());

        //comando para passar para javaFx
        ObservableList<Filme> itensFilmeFX = FXCollections.observableArrayList(filmes);
        // Jogar na tabela.
        tableFilme.setItems(itensFilmeFX);
    }

    public void alterar(ActionEvent event) {
        Filme filme = tableFilme.getSelectionModel().getSelectedItem();
        txtNome.setText(filme.getNome());
        txtGenero.setText(filme.getGenero());
        txtClassificacao.setText(filme.getClassificacao());
        txtAno.setText(filme.getAno());
        txtDuracao.setText(filme.getDuracao());
        idFilmeAlterado = filme.getId();
        
        btConfirmar.setDisable(false);
        btAtualizar.setDisable(true);
    }

    public void confirmarAlteracao(ActionEvent event) {

        String nome = txtNome.getText();
        String genero = txtGenero.getText();
        String classificacao = txtClassificacao.getText();
        String ano = txtAno.getText();
        String duracao = txtDuracao.getText();

        // criando um aluno novo e preenchendo 
        Filme filme = new Filme(nome, genero, classificacao, ano, duracao);
        filme.setId(idFilmeAlterado);

        //chamando o dao 
        filmeDAO dao = new filmeDAO();
        dao.update(filme);

        limparDadosFormulario();

        //atualizando dados da tabela.
        carregarDadosTabela();
        
        btConfirmar.setDisable(true);
        btAtualizar.setDisable(false);
    }

    public void remover(ActionEvent event) {
        Filme filme = tableFilme.getSelectionModel().getSelectedItem();
        filmeDAO dao = new filmeDAO();

        //apagar objeto
        dao.delete(filme.getId());

        carregarDadosTabela();

    }

    @FXML
    private void adicionarFilme(ActionEvent event) throws ClassNotFoundException {

        String nome = txtNome.getText();
        String genero = txtGenero.getText();
        String classificacao = txtClassificacao.getText();
        String ano = txtAno.getText();
        String duracao = txtDuracao.getText();

        // criando um aluno novo e preenchendo 
        Filme filme = new Filme(nome, genero, classificacao, ano, duracao);

        //chamando o dao 
        filmeDAO dao = new filmeDAO();
        dao.create(filme);

        limparDadosFormulario();

        //atualizando dados da tabela.
        carregarDadosTabela();
    }

    private void limparDadosFormulario() {
        txtNome.setText("");
        txtGenero.setText("");
        txtClassificacao.setText("");
        txtAno.setText("");
        txtDuracao.setText("");
    }

}
