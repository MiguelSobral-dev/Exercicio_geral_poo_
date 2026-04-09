package ExercícioGeral;

import java.time.Duration;
import java.time.LocalTime;

public class Registro {
    Veiculo veiculo;
    String horaEntrada;
    String horaSaida;

    public Registro(Veiculo veiculo, String horaEntrada) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
    }

    public double calcularTotal() {
        LocalTime inicio, fim;
        long minutos;
        double valor;

        inicio = LocalTime.parse(horaEntrada);
        fim = LocalTime.parse(horaSaida);
        minutos = Duration.between(inicio, fim).toMinutes();
        valor = minutos * 0.75;
        return valor;
    }
}
