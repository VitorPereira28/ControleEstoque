
package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

public class ListaProdutos {
    
    private  static ArrayList<Produto> lista = new ArrayList();
    
    //CRIAR METODOS DE RETORNA CONSULTA, EXCLUI..ETC.. AQUI NA PROPRIA CLASSE
    
    public static void consultarProduto(String nome){
        Boolean novoProduto = true;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNome().equalsIgnoreCase(nome)){
                JOptionPane.showMessageDialog(null, lista.get(i));
                novoProduto = false;
                break;
            }
        }
        if(novoProduto){
            JOptionPane.showMessageDialog(null,"Produto não encontrado!");
        }
    }
    public static void cadastrarProduto(String nome,String c, int q){
        Boolean novoProduto = true;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNome().equalsIgnoreCase(nome)){
                lista.get(i).incrementaQuantd(q);
                JOptionPane.showMessageDialog(null,"Produto já existe, quantidade adicionada!");
                novoProduto = false;
                break;
            }
        }
        if(novoProduto){
            JOptionPane.showMessageDialog(null,"Novo Produto Adicionado!");
            lista.add(new Produto(nome,c,q));
            
        }  
    }
    public static void removerProduto(String nome){
        Boolean novoProduto = true;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNome().equalsIgnoreCase(nome)){
                lista.remove(i);
                JOptionPane.showMessageDialog(null,"Produto removido!");
                novoProduto = false;
            }
        }
        if(novoProduto){
            JOptionPane.showMessageDialog(null,"Produto não existe!");
        }
    }
    public static void atualizarProduto(String nome,String e, int n2){
        Boolean novoProduto = true;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNome().equalsIgnoreCase(nome)){
                novoProduto = false;
                switch (n2) {
                    case 1:
                        lista.get(i).setNome(e);
                        JOptionPane.showMessageDialog(null,"Nome atualizado!");
                        break;
                    case 2:
                        lista.get(i).setCategoria(e);
                        JOptionPane.showMessageDialog(null,"Categoria atualizada!");
                        break;
                    case 3:
                        n2 = Integer.valueOf(e);
                        lista.get(i).setQuantd(n2);
                        JOptionPane.showMessageDialog(null,"Quantidade atualizada!");
                        break;
                    default:
                        break;
                }
            }
        }
        if(novoProduto){
        JOptionPane.showMessageDialog(null,"Produto não existe!");
        }

    }
    
    
}
