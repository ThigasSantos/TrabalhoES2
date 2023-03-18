/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.thigassantos.trabalholucio;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.controladores.LugarControler;
import io.github.thigassantos.trabalholucio.controladores.ReservaControler;
import java.util.Scanner;

public class TrabalhoLucio {  
    
        private static PreencheBanco banco= new PreencheBanco();
        private static LugarControler lug = new LugarControler();
        private static ReservaControler res = new ReservaControler();
    
    public static void main(String[] args) {
        
        banco.preencherBanco();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de reservas de salas!");
        System.out.println();

        while (true) {            
            System.out.println("Escolha o Campus:");
              for(Campus campusNow: banco.getCampusTD())
              {
                System.out.println(campusNow.getNome());
              }
            String nomeCampus = scanner.nextLine();           
            Campus campusNow = lug.buscarCampus(banco.getCampusTD(), nomeCampus); 
           
            while(true){               
               if(campusNow == null){
                System.out.println("Campus invalido digite novamente:");
                nomeCampus = scanner.nextLine();           
                campusNow = lug.buscarCampus(banco.getCampusTD(), nomeCampus); 
                }else{
                   break;
                }              
            }
                                        
            System.out.println("Escolha uma opção:");                                
            System.out.println("1. Verificar disponibilidade por data");
            System.out.println("2. Verificar ocupação da sala");
            System.out.println("3. Realizar reserva de sala");
            System.out.println("4. Verificar reservas do funcionario");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                res.verificarDisponibilidade(scanner,campusNow.getEquipamentos(),banco.getSalas(),banco.getFuncionarios(),banco.getReservas() );
            } else if (opcao == 2) {
                res.verificarOcupacao(scanner,banco.getSalas());
            } else if (opcao == 3) {
                res.verificarDisponibilidade(scanner,campusNow.getEquipamentos(),banco.getSalas(),banco.getFuncionarios(),banco.getReservas() );
            } else if (opcao == 4) {
                res.verificarReservasFuncionario(scanner,banco.getFuncionarios(),banco.getReservas());
            } else if (opcao == 5) {
                System.out.println("Saindo do sistema de reservas de salas...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println();
        }
               
    }         
    
}
