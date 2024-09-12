/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mmdigitalsoluctions;

import java.util.Stack;

public class Pilha {

    public static int somaElementos(Stack<Integer> pilha) {
        
        if (pilha.isEmpty()) {
            return 0;
        }
        
        
        int topo = pilha.pop();
        
      
        int soma = topo + somaElementos(pilha);
       
        pilha.push(topo);
        
        return soma;
    }

    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);

        System.out.println("Soma: " + somaElementos(pilha));
        System.out.println("Pilha: " + pilha); 
    }
}
