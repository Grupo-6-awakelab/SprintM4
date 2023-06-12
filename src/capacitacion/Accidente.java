package capacitacion;

import usuario.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Este objeto representa el registro de algun accidente ocurrido en una fecha y hora determinada y que esta
 * asignado a un cliente en especifico
 */
public class Accidente {
    private int id;
    private Cliente cliente;

    private LocalDate dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencia;

    public Accidente() {
    }

    public Accidente(Cliente cliente, LocalDate dia, String hora, String lugar, String origen, String consecuencia) {
        this.id = id();
        this.cliente = cliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencia = consecuencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    /**
     * Genera un id random.
     * @return el id generado.
     */
    public int id() {
        return (int) (Math.random() * 8999999) + 1000000;
    }

    /**
     * Valida que el rut no este vacio.
     * @param s rut
     * @return el rut.
     */

    public boolean validaRut(String s) {
        if (s.isEmpty()) {
            System.out.println("El rut es obligatorio, ingresalo!");
            boolean b = validaRut(new Scanner(System.in).nextLine());

        } return true;
    }

    /**
     * Validador para maximo 100 caracteres.
     *
     * @param l string recibido
     * @return el mismo string si no supera los 100 caracteres.
     */
    public String validarCienCaracteres(String l) {

        if (l.length() > 100) {
            System.out.println("los comentarios deben tener un maximo de 100 caracteres");
            System.out.println("Por favor, ingrese nuevamente el lugar:");
            Scanner scanner = new Scanner(System.in);
            l = validarCienCaracteres(scanner.nextLine());
        }
        return l;

    }
    /**
     * Validador de cantidad de caracteres para lugar del accidente.
     *
     * @param l lugar de la accidente
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
     * Valida que el dia sea ingresado en formato establecido.
     * @param s el dia
     * @return el dia como LocalDate.
     */

    public LocalDate validarDia(String s){
        try {
            DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dia = LocalDate.parse(s, fechaFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha de nacimiento inválida. Intente nuevamente. ");
            LocalDate f = validarDia(new Scanner(System.in).nextLine());

        }
        return dia;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Accidente{");
        sb.append("id=").append(id);
        sb.append(", runCliente=").append(cliente.getRun());
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", origen='").append(origen).append('\'');
        sb.append(", consecuencia='").append(consecuencia).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
