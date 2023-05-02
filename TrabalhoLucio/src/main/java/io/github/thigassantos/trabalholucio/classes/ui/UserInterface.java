/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.ui;

import io.github.thigassantos.trabalholucio.PreencheBanco;
import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.controladores.EquipamentoControler;
import io.github.thigassantos.trabalholucio.controladores.FuncionarioControler;
import io.github.thigassantos.trabalholucio.controladores.LugarControler;
import io.github.thigassantos.trabalholucio.controladores.ReservaControler;
import java.util.Scanner;

/**
 *
 * @author Tygsv
 */
public class UserInterface {   
    
    private PreencheBanco banco = PreencheBanco.getInstance();
    private LugarControler lug = new LugarControler();
    private EquipamentoControler equi = new EquipamentoControler();
    private ReservaControler res = new ReservaControler();
    private FuncionarioControler fun = new FuncionarioControler();
    
    public void ExibirInterface(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Book a Room!");
        System.out.println();
        
        System.out.println("Faça login para continuar");
        System.out.println();
        System.out.println("Nome:");
        String nomeFuncionario = scanner.nextLine();
        Funcionario logado = fun.buscarFuncionario(banco.getFuncionarios() , nomeFuncionario);
            while(true){
                if(logado == null){
                    System.out.println("Login incorreto tente novamente:");
                    nomeFuncionario = scanner.nextLine();   
                    logado = fun.buscarFuncionario(banco.getFuncionarios(), nomeFuncionario);
                }else
                    break;           
                }
        menuLogado(scanner, logado, banco);             
    }
    
    public void menuLogado(Scanner scanner, Funcionario logado,PreencheBanco banco){
        
        while(true){
            
        System.out.println("Bem-vindo "+logado.getNome()+ " ao Book a Room!");
        System.out.println();
        
        System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro");
            System.out.println("2. Reservas");

            int opcao = scanner.nextInt();
                scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Bem vindo ao Menu de cadastro");
                System.out.println("Escolha uma opção:");
                System.out.println("1. Cadastrar Campus");
                System.out.println("2. Cadastrar Predio");
                System.out.println("3. Cadastrar Sala");
                System.out.println("4. Cadastrar Equipamento");
                System.out.println("5. Cadastrar Funcionario");
                System.out.println("6. Voltar");

                opcao = scanner.nextInt();
                scanner.nextLine();

                if(opcao == 1){
                    lug.cadastrarCampus();
                }else if(opcao == 2){
                    lug.cadastrarPredio();
                }else if(opcao == 3){
                     lug.cadastrarSala();
                }else if(opcao == 4){
                    equi.cadastrarEquipamento();
                }else if(opcao == 5){
                    fun.cadastrarFuncionario();
                }else if(opcao == 6){
                    break;
                }else {
                System.out.println("Opção inválida!");
            }

            } else if (opcao == 2) {

                System.out.println("Bem vindo ao Menu de reservas");
                System.out.println("Digite um Campus para continuar:");  
                
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
                
                menuCampus(scanner, logado, campus);
            }else {
                System.out.println("Opção inválida!");
            }
        }     
    }
    
    public void menuCampus(Scanner scanner, Funcionario logado,Campus campus){
        
        System.out.println("Escolha uma opção:");                                
        System.out.println("1. Verificar disponibilidade por data");
        System.out.println("2. Verificar ocupação da sala");
        System.out.println("3. Realizar reserva de sala");
        System.out.println("4. Verificar reservas do funcionario");
        System.out.println("5. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

            if (opcao == 1) {
                res.verificarDisponibilidade(scanner, campus, logado);
            } else if (opcao == 2) {
                res.verificarOcupacao(scanner,campus);
            } else if (opcao == 3) {
                System.out.println("1. Reserva de Aula");
                System.out.println("2. Reserva de Reunião");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                if(opcao == 1)
                    res.realizarReservaAula(scanner, campus, logado);
                else if(opcao == 2)
                    res.verificarDisponibilidade(scanner, campus, logado);
                else 
                System.out.println("Opção inválida!");
        
                
            } else if (opcao == 4) {
                res.verificarReservasFuncionario(scanner, campus, logado);
            } else if (opcao == 5) {
                System.out.println("Voltando ao menu anterior . . .");
                    return;
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println();
    }
}
