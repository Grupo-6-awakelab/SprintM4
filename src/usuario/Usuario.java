package usuario;

import capacitacion.IAsesoria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Usuario implements IAsesoria {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int run;
    private DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Usuario(){

    }

    public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }


    public void obtenerEdad() {
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        System.out.println( "El usuario " + nombre + " tiene " + edad + " años");;


    }


    public void solicitarDatos(Scanner scanner) {
        System.out.println("Escriba su run:");
        setRun(validarRut(scanner.nextInt()));
        LocalDate fechaNacimiento = null;
        do {
            System.out.println("Escriba su Fecha de nacimiento: (dd/MM/yyyy)");
            String fechaIngresada = scanner.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaIngresada, fechaFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha de nacimiento inválida. Intente nuevamente.");
            }
        } while (fechaNacimiento == null);
    }

    public String validarNombre(String s) {
        boolean valid = false;
        while (!valid) {
            if (s.length() >= 10 && s.length() <= 50) {
                valid = true;
            } else {
                System.out.println("El nombre contiene errores. Debe tener entre 10 y 50 caracteres.");
                System.out.println("Por favor, ingrese un nuevo nombre:");
                Scanner scanner = new Scanner(System.in);
                String nombre = validarNombre(scanner.nextLine());
                return nombre;
            }
        }
        return s;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", fechaNacimiento='").append(fechaNacimiento).append('\'');
        sb.append(", run=").append(run);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Su nombre es: " + nombre + " y su rut es: " + run);
    }

    public int validarRut(int rut){
        Scanner scanner = new Scanner(System.in);
        while (run >= 99999999) {
            System.out.println("RUT inválido. Intente nuevamente.");
            System.out.println("Escriba su run:");
            run = scanner.nextInt();
            scanner.nextLine();
        }
        return rut;
    }
}
