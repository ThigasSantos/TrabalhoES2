/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class EquipamentoControler {

    /**
     *
     * @return
     */  
    public Equipamento cadastrarEquipamento(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return null;
        }
        
        Equipamento equipamento = new Equipamento(nome);
 
        return equipamento;
    }
    
    public boolean existeEquipamento(List<Equipamento> equipamentos,String nome){
        for (Equipamento equipamento : equipamentos) {
        if (equipamento.getNome().equals(nome)) {
            return true;
        }
    }
        return false;
    }
    
}
