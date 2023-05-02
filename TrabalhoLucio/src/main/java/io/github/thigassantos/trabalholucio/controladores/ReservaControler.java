/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;


import io.github.thigassantos.trabalholucio.PreencheBanco;
import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import io.github.thigassantos.trabalholucio.classes.reserva.TipoReserva;
import io.github.thigassantos.trabalholucio.classes.reserva.tipos.ReservaAula;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tygsv
 */
public class ReservaControler {
    
    LugarControler lug = new LugarControler();
    PreencheBanco banco = PreencheBanco.getInstance();
    
    public List<LocalDateTime> pegarHorario(Scanner scanner){
        System.out.println("Digite o período que deseja (formato dd/MM/yyyy HH:mm - dd/MM/yyyy HH:mm):");
        String periodoStr = scanner.nextLine();

        String[] periodo = periodoStr.split(" - ");
        LocalDateTime dataHora = LocalDateTime.parse(periodo[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime dataHoraFim = LocalDateTime.parse(periodo[1], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        return  List.of(dataHora,dataHoraFim);
    }
    
    public List<LocalDate> pegarPeriodo(Scanner scanner){
        System.out.println("Digite o período que deseja (formato dd/MM/yyyy - dd/MM/yyyy):");
        String periodoStr = scanner.nextLine();

        String[] periodo = periodoStr.split(" - ");
        LocalDate dataHora = LocalDate.parse(periodo[0], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataHoraFim = LocalDate.parse(periodo[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        return  List.of(dataHora,dataHoraFim);
    }
    
    public void verificarDisponibilidade(Scanner scanner,Campus campus,Funcionario logado) {
        
        List<LocalDateTime> dataHora = pegarHorario(scanner);
        List<LocalDate> periodo = new ArrayList<>();
        periodo.add(dataHora.get(0).toLocalDate());
        periodo.add(dataHora.get(1).toLocalDate());
        
        List<LocalTime> horario = new ArrayList<>();
        horario.add(dataHora.get(0).toLocalTime());
        horario.add(dataHora.get(1).toLocalTime());
        
        System.out.println("Salas disponíveis na data e horário informados:");
        lug.exibirSalasDisponiveis(campus, periodo,horario);
      
        System.out.println("Deseja realizar uma reserva ? S/N");       
        if(scanner.nextLine().equalsIgnoreCase("S"))
            realizarReserva(scanner,campus,dataHora,logado);
                   
    }

    public void verificarOcupacao(Scanner scanner, Campus campus) {
        
        lug.exibirSalas(campus);
        List<Sala> salas = lug.getSalasCampus(campus);
                
        System.out.println("Digite o numero da sala que deseja verificar a ocupação:");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();       
        
        Sala sala = lug.acharSala(campus, numeroSala);;
        
        while(true){
            if(sala == null){
                System.out.println("Sala não encontrada, por favor digite outra sala:");
                numeroSala = scanner.nextInt();   
                scanner.nextLine();
                sala = lug.acharSala(campus, numeroSala);
            }else
                break;           
        }
        
        List<LocalDateTime> dataHora = pegarHorario(scanner);
        List<Reserva> reservas = sala.getReservas();

        System.out.println("Reservas da sala " + sala.getNumero() + " no período informado:");
        for (Reserva reserva : reservas) {
            System.out.println("ID: "+reserva.getId()+"  Sala: "+reserva.getSala().getNumero() +"  Horario inicio: "+reserva.getPeriodo().get(0)+" "+reserva.getHorario().get(0)+"  Horario fim: "+reserva.getPeriodo().get(1)+" "+reserva.getHorario().get(1));
        } 
        if(reservas.isEmpty()){
            System.out.println("Não existe reservas para essa sala!");
        }
    }
    
    public void realizarReserva(Scanner scanner,Campus campus,List<LocalDateTime> horaReserva,Funcionario logado) {
        
        List<LocalDate> periodo = new ArrayList<>();
        periodo.add(horaReserva.get(0).toLocalDate());
        periodo.add(horaReserva.get(1).toLocalDate());
        
        List<LocalTime> horario = new ArrayList<>();
        horario.add(horaReserva.get(0).toLocalTime());
        horario.add(horaReserva.get(1).toLocalTime());
        
        System.out.println("Selecione uma sala livre para realizar a reserva:");
        
        int numeroSala = scanner.nextInt();   
        scanner.nextLine();
        Sala sala = lug.acharSala(campus, numeroSala);
        
        while(true){
            if(sala == null){
                System.out.println("Sala não encontrada, por favor digite outra sala:");
                numeroSala = scanner.nextInt();   
                scanner.nextLine();
                sala = lug.acharSala(campus, numeroSala);
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
                for(Equipamento equipamento: campus.getEquipamentos())
                {
                    if(equipamento.isDisponivel(periodo,horario)){
                      System.out.println("Nome: "+equipamento.getNome()+" Patrimonio: "+equipamento.getPatrimonio());  
                    }
                   
                }
                while(true){                   
                    String nomeEquipamento = scanner.nextLine();                   
                    if (nomeEquipamento.equalsIgnoreCase("2"))
                        break;
                    else if(campus.buscarEquipamento(nomeEquipamento) == null)
                        System.out.println("Equipamento não encontrado digite novamente:");
                    else
                        equipamentoS.add(campus.buscarEquipamento(nomeEquipamento));
                }
                
            }
                 
        Reserva reserva = new Reserva( periodo, horario, assunto, sala, equipamentoS, logado,TipoReserva.REUNIAO);
        sala.addReserva(reserva);
        for(Equipamento equipamento: equipamentoS){
            equipamento.addReserva(reserva);
        }
        
        System.out.println("Reserva realizada com sucesso! Reserva numero:" + reserva.getId());   
        logado.addReserva(reserva);
        banco.addReserva(reserva);
    }
    
    public void realizarReservaAula(Scanner scanner,Campus campus,Funcionario logado){
        
        List<LocalDate> periodo = pegarPeriodo(scanner);
        List<Integer> diaSemana = new ArrayList<>();
        List<LocalTime> horario = new ArrayList<>();
        
        System.out.println("Digite o numero equivalente ao dia da semana que terá aula e depois aperte 0 para concluir:");
        System.out.println(" 1-Segunda");
        System.out.println(" 2-Terça");
        System.out.println(" 3-Quarta");
        System.out.println(" 4-Quinta");
        System.out.println(" 5-Sexta");
        System.out.println(" 6-Sabado");       
        
        while(true){                   
            int dia = scanner.nextInt();
                scanner.nextLine();
            if (dia == 0)
                break;
            else if(dia > 6)
                System.out.println("Dia não encontrado digite novamente:");
            else 
                diaSemana.add(dia);
        }
        
        System.out.println("Digite o horario da aula (formato HH:mm - HH:mm)");        
        String horarioStr = scanner.nextLine();

        String[] horarioAula = horarioStr.split(" - ");
        horario.add(LocalTime.parse(horarioAula[0], DateTimeFormatter.ofPattern("HH:mm")));
        horario.add(LocalTime.parse(horarioAula[1], DateTimeFormatter.ofPattern("HH:mm")));
        
        lug.exibirSalasDisponiveisAula(campus, periodo, horario);      
        System.out.println("Selecione uma sala livre para realizar a reserva:");
        
        int numeroSala = scanner.nextInt();   
        scanner.nextLine();
        Sala sala = lug.acharSala(campus, numeroSala);
        
        while(true){
            if(sala == null){
                System.out.println("Sala não encontrada, por favor digite outra sala:");
                numeroSala = scanner.nextInt();   
                scanner.nextLine();
                sala = lug.acharSala(campus, numeroSala);
            }else
                break;
            
        }            
        System.out.println("Digite a materia:");
        String assunto = scanner.nextLine();
        
        System.out.println("Deseja adicionar equipamentos à reserva? (S/N)");
        String adicionarEquipamentos = scanner.nextLine();
        List<Equipamento> equipamentoS = new ArrayList<>();
        
            if (adicionarEquipamentos.equalsIgnoreCase("S")) {            
                System.out.println("Digite o nome do equipamento ou Digite 2 para concluir:");
                for(Equipamento equipamento: campus.getEquipamentos())
                {
                    if(equipamento.isDisponivelAula(periodo, horario)){
                      System.out.println("Nome: "+equipamento.getNome()+" Patrimonio: "+equipamento.getPatrimonio());  
                    }
                   
                }
                while(true){                   
                    String nomeEquipamento = scanner.nextLine();                   
                    if (nomeEquipamento.equalsIgnoreCase("2"))
                        break;
                    else if(campus.buscarEquipamento(nomeEquipamento) == null)
                        System.out.println("Equipamento não encontrado digite novamente:");
                    else
                        equipamentoS.add(campus.buscarEquipamento(nomeEquipamento));
                }
                
            }
            
        ReservaAula reserva = new ReservaAula(periodo,horario, assunto, sala, equipamentoS, logado,TipoReserva.AULA,diaSemana);
        sala.addReserva(reserva);
        for(Equipamento equipamento: equipamentoS){
            equipamento.addReserva(reserva);
        }
        
        System.out.println("Reserva realizada com sucesso! Reserva numero:" + reserva.getId());   
        logado.addReserva(reserva);
        banco.addReserva(reserva);
    }
    
    public void verificarReservasFuncionario(Scanner scanner, Campus campus, Funcionario logado){
         
        System.out.println("Essas são as reservas feitas:");
        for(Reserva reserva: logado.getReservas()){
                System.out.println("ID: "+reserva.getId()+"  Sala: "+reserva.getSala().getNumero() +"  Horario inicio: "+reserva.getPeriodo().get(0)+" "+reserva.getHorario().get(0)+"  Horario fim: "+reserva.getPeriodo().get(1)+" "+reserva.getHorario().get(1)+"  Ativa: "+reserva.isAtiva() );    
        }       
    } 
    
}
