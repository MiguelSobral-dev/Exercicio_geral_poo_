package br.fiap.carga;

import br.fiap.cliente.Cliente;

import java.util.Random;

public class Carga {
    private int id;
    private String destino;
    private double peso;
    private Cliente cliente;

    public Carga(int id, String destino, double peso, Cliente cliente){
        Random random = new Random();
        this.destino = destino;
        this.cliente = cliente;
        this.id = random.nextInt(10,100);
        this.peso = random.nextDouble(1000, 100000);
    }

    public String getDestino(){
        return destino;
    }

    public void setDestino(){
        this.destino = destino;
    }
}
