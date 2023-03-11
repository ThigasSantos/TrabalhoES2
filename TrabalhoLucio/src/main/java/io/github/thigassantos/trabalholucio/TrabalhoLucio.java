/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.thigassantos.trabalholucio;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Endereco;
import io.github.thigassantos.trabalholucio.classes.campus.Predio;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrabalhoLucio {  
    
        private static List<Sala> salas = new ArrayList<>();
        private static List<Campus> campusTD = new ArrayList<>();
        private static List<Funcionario> funcionarios = new ArrayList<>();
        
    public static void main(String[] args) {
        
        
        
        // Criação das salas
        salas.add(new Sala(1, 10));
        salas.add(new Sala(2, 20));
        salas.add(new Sala(3, 30));
        
        Endereco end = new Endereco("MOC","Rua A","Bairro Aquele lá", 13);
        campusTD.add(new Campus("Campus A", end));
        
        Campus campusA = buscarCampus(campusTD,"Campus A");
        Equipamento dataShow = new Equipamento("DataShow","1542");
        Equipamento som = new Equipamento("Som","6523");
        Equipamento tv = new Equipamento("TV","4221");
        
        campusA.adicionarEquipamento(dataShow);
        campusA.adicionarEquipamento(som);
        campusA.adicionarEquipamento(tv);
        
        funcionarios.add(new Funcionario("Emily","Reitora","0154"));
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de reservas de salas!");
        System.out.println();

        while (true) {
            
            System.out.println("Escolha o Campus:");
              for(Campus campusNow: campusTD)
              {
                System.out.println(campusNow.getNome());
              }
            String nomeCampus = scanner.nextLine();           
            Campus campusNow = buscarCampus(campusTD, nomeCampus);            
            
            System.out.println("Escolha uma opção:");                                
            System.out.println("1. Verificar disponibilidade por data");
            System.out.println("2. Verificar ocupação da sala");
            System.out.println("3. Realizar reserva de sala");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                verificarDisponibilidade(scanner);
            } else if (opcao == 2) {
                verificarOcupacao(scanner);
            } else if (opcao == 3) {
                realizarReserva(scanner,campusNow.getEquipamentos());
            } else if (opcao == 4) {
                System.out.println("Saindo do sistema de reservas de salas...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println();
        }
    }

    private static List<LocalDateTime> verificarDisponibilidade(Scanner scanner) {
        System.out.println("Digite a data e horário que deseja reservar (formato dd/MM/yyyy HH:mm):");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        System.out.println("Digite a data e horário do fim da reserva (formato dd/MM/yyyy HH:mm):");
        String dataHoraStrFim = scanner.nextLine();
        LocalDateTime dataHoraFim = LocalDateTime.parse(dataHoraStrFim, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println("Salas disponíveis para reserva na data e horário informados:");
        for (Sala sala : salas) {
            if (sala.isDisponivel(dataHora, dataHoraFim)) {
                System.out.println(sala.getNumero());
            }
            else{
                System.out.println("Nenhuma sala disponivel na data e horario informados");
            }
        }
        return  List.of(dataHora,dataHoraFim);
    }

    private static void verificarOcupacao(Scanner scanner) {
        System.out.println("Digite o nome da sala que deseja verificar a ocupação:");
        int nomeSala = scanner.nextInt();

        Sala salaSelecionada = null;
        for (Sala sala : salas) {
            if (sala.getNumero() == nomeSala) {
                salaSelecionada = sala;
                break;
            }
        }

        if (salaSelecionada == null) {
            System.out.println("Sala não encontrada!");
            return;
        }

        System.out.println("Digite o período que deseja verificar a ocupação (formato dd/MM/yyyy HH:mm - dd/MM/yyyy HH:mm):");
        String periodoStr = scanner.nextLine();

        String[] periodo = periodoStr.split(" - ");
        LocalDateTime inicio = LocalDateTime.parse(periodo[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime fim = LocalDateTime.parse(periodo[1], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        List<Reserva> reservas = salaSelecionada.getReservasPeriodo(inicio, fim);

        System.out.println("Reservas da sala " + salaSelecionada.getNumero() + " no período informado:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }              
    }
    
    private static void realizarReserva(Scanner scanner, List<Equipamento> equipamentos) {
    
        List<LocalDateTime> horaReserva = verificarDisponibilidade(scanner);
        
        System.out.println("Selecione uma sala livre para realizar a reserva:");
        System.out.println("Digite o número da sala desejada:");
        int numeroSala = scanner.nextInt();
        
        scanner.nextLine();
        
        Sala sala = buscarSala(salas, numeroSala);       
        System.out.println("Digite o assunto da reserva:");
        String assunto = scanner.nextLine();
        
        System.out.println("Deseja adicionar equipamentos à reserva? (S/N)");
        String adicionarEquipamentos = scanner.nextLine();
        List<Equipamento> equipamentoS = new ArrayList<>();
            if (adicionarEquipamentos.equalsIgnoreCase("S")) {            
                System.out.println("Digite o nome do equipamento:");
                for(Equipamento equipamento: equipamentos)
                {
                    System.out.println(equipamento.getNome());
                }
                String nomeEquipamento = scanner.nextLine();               
                equipamentoS.add(buscarEquipamento(equipamentos ,nomeEquipamento));
            }
        
        System.out.println("Se identifique:");
        String nomeFuncionario = scanner.nextLine();
        Funcionario responsavel = buscarFuncionario(funcionarios, nomeFuncionario);       
        Reserva reserva = new Reserva( horaReserva.get(0),horaReserva.get(1), assunto, sala, equipamentoS, responsavel);
        sala.addReserva(reserva);
        System.out.println("Reserva realizada com sucesso: " + reserva);
    
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
    
    public static Funcionario buscarFuncionario(List<Funcionario> funcionarios, String nome) {
    for (Funcionario funcionario : funcionarios) {
        if (funcionario.getNome().equalsIgnoreCase(nome)) {
            return funcionario;
        }
    }
    return null;
    }
    
    public static Sala buscarSala(List<Sala> salas, int numero) {
    for (Sala sala : salas) {
        if (sala.getNumero() == numero) {
            return sala;
        }
    }
    return null;
    }
    
}
