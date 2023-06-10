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
        setApellidos(validarApellido(scanner.nextLine()));
        super.solicitarDatos(scanner);
        System.out.println("Escriba su telefono: ");
        setTelefono(validarTelefono(scanner.nextLine()));
        System.out.println("Escriba su afp; ");
        setAfp(validarAfp(scanner.nextLine()));

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
        setDireccion(validarDireccion(scanner.nextLine()));
        System.out.println("Escriba su comuna; ");
        setComuna(validarComuna(scanner.nextLine()));
        System.out.println("Escriba su edad: ");
        setEdad(validarEdad(scanner.nextInt()));
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

    public String validarApellido(String s) {
        boolean valid = false;
        while (!valid) {
            if (s.length() >= 5 && s.length() <= 30) {
                valid = true;
            } else {
                System.out.println("El apellido contiene errores. Debe tener entre 5 y 30 caracteres.");
                System.out.println("Por favor, ingrese un nuevo nombre:");
                Scanner scanner = new Scanner(System.in);
                String apellido = validarNombre(scanner.nextLine());
                return apellido;
            }
        }
        return s;
    }
    public String validarTelefono(String fono){
    if (fono.isEmpty()) {
        System.out.println("El teléfono es obligatorio. Intente nuevamente.");
        Scanner scanner = new Scanner(System.in);
        fono = scanner.nextLine();
        }
        return fono;
    }

    public String validarAfp(String afp){
        if (afp.length() >= 4 && afp.length() <= 30) {
            System.out.println("Lo ingresado debe estar entre 4 y 30 caracteres. Intente nuevamente.");
            Scanner scanner = new Scanner(System.in);
            afp = scanner.nextLine();

        }
        return afp;
    }
    public String validarDireccion(String dir){
        if (dir.length() >= 70) {
            System.out.println("No puede ingresar mas de 70 caracteres. Intente nuevamente.");
            Scanner scanner = new Scanner(System.in);
            dir = scanner.nextLine();

        }
        return dir;
    }
    public String validarComuna(String comuna){
        if (comuna.length() >= 50) {
            System.out.println("No puede ingresar mas de 50 caracteres. Intente nuevamente.");
            Scanner scanner = new Scanner(System.in);
            comuna = scanner.nextLine();

        }
        return comuna;
    }
    public int validarEdad(int edad) {
        boolean valid = false;
        while (!valid) {
            if (edad >= 0 && edad <= 150) {
                valid = true;
            } else {
                System.out.println("La edad ingresada no es válida. Debe estar entre 0 y 150 años.");
                System.out.println("Por favor, ingrese una nueva edad:");
                Scanner scanner = new Scanner(System.in);
                edad = scanner.nextInt();
            }
        }
        return edad;
    }

}





