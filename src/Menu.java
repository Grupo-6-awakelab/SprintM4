import capacitacion.Capacitacion;
import usuario.Cliente;
import usuario.SistemaSalud;
import usuario.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    Contenedor contenedor = new Contenedor();

    public void orquestaMenu() {
        int op;
        Usuario cliente1 = new Cliente("Luis", LocalDate.of(1986, 3, 7), 7890123, "987654321","adaadad","adada", SistemaSalud.FONASA,"adada","adada",123);
        contenedor.adduser(cliente1);
        do {
            muestraMenu();
            System.out.println("Selecciona la opción del menú: ");
            op = opcionDeMenu();
            switch (op){
                case 1: {
                    contenedor.almacenarUsuario();
                    break;
                }
                case 2: {
                    contenedor.almacenarCapacitacon();
                    break;
                }
                case 3: {
                    contenedor.eliminarUsuario();
                    break;
                }
                case 4: {
                    contenedor.listarUsuarios();
                    break;

                    }
                case 5:{
                    contenedor.listarCapacitaciones();
                    break;

                }
                case 6:{
                    contenedor.listarUsuarioPorTipo();
                    break;
                }
                case 0: {
                    System.out.println("Saliendo........");
                    break;
                }
                default: {
                    System.out.println("Elije una opncion correcta.");
                }
            }
        } while (op != 0);

    }

    public void muestraMenu(){
        System.out.println("===========================");
        System.out.println(" MENÚ PRINCIPAL");
        System.out.println("---------------------------");
        System.out.println("1. Almacenar Usuario");
        System.out.println("2. Almacenar Capacitacion");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Listar Usuarios");
        System.out.println("5. Listar Capacitaciones");
        System.out.println("6. Listar por tipo de Usuarios");
        System.out.println("0. Salir");
        System.out.println("---------------------------");
    }
    public int opcionDeMenu(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }



}
