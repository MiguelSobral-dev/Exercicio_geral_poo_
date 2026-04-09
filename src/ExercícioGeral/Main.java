package ExercícioGeral;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Veiculo[] veiculo = new Veiculo[5];
    static int indexVeiculo;
    static Registro[] registro = new Registro[10];
    static int indexRegistro;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("#### Estacionamento ParkEasy ####");
            System.out.println("[1] Entrada de veículo");
            System.out.println("[2] Saída de veículo");
            System.out.println("[3] Imprimir veículos estacionados");
            System.out.println("[4] Imprimir a receita");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();

            switch(opcao) {
                case 1 -> entrada();
                case 2 -> saida();
                case 3 -> estacionados();
                case 4 -> imprimirReceita();
                case 5 -> System.out.println("Volte semrpe!");
                default -> System.out.println("OPÇÃO INVALÍDA")     ;
            }

        } while(opcao != 5);
        System.out.println();
    }

    private static void imprimirReceita() {
        double total = 0;
        for (int i = 0; i < indexRegistro; i++) {
            if (registro[i].horaSaida != null){
                total += registro[i].calcularTotal();
            }
        }
        System.out.println("Receita até o momento ---> R$ " +total);
    }

    private static void saida() {
        String horaSaida;
        double valor;
        Registro registro = pesquisarRegistro();
        if(registro != null) {
            System.out.print("Hora de saída (hh:mm) --> ");
            horaSaida = sc.next();
            registro.horaSaida = horaSaida;
            valor = registro.calcularTotal();
            System.out.println("Valor total a pagar R$ " + valor);
        }
    }

    private static Registro pesquisarRegistro() {
        String placa;
        System.out.print("Placa --> ");
        placa = sc.next().toUpperCase();
        for(int i = 0; i < indexRegistro; i++) {
            if(registro[i].veiculo.placa.equals(placa)) {
                return registro[i];
            }
        }
        System.out.println("Veículo não encontrado");
        return null;
    }

    private static void estacionados() {
        System.out.println("######## VEÍCULOS ESTACIONADOS ########");
        for (int i = 0; i < indexRegistro; i++) {
            if (registro[i].horaSaida == null) {
                System.out.println("Placa --> " + registro[i].veiculo.placa);
            }
            System.out.println();
        }
    }

    private static void entrada() {
        String nome;
        String marca, modelo, placa;
        long cpf;
        String horaEntrada;
        Veiculo veiculoEncontrado = pesquisarVeiculo();

        if(veiculoEncontrado == null) {
            System.out.print("Marca --> ");
            marca = sc.next();
            System.out.print("Modelo --> ");
            modelo = sc.next();
            System.out.print("Placa --> ");
            placa = sc.next().toUpperCase();
            System.out.print("Nome do proprietário --> ");
            nome = sc.next();
            System.out.print("CPF --> ");
            cpf = sc.nextLong();
            Proprietario proprietario = new Proprietario(cpf, nome);
            veiculoEncontrado = new Veiculo(placa, marca, modelo, proprietario);
            veiculo[indexVeiculo] = veiculoEncontrado;
            indexVeiculo++;
        }
        System.out.print("Hora de entrada no formato hh:mm --> ");
        horaEntrada = sc.next();
        registro[indexRegistro] = new Registro(veiculoEncontrado, horaEntrada);
        indexRegistro++;

    }

    private static Veiculo pesquisarVeiculo() {
        String placa;
        System.out.print("Placa --> ");
        placa = sc.next().toUpperCase();
        for(int i = 0; i < indexVeiculo; i++) {
            if(veiculo[i].placa.equals(placa)) {
                return veiculo[i];
            }
        }
        System.out.println("Veículo não encontrado");
        return null;
    }
}

