package model.emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Multa extends Emprestimo {
    private int idMulta;
    private String statusPagamento;
    private double valorMulta;
    private static final double VALOR_MULTA_DIARIA = 5.99;
    private String dataMulta;

    public Multa(String dataEmprestimo, String dataDevolucao, String dataDevolucaoPrevista, int idMulta, String statusPagamento, double valor, String dataMulta) {
        super(dataEmprestimo, dataDevolucao, dataDevolucaoPrevista);
        this.idMulta = idMulta;
        this.statusPagamento = statusPagamento;
        this.valorMulta = valor;
        this.dataMulta = dataMulta;
    }

    public Multa() {
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public double getValor() {
        return valorMulta;
    }

    public void setValor(double valor) {
        this.valorMulta = valor;
    }

    public String getDataMulta() {
        return dataMulta;
    }

    public void setDataMulta(String dataMulta) {
        this.dataMulta = dataMulta;
    }

    public boolean verificarDevolucaoAtrasada() {
        if (getDataDevolucao() == null || getDataDevolucaoPrevista() == null) {
            System.out.println("Não há informações suficientes para calcular a multa.");
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataDevolucao;
        LocalDate dataPrevista;

        try {
            dataDevolucao = LocalDate.parse(getDataDevolucao(), formatter);
            dataPrevista = LocalDate.parse(getDataDevolucaoPrevista(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Datas informadas estão no formato inválido.");
            return false;
        }
        if (dataDevolucao.isAfter(dataPrevista)) {
            long diasAtraso = ChronoUnit.DAYS.between(dataPrevista, dataDevolucao);
            System.out.println("Você possui multa. Dias atrasados: " + diasAtraso);
            valorMulta = calcularMulta(diasAtraso);
            System.out.println("Valor da multa: R$ " + String.format("%.2f", valorMulta));
            return true;
        } else {
            System.out.println("Você não possui multa.");
            return false;
        }
    }

    public double calcularMulta(long diasAtraso) {
        return diasAtraso * VALOR_MULTA_DIARIA;
    }
}
