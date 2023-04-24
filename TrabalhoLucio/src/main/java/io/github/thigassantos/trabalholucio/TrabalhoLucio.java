/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package io.github.thigassantos.trabalholucio;
import io.github.thigassantos.trabalholucio.classes.campus.ui.UserInterface;

public class TrabalhoLucio {  
              
    public static void main(String[] args) {
        
        PreencheBanco banco = new PreencheBanco();
        UserInterface uInterface = new UserInterface();
        banco.preencherBanco();
        uInterface.ExibirInterface();
    }   
}
