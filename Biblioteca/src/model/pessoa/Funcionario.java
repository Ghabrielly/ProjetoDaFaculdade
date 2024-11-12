package model.pessoa;

import java.util.Scanner;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(String nome, String telefone, String endereco, String email, String cpf, String cargo) {
        super(nome,telefone, endereco,  email, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void cadastrarPessoa() {
        super.cadastrarPessoa();

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cargo: ");
        String cargo = sc.nextLine();
        setCargo(cargo);
    }

    public String toString() {
        return super.toString() + " - Cargo: " + this.getCargo();
    }
}
