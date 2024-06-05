package com.seu.nome;

import org.junit.jupiter.api.*;


public class ConsultarDadosDePessoaTest {

    @BeforeAll
    static void configurarConexao(){
        BancoDeDados.iniciarConexao();
        System.out.println("Rodou configurarConexao");

    }
    @BeforeEach
    void insereDadosParaTeste(){
        BancoDeDados.inserirDados();
    }

    @Test
    void validarDadosDeRetorno(){
        Assertions.assertTrue(true);
    }
    @Test
    void validarDadosDeRetorno2(){
        Assertions.assertNull(null);
    }

    @AfterEach
    void removeDadosDoTeste(){
        BancoDeDados.removerDados();
    }

    @AfterAll
    static void finalizarConexao(){
        BancoDeDados.finalizarConexao();
        System.out.println("Rodou finalizarConexao");

    }
}
