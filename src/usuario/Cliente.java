package usuario;

import capacitacion.Accidente;
import capacitacion.Capacitacion;
import capacitacion.VisitaTerreno;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa usuario tipo cliente.
 */

public class Cliente extends Usuario {

    Scanner scanner = new Scanner(System.in);
    private String apellidos;
    private String telefono;
    private String afp;

    private List<Capacitacion> capacitaciones;
    private List<VisitaTerreno> visitaTerrenos;
    private List<Accidente> accidentes;
    private SistemaSalud sistemaSalud;

    private String direccion;
    private String comuna;
    private int edad;

    public Cliente() {


    }

    public Cliente(Scanner scanner) {

    }

    public Cliente(String nombre, LocalDate fechaNacimiento, int run, String apellidos, String telefono, String afp, List<Capacitacion> capacitaciones, List<VisitaTerreno> visitaTerrenos, List<Accidente> accidentes, SistemaSalud sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.capacitaciones = capacitaciones;
        this.visitaTerrenos = visitaTerrenos;
        this.accidentes = accidentes;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public List<Accidente> getAccidentes() {
        return accidentes;
    }

    public void setAccidentes(List<Accidente> accidentes) {
        this.accidentes = accidentes;
    }

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public List<VisitaTerreno> getVisitaTerrenos() {
        return visitaTerrenos;
    }

    public void setVisitaTerrenos(List<VisitaTerreno> visitaTerrenos) {
        this.visitaTerrenos = visitaTerrenos;
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

    /**
     * Metodo que nos sirve para obtener el sistema de salud del cliente.
     * @return el sistema de salud.
     */
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

    /**
     * Valida si el cliente tiene visitas a terreno.
     */
    public void contarVisitasTerreno() {
        if (visitaTerrenos != null) {

        } else {
            System.out.println("El cliente no registra visitas a terreno - debes agregar al menos una, puedes hacerlo despues");
        }
    }

    /**
     * Metodo que se usa para seter datos del cliente.
     * @param scanner
     */
    @Override
    public void solicitarDatos(Scanner scanner) {
        System.out.println("Escriba su nombre: ");
        setNombre(validarNombre(scanner.nextLine()));
        System.out.println("Escriba sus apellidos: ");
        setApellidos(validarApellido(scanner.nextLine()));
        super.solicitarDatos(scanner);
        System.out.println("Escriba su telefono: ");
        setTelefono(validarTelefono(scanner.nextLine()));
        System.out.println("Escriba su afp: ");
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
        System.out.println("Escriba su comuna: ");
        setComuna(validarComuna(scanner.nextLine()));
        System.out.println("Escriba su edad: ");
        setEdad(validarEdad(scanner.nextInt()));
    }

    /**
     * Metodo que entrega en consola los datos relevantes.
     */
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Su dreccion es: " + direccion);
        System.out.println("Su comuna es: " + comuna);


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

    /**
     * Metodo que valida largo del apellido.
     * @param s apellido
     * @return apellido
     */
    public String validarApellido(String s) {

        if (s.length() < 5 || s.length() > 30) {
            System.out.println("El apellido contiene errores. Debe tener entre 5 y 30 caracteres.");
            System.out.println("Por favor, ingrese un nuevo nombre:");
            Scanner scanner = new Scanner(System.in);
            s = validarApellido(scanner.nextLine());

        }
        return s;
    }

    /**
     * Metodo que valida que telefono sea obligatorio
     * @param fono
     * @return telefono
     */
    public String validarTelefono(String fono) {
        if (fono.isEmpty()) {
            System.out.println("El teléfono es obligatorio. Intente nuevamente.");
            Scanner scanner = new Scanner(System.in);
            fono = scanner.nextLine();
        }
        return fono;
    }

    /**
     * metodo que valida largo de afp
     * @param s afp
     * @return afp
     */
    public String validarAfp(String s) {
        if (s.length() < 4 || s.length() > 30) {
            System.out.println("Lo ingresado debe estar entre 4 y 30 caracteres. Intente nuevamente.");
            s = validarAfp(scanner.nextLine());
        }
        return s;
    }

    public String validarDireccion(String dir) {
        if (dir.length() > 70) {
            System.out.println("No puede ingresar mas de 70 caracteres. Intente nuevamente.");
            Scanner scanner = new Scanner(System.in);
            dir = validarDireccion(scanner.nextLine());

        }
        return dir;
    }

    public String validarComuna(String s) {
        if (s.length() > 50) {
            System.out.println("No puede ingresar mas de 50 caracteres. Intente nuevamente.");
            Scanner scanner = new Scanner(System.in);
            s = validarComuna(scanner.nextLine());

        }
        return s;
    }

    public int validarEdad(int i) {
        if (i == 0 || i > 150) {
            System.out.println("La edad ingresada no es válida. Debe estar entre 0 y 150 años.");
            System.out.println("Por favor, ingrese una nueva edad:");
            i = validarEdad(new Scanner(System.in).nextInt());

        }
        return i;
    }
}







