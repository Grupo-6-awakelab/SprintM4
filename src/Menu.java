import capacitacion.Capacitacion;

import java.util.Scanner;

public class Menu {

    Contenedor contenedor = new Contenedor();

    public void orquestaMenu() {
        int op;

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
        System.out.println("---------------------------");
    }
    public int opcionDeMenu(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
}
