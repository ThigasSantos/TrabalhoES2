/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Endereco;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tygsv
 */
public class LugarControler {
    
     public static Sala buscarSala(List<Sala> salas, int numero) {
    for (Sala sala : salas) {
        if (sala.getNumero() == numero) {
            return sala;
        }
    }
    return null;
    }
     
    public static Campus cadastrarCampus(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do campus");
        String nome = scanner.nextLine();
        
        System.out.println("Digite o endereço:");
        System.out.println("Cidade:");
        String cidade = scanner.nextLine();
        System.out.println("Rua:");
        String rua = scanner.nextLine();
        System.out.println("Bairro:");
        String bairro = scanner.nextLine();
        System.out.println("Numero:");
        int numero = scanner.nextInt();
        scanner.nextLine();
        
        // validações adicionais
        if (nome.isEmpty()) {
            System.out.println("O nome do campus é obrigatório.");
            return null;
        }
        
        Endereco endereco = new Endereco(cidade,rua,bairro,numero);
        Campus campus = new Campus(nome, endereco);
        
        return campus;
    }
    
    public static Equipamento buscarEquipamento(List<Equipamento> equipamentos, String nome) {
    for (Equipamento equipamento : equipamentos) {
        if (equipamento.getNome().equalsIgnoreCase(nome)) {
            return equipamento;
        }
    }
    return null;
    }
    
    public static Campus buscarCampus(List<Campus> campusTD, String nome) {
    for (Campus campus : campusTD) {
        if (campus.getNome().equalsIgnoreCase(nome)) {
            return campus;
        }
    }
    return null;
    }
}
