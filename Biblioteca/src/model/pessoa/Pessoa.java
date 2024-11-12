package model.pessoa;

import java.util.Scanner;

public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
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

    public void cadastrarPessoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        setNome(nome);

        System.out.println("Digite o CPF: ");
        String cpf = sc.nextLine();
        setCpf(cpf);

        System.out.println("Digite o telefone: ");
        String telefone = sc.nextLine();
        setTelefone(telefone);

        System.out.println("Digite o endereço: ");
        String endereco = sc.nextLine();
        setEndereco(endereco);

        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        setEmail(email);
    }

    public String toString(){
        return "Nome: " + this.getNome() +" - " + "CPF:"  + this.getCpf() +" - "+ "Telefone: " + this.getTelefone() +" - "+ "Email: " + this.getEmail() +" - "+ "Endereço: " + this.getEndereco() + "-";
    }
}
