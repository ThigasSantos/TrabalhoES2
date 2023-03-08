/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.campus;

import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Sala {   
    //atributos
    private int numero;
    private int quantidadeLugares;
    private List<Reserva> reserva;
    private Predio predio;

    //construtor
    public Sala(int numero, int quantidadeLugares) {
        this.numero = numero;
        this.quantidadeLugares = quantidadeLugares;
    }
    
    //getters e setters
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }
    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }
    
    //to string
    @Override
    public String toString() {
        return "Sala{" + "numero=" + numero + ", quantidadeLugares=" + quantidadeLugares + ", reserva=" + reserva + ", predio=" + predio + '}';
    }
    

}
