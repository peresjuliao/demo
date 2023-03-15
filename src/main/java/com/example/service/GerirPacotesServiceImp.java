package com.example.service;

import com.example.model.GerirPacotes;

public class GerirPacotesServiceImp {

    public GerirPacotes createGerirPacotes(GerirPacotes gerirPacotes) {
        return GerirPacotes.builder()
                .valor(gerirPacotes.getValor())
                .consultaSimplesAdquiridas(gerirPacotes.getConsultaSimplesAdquiridas())
                .consultaCompletaAdquiridas(gerirPacotes.getConsultaCompletaAdquiridas())
                .dataHoraCompra(gerirPacotes.getDataHoraCompra())
                .consultaSimplesRestantes(gerirPacotes.getConsultaSimplesRestantes())
                .consultaCompletaRestantes(gerirPacotes.getConsultaCompletaRestantes())
                .dataExpiracao(gerirPacotes.getDataExpiracao())
                .diasExpiracao(gerirPacotes.getDiasExpiracao())
                .status(gerirPacotes.getStatus())
                .contrato(gerirPacotes.getContrato())
                .build();
    }
}
