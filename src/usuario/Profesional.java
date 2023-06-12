package usuario;

import java.time.LocalDate;
import java.util.Scanner;


public class Profesional extends Usuario {
    private String titulo;
    private String fechaIngreso;


    public Profesional() {
    }

    public Profesional(Scanner scanner) {

    }

    public Profesional(String nombre, LocalDate fechaNacimiento, int run, String titulo, String fechaIngreso) {
        super(nombre, fechaNacimiento, run);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }


    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;

    }

    @Override
    public void solicitarDatos(Scanner scanner) {
        System.out.println("Escriba su nombre: ");
        setNombre(validarNombre(scanner.nextLine()));
        super.solicitarDatos(scanner);
        System.out.println("Escriba su título: ");
        setTitulo(validarTitulo(scanner.nextLine()));
        System.out.println("Escriba su Fecha de ingreso: (dd/MM/yyyy)");
        fechaIngreso = scanner.nextLine();

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Profesional{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", fechaIngreso='").append(fechaIngreso).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("su titulo es: " + titulo + ", y su fecha de ingreso fue: " + fechaIngreso);
    }

    public String validarTitulo(String titulo) {

        if (titulo.length() < 10 || titulo.length() > 50) {
            System.out.println("Debe ingresar entre 10 y 50 caracteres. Intente nuevamente.");
            titulo = validarTitulo(new Scanner(System.in).nextLine());

        }
        return titulo;
    }
}