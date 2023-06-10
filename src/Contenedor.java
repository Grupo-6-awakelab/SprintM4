import capacitacion.Capacitacion;
import capacitacion.IAsesoria;
import usuario.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contenedor {
    private List<IAsesoria> usuarios;
    private List<Capacitacion> capacitaciones;

    public Contenedor() {
        usuarios = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }


    //    public void almacenarUsuario(){
//        System.out.println("================================================================");
//        System.out.println("1. Cliente");
//        System.out.println("2. Profesional");
//        System.out.println("3. Administrativo");
//        System.out.println("================================================================");
//        Scanner scanner = new Scanner(System.in);
//        int op = scanner.nextInt();
//        scanner.nextLine();
//        String nombre;
//        String apellidos;
//        int run;
//        String fecha;
//        String telefono;
//        String afp;
//        String sistema;
//        String direccion;
//        String comuna;
//        int edad;
//        String titulo;
//        String fechaIngreso;
//        String area;
//        String experienciaPrevia;
//        LocalDate fechaNacimiento;
//        DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        /**
//         * para agregar
//         */
//
//        switch(op){
//            case 1:
//                System.out.println("Escriba su nombre:");
//                nombre = scanner.nextLine();
//
//                System.out.println("Escriba su apellidos:");
//                apellidos = scanner.nextLine();
//
//                System.out.println("Escriba su run:");
//                run = scanner.nextInt();
//                scanner.nextLine(); // Agrega esta línea para consumir el salto de línea después de leer el entero
//
//                System.out.println("Escriba su fecha de nacimiento (DD/MM/AAAA):");
//                fecha = scanner.nextLine();
//                fechaNacimiento = LocalDate.parse(fecha, fechaFormatter);
//
//                System.out.println("Escriba su telefono:");
//                telefono = scanner.nextLine();
//
//                System.out.println("Escriba su afp:");
//                afp = scanner.nextLine();
//
//                System.out.println("Escriba su sistema de salud (Fonasa o Isapre):");
//                sistema = scanner.nextLine();
//                SistemaSalud sistemaSalud = SistemaSalud.valueOf(sistema.toUpperCase());
//
//                System.out.println("Escriba su direccion:");
//                direccion = scanner.nextLine();
//
//                System.out.println("Escriba su comuna:");
//                comuna = scanner.nextLine();
//
//                System.out.println("Escriba su edad:");
//                edad = scanner.nextInt();
//
//                Cliente cliente = new Cliente(nombre,fechaNacimiento,run,apellidos,telefono,afp,sistemaSalud,direccion,comuna,edad);
//                usuarios.add(cliente);
//                cliente.analizarUsuario();
//                break;
//            case 2:
//                System.out.println("Escriba su nombre:");
//                nombre = scanner.nextLine();
//
//                System.out.println("Escriba su run:");
//                run = scanner.nextInt();
//                scanner.nextLine(); // Agrega esta línea para consumir el salto de línea después de leer el entero
//
//                System.out.println("Escriba su fecha de nacimiento (DD/MM/AAAA):");
//                fecha = scanner.nextLine();
//                fechaNacimiento = LocalDate.parse(fecha, fechaFormatter);
//
//                System.out.println("Escriba su titulo");
//                titulo = scanner.nextLine();
//
//                System.out.println("Escriba su fecha de ingreso:");
//                fechaIngreso = scanner.nextLine();
//
//
//                Profesional profesional = new Profesional(nombre, fechaNacimiento, run,titulo, fechaIngreso);
//                usuarios.add(profesional);
//                profesional.analizarUsuario();
//
//                break;
//            case 3:
//               System.out.println("Escriba su nombre:");
//                nombre = scanner.nextLine();
//                System.out.println("Escriba su fecha de nacimiento (DD/MM/AAAA):");
//                fecha = scanner.nextLine();
//                fechaNacimiento = LocalDate.parse(fecha, fechaFormatter);
//                System.out.println("Escriba su run:");
//                run = scanner.nextInt();
//                scanner.nextLine();
//                System.out.println("Ingrese su area: ");
//                area = scanner.next();
//                System.out.println("Ingrese su experiencia:");
//                experienciaPrevia = scanner.nextLine();
//                Administrativo administrativo = new Administrativo(nombre, fechaNacimiento, run, area, experienciaPrevia);
//                usuarios.add(administrativo);
//                administrativo.analizarUsuario();
//                break;
//
//        }
//    }
    public void adduser(IAsesoria usuario) {
        usuarios.add(usuario);
    }

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
            usuario.analizarUsuario();
        } else {
            System.out.println("Opción no válida");
        }
    }

    public String obtenerNombreClase(int op) {
        switch (op) {
            case 1:
                return "usuario.Cliente";
            case 2:
                return "usuario.Profesional";
            case 3:
                return "usuario.Administrativo";
            default:
                return null;
        }
    }

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


    private static boolean esDiaValido(String dia) {
        String[] diasValidos = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        for (String diaValido : diasValidos) {
            if (dia.equalsIgnoreCase(diaValido)) {
                return true;
            }
        }
        return false;
    }

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
                listarporTipo(Administrativo.class, i);
                break;
            case 3:
                listarporTipo(Profesional.class, i);
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
            System.out.println("El id de la capacitacion es: " + capacitacion.getId() + "\nesta asociada al run de cliente: " +
                    capacitacion.getCliente().getRun() + "\nEsta sera el dia: " + capacitacion.getDia() + "\na las: " + capacitacion.getHora() + "\nen: "
                    + capacitacion.getLugar() + "\ny esta durará: " + capacitacion.getDuracion() + " minutos." + "\ny tiene " + capacitacion.getCantidadAsistentes() + " asistentes.\n");

            System.out.println("Los datos del cliente son: " + "\nNombre del cliente: " + capacitacion.getCliente().getNombre() + " " +
                    capacitacion.getCliente().getApellidos() + "\nTelefono: " + capacitacion.getCliente().getTelefono() + "\nAFP: "
                    + capacitacion.getCliente().getAfp() + "\nSistema de salud: " + capacitacion.getCliente().obtenerSistemaDeSalud() + "\nDireccion: "
                    + capacitacion.getCliente().getDireccion() + "\nComuna: " + capacitacion.getCliente().getComuna() + "\nEdad: " + capacitacion.getCliente().getEdad());
            System.out.println("--------------------------------");


        }
    }

    public void almacenarCapacitacon() {
        String dia;
        Capacitacion capacitacion = new Capacitacion();
        System.out.println("Ingrese su run");
        Scanner entrada = new Scanner(System.in);
        Cliente clienteAsignado = null;
        int run = entrada.nextInt();
        entrada.nextLine();
        for (IAsesoria usuario : usuarios) {
            if (usuario instanceof Cliente) {
                Cliente c = (Cliente) usuario;
                if (c.getRun() == run) {
                    clienteAsignado = c;
                } else {
                    System.out.println("error");
                }
            }
        }
        System.out.println("ingrese el dia de la capacitacion");
        dia = entrada.nextLine();
        public void validarDia(dia) {
        boolean valid = false;
        while (!valid) {
            if (diavalido(dia)) {
                dia = dia;
                valid = true;
// CORREGIR PROBLEMA
            } else {
                System.out.println("Error, ingrese dia valido");
                Scanner scanner = new Scanner(System.in);
                dia = scanner.nextLine();
                diavalido(dia);

            }

        }
        }


       System.out.println("Ingrese la Hora");
        String hora = entrada.nextLine();
        boolean valid = false;
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



        System.out.println("Ingrese el lugar de la capacitación");
        capacitacion.validarLugar(entrada.nextLine());

        System.out.println("Ingrese la duración");
        capacitacion.validarDuracion(entrada.nextLine());

        System.out.println("Ingrese cantidad asistentes");
        capacitacion.validarAsistentes((entrada.nextInt()));


}

}





