/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.equipamento;

import io.github.thigassantos.trabalholucio.PreencheBanco;
import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoAcessorio;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoAudio;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoImpressora3D;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoMesa;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoNotebook;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoVideo;
import java.util.Scanner;

/**
 *
 * @author Tygsv
 */
public class FactoryEquipamento {
    
    private PreencheBanco banco = PreencheBanco.getInstance();
    private int opcao;
    

    public FactoryEquipamento(int opcao, Scanner scanner,Campus campus) {
        this.opcao = opcao;
        
        if (opcao == 1) { 
                cadastrarEquipamentoAudio(scanner, campus);
            } else if (opcao == 2) {               
                cadastrarEquipamentoVideo(scanner, campus);
            } else if (opcao == 3) {
                cadastrarEquipamentoNotebook(scanner, campus);
            } else if (opcao == 4) {
                cadastrarEquipamentoImpressora3D(scanner, campus);
            } else if (opcao == 5) {
                cadastrarEquipamentoMesas(scanner, campus);
            } else if (opcao == 6) {
                cadastrarEquipamentoAcessorio(scanner, campus);
            }else if (opcao == 7) {
                return;
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println(); 
    }
    
        public void cadastrarEquipamentoAudio(Scanner scanner,Campus campus){
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return;
        }
        
        System.out.println("Digite a potencia do equipamento:");
        int potencia = scanner.nextInt();
        scanner.nextLine();                      
        
        EquipamentoAudio eqp = new EquipamentoAudio(nome,potencia);
        banco.addEquipamento(eqp);
        campus.adicionarEquipamento(eqp);
        System.out.println("Equipamento cadastrado com sucesso!");
    }
    
    public void cadastrarEquipamentoVideo(Scanner scanner,Campus campus){
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return;
        }
        
        System.out.println("Digite a marca do equipamento:");
        String marca = scanner.nextLine(); 
        
        EquipamentoVideo eqp = new EquipamentoVideo(nome,marca);
        banco.addEquipamento(eqp);
        campus.adicionarEquipamento(eqp);
        System.out.println("Equipamento cadastrado com sucesso!");
    }
    
    public void cadastrarEquipamentoNotebook(Scanner scanner,Campus campus){
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return;
        }
        
        System.out.println("Digite a marca do equipamento:");
        String marca = scanner.nextLine(); 
        
        System.out.println("Digite o modelo:");
        String modelo = scanner.nextLine();
        
        System.out.println("Digite o tamanho da tela:");
        double tamanhoTela = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Quantidade de memoria RAM:");
        int memRam = scanner.nextInt();
        scanner.nextLine();
        
        EquipamentoNotebook eqp = new EquipamentoNotebook(nome,marca,modelo,tamanhoTela,memRam);
        banco.addEquipamento(eqp);
        campus.adicionarEquipamento(eqp);
        System.out.println("Equipamento cadastrado com sucesso!");
    }
    
    public void cadastrarEquipamentoImpressora3D(Scanner scanner,Campus campus){
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return;
        }
        
        System.out.println("Digite a marca do equipamento:");
        String marca = scanner.nextLine(); 
        
        System.out.println("Digite a resolução maxima da impressora:");
        int res = scanner.nextInt();
        scanner.nextLine();
        
        EquipamentoImpressora3D eqp = new EquipamentoImpressora3D(nome,marca,res);
        banco.addEquipamento(eqp);
        campus.adicionarEquipamento(eqp);
        System.out.println("Equipamento cadastrado com sucesso!");
    }
    
    public void cadastrarEquipamentoMesas(Scanner scanner,Campus campus){
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return;
        }
        
        System.out.println("Digite a altura da mesa:");
        int alt = scanner.nextInt();
        scanner.nextLine();
        
        EquipamentoMesa eqp = new EquipamentoMesa(nome,alt);
        banco.addEquipamento(eqp);
        campus.adicionarEquipamento(eqp);
        System.out.println("Equipamento cadastrado com sucesso!");
    }
    
    public void cadastrarEquipamentoAcessorio(Scanner scanner,Campus campus){
        
        System.out.println("Digite o nome do equipamento");
        String nome = scanner.nextLine();
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do equipamento é obrigatório.");
            return;
        }
        
        EquipamentoAcessorio eqp = new EquipamentoAcessorio(nome);
        banco.addEquipamento(eqp);
        campus.adicionarEquipamento(eqp);
        System.out.println("Equipamento cadastrado com sucesso!");
    }
    
    
    
}
