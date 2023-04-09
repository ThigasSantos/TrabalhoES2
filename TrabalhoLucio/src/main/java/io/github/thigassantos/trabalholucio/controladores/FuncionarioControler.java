/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import java.util.List;
import java.util.Scanner;

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
    
    
    public static Funcionario cadastrarFuncionario(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do funcionário");
        String nome = scanner.nextLine();
        System.out.println("Digite o cargo do funcionário");
        String cargo = scanner.nextLine();
        System.out.println("Digite o ramal do funcionário");
        String ramal = scanner.nextLine();
        
        
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do funcionario é obrigatório.");
            return null;
        }
        
        Funcionario funcionario = new Funcionario(nome,cargo,ramal);
 
        return funcionario;
    }
}
