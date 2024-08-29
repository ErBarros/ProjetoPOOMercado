package controller;

import model.Almoxarife;

import java.util.Map;

public class AlmoxarifeController {
    public void cadastrarAlmoxarife(Map<String, String> dados) {
        // Cria um novo Almoxarife com os dados fornecidos
        Almoxarife almoxarife = new Almoxarife(
                dados.get("nome"),
                dados.get("login"),
                dados.get("senha"),
                dados.get("email"),
                dados.get("nisPis")
        );
        // Lógica para armazenar o almoxarife no sistema
    }
}