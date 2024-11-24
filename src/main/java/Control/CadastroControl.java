// @author Eduardo
package Control;

import Model.ClienteModel;
import View.CadastroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroControl {

    private CadastroView view;
    private ArrayList<ClienteModel> clientes;

    public CadastroControl(CadastroView view) {
        this.view = view;
        this.clientes = new ArrayList<>();

        // Adiciona ouvintes de ação
        this.view.addCadastrarListener(new CadastrarListener());
        this.view.addMostrarListener(new MostrarListener());
    }

    // Listener para o botão Cadastrar
    class CadastrarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = view.getNome();
            String email = view.getEmail();
            String plano = view.getPlano();

            // Validações simples
            if (nome.isEmpty() || email.isEmpty()) {
                view.exibirMensagem("Por favor, preencha todos os campos.");
            } else {
                // Cria um novo cliente e adiciona à lista
                ClienteModel cliente = new ClienteModel(nome, email, plano);
                clientes.add(cliente);
                view.exibirMensagem("Cliente cadastrado com sucesso!");
            }
        }
    }

    // Listener para o botão Mostrar Clientes
    class MostrarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            for (ClienteModel cliente : clientes) {
                sb.append("Nome: ").append(cliente.getNome())
                  .append(", Email: ").append(cliente.getEmail())
                  .append(", Plano: ").append(cliente.getPlano())
                  .append("\n");
            }
            view.exibirClientes(sb.toString());
        }
    }
}

