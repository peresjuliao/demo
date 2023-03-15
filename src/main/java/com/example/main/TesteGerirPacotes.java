package com.example.main;

import com.example.model.GerirPacotes;
import com.example.service.GerirPacotesServiceImp;
import com.google.gson.Gson;

import java.math.BigDecimal;

public class TesteGerirPacotes {

    public static void main(String[] args) {
        GerirPacotes gerirPacotes = new GerirPacotes();
        gerirPacotes.setValor(new BigDecimal("36.90"));
        gerirPacotes.setConsultaSimplesAdquiridas(5);
        gerirPacotes.setConsultaCompletaAdquiridas(5);
        gerirPacotes.setDataHoraCompra("2022-10-01 15:00:00");
        gerirPacotes.setConsultaSimplesRestantes(2);
        gerirPacotes.setConsultaCompletaRestantes(1);
        gerirPacotes.setDataExpiracao("2022-03-31");
        gerirPacotes.setDiasExpiracao("15");
        gerirPacotes.setStatus("ENCERRADO");
        gerirPacotes.setContrato("123456");

        GerirPacotesServiceImp gerirPacotesServiceImp = new GerirPacotesServiceImp();
        GerirPacotes pacotes = gerirPacotesServiceImp.createGerirPacotes(gerirPacotes);


        Gson gson = new Gson();
        String json = gson.toJson(pacotes);
        System.out.println(json);

    }
}
