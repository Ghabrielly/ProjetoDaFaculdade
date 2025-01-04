package model.emprestimo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

@Entity
@Table(name = "Emprestimo")
@MappedSuperclass
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmprestimo")
    private long idEmprestimo;
    @Column(name = "status")
    private String status;
    @Column(name = "dataEmprestimo")
    private String dataEmprestimo;
    @Column(name = "dataDevolucao")
    private String dataDevolucao;
    @Column(name = "dataDevolucaoPrevista")
    private String dataDevolucaoPrevista;

    public Emprestimo(String status, String dataEmprestimo, String dataDevolucao, String dataPrevista) {
        this.status = status;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolucaoPrevista = dataPrevista;
    }

    public Emprestimo() {
    }

    public Emprestimo(String dataEmprestimo, String dataDevolucao, String dataDevolucaoPrevista) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public long getIdEmprestimo() {
        return idEmprestimo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }


    public String toString() {
        return "Status: " + this.status + " - " +
                "Data de Empréstimo: " + this.dataEmprestimo + " - " +
                "Data de Devolução Prevista: " + this.dataDevolucaoPrevista + " - " +
                "Data de Devolução: " + this.dataDevolucao;
    }
}
