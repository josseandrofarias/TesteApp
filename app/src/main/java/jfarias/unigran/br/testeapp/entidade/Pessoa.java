package jfarias.unigran.br.testeapp.entidade;


import java.io.Serializable;

public class Pessoa implements Serializable{

    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer idade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    @Override
    public String toString() {
        return "Nome: " + getNome() +
                "\nSobrenome: " + getSobrenome() +
                "\nIdade: " + getIdade();
    }
}
