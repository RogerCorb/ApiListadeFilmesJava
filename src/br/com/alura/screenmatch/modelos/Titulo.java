package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErrorDeConversaoException;

public class Titulo implements  Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacao;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4) {
            throw new ErrorDeConversaoException("Não consegui converter ano pois o mesmo está vindo com mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos=Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    public void exibeFichaTecnica() {
        System.out.println("nome do filme " + nome );
        System.out.println("Ano de lançamento " + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaAvaliacao += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaAvaliacao / totalDeAvaliacoes;
    }


    // Getters and Setters //

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }


    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
    @Override
    public String toString() {
        return  "(nome: " + nome +
                ", anoDeLancamento: " + anoDeLancamento +
                ",duração: " + duracaoEmMinutos + " min)";
    }
}
