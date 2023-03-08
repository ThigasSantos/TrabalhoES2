/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.campus;

import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Campus {   
    
    private String nome;
    private String endereco;
    private List<Predio> predios;
    private List<Funcionario> funcionarios;
    
    //construtor
    public Campus(String nome, String endereco, List<Predio> predios) {
        this.nome = nome;
        this.endereco = endereco;
        this.predios = predios;
    }
    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Predio> getPredios() {
        return predios;
    }

    public void setPredios(List<Predio> predios) {
        this.predios = predios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Campus [nome=" + nome + ", endereco=" + endereco + "]";
    }
}
