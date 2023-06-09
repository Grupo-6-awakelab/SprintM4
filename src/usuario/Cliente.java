package usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente extends Usuario {
    private String apellidos;
    private String telefono;
    private String afp;


    private SistemaSalud sistemaSalud;

    private String direccion;
    private String comuna;
    private int edad;

    public Cliente() {


    }

    public Cliente(Scanner scanner) {

    }

    public Cliente(String nombre, LocalDate fechaNacimiento, int run, String apellidos, String telefono, String afp, SistemaSalud sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * en el metodo obtenerNombre() traemos el nombre de la clase usuario y el apellido de la clase
     * cliente.
     */
    public String obtenerNombre() {
        return getNombre() + " " + apellidos;
    }

    public SistemaSalud getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(SistemaSalud sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }

    public String obtenerSistemaDeSalud() {

        switch (sistemaSalud.ordinal() + 1) {
            case 1:
                return "Fonasa";

            case 2:
                return "Isapre";

            default:

        }
        return null;
    }


    @Override
    public void solicitarDatos(Scanner scanner) {


        System.out.println("Escriba su nombre: ");
        setNombre(validarNombre(scanner.nextLine()));
        System.out.println("Escriba sus apellidos: ");
        apellidos = scanner.nextLine();
        super.solicitarDatos(scanner);
        System.out.println("Escriba su telefono: ");
        telefono = scanner.nextLine();
        System.out.println("Escriba su afp; ");
        afp = scanner.nextLine();

        boolean sistemaValido = false;

        while (!sistemaValido) {
            System.out.println("Escriba su sistema de salud (Fonasa o Isapre):");
            String sistema = scanner.nextLine();
            sistema = sistema.toUpperCase();

            if (sistema.equals("FONASA") || sistema.equals("ISAPRE")) {
                sistemaSalud = SistemaSalud.valueOf(sistema);
                sistemaValido = true;
            } else {
                System.out.println("El sistema de salud ingresado no es válido. Por favor, intente nuevamente.");
            }
        }

        System.out.println("Escriba su dirección: ");
        direccion = scanner.nextLine();
        System.out.println("Escriba su comuna; ");
        comuna = scanner.nextLine();
        System.out.println("Escriba su edad: ");
        edad = scanner.nextInt();

    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("run='").append(getRun()).append('\'');
        sb.append("apellidos='").append(apellidos).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", afp='").append(afp).append('\'');
        sb.append(", sistemaSalud=").append(sistemaSalud);
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", comuna='").append(comuna).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }


}





