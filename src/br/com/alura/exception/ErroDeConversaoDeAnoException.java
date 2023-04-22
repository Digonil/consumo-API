package br.com.alura.exception;

public class ErroDeConversaoDeAnoException extends RuntimeException {

    String mensagem;
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
