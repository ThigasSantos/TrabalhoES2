/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.thigassantos.trabalholucio;
import io.github.thigassantos.trabalholucio.classes.ui.UserInterface;

public class TrabalhoLucio {  
              
    public static void main(String[] args) {
        
        PreencheBanco banco = PreencheBanco.getInstance();
        banco.preencherBanco();
        
        UserInterface uInterface = new UserInterface();       
        uInterface.ExibirInterface();
    }   
}
