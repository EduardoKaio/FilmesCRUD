package model;

public class Venda {
    private Integer id_venda;
    private double valor;
    private String data_venda;
    private String nome_comprador;
    
    public Venda(){
    }
    
    public Venda (double valor, String data_venda, String nome_comprador){
    this.valor = valor;
    this.data_venda = data_venda;
    this.nome_comprador = nome_comprador;
    }
    
    public Integer getId_venda() {
        return id_venda;
    }

    public void setId_venda(Integer id_venda) {
        this.id_venda = id_venda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public String getNome_comprador() {
        return nome_comprador;
    }

    public void setNome_comprador(String nome_comprador) {
        this.nome_comprador = nome_comprador;
    }
    
}
