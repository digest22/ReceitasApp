package com.example.aluno.receitas;

import com.orm.SugarRecord;

/**
 * Created by aluno on 16/09/19.
 */

public class Receita extends SugarRecord {

    private String nome;
    private String modoPreparo;
    private String ingredientes;
    private String imagem;


    public Receita() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
