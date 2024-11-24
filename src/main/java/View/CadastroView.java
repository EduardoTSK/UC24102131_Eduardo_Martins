// @author Eduardo
package View;

import Control.CadastroControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastroView extends JFrame {

    // Componentes da interface
    private JTextField txtNome;
    private JTextField txtEmail;
    private JComboBox<String> comboPlano;
    private JButton btnCadastrar;
    private JButton btnMostrar;
    private JTextArea txtAreaClientes;
    
    public CadastroView() {
        setTitle("Cadastro de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout e componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);
        
        JLabel lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField(20);
        
        JLabel lblPlano = new JLabel("Plano:");
        comboPlano = new JComboBox<>(new String[] {"Plano Básico", "Plano Premium", "Plano VIP"});

        btnCadastrar = new JButton("Cadastrar");
        btnMostrar = new JButton("Mostrar Clientes");

        txtAreaClientes = new JTextArea(5, 20);
        txtAreaClientes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaClientes);

        // Adicionando componentes ao painel
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPlano);
        panel.add(comboPlano);
        panel.add(btnCadastrar);
        panel.add(btnMostrar);

        // Layout principal
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    // Métodos para obter dados da view
    public String getNome() {
        return txtNome.getText();
    }

    public String getEmail() {
        return txtEmail.getText();
    }

    public String getPlano() {
        return (String) comboPlano.getSelectedItem();
    }

    // Método para adicionar ouvintes de ação
    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }

    public void addMostrarListener(ActionListener listener) {
        btnMostrar.addActionListener(listener);
    }

    // Método para exibir uma mensagem
    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    // Método para exibir os clientes cadastrados
    public void exibirClientes(String texto) {
        txtAreaClientes.setText(texto);
    }
    
        public static void main(String[] args) {
         // Cria a view e o controller
         CadastroView view = new CadastroView();
         CadastroControl controller = new CadastroControl(view);

         // Exibe a janela
         view.setVisible(true);
     }
}