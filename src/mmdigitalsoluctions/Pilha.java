/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mmdigitalsoluctions;

import java.util.Stack;

public class Pilha {

    public static int somaElementos(Stack<Integer> pilha) {
        // Caso base: se a pilha estiver vazia, retorna 0
        if (pilha.isEmpty()) {
            return 0;
        }
        
        // Retira o elemento do topo temporariamente
        int topo = pilha.pop();
        
        // Soma o elemento atual com a soma dos elementos restantes
        int soma = topo + somaElementos(pilha);
        
        // Reinsere o elemento removido, restaurando a pilha
        pilha.push(topo);
        
        return soma;
    }

    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);

        System.out.println("Soma dos elementos da pilha: " + somaElementos(pilha));
        System.out.println("Pilha após soma: " + pilha); // Verificação de que a pilha não foi alterada
    }
}
