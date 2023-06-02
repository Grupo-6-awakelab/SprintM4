import usuario.Cliente;
import usuario.SistemaSalud;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Kevin", LocalDate.now(),
                123123, "Apellido", "123123",
                "asdasd", SistemaSalud.Fonasa,"asdasd","asdasd",12);

        }
    }
