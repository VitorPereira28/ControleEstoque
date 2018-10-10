package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaMenu extends JFrame implements ActionListener{

    private Container cont;
    private JPanel panel1;
    private JPanel panel2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu naveMenu = new JMenu("Navegar");
    private JMenuItem deslogItem = new JMenuItem("Deslogar");

    public TelaMenu(){
        super("MENU");
        iniciarComponentes();
    }

    private void iniciarComponentes() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cont = getContentPane();
        cont.setLayout(new GridLayout(3,2));
        cont.setBackground(Color.decode("#B0C4DE"));
        setMinimumSize(new Dimension(600, 400));
        setResizable(false);
        setJMenuBar(menuBar);
        menuBar.add(naveMenu);
        naveMenu.add(deslogItem);

        //Um JPainel para adicionar os componentes JLabel
        panel1 = new JPanel();

        //Outro JPainel para adicionar os componentes Botoes 
        panel2 = new JPanel();
        
        //Iniciar Componentes
        jButton1 = new JButton("Consultar");
        jButton2 = new JButton("Cadastrar");
        jButton3 = new JButton("Atualizar");
        jButton4 = new JButton("Excluir");
        
        //Adição dos componentes ao JPanel 1
        panel1.setBackground(Color.decode("#B0C4DE"));
        panel1.add(new JLabel("OPÇÕES ESTOQUE DE PRODUTOS: "));
        
        //Adicao dos componentes ao JPanel 2
        panel2.setBackground(Color.decode("#B0C4DE"));
        panel2.add(jButton1);
        panel2.add(jButton2);
        panel2.add(jButton3);
        panel2.add(jButton4);

        //Adição dos componentes JPanel ao JFrame
        cont.add(panel1);
        cont.add(panel2);

        //Centraliza a janela
        setLocationRelativeTo(null);
        setVisible(true);
        
        //Add Handler aos componentes
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        deslogItem.addActionListener(this);
    }
         @Override
         public void actionPerformed(ActionEvent evento) {
             if(evento.getSource() == jButton1){
                 new TelaConsultar();
                 dispose();
                 System.gc();
             }else if(evento.getSource() == jButton2){
                 new TelaCadastrar();
                 dispose();
                 System.gc();
             }else if(evento.getSource() == jButton3){
                 new TelaAtualizar();
                 dispose();
                 System.gc();
             }else if(evento.getSource() == jButton4){
                 new TelaExcluir();
                 dispose();
                 System.gc();
             }else if(evento.getSource() == deslogItem){
                 new TelaInicial();
                 dispose();
                 System.gc(); 
        }
    }
    
 }