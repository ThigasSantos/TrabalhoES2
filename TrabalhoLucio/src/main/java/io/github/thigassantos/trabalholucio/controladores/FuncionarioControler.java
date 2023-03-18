/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class FuncionarioControler {
    
    public static Funcionario buscarFuncionario(List<Funcionario> funcionarios, String nome) {
    for (Funcionario funcionario : funcionarios) {
        if (funcionario.getNome().equalsIgnoreCase(nome)) {
            return funcionario;
        }
    }
    return null;
    }
    
}
