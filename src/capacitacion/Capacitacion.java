package capacitacion;

import usuario.Cliente;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Capacitacion {
    private int id;
    private Cliente cliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;


    public Capacitacion() {

    }
    private Capacitacion(Scanner scanner) {
    }

    public Capacitacion(Cliente cliente, String dia, String hora, String lugar, String duracion, int cantidadAsistentes) {
        this.id = id();
        this.cliente = cliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }




    public boolean diavalido(String dia) {
        String[] diasValidos = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        return Arrays.asList(diasValidos).contains(dia.toLowerCase());
    }

    public int id() {
        return (int) (Math.random() * 8999999) + 1000000;
    }


    public String validarLugar(String l) {
        boolean valid = false;
        if (l.length() < 9 || l.length() > 50) {
            System.out.println("El lugar contiene errores. Debe tener entre 10 y 50 caracteres.");
            System.out.println("Por favor, ingrese nuevamente el lugar:");
            Scanner scanner = new Scanner(System.in);
            l = validarLugar(scanner.nextLine());
        }
        return l;

    }

    public String validarDuracion(String d) {
        if (d.length() > 70) {
            System.out.println("el texto ingresado no debe superar los 70 caracteres, ingrese nuevamente");
            d = validarDuracion(new Scanner(System.in).nextLine());
        }
        return d;
    }

    public int validarAsistentes(int a) {
        if (a > 1000) {
            System.out.println("No debe superar los 1000 asistentes. Intente nuevamente.");
            a = validarAsistentes(new Scanner(System.in).nextInt());
        }
        return a;
    }

    public void mostrarDetalles() {
        System.out.println("El id de la capacitacion es: " + id + "\nesta asociada al run de cliente: " +
                getCliente().getRun() + "\nEsta sera el dia: " + dia + "\na las: " + hora + "\nen: "
                + lugar + "\ny esta durará: " + duracion + " minutos." + "\ny tiene " + cantidadAsistentes + " asistentes.\n");


    }


    public boolean horaValida(String hora) {
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(hora, horaFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Capacitacion{");
        sb.append("id=").append(id);
        sb.append(", runCliente=").append(cliente.getRun());
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", duracion='").append(duracion).append('\'');
        sb.append(", cantidadAsistentes=").append(cantidadAsistentes);
        sb.append('}');
        return sb.toString();
    }
}










