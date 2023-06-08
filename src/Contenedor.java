import capacitacion.Capacitacion;
import capacitacion.IAsesoria;
import usuario.Administrativo;
import usuario.Cliente;
import usuario.SistemaSalud;
import usuario.Usuario;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public void almacenarUsuario(IAsesoria usuario) {
        usuarios.add(usuario);
    }

    public void agregarUsuario(){
        System.out.println("================================================================");
        System.out.println("1. Cliente");
        System.out.println("2. Profesional");
        System.out.println("3. Administrativo");
        System.out.println("================================================================");
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        scanner.nextLine();
        String nombre;
        String apellidos;
        int run;
        String fecha;
        String telefono;
        String afp;
        String sistema;
        String direccion;
        String comuna;
        int edad;
        String titulo;
        String fechaIngreso;
        String area;
        String experienciaPrevia;

        switch(op){
            case 1:
                System.out.println("Escriba su nombre:");
                nombre = scanner.nextLine();

                System.out.println("Escriba su apellidos:");
                apellidos = scanner.nextLine();

                System.out.println("Escriba su run:");
                run = scanner.nextInt();
                scanner.nextLine(); // Agrega esta línea para consumir el salto de línea después de leer el entero

                System.out.println("Escriba su fecha de nacimiento (DD/MM/AAAA):");
                fecha = scanner.nextLine();
                DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNacimiento = LocalDate.parse(fecha, fechaFormatter);

                System.out.println("Escriba su telefono:");
                telefono = scanner.nextLine();

                System.out.println("Escriba su afp:");
                afp = scanner.nextLine();

                System.out.println("Escriba su sistema de salud (Fonasa o Isapre):");
                sistema = scanner.nextLine();
                SistemaSalud sistemaSalud = SistemaSalud.valueOf(sistema.toUpperCase());

                System.out.println("Escriba su direccion:");
                direccion = scanner.nextLine();

                System.out.println("Escriba su comuna:");
                comuna = scanner.nextLine();

                System.out.println("Escriba su edad:");
                edad = scanner.nextInt();

                Cliente cliente = new Cliente(nombre,fechaNacimiento,run,apellidos,telefono,afp,sistemaSalud,direccion,comuna,edad);
                almacenarUsuario(cliente);
                cliente.analizarUsuario();
                break;
            case 2:

                break;
            case 3:
               System.out.println("Escriba su nombre:");
                nombre = scanner.nextLine();
                System.out.println("Escriba su apellidos:");
                apellidos = scanner.nextLine();
                System.out.println("Escriba su run:");
                run = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese su area: ");
                area = scanner.next();
                System.out.println("Ingrese su experiencia:");
                experienciaPrevia = scanner.nextLine();
                Administrativo administrativo = new Administrativo(nombre, apellidos, run, area, experienciaPrevia);
                almacenarUsuario(administrativo);
                administrativo.analizarUsuario();
                break;

        }
    }


    public void almacenarCapacitacon(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
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
            System.out.println("El run ingresado no esta registrado, intente nuevamente");
            eliminarUsuario();
        }
    }


    public void listarUsuarios() {
        for (IAsesoria usuario : usuarios) {
            usuario.analizarUsuario();
        }
    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println("El id de la capacitacion es: " + capacitacion.getId() + "\nesta asociada al run de cliente: "+
                    capacitacion.getCliente().getRun() + "\nEsta sera el dia: " + capacitacion.getDia() + "\na las: " + capacitacion.getHora() + "\nen: "
                    + capacitacion.getLugar() + "\ny esta durará: " + capacitacion.getDuracion() + " minutos." + "\ny tiene " + capacitacion.getCantidadAsistentes() + " asistentes.\n");

            System.out.println("Los datos del cliente son: " + "\nNombre del cliente: " + capacitacion.getCliente().getNombre() + " " +
                    capacitacion.getCliente().getApellidos() + "\nTelefono: " + capacitacion.getCliente().getTelefono() +"\nAFP: "
                    + capacitacion.getCliente().getAfp() + "\nSistema de salud: "+ capacitacion.getCliente().obtenerSistemaDeSalud() + "\nDireccion: "
                    + capacitacion.getCliente().getDireccion() + "\nComuna: "+ capacitacion.getCliente().getComuna() + "\nEdad: "+ capacitacion.getCliente().getEdad());
            System.out.println("--------------------------------");


        }
    }
}
