package com.seu.nome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class CondicionalTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "junio")
    void  validarAlgoSomenteNoUsuarioJunio(){
        Assertions.assertEquals(10, 5+5);
    }
}
