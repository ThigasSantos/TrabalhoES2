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
import java.time.LocalDateTime;
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
    
    public void verificarDisponibilidade(Scanner scanner,Campus campus,Funcionario logado) {
        
        List<LocalDateTime> dataHora = pegarHorario(scanner);
        
        System.out.println("Salas disponíveis na data e horário informados:");
        lug.exibirSalasDisponiveis(campus, dataHora);
      
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
        List<Reserva> reservas = sala.getReservasPeriodo(dataHora.get(0), dataHora.get(1));

        System.out.println("Reservas da sala " + sala.getNumero() + " no período informado:");
        for (Reserva reserva : reservas) {
            System.out.println("ID da Reserva: " + reserva.getId() + "  Hora de inicio: " + reserva.getDataHoraInicio() + "  Hora Fim: " + reserva.getDataHoraFim());
        } 
        if(reservas.isEmpty()){
            System.out.println("Não existe reservas para essa sala!");
        }
    }
    
    public void realizarReserva(Scanner scanner,Campus campus,List<LocalDateTime> horaReserva,Funcionario logado) {
            
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
                    if(equipamento.isDisponivel(horaReserva.get(0), horaReserva.get(1))){
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
                 
        Reserva reserva = new Reserva( horaReserva.get(0),horaReserva.get(1), assunto, sala, equipamentoS, logado,TipoReserva.REUNIAO);
        sala.addReserva(reserva);
        for(Equipamento equipamento: equipamentoS){
            equipamento.addReserva(reserva);
        }
        
        System.out.println("Reserva realizada com sucesso! Reserva numero:" + reserva.getId());        
        banco.addReserva(reserva);
    }
    
    public void verificarReservasFuncionario(Scanner scanner, Campus campus, Funcionario logado){
         
        System.out.println("Essas são as reservas feitas:");
        for(Reserva reserva: logado.getReservas()){
                System.out.println("ID: "+reserva.getId()+"  Sala: "+reserva.getSala().getNumero() +"  Horario inicio: "+reserva.getDataHoraInicio()+"  Horario fim: "+reserva.getDataHoraFim()+"  Ativa: "+reserva.isAtiva() );    
        }       
    } 
    
}
