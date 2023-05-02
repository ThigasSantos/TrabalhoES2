/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.PreencheBanco;
import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Endereco;
import io.github.thigassantos.trabalholucio.classes.campus.Predio;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tygsv
 */
public class LugarControler {
    
    private PreencheBanco banco = PreencheBanco.getInstance();
    
    public Campus buscarCampus(String nome) {
    for (Campus campus : banco.getCampusTD()) {
        if (campus.getNome().equalsIgnoreCase(nome)) {
            return campus;
        }
    }
    return null;
    }
          
    public void cadastrarCampus(){
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
            return;
        }
        
        Endereco endereco = new Endereco(cidade,rua,bairro,numero);
        Campus campus = new Campus(nome, endereco);
        banco.addCampus(campus);
    }
    
    public List<Sala> getSalasCampus(Campus campus){
        List<Predio> predios = campus.getPredios();
        List<Sala> salas = new ArrayList<>();
        for (Predio predio : predios) {           
            salas.addAll(predio.getSalas());                  
        }
        
        return salas;
    }
    
    public void exibirSalas(Campus campus){
        
        List<Predio> predios = campus.getPredios();
        for (Predio predio : predios) {
            System.out.println("Predio: "+predio.getNome());
            for (Sala sala : predio.getSalas()) { 
                System.out.println("Sala Numero: "+sala.getNumero()+" Capacidade: "+ sala.getCapacidade());
            }          
        }
    }
    
    public Sala acharSala(Campus campus,int numSala){
        List<Predio> predios = campus.getPredios();
        Sala sala;
        for (Predio predio : predios) {
            sala = predio.buscarSala(numSala);
            if(sala != null)
            {
                return sala;
            }
        } 
        return null;
    }
    
    public void exibirSalasDisponiveis(Campus campus, List<LocalDate> periodo, List<LocalTime> horario){
        List<Predio> predios = campus.getPredios();
        
        for (Predio predio : predios) {
            for (Sala sala : predio.getSalas()) {     
                if (sala.isDisponivel(periodo, horario)) {
                System.out.println("Sala Numero: "+sala.getNumero()+" Capacidade: "+ sala.getCapacidade());
                }
            }          
        }
    }
    
    public void exibirSalasDisponiveisAula(Campus campus, List<LocalDate> periodo, List<LocalTime> horario){
        List<Predio> predios = campus.getPredios();
        
        for (Predio predio : predios) {
            for (Sala sala : predio.getSalas()) {     
                if (sala.isDisponivelAula(periodo, horario)) {
                System.out.println("Sala Numero: "+sala.getNumero()+" Capacidade: "+ sala.getCapacidade());
                }
            }          
        }
    }
    
    public void cadastrarPredio(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do campus");
        String nome_campus = scanner.nextLine();
        
        Campus campus = new Campus();
        campus = buscarCampus( nome_campus);
        while(true){
            if(campus == null)
            {
                System.out.println("Nome do campus digitado errado, digite novamente:");
                nome_campus = scanner.nextLine();
                campus= buscarCampus(nome_campus);
            }else
                break;
        }
        
        System.out.println("Digite o nome do predio");
        String nome_predio = scanner.nextLine();
        
        Predio predio = new Predio(nome_predio);
        campus.adicionarPredio(predio);
        banco.addPredio(predio);
    }
    
    public void cadastrarSala(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do campus");
        String nome_campus = scanner.nextLine();
        
        Campus campus = new Campus();
        campus = buscarCampus( nome_campus);
        while(true){
            if(campus == null)
            {
                System.out.println("Nome do campus digitado errado, digite novamente:");
                nome_campus = scanner.nextLine();
                campus = buscarCampus(nome_campus);
            }else
                break;
        }
        
        List<Predio> predioTD = campus.getPredios();
        
        System.out.println("Digite o nome do predio");
        String nome_predio = scanner.nextLine();
        
        Predio predio = new Predio();
        predio = campus.buscarPredio( nome_predio);
        while(true){
            if(predio == null)
            {
                System.out.println("Nome do predio digitado errado, digite novamente:");
                nome_predio = scanner.nextLine();
                predio = campus.buscarPredio(nome_predio);
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
        banco.addSala(sala);
    }
    
}
