/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Filme;

/**
 *
 * @author Kayn Malícias
 */
public class filmeDAOFake {
    private static ArrayList<Filme> lista = new ArrayList<>();

  
    /**
     * Simulando o insert do banco.
     * @param a 
     */
    public static void create(Filme a ){
        lista.add(a);
    }
    
   public static void alterarFilme(String id, Filme filmeNovo) {
       for(Filme a : lista){
            if( a.getId().equals(id) ) {
                
                System.out.println("--- entrou");
                a.setNome(filmeNovo.getNome());
                a.setGenero(filmeNovo.getGenero());
                a.setClassificacao(filmeNovo.getClassificacao());
                a.setAno(filmeNovo.getAno());
                a.setDuracao(filmeNovo.getDuracao());

            }
        } 
}
    
    public static void remove(Filme a ){
        lista.remove(a);
    }
    
    public static ArrayList<Filme> retornaTodos(){
        return lista;
    }
    
    public static Filme buscaPorId( String id_buscador ){
        Filme retorno=null;
        
        for(Filme a : lista ){
            if( a.getId().equals( id_buscador ) ){
                retorno = a; 
            }
        }
        return retorno;
    }

    public ArrayList<Filme> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Filme> lista) {
        this.lista = lista;
    }
    
    
}
    
