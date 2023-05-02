/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.reserva.tipos;

import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import io.github.thigassantos.trabalholucio.classes.reserva.TipoReserva;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class ReservaAula extends Reserva{
   
    private int[] diasSemana = new int[7];
    private List<LocalDate> diasAula = new ArrayList<>();
    
    public ReservaAula(List<LocalDate> periodo, List<LocalTime> horario, String assunto, Sala sala, List<Equipamento> equipamentos, Funcionario responsavel, TipoReserva tipoReserva,List<Integer> diaSemana) {
        super(periodo, horario, assunto, sala, equipamentos, responsavel, tipoReserva);
        diasAula.add(periodo.get(0));        

        for (int i = 0; i < diaSemana.size(); i++) {
            int dia = diaSemana.get(i);
            if (dia >= 0 && dia < 7) {
                diasSemana[dia] = 1;
            }
        }        
        
        while (!diasAula.get(diasAula.size() - 1).isAfter(periodo.get(1))) {
            LocalDate dataAula = diasAula.get(diasAula.size() - 1);
            if (diasSemana[dataAula.getDayOfWeek().getValue() - 1] == 1) {
                diasAula.add(dataAula);
            }
            diasAula.add(dataAula.plusDays(1));
        }
    }
}
