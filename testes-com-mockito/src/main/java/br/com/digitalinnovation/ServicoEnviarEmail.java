package br.com.digitalinnovation;

public class ServicoEnviarEmail {
    private PlataformaDeEnvio plataforma;

    void enviarEmail(String enderecoEmail, String mensagem, String formatoHtml){
        Email email = null;

        if(formatoHtml.equalsIgnoreCase("html")){
            email = new Email(enderecoEmail, mensagem, formatoHtml);
        }else{
            email = new Email(enderecoEmail, mensagem, formatoHtml);
        }

        plataforma.enviarEmail(email);
    }
}
