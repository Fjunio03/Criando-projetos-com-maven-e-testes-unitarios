package br.com.digitalinnovation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {

    //PODE SE USR DESSA FORMA TAMBEM
    /*
     * @BeforeAll
     * void setUp(){
     *      MockitoAnnotations.initMocks(this);
     * }
     * private ApiDosCorreios apiDosCorreios = Mockito.mock(ApiDosCorreios.class);
     *
     **/

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){

        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Belo Horizonte", "Rua  Fulano de Tal", "Casa", "Centro");

        Mockito.when(apiDosCorreios.buscarDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);

        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Flavio","6546545645", LocalDate.now(), "31615250");

        Assertions.assertEquals("Flavio", pessoa.getNome());
        Assertions.assertEquals("6546545645", pessoa.getDocumento());
        Assertions.assertEquals("MG", pessoa.getEndereco().getUf());
        Assertions.assertEquals("Casa", pessoa.getEndereco().getComplemento());


    }

    @Test
    void lancarExceptionQuandoChamarApiDosCorreios(){

        Mockito.when(apiDosCorreios.buscarDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);

        //Mockito.doThrow(IllegalArgumentException.class).when(apiDosCorreios).buscarDadosComBaseNoCep(AnyString());

        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Flavio","6546545645", LocalDate.now(), "31615250"));
    }


}
