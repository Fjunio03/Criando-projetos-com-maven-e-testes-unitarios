package com.seu.nome;

import java.util.logging.Logger;

public class BancoDeDados {
    private static final Logger LOGGER = Logger.getLogger(BancoDeDados.class.getName());

    protected static void iniciarConexao(){
        LOGGER.info("Iniciou Conexão");
    }
    protected static void finalizarConexao(){
        LOGGER.info("Finalizou conexão");
    }

    public static void inserirDados(){
        LOGGER.info("Inseriu dados");
    }

    public static void removerDados(){
        LOGGER.info("removeu dados");
    }

}
