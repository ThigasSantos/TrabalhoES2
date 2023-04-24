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
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.time.LocalDateTime;
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
        
    public void preencherBanco(){
            
        //<editor-fold defaultstate="collapsed" desc="Preenchimento do Banco">
        //Preencher banco
        salas.add(new Sala(1, 10));
        salas.add(new Sala(2, 20));
        salas.add(new Sala(3, 30));
        
        Endereco end = new Endereco("MOC","Rua A","Bairro Aquele lá", 13);
        Campus campusA = new Campus("Campus A", end);
        campusTD.add(campusA);
        
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
        
        }
    
}
