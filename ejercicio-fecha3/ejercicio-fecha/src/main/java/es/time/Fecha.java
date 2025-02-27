package es.time;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.*;

public class Fecha {

    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    public LocalDate convertirStringALocalDate(String fechaStr, String formato) {
        fechaStr = "dd-MM-yyyy";
        LocalDate convertir = LocalDate.parse(formato);
        LocalDate convertir2 = convertir.parse(fechaStr);
        return convertir2;
    }

    public String formatearFecha(LocalDate fecha, String formato) {
        fecha = LocalDate.now();
        DateTimeFormatter convertir2 = DateTimeFormatter.ofPattern(formato);
        String covertir = fecha.format(convertir2);

        return covertir;
    }

    public int calcularEdad(LocalDate fechaNacimiento) {
        
        return 0;
    }

    public LocalDate sumarDias(LocalDate fecha, int dias) {
        LocalDate suma = fecha.plusDays(dias);
        return suma;
    }

    public LocalDate restarDias(LocalDate fecha, int dias) {
        return fecha.minusDays(dias);
    }

    public LocalDate sumarMeses(LocalDate fecha, int meses) {
        return fecha.plusMonths(meses);
    }

    public LocalDate restarMeses(LocalDate fecha, int meses) {
        return fecha.minusMonths(meses);
    }

    public long diferenciaDias(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }

    public long diferenciaMeses(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.MONTHS.between(fecha1, fecha2);
    }

    public long diferenciaAnios(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.YEARS.between(fecha1, fecha2);
    }

    public int compararFechas(LocalDate fecha1, LocalDate fecha2) {
        return 1000;
    }

    public boolean esBisiesto(LocalDate fecha) {
        return fecha.isLeapYear();
    }

    public String obtenerDiaSemana(LocalDate fecha) {
        return null;
    }

    public int obtenerDiaDelAnio(LocalDate fecha) {
        return -1;
    }

    public LocalDate obtenerPrimerDiaMes(LocalDate fecha) {
        return null;
    }

    public LocalDate obtenerUltimoDiaMes(LocalDate fecha) {
        return null;
    }

    public ZonedDateTime convertirZonaHoraria(LocalDateTime fechaHora, String zona) {
        return null;
    }


    public Duration calcularDiferenciaHorasMinutos(LocalDateTime inicio, LocalDateTime fin) {
        return null;
    }
}
