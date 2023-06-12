package capacitacion;

import usuario.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una visita a terrero, en una fecha y hora determianda.
 */

public class VisitaTerreno {

    private int id;
    private Cliente cliente;
    private List<Revision> revisiones;
    private LocalDate dia;
    private String hora;
    private String lugar;
    private String comentarios;


    public VisitaTerreno() {
    }

    public VisitaTerreno( Cliente cliente, List<Revision> revisiones, LocalDate dia, String hora, String lugar, String comentarios) {
        this.id = id();
        this.cliente = cliente;
        this.revisiones = revisiones;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int id() {
        return (int) (Math.random() * 8999999) + 1000000;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Valida que esta visita a terreno tenga una revision
     */

    public void verificarRevison() {
        if (revisiones != null) {

        } else {
            System.out.println("Las visitas a terrenos deben tener una o mas revisiones por ocasion");
        }
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
    /**
     * Validador de cantidad de caracteres para lugar de la revision.
     *
     * @param l lugar de la revision
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
     * Validador de cantidad de caracteres para los comentarios.
     *
     * @param l comentario de la revision
     * @return el comentario si tiene maximo 100 caracteres.
     */
    public String validarComentarios(String l) {

        if (l.length() > 100) {
            System.out.println("los comentarios deben tener un maximo de 100 caracteres");
            System.out.println("Por favor, ingrese nuevamente el lugar:");
            Scanner scanner = new Scanner(System.in);
            l = validarLugar(scanner.nextLine());
        }
        return l;

    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VisitaTerreno{");
        sb.append("id=").append(id);
        sb.append(", rutCliente=").append(cliente.getRun());
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", comentarios='").append(comentarios).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
