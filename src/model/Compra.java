
package model;

public class Compra {
    private Integer id_compra;
    private double valor;
    private String data_compra;
    private String nome_vendedor;
    
    public Compra(){
    }
    
    public Compra (double valor, String data_compra, String nome_vendedor){
    this.valor = valor;
    this.data_compra = data_compra;
    this.nome_vendedor = nome_vendedor;
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }
    
   
}
