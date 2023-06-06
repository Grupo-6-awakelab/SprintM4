    import capacitacion.Capacitacion;
    import capacitacion.IAsesoria;
    import usuario.Usuario;

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
            Scanner entrada = new Scanner(System.in);
            System.out.println("Escriba el rut del usuario a eliminar");
            int run = entrada.nextInt();
            for (int i = 0; i < usuarios.size(); i++) {
                IAsesoria usuario = usuarios.get(i);
                if (usuario instanceof Usuario && ((Usuario) usuario).getRun() == run) {
                    usuarios.remove(i);
                    i--; // Ajustar el índice después de la eliminación
                }
            }
        }
        public void analizarUsuario() {
            for (IAsesoria usuario : usuarios) {
                usuario.analizarUsuario();
            }
        }
    }
