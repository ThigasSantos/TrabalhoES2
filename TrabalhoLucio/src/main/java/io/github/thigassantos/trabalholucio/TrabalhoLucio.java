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
    
        //Banco de dados
        private static List<Sala> salas = new ArrayList<>();
        private static List<Campus> campusTD = new ArrayList<>();
        private static List<Funcionario> funcionarios = new ArrayList<>();
        private static List<Reserva> reservas = new ArrayList<>();
        
    public static void main(String[] args) {
        
        
        //<editor-fold defaultstate="collapsed" desc="Preenchimento do Banco">
        //Preencher banco
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
        funcionarios.add(new Funcionario("Fernanda","Professora","0134"));
        funcionarios.add(new Funcionario("Thiago","Cordenador","0124"));
        
        
        LocalDateTime horaInicio = LocalDateTime.parse("07/02/2023 14:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime horaFim = LocalDateTime.parse("07/02/2023 17:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        reservas.add(new Reserva(horaInicio,horaFim,"aula",salas.get(1),null,funcionarios.get(2)));
        
        horaInicio = LocalDateTime.parse("10/02/2023 14:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        horaFim = LocalDateTime.parse("11/02/2023 17:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        reservas.add(new Reserva(horaInicio,horaFim,"aula",salas.get(1),null,funcionarios.get(2)));
        
        horaInicio = LocalDateTime.parse("10/02/2023 14:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        horaFim = LocalDateTime.parse("11/02/2023 17:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        reservas.add(new Reserva(horaInicio,horaFim,"aula",salas.get(2),null,funcionarios.get(1)));
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Sistema">
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
           
            while(true){               
               if(campusNow == null){
                System.out.println("Campus invalido digite novamente:");
                nomeCampus = scanner.nextLine();           
                campusNow = buscarCampus(campusTD, nomeCampus); 
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
                verificarDisponibilidade(scanner,campusNow.getEquipamentos());
            } else if (opcao == 2) {
                verificarOcupacao(scanner);
            } else if (opcao == 3) {
                realizarReserva(scanner,campusNow.getEquipamentos());
            } else if (opcao == 4) {
                verificarReservasFuncionario(scanner);
            } else if (opcao == 5) {
                System.out.println("Saindo do sistema de reservas de salas...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println();
        }
        //</editor-fold>
               
    }

    private static List<LocalDateTime> verificarDisponibilidade(Scanner scanner, List<Equipamento> equipamentos) {
        System.out.println("Digite o período que deseja verificar a ocupação (formato dd/MM/yyyy HH:mm - dd/MM/yyyy HH:mm):");
        String periodoStr = scanner.nextLine();

        String[] periodo = periodoStr.split(" - ");
        LocalDateTime dataHora = LocalDateTime.parse(periodo[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime dataHoraFim = LocalDateTime.parse(periodo[1], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println("Salas disponíveis para reserva na data e horário informados:");
        for (Sala sala : salas) {
            if (sala.isDisponivel(dataHora, dataHoraFim)) {
                System.out.println(sala.getNumero());
            }
        }
        
        System.out.println("Deseja realizar uma reserva ? S/N");
        
        if(scanner.nextLine().equalsIgnoreCase("S"))
            realizarReserva(scanner,equipamentos,List.of(dataHora,dataHoraFim));
            
            return  List.of(dataHora,dataHoraFim);
        
    }

    private static void verificarOcupacao(Scanner scanner) {
        System.out.println("Digite o numero da sala que deseja verificar a ocupação:");
        int nomeSala = scanner.nextInt();
        scanner.nextLine();
        
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
            System.out.println("ID da Reserva: " + reserva.getId() + "  Hora de inicio: " + reserva.getDataHoraInicio() + "  Hora Fim: " + reserva.getDataHoraFim());
        } 
        if(reservas.isEmpty()){
            System.out.println("Não existe reservas para essa sala!");
        }
    }
    
    private static void realizarReserva(Scanner scanner, List<Equipamento> equipamentos) {
    
        List<LocalDateTime> horaReserva = verificarDisponibilidade(scanner,equipamentos);
        
        System.out.println("Selecione uma sala livre para realizar a reserva:");
        
        int numeroSala = scanner.nextInt();   
        scanner.nextLine();
        Sala sala = buscarSala(salas, numeroSala);
        
        while(true){
            if(sala == null){
                System.out.println("Sala não encontrada, por favor digite outra sala:");
                numeroSala = scanner.nextInt();   
                scanner.nextLine();
                sala = buscarSala(salas, numeroSala);
            }else
                break;
            
        }            
        System.out.println("Digite o assunto da reserva:");
        String assunto = scanner.nextLine();
        
        System.out.println("Deseja adicionar equipamentos à reserva? (S/N)");
        String adicionarEquipamentos = scanner.nextLine();
        List<Equipamento> equipamentoS = new ArrayList<>();
        
            if (adicionarEquipamentos.equalsIgnoreCase("S")) {            
                System.out.println("Digite o nome do equipamento ou Digite 2 para concluir:");
                for(Equipamento equipamento: equipamentos)
                {
                    System.out.println(equipamento.getNome());
                }
                while(true){                   
                    String nomeEquipamento = scanner.nextLine();                   
                    if (nomeEquipamento.equalsIgnoreCase("2"))
                        break;
                    else if(buscarEquipamento(equipamentos ,nomeEquipamento) == null)
                        System.out.println("Equipamento não encontrado");
                    else
                        equipamentoS.add(buscarEquipamento(equipamentos ,nomeEquipamento));
                }
                
            }
            
        System.out.println("Se identifique:");
        String nomeFuncionario = scanner.nextLine();
        Funcionario responsavel = buscarFuncionario(funcionarios, nomeFuncionario);    
        
            while(true){
                if(responsavel == null){
                    System.out.println("Usuario invalido digite novamente:");
                    nomeFuncionario = scanner.nextLine();
                    responsavel = buscarFuncionario(funcionarios, nomeFuncionario); 
                }else{
                    break;
                }
            }  
            
        Reserva reserva = new Reserva( horaReserva.get(0),horaReserva.get(1), assunto, sala, equipamentoS, responsavel);
        reservas.add(reserva);
        sala.addReserva(reserva);
        System.out.println("Reserva realizada com sucesso! Reserva numero:" + reserva.getId());
    
    }
    
    private static void realizarReserva(Scanner scanner, List<Equipamento> equipamentos, List<LocalDateTime> horaReserva) {
            
        System.out.println("Selecione uma sala livre para realizar a reserva:");
        
        int numeroSala = scanner.nextInt();   
        scanner.nextLine();
        Sala sala = buscarSala(salas, numeroSala);
        
        while(true){
            if(sala == null){
                System.out.println("Sala não encontrada, por favor digite outra sala:");
                numeroSala = scanner.nextInt();   
                scanner.nextLine();
                sala = buscarSala(salas, numeroSala);
            }else
                break;
            
        }            
        System.out.println("Digite o assunto da reserva:");
        String assunto = scanner.nextLine();
        
        System.out.println("Deseja adicionar equipamentos à reserva? (S/N)");
        String adicionarEquipamentos = scanner.nextLine();
        List<Equipamento> equipamentoS = new ArrayList<>();
        
            if (adicionarEquipamentos.equalsIgnoreCase("S")) {            
                System.out.println("Digite o nome do equipamento ou Digite 2 para concluir:");
                for(Equipamento equipamento: equipamentos)
                {
                    System.out.println(equipamento.getNome());
                }
                while(true){                   
                    String nomeEquipamento = scanner.nextLine();                   
                    if (nomeEquipamento.equalsIgnoreCase("2"))
                        break;
                    else if(buscarEquipamento(equipamentos ,nomeEquipamento) == null)
                        System.out.println("Equipamento não encontrado");
                    else
                        equipamentoS.add(buscarEquipamento(equipamentos ,nomeEquipamento));
                }
                
            }
            
        System.out.println("Se identifique:");
        String nomeFuncionario = scanner.nextLine();
        Funcionario responsavel = buscarFuncionario(funcionarios, nomeFuncionario);    
        
            while(true){
                if(responsavel == null){
                    System.out.println("Usuario invalido digite novamente:");
                    nomeFuncionario = scanner.nextLine();
                    responsavel = buscarFuncionario(funcionarios, nomeFuncionario); 
                }else{
                    break;
                }
            }  
            
        Reserva reserva = new Reserva( horaReserva.get(0),horaReserva.get(1), assunto, sala, equipamentoS, responsavel);
        reservas.add(reserva);
        sala.addReserva(reserva);
        System.out.println("Reserva realizada com sucesso! Reserva numero:" + reserva.getId());
    
    }
    
    private static void verificarReservasFuncionario(Scanner scanner){
        System.out.println("Digite o funcionario para olhar suas reservas:");
        String nomeFuncionario = scanner.nextLine();
        
        Funcionario func = buscarFuncionario(funcionarios,nomeFuncionario);
        
        while(true){
            if(func == null)
            {
                System.out.println("Nome do funcionario digitado errado, digite novamente:");
                nomeFuncionario = scanner.nextLine();
                func = buscarFuncionario(funcionarios, nomeFuncionario);
            }else
                break;
        }
        
        System.out.println("Essas são as reservas feitas:");
        for(Reserva reserva: reservas){
            if (reserva.getResponsavel().getNome().equalsIgnoreCase(nomeFuncionario)) {
                System.out.println("ID: "+reserva.getId()+"  Sala: "+reserva.getSala().getNumero() +"  Horario inicio: "+reserva.getDataHoraInicio()+"  Horario fim: "+reserva.getDataHoraFim()+"  Ativa: "+reserva.isAtiva() );
            }
        }
        
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
    
    public static Reserva buscarReserva(List<Reserva> reservas, String nomeFuncionario) {
    for (Reserva reserva : reservas) {
        if (reserva.getResponsavel().getNome().equalsIgnoreCase(nomeFuncionario)) {
            return reserva;
        }
    }
    return null;
    }
    
}
