/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;


import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import static io.github.thigassantos.trabalholucio.controladores.FuncionarioControler.buscarFuncionario;
import static io.github.thigassantos.trabalholucio.controladores.LugarControler.buscarEquipamento;
import static io.github.thigassantos.trabalholucio.controladores.LugarControler.buscarSala;
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
    
    public Reserva buscarReserva(List<Reserva> reservas, String nomeFuncionario) {
    for (Reserva reserva : reservas) {
        if (reserva.getResponsavel().getNome().equalsIgnoreCase(nomeFuncionario)) {
            return reserva;
        }
    }
    return null;
    }
    
    public List<LocalDateTime> verificarDisponibilidade(Scanner scanner, List<Equipamento> equipamentos, List<Sala> salas, List<Funcionario> funcionarios, List<Reserva> reservas) {
        System.out.println("Digite o período que deseja (formato dd/MM/yyyy HH:mm - dd/MM/yyyy HH:mm):");
        String periodoStr = scanner.nextLine();

        String[] periodo = periodoStr.split(" - ");
        LocalDateTime dataHora = LocalDateTime.parse(periodo[0], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime dataHoraFim = LocalDateTime.parse(periodo[1], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println("Salas disponíveis na data e horário informados:");
        for (Sala sala : salas) {
            if (sala.isDisponivel(dataHora, dataHoraFim)) {
                System.out.println(sala.getNumero());
            }
        }
        
        System.out.println("Deseja realizar uma reserva ? S/N");
        
        if(scanner.nextLine().equalsIgnoreCase("S"))
            realizarReserva(scanner,equipamentos,List.of(dataHora,dataHoraFim),salas,funcionarios,reservas);
            
            return  List.of(dataHora,dataHoraFim);
        
    }

    public void verificarOcupacao(Scanner scanner, List<Sala> salas) {
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
    
    public void realizarReserva(Scanner scanner, List<Equipamento> equipamentos, List<LocalDateTime> horaReserva, List<Sala> salas, List<Funcionario> funcionarios, List<Reserva> reservas) {
            
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
                        System.out.println("Equipamento não encontrado digite novamente:");
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
    
    public void verificarReservasFuncionario(Scanner scanner, List<Funcionario> funcionarios, List<Reserva> reservas){
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
    
}
