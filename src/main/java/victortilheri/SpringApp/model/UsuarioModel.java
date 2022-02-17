package victortilheri.SpringApp.model;

import javax.persistence.*;

@Entity(name = "usuario")
public class UsuarioModel {

    @Id @GeneratedValue
    public Integer codigo;

    @Column(nullable = false, length = 50, name = "nome")
    public String nome;

    @Column(nullable = false, length = 16, name = "login")
    public String login;

    @Column(nullable = false, length = 16, name = "senha")
    public String senha;

    @Column(nullable = false, length = 30, name = "cidade")
    public String cidade;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
