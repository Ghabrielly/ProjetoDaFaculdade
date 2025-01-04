package model.pessoa;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Funcionario")
public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(String nome, String telefone, String endereco, String email, String cpf, String cargo) {
        super(nome, telefone, endereco, email, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + " - Cargo: " + this.getCargo();
    }
}
