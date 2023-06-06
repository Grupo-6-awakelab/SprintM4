import capacitacion.Capacitacion;
import capacitacion.IAsesoria;
import usuario.Usuario;

import javax.swing.*;
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

    public void almacenarCliente(IAsesoria usuario) {
        usuarios.add(usuario);
    }

    public void almacenarProfesional(IAsesoria usuario) {
        usuarios.add(usuario);
    }

    public void agregarAdministrativo(IAsesoria usuario) {
        usuarios.add(usuario);
    }

    public void almacenarCapacitacono(Capacitacion capacitacion) {
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
            System.out.println(capacitacion);
            System.out.println(capacitacion.getCliente().toString());

        }
    }
}
