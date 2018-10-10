
package model;

public class Produto {
    
    private String nome;
    private String categoria;
    private int quantd;
    
    public Produto(String n, String c, int q){
       this.nome = n;
       this.categoria = c;
       this. quantd = q;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String n){
        this.nome = n;
    }
    
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String c){
        this.categoria = c;
    }
    
    public int getQuantd(){
        return quantd;
    }
    public void setQuantd(int q){
        this.quantd = q;
    }
    
    public void incrementaQuantd(int q){
        this.quantd += q;
    }
    
    @Override
    public String toString(){
        return "\n"+"Nome: "+nome+"\n"
                +"Categoria: "+categoria+"\n"
                +"Quantidade: "+quantd;
    }
}
