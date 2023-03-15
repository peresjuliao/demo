package com.example.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@ToString
@Builder(builderMethodName = "hiddenBuilder")
@NoArgsConstructor
public class GerirPacotes {
    private BigDecimal valor;
    private Integer consultaSimplesAdquiridas;
    private Integer consultaCompletaAdquiridas;
    private String dataHoraCompra;
    private Integer consultaSimplesRestantes;
    private Integer consultaCompletaRestantes;
    private String dataExpiracao;
    private String diasExpiracao;
    private String status;
    private String contrato;
    private BigDecimal valorReembolso;

    public BigDecimal calcularReembolso() {
        if (!"ENCERRADO".equals(status)) {
            return null;
        }
        BigDecimal valorTotalConsultas = new BigDecimal(consultaSimplesAdquiridas + consultaCompletaAdquiridas);
        BigDecimal valorConsulta = valor.divide(valorTotalConsultas, 2, RoundingMode.HALF_EVEN);
        BigDecimal consultasNaoRealizadas = new BigDecimal((consultaSimplesAdquiridas + consultaCompletaAdquiridas) - (consultaSimplesRestantes + consultaCompletaRestantes));
        BigDecimal valorReembolsado = valorConsulta.multiply(consultasNaoRealizadas);
        return valorReembolsado;
    }

    public static GerirPacotesBuilder builder() {
        return hiddenBuilder().valorReembolso(null);
    }

    @Builder(builderMethodName = "hiddenBuilder")
    public GerirPacotes(BigDecimal valor, Integer consultaSimplesAdquiridas, Integer consultaCompletaAdquiridas, String dataHoraCompra,
                        Integer consultaSimplesRestantes, Integer consultaCompletaRestantes, String dataExpiracao, String diasExpiracao,
                        String status, String contrato, BigDecimal valorReembolso) {
        this.valor = valor;
        this.consultaSimplesAdquiridas = consultaSimplesAdquiridas;
        this.consultaCompletaAdquiridas = consultaCompletaAdquiridas;
        this.dataHoraCompra = dataHoraCompra;
        this.consultaSimplesRestantes = consultaSimplesRestantes;
        this.consultaCompletaRestantes = consultaCompletaRestantes;
        this.dataExpiracao = dataExpiracao;
        this.diasExpiracao = diasExpiracao;
        this.status = status;
        this.contrato = contrato;
        this.valorReembolso = valorReembolso;
        if (valorReembolso == null) {
            this.valorReembolso = calcularReembolso();
        }
    }
}
