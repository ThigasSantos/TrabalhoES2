/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.reserva;

import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class ReservaAula extends Reserva{
    
    public ReservaAula(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String assunto, Sala sala, List<Equipamento> equipamentos, Funcionario responsavel, TipoReserva tipoReserva) {
        super(dataHoraInicio, dataHoraFim, assunto, sala, equipamentos, responsavel, tipoReserva);
    }
    
}
