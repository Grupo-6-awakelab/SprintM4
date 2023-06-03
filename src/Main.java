import usuario.Cliente;
import usuario.SistemaSalud;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Kevin", LocalDate.now(),
                1111, "Apellido", "123123",
                "asdasd", SistemaSalud.Isapre,"asdasd","asdasd",12);
        Cliente cliente2 = new Cliente("Kevin1", LocalDate.now(),
                2222, "Apellido", "123123",
                "asdasd", SistemaSalud.Isapre,"asdasd","asdasd",12);



        Contenedor contenedor = new Contenedor();
        contenedor.almacenarCliente(cliente);
        contenedor.almacenarCliente(cliente2);
        contenedor.analizarUsuario();

        contenedor.eliminarUsuario();

        contenedor.analizarUsuario();

    }

    }
