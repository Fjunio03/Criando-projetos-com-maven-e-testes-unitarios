package br.com.digitalinnovation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnviarEmailTest {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnviarEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaAPlataforma(){
        String enderecoDeEmail = "usuario@emial.com.br";
        String mensagem = "Teste de mensagem";
        String formatoHtml = "Html";

        servico.enviarEmail(enderecoDeEmail, mensagem, formatoHtml);

        Mockito.verify(plataforma).enviarEmail(captor.capture());

        Email emailcapturado = captor.getValue();

        Assertions.assertEquals(enderecoDeEmail, emailcapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailcapturado.getMensagem());
        Assertions.assertEquals(formatoHtml, emailcapturado.getFormato());
    }
}
