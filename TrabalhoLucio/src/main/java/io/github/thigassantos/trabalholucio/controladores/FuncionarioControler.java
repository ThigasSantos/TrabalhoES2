/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tygsv
 */
public class FuncionarioControler {
      
    public List<Reserva> buscarReservaFunc(List<Funcionario> funcionarios, String nomeFuncionario) {
    for (Funcionario func : funcionarios) {
        if (func.getNome().equalsIgnoreCase(nomeFuncionario)) {
            return func.getReservas();
        }
    }
    return null;
    }
    
    public Funcionario buscarFuncionario(List<Funcionario> funcionarios, String nomeFuncionario){
        for(Funcionario func : funcionarios){
            if (func.getNome().equalsIgnoreCase(nomeFuncionario)) {
                return func;
            }
        }
        return null;
    }
    
    public Funcionario cadastrarFuncionario(){
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
