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
    public static Equipamento cadastrarEquipamento(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        System.out.println("Digite o patrimonio do equipamento");
        String patrimonio = scanner.nextLine();
        
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do patrimonio é obrigatório.");
            return null;
        }
        
        Equipamento equipamento = new Equipamento(nome,patrimonio);
 
        return equipamento;
    }
    
    public static Equipamento buscarEquipamento(List<Equipamento> equipamentos, String nome) {
    for (Equipamento equipamento : equipamentos) {
        if (equipamento.getNome().equalsIgnoreCase(nome)) {
            return equipamento;
        }
    }
    return null;
    }
}
