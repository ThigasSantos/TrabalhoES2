/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Endereco;
import io.github.thigassantos.trabalholucio.classes.campus.Predio;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import static io.github.thigassantos.trabalholucio.controladores.FuncionarioControler.buscarFuncionario;
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
     
    public static Campus cadastrarCampus(List<Campus> campusTD){
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
        campusTD.add(campus);
        return campus;
    }
    
    public static Predio cadastrarPredio(List<Campus> campusTD){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do campus");
        String nome_campus = scanner.nextLine();
        
        Campus campus = new Campus();
        campus = buscarCampus(campusTD, nome_campus);
        while(true){
            if(campus == null)
            {
                System.out.println("Nome do campus digitado errado, digite novamente:");
                nome_campus = scanner.nextLine();
                campus= buscarCampus(campusTD,nome_campus);
            }else
                break;
        }
        
        System.out.println("Digite o nome do predio");
        String nome_predio = scanner.nextLine();
        
        Predio predio = new Predio(nome_predio);
        campus.adicionarPredio(predio);
         return predio;
    }
    public static Sala cadastrarSala(List<Campus> campusTD,List<Predio> predioTD){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do campus");
        String nome_campus = scanner.nextLine();
        
        Campus campus = new Campus();
        campus = buscarCampus(campusTD, nome_campus);
        while(true){
            if(campus == null)
            {
                System.out.println("Nome do campus digitado errado, digite novamente:");
                nome_campus = scanner.nextLine();
                campus= buscarCampus(campusTD,nome_campus);
            }else
                break;
        }
        
        predioTD = campus.getPredios();
        
        System.out.println("Digite o nome do predio");
        String nome_predio = scanner.nextLine();
        
        Predio predio = new Predio();
        predio = buscarPredio(predioTD, nome_predio);
        while(true){
            if(predio == null)
            {
                System.out.println("Nome do predio digitado errado, digite novamente:");
                nome_predio = scanner.nextLine();
                predio = buscarPredio(predioTD,nome_predio);
            }else
                break;
        }
        
        
        System.out.println("Digite o número da sala");
        int numero = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Digite a capacidade da sala");
        int capacidade = scanner.nextInt();
        scanner.nextLine();
        
        Sala sala = new Sala(numero, capacidade);
        predio.adicionarSala(sala);
         return sala;
    }
   
    public static Campus buscarCampus(List<Campus> campusTD, String nome) {
    for (Campus campus : campusTD) {
        if (campus.getNome().equalsIgnoreCase(nome)) {
            return campus;
        }
    }
    return null;
    }
    
    public static Predio buscarPredio(List<Predio> predioTD, String nome) {
    for (Predio predio : predioTD) {
        if (predio.getNome().equalsIgnoreCase(nome)) {
            return predio;
        }
    }
    return null;
    }
}
