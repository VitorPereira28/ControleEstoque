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

public class TelaCadastrar extends JFrame implements ActionListener{

    private Container cont;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JButton jButton1;
    private JTextField jTxtNome;
    private JTextField jTxtCate;
    private JTextField jTxtQuantd;
    private JMenuBar menuBar;
    private JMenu naveMenu;
    private JMenuItem voltarMenuItem;

    //CONSTRUTOR DA CLASSE chama Metodo iniciarComponentes() que cria toda interface/componentes
    public TelaCadastrar(){
        super("CADASTRAR PRODUTO");
        iniciarComponentes();
    }

    //METODO QUE INICIA COMPONENTES
    private void iniciarComponentes() {
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont = getContentPane();
        cont.setLayout(new GridLayout(4,2));
        cont.setBackground(Color.decode("#B0C4DE"));
        setMinimumSize(new Dimension(600, 400));
        setResizable(false);

        //Iniciar Panels
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        
        
        //Iniciar Componentes
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        naveMenu = new JMenu("Navegar");
        menuBar.add(naveMenu);
        voltarMenuItem = new JMenuItem("Voltar ao Menu");
        naveMenu.add(voltarMenuItem);
        jButton1 = new JButton("Cadastrar");
        jTxtNome = new JTextField(15);
        jTxtCate = new JTextField(15);
        jTxtQuantd = new JTextField(15);
        
        //Adição dos componentes ao JPanel 1
        panel1.setBackground(Color.decode("#B0C4DE"));
        panel1.add(new JLabel("Nome: "));
        panel1.add(jTxtNome);

        
        //Adicao dos componentes ao JPanel 2
        panel2.setBackground(Color.decode("#B0C4DE"));
        panel2.add(new JLabel("Categoria: "));
        panel2.add(jTxtCate);
        
        
        //Adição dos componentes ao JPanel 3
        panel3.setBackground(Color.decode("#B0C4DE"));
        panel3.add(new JLabel("Quantidade: "));
        panel3.add(jTxtQuantd);
        
        //Adição dos componentes ao JPanel 4
        panel4.setBackground(Color.decode("#B0C4DE"));
        panel4.add(jButton1);

        //Adição dos componentes JPanel ao JFrame
        cont.add(panel1);
        cont.add(panel2);
        cont.add(panel3);
        cont.add(panel4);

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
                 String eCate = jTxtCate.getText();
                 int eQuantd = Integer.parseInt(jTxtQuantd.getText());
                 ListaProdutos.cadastrarProduto(eNome,eCate,eQuantd);
                 jTxtNome.setText(null);
                 jTxtCate.setText(null);
                 jTxtQuantd.setText(null);
                 
                }else if(evento.getSource() == voltarMenuItem){
                    new TelaMenu();
                }
    }
 }