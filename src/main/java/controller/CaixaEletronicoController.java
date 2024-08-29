package controller;

import model.CaixaEletronico;

import java.util.Map;

public class CaixaEletronicoController {
    public void cadastrarCaixaEletronico(Map<String, String> dados) {
        // Cria um novo CaixaEletronico com os dados fornecidos
        CaixaEletronico caixa = new CaixaEletronico(
                dados.get("nome"),
                dados.get("login"),
                dados.get("senha"),
                dados.get("email"),
                dados.get("nisPis")
        );
        // Lógica para armazenar o caixa eletrônico no sistema
    }
}