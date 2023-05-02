/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.PreencheBanco;
import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.equipamento.FactoryEquipamento;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class EquipamentoControler {
    
    private LugarControler lug = new LugarControler();
    
    public void cadastrarEquipamento(){
        Scanner scanner = new Scanner(System.in);
                            
        System.out.println("Indique o tipo de equipmento:");
        System.out.println("1 - Equipamento de Som");
        System.out.println("2 - Equipamento de Video");
        System.out.println("3 - Notebook");
        System.out.println("4 - Impressora 3D");
        System.out.println("5 - Mesas");
        System.out.println("6 - Acessórios");
        System.out.println("7 - Voltar");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Esse equipamento irá para qual campus ?");
        String nomeCampus = scanner.nextLine();
        
        Campus campus = lug.buscarCampus(nomeCampus);
                
        while(true){
            if(campus == null){
                System.out.println("Campus incorreto tente novamente:");
                nomeCampus = scanner.nextLine();   
                campus = lug.buscarCampus( nomeCampus);
            }else
                break;           
            }
        
        FactoryEquipamento fac = new FactoryEquipamento(opcao, scanner, campus);
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
