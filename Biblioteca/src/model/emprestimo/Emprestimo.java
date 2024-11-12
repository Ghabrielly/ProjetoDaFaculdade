package model.emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Emprestimo {
    private int idEmprestimo;
    private String status;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String dataDevolucaoPrevista;

    public Emprestimo(int idEmprestimo, String status, String dataEmprestimo, String dataDevolucao, String dataPrevista) {
        this.idEmprestimo = idEmprestimo;
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

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
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

    public void realizarEmprestimo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Data emprestimo: ");
        String dataEmprestimo = sc.nextLine();
        setDataEmprestimo(dataEmprestimo);

        System.out.println("Data de devolução: ");
        String dataDevolucao = sc.nextLine();
        setDataDevolucao(dataDevolucao);

        System.out.println("Data prevista: ");
        String dataDevolucaoPrevista = sc.nextLine();
        setDataDevolucaoPrevista(dataDevolucaoPrevista);

        System.out.println("Status: ");
        String Status = sc.nextLine();
        setStatus(status);
    }

    public String toString() {
        return "Status: " + this.status + " - " +
                "Data de Empréstimo: " + this.dataEmprestimo + " - " +
                "Data de Devolução Prevista: " + this.dataDevolucaoPrevista + " - " +
                "Data de Devolução: " + this.dataDevolucao;
    }
}
