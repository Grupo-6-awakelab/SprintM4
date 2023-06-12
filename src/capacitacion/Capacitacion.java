package capacitacion;

import usuario.Cliente;

import java.time.LocalTime;

import java.time.format.DateTimeParseException;
import java.util.Arrays;

import java.util.Scanner;

/**
 * Objeto que representa una capacitacion dirigida a un usuario tipo cliente,
 * en una fecha y lugar determinado.
 */
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


    /**
     * Metodo que se usa para validar el dia ingresado, y que este este en el arreglo.
     *
     * @param dia dia de la capacitación
     * @return boolean
     */
    public boolean diavalido(String dia) {
        String[] diasValidos = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        return Arrays.asList(diasValidos).contains(dia.toLowerCase());
    }

    /**
     * Metodo que genera un id random para una capacitación
     *
     * @return un id random
     */
    public int id() {
        return (int) (Math.random() * 8999999) + 1000000;
    }

    /**
     * Validador de cantidad de caracteres para lugar de la capacitación.
     *
     * @param l lugar de la capacitación
     * @return el lugar si tiene 10 o mas y menor a 50 caracteres.
     */
    public String validarLugar(String l) {

        if (l.length() < 9 || l.length() > 50) {
            System.out.println("El lugar contiene errores. Debe tener entre 10 y 50 caracteres.");
            System.out.println("Por favor, ingrese nuevamente el lugar:");
            Scanner scanner = new Scanner(System.in);
            l = validarLugar(scanner.nextLine());
        }
        return l;

    }

    /**
     * Validador de caracteres para la duracion de la capacitacion.
     *
     * @param d duracion de la capacitacioón.
     * @return la duracion siempre que sea menor o igual a 70 caracteres.
     */
    public String validarDuracion(String d) {
        if (d.length() > 70) {
            System.out.println("el texto ingresado no debe superar los 70 caracteres, ingrese nuevamente");
            d = validarDuracion(new Scanner(System.in).nextLine());
        }
        return d;
    }

    /**
     * Validador de cantidad de asistentes para una capacitación.
     *
     * @param a cantidad de asistentes.
     * @return si es menor o igual a 1000 retorna el valor.
     */
    public int validarAsistentes(int a) {
        if (a > 1000) {
            System.out.println("No debe superar los 1000 asistentes. Intente nuevamente.");
            a = validarAsistentes(new Scanner(System.in).nextInt());
        }
        return a;
    }

    /**
     * Funcion para mostrar detalles de una capacitación..
     */
    public void mostrarDetalles() {
        System.out.println("El id de la capacitacion es: " + id + "\nesta asociada al run de cliente: " +
                getCliente().getRun() + "\nEsta sera el dia: " + dia + "\na las: " + hora + "\nen: "
                + lugar + "\nesta durará: " + duracion + " minutos." + "\ny tiene " + cantidadAsistentes + " asistentes.\n");

    }


    /**
     * Funcion para validar una hora ingresada con un formato en especifico HH:mm (H = Hora m = Minutos)
     * @param hora recibe una hora.
     * @return
     */
    public boolean horaValida(String hora) {

        try {
            LocalTime localTime = LocalTime.parse(hora);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("La hora no debe ser entre 00:00 a 23:59, ingrese nuevamente");
            horaValida(new Scanner(System.in).nextLine());

        }
        return true;
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










