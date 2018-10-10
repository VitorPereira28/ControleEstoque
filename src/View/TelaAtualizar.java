package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaAtualizar extends JFrame implements ActionListener{

    private Container cont;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JButton jButton1;
    private JTextField jTxtNome;
    private JTextField jTxtNovaInf;
    private JCheckBox jcAlterar = new JCheckBox("Alterar informação");
    private JRadioButton jRad1 = new JRadioButton("Nome");
    private JRadioButton jRad2 = new JRadioButton("Categoria");
    private JRadioButton jRad3 = new JRadioButton("Quantidade");
    private ButtonGroup btGroup = new ButtonGroup();
    private JMenuBar menuBar;
    private JMenu naveMenu;
    private JMenuItem voltarMenuItem;

    //CONSTRUTOR DA CLASSE chama Metodo iniciarComponentes() que cria toda interface/componentes
    public TelaAtualizar(){
        super("ATUALIZAR PRODUTO");
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
        jButton1 = new JButton("Atualizar");
        jTxtNome = new JTextField(15);
        jTxtNovaInf = new JTextField(15);
        jTxtNovaInf.setEditable(false);
        btGroup.add(jRad1);
        btGroup.add(jRad2);
        btGroup.add(jRad3);
        
        //Adição dos componentes ao JPanel 1
        panel1.setBackground(Color.decode("#B0C4DE"));
        panel1.add(new JLabel("Nome do Produto: "));
        panel1.add(jTxtNome);
        
        //Adicao dos componentes ao JPanel 2
        panel2.setBackground(Color.decode("#B0C4DE"));
        panel2.add(new JLabel("Campo a Atualizar"));
        panel2.add(jRad1);
        panel2.add(jRad2);
        panel2.add(jRad3);

        //Adição dos componentes ao JPanel 3
        panel3.setBackground(Color.decode("#B0C4DE"));
        panel3.add(new JLabel("Nova Informação: "));
        panel3.add(jTxtNovaInf);
        panel3.add(jcAlterar);
        
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
        jcAlterar.addActionListener(this);
        jRad1.addActionListener(this);
        jRad2.addActionListener(this);
        jRad3.addActionListener(this);
        voltarMenuItem.addActionListener(this);
        
    }
         @Override
         public void actionPerformed(ActionEvent evento) {
                if(evento.getSource() == jButton1){
                 String eNome = jTxtNome.getText();
                 String eNovaInf = jTxtNovaInf.getText();
                 int campo = 0;
                 if(jRad1.isSelected()){
                     campo = 1;
                 }else if(jRad2.isSelected()){
                     campo = 2;
                 }else if(jRad3.isSelected()){
                     campo = 3;
                 }
                 ListaProdutos.atualizarProduto(eNome,eNovaInf,campo);
                 jTxtNome.setText(null);
                 jTxtNovaInf.setText(null);
                 
                }else if(evento.getSource() == voltarMenuItem){
                    new TelaMenu();
                }else if(evento.getSource() == jcAlterar){
                    if(jcAlterar.isSelected()){
                        jTxtNovaInf.setEditable(true);
                    }else{
                        jTxtNovaInf.setEditable(false);
                        jTxtNovaInf.setText(null);
                    }
                    
                }
    }
 }