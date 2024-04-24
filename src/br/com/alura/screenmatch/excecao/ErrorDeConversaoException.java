package br.com.alura.screenmatch.excecao;

public class ErrorDeConversaoException extends RuntimeException{
    private String mensagem;
    public ErrorDeConversaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
