package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaInicial extends JFrame implements ActionListener, FocusListener{

    private Container cont;
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JTextField jTextLogin = new JTextField(20);
    private JPasswordField jPasswordSenha = new JPasswordField(20);
    private JButton jButton1 = new JButton("Efetuar Login");
    private JLabel jlLogin = new JLabel("CONTROLE DO ESTOQUE");

    public TelaInicial() {
        super("LOGIN - Estoque de Produtos");
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cont = getContentPane();
        cont.setLayout(new GridLayout(5,2));
        cont.setBackground(Color.decode("#B0C4DE"));
        setMinimumSize(new Dimension(600, 400));
        setResizable(false);
        
        //Adicao dos componentes ao JPanel 1
        panel1.setBackground(Color.decode("#B0C4DE"));
        jlLogin.setFont(new Font("Courier" , Font.ITALIC, 23));
        panel1.add(jlLogin);
        
        //Adição dos componentes ao JPanel 2
        panel2.setBackground(Color.decode("#B0C4DE"));
        panel2.add(new JLabel("Login: "));
        panel2.add(jTextLogin);

        //Adição dos componentes ao JPanel 3
        panel3.setBackground(Color.decode("#B0C4DE"));
        panel3.add(new JLabel("Senha"));
        panel3.add(jPasswordSenha);
        
        //Adicao dos componentes ao JPanel 4
        panel4.setBackground(Color.decode("#B0C4DE"));
        panel4.add(jButton1);

        //Adição dos componentes JPanel ao JFrame
        cont.add(panel1);
        cont.add(panel2);
        cont.add(panel3);
        cont.add(panel4);
        
        //Centralizar Tela
        setLocationRelativeTo(null);
        setVisible(true);
        
        jButton1.addActionListener(this);
        jTextLogin.addFocusListener(this);
    }

        @Override
        public void actionPerformed(ActionEvent evento) {
             JOptionPane.showMessageDialog(null,"Bem-Vindo!");
             new TelaMenu();
             dispose();
             System.gc();
    }

    @Override
    public void focusGained(FocusEvent e) {
        jTextLogin.setText(null);
        jTextLogin.setForeground(Color.black);
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        jTextLogin.setForeground(Color.gray);
        jTextLogin.setText("seuemail@email.com");
    }
    
 }