package model.pessoa;

import jakarta.persistence.*;

import java.util.Scanner;
import java.util.UUID;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
public class Pessoa {
    @Id
    @Column(name = "idPessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String endereco, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String cpf, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString() {
        return "Nome: " + this.getNome() + " - " + "CPF:" + this.getCpf() + " - " + "Telefone: " + this.getTelefone() + " - " + "Email: " + this.getEmail() + " - " + "Endereço: " + this.getEndereco() + "-";
    }

    public long getId() {
        return this.id = id;
    }
}
