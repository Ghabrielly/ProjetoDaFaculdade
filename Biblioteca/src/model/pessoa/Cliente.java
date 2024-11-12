package model.pessoa;

import java.util.Scanner;

public class Cliente extends Pessoa {
    public Cliente() {
    }
    public Cliente(String nome, String telefone, String endereco, String email, String cpf) {
        super( nome, telefone, endereco, email, cpf);
    }

}
