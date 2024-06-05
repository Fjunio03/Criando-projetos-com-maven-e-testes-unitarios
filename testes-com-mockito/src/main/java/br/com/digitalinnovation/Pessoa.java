package br.com.digitalinnovation;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String documento;
    private LocalDate nascimento;
    private DadosLocalizacao endereco;

    public Pessoa(final String nome, final String documento, final LocalDate nascimento) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
    }

    public void adicionarEndereco(DadosLocalizacao dadosLocalizacao){
        this.endereco= dadosLocalizacao;
    }

    public DadosLocalizacao getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
}
