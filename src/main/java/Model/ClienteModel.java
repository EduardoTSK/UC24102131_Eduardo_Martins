// @author Eduardo
package Model;

public class ClienteModel {
    private String nome;
    private String email;
    private String plano;

    public ClienteModel(String nome, String email, String plano) {
        this.nome = nome;
        this.email = email;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
}