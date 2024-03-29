/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Endereco;
import io.github.thigassantos.trabalholucio.classes.campus.Predio;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoAudio;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoNotebook;
import io.github.thigassantos.trabalholucio.classes.equipamento.tipos.EquipamentoVideo;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import io.github.thigassantos.trabalholucio.classes.reserva.TipoReserva;
import io.github.thigassantos.trabalholucio.classes.reserva.tipos.ReservaAula;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class PreencheBanco {
    
    //Banco de dados
        private  List<Sala> salas = new ArrayList<>();
        private  List<Equipamento> equipamentos = new ArrayList<>();
        private  List<Campus> campusTD = new ArrayList<>();
        private  List<Predio> predioTD = new ArrayList<>();
        private  List<Funcionario> funcionarios = new ArrayList<>();
        private  List<Reserva> reservas = new ArrayList<>();
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">    
    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Campus> getCampusTD() {
        return campusTD;
    }
    public List<Predio> getPredioTD() {
        return predioTD;
    }

    public void setCampusTD(List<Campus> campusTD) {
        this.campusTD = campusTD;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    public void addSala(Sala sala) {
        salas.add(sala);
    }
    
    public void addEquipamento(Equipamento eqp) {
        equipamentos.add(eqp);
    }
    
    public void addFuncionario(Funcionario func) {
        funcionarios.add(func);
    }
    
    public void addCampus(Campus camp) {
        campusTD.add(camp);
    }
    
    public void addPredio(Predio predio) {
        predioTD.add(predio);
    }
    
    //</editor-fold>

    // Campo estático privado da própria classe
    private static PreencheBanco instance;

    // Construtor privado da classe
    private PreencheBanco() {
    
    }

    // Método estático que retorna a única instância da classe
    public static PreencheBanco getInstance() {
        if (instance == null) {
            instance = new PreencheBanco();
            instance.preencherBanco(); // chamada ao método preencherBanco para preencher os dados
        }
        return instance;
    }
    
    public void preencherBanco(){
            
        //<editor-fold defaultstate="collapsed" desc="Preenchimento do Banco">
        //Preencher banco
        salas.add(new Sala(1, 10));
        salas.add(new Sala(2, 20));
        salas.add(new Sala(3, 30));
        
        Endereco end = new Endereco("MOC","Rua A","Bairro Aquele lá", 13);
        Campus campusA = new Campus("Campus A", end);
        campusTD.add(campusA);
        
        Predio predioA = new Predio("Administrativo");
        Predio predioB = new Predio("Predio 1");
        campusA.adicionarPredio(predioB);
        campusA.adicionarPredio(predioA);
        
        predioA.adicionarSala(salas.get(0));
        predioB.adicionarSala(salas.get(1));
        predioB.adicionarSala(salas.get(2));
        
        predioTD.add(predioA);
        predioTD.add(predioB);
        
        EquipamentoVideo dataShow = new EquipamentoVideo("DataShow","Samsung");
        EquipamentoVideo dataShow2 = new EquipamentoVideo("DataShow","Samsung");
        EquipamentoAudio som = new EquipamentoAudio("Som",350);
        EquipamentoVideo tv = new EquipamentoVideo("TV","LG");
        EquipamentoNotebook notebook = new EquipamentoNotebook("Notebook","Dell","x5264",27,16);
        
        campusA.adicionarEquipamento(dataShow);
        campusA.adicionarEquipamento(dataShow2);
        campusA.adicionarEquipamento(som);
        campusA.adicionarEquipamento(tv);
        campusA.adicionarEquipamento(notebook);
        
        funcionarios.add(new Funcionario("Emily","Reitora","0154"));
        funcionarios.add(new Funcionario("Fernanda","Professora","0134"));
        funcionarios.add(new Funcionario("Thiago","Cordenador","0124"));
        
        campusA.adicionarFuncionario(funcionarios.get(0));
        campusA.adicionarFuncionario(funcionarios.get(1));
        campusA.adicionarFuncionario(funcionarios.get(2));
        
        List<LocalDate> periodo = new ArrayList<>();
        periodo.add(LocalDate.parse("07/02/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        periodo.add(LocalDate.parse("07/02/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        List<LocalTime> horario = new ArrayList<>();
        horario.add(LocalTime.parse("15:20", DateTimeFormatter.ofPattern("HH:mm")));
        horario.add(LocalTime.parse("17:20", DateTimeFormatter.ofPattern("HH:mm")));
        
        reservas.add(new Reserva(periodo,horario,"palestra bem legal",salas.get(1),null,funcionarios.get(2),TipoReserva.REUNIAO));
        Sala sala = salas.get(1);
        sala.addReserva(reservas.get(0));
        
        periodo = new ArrayList<>();
        periodo.add(LocalDate.parse("10/02/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        periodo.add(LocalDate.parse("10/02/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        horario = new ArrayList<>();
        horario.add(LocalTime.parse("11:00", DateTimeFormatter.ofPattern("HH:mm")));
        horario.add(LocalTime.parse("13:20", DateTimeFormatter.ofPattern("HH:mm")));
        
        reservas.add(new Reserva(periodo,horario,"palestra sobre como formar",salas.get(1),null,funcionarios.get(2),TipoReserva.REUNIAO));
        sala = salas.get(1);
        sala.addReserva(reservas.get(1));
        
        periodo = new ArrayList<>();
        periodo.add(LocalDate.parse("07/02/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        periodo.add(LocalDate.parse("12/06/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        horario = new ArrayList<>();
        horario.add(LocalTime.parse("11:00", DateTimeFormatter.ofPattern("HH:mm")));
        horario.add(LocalTime.parse("12:40", DateTimeFormatter.ofPattern("HH:mm")));
        
        List<Integer> dias = new ArrayList<>();
        dias = List.of(1,3,4);
        reservas.add(new ReservaAula(periodo,horario,"Calculo",salas.get(2),null,funcionarios.get(1),TipoReserva.AULA, dias));
        sala = salas.get(2);
        sala.addReserva(reservas.get(2));
        
        Funcionario func = funcionarios.get(1);
        func.addReserva(reservas.get(2));
        
        func = funcionarios.get(2);
        func.addReserva(reservas.get(0));
        func.addReserva(reservas.get(1));
        
        //</editor-fold>
        
        }
    
}
