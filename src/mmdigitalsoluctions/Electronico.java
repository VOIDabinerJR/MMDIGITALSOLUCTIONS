package mmdigitalsoluctions;

import java.util.List;
import java.util.ArrayList;


abstract class Electronico {
    
    private String nome;
    private String marca;
    private Double preco;

    
    public abstract void calcularPrecoFinal();
    
    public void imprimirDados() {
        System.out.println("Nome: " + this.getNome() + ". Marca: " + this.getMarca() + ". Preço: " + this.getPreco());
    } 
            
 
    public Electronico() {
    }

    
    public Electronico(String nome, String marca, Double preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}


class Computador extends Electronico {
    
    private boolean gamer;
    private boolean status;

    
    public Computador() {
        super(); 
    }

    
    public Computador(String nome, String marca, Double preco, boolean gamer, boolean status) {
        super(nome, marca, preco);
        this.status = status;
    }

    @Override
    public void calcularPrecoFinal() {
        if (this.isGamer()) {
            this.setPreco(this.getPreco() * 0.1 + this.getPreco());
        }
    }
    
    @Override
    public void imprimirDados() {
        super.imprimirDados(); 
        System.out.println("Gamer: " + this.gamer);
        System.out.println("Status: " + this.status);
    }

    // Getters e Setters
    public boolean isGamer() {
        return gamer;
    }

    public void setGamer(boolean gamer) {
        this.gamer = gamer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}


class Smartphone extends Electronico {

    private int memoriaRAM;
    private int armazenamento;

    // Construtor padrão
    public Smartphone() {
        super();
    }


    public Smartphone(String nome, String marca, Double preco, int memoriaRAM, int armazenamento) {
        super(nome, marca, preco); 
        this.memoriaRAM = memoriaRAM;
        this.armazenamento = armazenamento;
    }

    @Override
    public void calcularPrecoFinal() {
        if (this.getMemoriaRAM() > 8192) {
            this.setPreco(this.getPreco() * 0.08 + this.getPreco());
        }
    }
    @Override
    public void imprimirDados() {
        super.imprimirDados(); 
        System.out.println("MemoriaRAM: " + this.memoriaRAM);
        System.out.println("Armazenamento: " + this.armazenamento);
    }

    // Getters e Setters
    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }
}
