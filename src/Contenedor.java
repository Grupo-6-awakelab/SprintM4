import capacitacion.Capacitacion;
import capacitacion.IAsesoria;
import usuario.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase contenedora de funciones y listas de usuario y capacitaciones
 */
public class Contenedor {
    private List<IAsesoria> usuarios;
    private List<Capacitacion> capacitaciones;

    public Contenedor() {
        usuarios = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }


    public void adduser(IAsesoria usuario) {
        usuarios.add(usuario);
    }

    public void addCapacitacion(Capacitacion capacitacion) {
        this.capacitaciones.add(capacitacion);
    }

    /**
     * Funcion que sirve para almacenar a los usuarios.
     */
    public void almacenarUsuario() {
        System.out.println("================================================================");
        System.out.println("1. Cliente");
        System.out.println("2. Profesional");
        System.out.println("3. Administrativo");
        System.out.println("================================================================");
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = crearUsuario(op, scanner);

        if (usuario != null) {
            usuario.solicitarDatos(scanner);
            usuarios.add(usuario);
            if (usuario instanceof Cliente) {
                Cliente c = (Cliente) usuario;
                c.contarVisitasTerreno();
            }
        } else {
            System.out.println("Opción no válida");
        }
    }

    /**
     * metodo para obtener nombre clase del usuario
     * @param op opcion
     * @return nombre de la clas.
     */
    public String obtenerNombreClase(int op) {
        switch (op) {
            case 1:
                return "usuario.Cliente";
            case 2:
                return "usuario.Profesional";
            case 3:
                return "usuario.Administrativo";
            default: {
                System.out.println("Opcion incorrecta elija nuevamente");
                almacenarUsuario();


            }
            return null;
        }
    }

    /**
     * Reflexion usada para crear al usuario.
     * @param op opcion para obtener clase del usurio
     * @param scanner para buscar al constructor.
     * @return
     */
    public Usuario crearUsuario(int op, Scanner scanner) {
        try {
            Class<?> usuarioClass = Class.forName(obtenerNombreClase(op));
            Constructor<?> constructor = usuarioClass.getConstructor(Scanner.class);
            return (Usuario) constructor.newInstance(scanner);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * metodo para listar usuarios por tipo
     * @param c la clase
     * @param i numero de usuario
     */

    public void listarporTipo(Class c, int i) {
        for (IAsesoria usuario : usuarios) {
            if (c.isInstance(usuario)) {
                System.out.println("Usuario " + i);
                System.out.println("----------------------");
                usuario.analizarUsuario();
                System.out.println("----------------------");
                i++;
            }
        }
    }

    public void listarUsuarioPorTipo() {
        int op;
        int i = 1;
        System.out.println("================================================================");
        System.out.println("1. Cliente");
        System.out.println("2. Profesional");
        System.out.println("3. Administrativo");
        System.out.println("================================================================");
        op = new Scanner(System.in).nextInt();
        switch (op) {
            case 1:
                listarporTipo(Cliente.class, i);
                break;
            case 2:
                listarporTipo(Profesional.class, i);
                break;
            case 3:
                listarporTipo(Administrativo.class, i);
                break;

            default:
                System.out.println("Elija la opcion correcta");


        }
    }

    public void eliminarUsuario() {

        boolean encontrado = false;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el rut del usuario a eliminar");
        int run = entrada.nextInt();
        for (int i = 0; i < usuarios.size(); i++) {
            IAsesoria usuario = usuarios.get(i);
            if (((Usuario) usuario).getRun() == run) {
                usuarios.remove(i);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {

            System.out.println("Se ha eliminado correctamente al usuario con run: " + run);

        } else {
            System.out.println("El run ingresado no esta registrado. ¿Quiere intentar nuevamente? (1.SI 2.NO");
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();
            if (op == 1) {
                eliminarUsuario();
            }
            Menu menu = new Menu();
            menu.orquestaMenu();

        }
    }


    public void listarUsuarios() {
        int i = 1;
        for (IAsesoria usuario : usuarios) {
            System.out.println("Usuario " + i);
            System.out.println("----------------------");
            usuario.analizarUsuario();
            i++;
            System.out.println("----------------------");
        }
    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            capacitacion.mostrarDetalles();
            System.out.println("-------------------- Datos Cliente asociado a la capacitacion " + capacitacion.getId() + " -------------------");
            System.out.println("Los datos del cliente son: " + "\nNombre del cliente: " + capacitacion.getCliente().getNombre() + " " +
                    capacitacion.getCliente().getApellidos() + "\nTelefono: " + capacitacion.getCliente().getTelefono() + "\nAFP: "
                    + capacitacion.getCliente().getAfp() + "\nSistema de salud: " + capacitacion.getCliente().obtenerSistemaDeSalud() + "\nDireccion: "
                    + capacitacion.getCliente().getDireccion() + "\nComuna: " + capacitacion.getCliente().getComuna() + "\nEdad: " + capacitacion.getCliente().getEdad());
            System.out.println("--------------------------------");


        }
    }

    /**
     * Metodo que almacena las capacitaciones en una lista solicitando datos por consola.
     */
    public void almacenarCapacitacion() {

        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setId(capacitacion.id());
        System.out.println("Ingrese su run");
        Scanner entrada = new Scanner(System.in);
        int run = entrada.nextInt();
        boolean clienteEncontrado = false;
        entrada.nextLine();

        while (!clienteEncontrado) {
            for (IAsesoria usuario : usuarios) {
                if (usuario instanceof Cliente) {
                    Cliente c = (Cliente) usuario;
                    if (c.getRun() == run) {
                        clienteEncontrado = true;
                        capacitacion.setCliente(c);
                        break;
                    }
                }

            }
            if (!clienteEncontrado) {
                System.out.println("No se encontro un cliente con el rut indicado, ingrese nuevamente");
                run = entrada.nextInt();
            }
        }

        System.out.println("ingrese el dia de la capacitacion");
        String dia = entrada.nextLine();
        boolean valid = false;
        while (!valid) {
            if (capacitacion.diavalido(dia)) {
                dia = dia;
                valid = true;

            } else {
                System.out.println("Error, ingrese dia valido");
                Scanner scanner = new Scanner(System.in);
                dia = scanner.nextLine();
                capacitacion.diavalido(dia);

            }
        }
        capacitacion.setDia(dia);
        //Ingreso y validacion de hora
        System.out.println("Ingrese la Hora");
        String hora = entrada.nextLine();
        valid = false;
        while (!valid) {
            if (capacitacion.horaValida(hora)) {
                hora = hora;
                valid = true;

            } else {
                System.out.println("Error, ingrese hora valida");
                hora = entrada.nextLine();
                capacitacion.horaValida(hora);

            }

        }
        capacitacion.setHora(hora);
        //ingreso de lugar de capacitacion
        System.out.println("Ingrese el lugar de la capacitación");
        String lugar = capacitacion.validarLugar(entrada.nextLine());
        capacitacion.setLugar(lugar);
        //Ingreso de la duracion de la capacitacion
        System.out.println("Ingrese la duración");
        String duracion = capacitacion.validarDuracion(entrada.nextLine());
        capacitacion.setDuracion(duracion);
        //ingreso de la cantidad de asistentes
        System.out.println("Ingrese cantidad asistentes");
        int asistentes = capacitacion.validarAsistentes((entrada.nextInt()));
        capacitacion.setCantidadAsistentes(asistentes);
        this.addCapacitacion(capacitacion);
    }


}





