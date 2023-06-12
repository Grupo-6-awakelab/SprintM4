package usuario;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase que representa un usuario de tipo Administrativo.
 */

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;


    public Administrativo() {
    }

    public Administrativo(Scanner scanner) {

    }


    public Administrativo(String nombre, LocalDate fechaNacimiento, int run, String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, run);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }


    /**
     * Metodo que solicita datos via scanner para ser guardados en el usuario.
     *
     * @param scanner
     */
    @Override
    public void solicitarDatos(Scanner scanner) {
        System.out.println("Escriba su nombre: ");
        setNombre(validarNombre(scanner.nextLine()));
        super.solicitarDatos(scanner);
        System.out.println("Escriba su área:");
        setArea(validarArea(scanner.nextLine()));
        System.out.println("Escriba su experiencia previa:");
        setExperienciaPrevia(validarExperiencia(scanner.nextLine()));
    }

    /**
     * Metodo que analiza el usuario entregando datos de relevancia.
     */
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("su área es: " + area + ", y su experiencia previa: " + experienciaPrevia);
    }

    /**
     * Validador de largo de atribulo area
     *
     * @param s area del administrador
     * @return el aria si es valida
     */
    public String validarArea(String s) {
        if (s.length() < 5 || s.length() > 20) {
            System.out.println("El area ingresado debe contener entre 5 y 20 caracteres");
            s = validarArea(new Scanner(System.in).nextLine());
        }
        return s;
    }

    /**
     * valida largo de experiencia ingresada a maximo 100 caracteres
     * @param s experiencia
     * @return experiencia
     */
    public String validarExperiencia(String s) {
        if (s.length() > 100) {
            System.out.println("La experiencia ingresada debe contener maximo 100 caracteres1");
            s = validarArea(new Scanner(System.in).nextLine());
        }
        return s;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "area='" + area + '\'' +
                ", experienciaPrevia='" + experienciaPrevia + '\'' +
                '}';
    }
}
