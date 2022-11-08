package model;

import java.util.UUID;

public class Filme {

    private Integer id;
    private String nome;
    private String genero;
    private String classificacao;
    private String ano;
    private String duracao;
    
     public Filme(){
    }
    
    public Filme(String nome, String genero, String classificacao, String ano, String duracao) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.ano = ano;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Integer getId() {
        return id;
    }

     public void setId(Integer id) {
        this.id = id;
    }
}
