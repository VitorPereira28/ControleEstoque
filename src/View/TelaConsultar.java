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
import javax.swing.JTextField;

public class TelaConsultar extends JFrame implements ActionListener{

    private Container cont;
    private JPanel panel1;
    private JPanel panel2;
    private JButton jButton1;
    private JTextField jTxtNome;
    private JMenuBar menuBar;
    private JMenu naveMenu;
    private JMenuItem voltarMenuItem;

    //CONSTRUTOR DA CLASSE chama Metodo iniciarComponentes() que cria toda interface/componentes
    public TelaConsultar(){
        super("CONSULTAR PRODUTO");
        iniciarComponentes();
    }

    //METODO QUE INICIA COMPONENTES
    private void iniciarComponentes() {
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont = getContentPane();
        cont.setLayout(new GridLayout(3,2));
        cont.setBackground(Color.decode("#B0C4DE"));
        setMinimumSize(new Dimension(600, 400));
        setResizable(false);

        //Um JPainel para adicionar os componentes JLabel
        panel1 = new JPanel();

        //Outro JPainel para adicionar os componentes Botoes 
        panel2 = new JPanel();
        
        //Iniciar Componentes
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        naveMenu = new JMenu("Navegar");
        menuBar.add(naveMenu);
        voltarMenuItem = new JMenuItem("Voltar ao Menu");
        naveMenu.add(voltarMenuItem);
        jButton1 = new JButton("Consultar");
        jTxtNome = new JTextField(15);
        
        //Adição dos componentes ao JPanel 1
        panel1.setBackground(Color.decode("#B0C4DE"));
        panel1.add(new JLabel("CONSULTAR UM PRODUTO: "));
        
        //Adicao dos componentes ao JPanel 2
        panel2.setBackground(Color.decode("#B0C4DE"));
        panel2.add(new JLabel("Nome: "));
        panel2.add(jTxtNome);
        panel2.add(jButton1);

        //Adição dos componentes JPanel ao JFrame
        cont.add(panel1);
        cont.add(panel2);

        //Centraliza a janela
        setLocationRelativeTo(null);
        setVisible(true);
        
        //Add Handler aos componentes
        jButton1.addActionListener(this);
        voltarMenuItem.addActionListener(this);
        
    }
         @Override
         public void actionPerformed(ActionEvent evento) {
                if(evento.getSource() == jButton1){
                 String eNome = jTxtNome.getText();
                 ListaProdutos.consultarProduto(eNome);
                 jTxtNome.setText(null);
                }else if(evento.getSource() == voltarMenuItem){
                    new TelaMenu();
                }
    }
 }