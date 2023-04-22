package br.com.alura.principal;

import br.com.alura.exception.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Titulo implements Comparable<Titulo> {


    private String nome;

    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDasAvaliacoes;
    private int duracaoEmMinutos;



    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano pois possui mais de 04 caracteres!");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year()) ;
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public int getTotalDasAvaliacoes() {
        return totalDasAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public void setTotalDasAvaliacoes(int totalDasAvaliacoes) {
        this.totalDasAvaliacoes = totalDasAvaliacoes;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDasAvaliacoes ++;
    }

    public double pegaMedia(Titulo outroTitulo){
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titulo titulo = (Titulo) o;
        return anoDeLancamento == titulo.anoDeLancamento && incluidoNoPlano == titulo.incluidoNoPlano && Double.compare(titulo.somaDasAvaliacoes, somaDasAvaliacoes) == 0 && totalDasAvaliacoes == titulo.totalDasAvaliacoes && duracaoEmMinutos == titulo.duracaoEmMinutos && Objects.equals(nome, titulo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeLancamento, incluidoNoPlano, somaDasAvaliacoes, totalDasAvaliacoes, duracaoEmMinutos);
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                '}';
    }

    @Override
    public int compareTo(Titulo titulo) {
        return 0;
    }
}
