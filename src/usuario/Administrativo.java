package usuario;

import java.time.LocalDate;
import java.util.Scanner;

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




    @Override
    public void solicitarDatos(Scanner scanner) {
        System.out.println("Escriba su nombre: ");
        setNombre(validarNombre(scanner.nextLine()));
        super.solicitarDatos(scanner);
        do {
            System.out.println("Escriba su área:");
            area = scanner.nextLine();
            if (area.length() < 5 || area.length() > 20) {
                System.out.println("Debe ingresar entre 5 y 20 caracteres. Intente nuevamente.");
            }
        } while (area.length() < 5 || area.length() > 20);
        this.area = area;

        do {
            System.out.println("Escriba su experiencia previa:");
            experienciaPrevia = scanner.nextLine();
            if (experienciaPrevia.length() > 100) {
                System.out.println("Largo máximo de caracteres (100) superado, ingrese menos caracteres.");
            }
        } while (experienciaPrevia.length() > 100);
        this.experienciaPrevia = experienciaPrevia;


    }
    @Override
    public String toString() {
        return "Administrativo{" +
                "area='" + area + '\'' +
                ", experienciaPrevia='" + experienciaPrevia + '\'' +
                '}';
    }

        @Override
        public void analizarUsuario() {
            super.analizarUsuario();
            System.out.println("su área es: " + area + ", y su experiencia previa: " + experienciaPrevia);
        }


}
