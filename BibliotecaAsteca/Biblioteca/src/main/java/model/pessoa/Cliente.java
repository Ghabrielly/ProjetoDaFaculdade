package model.pessoa;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Cliente")
public class Cliente extends Pessoa {
    public Cliente() {
    }

    public Cliente(String nome, String telefone, String endereco, String email, String cpf) {
        super(nome, telefone, endereco, email, cpf);
    }
}
