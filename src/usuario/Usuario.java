package usuario;

import capacitacion.IAsesoria;

import java.time.LocalDate;

public class Usuario implements IAsesoria {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int run;


    public Usuario(){

    }

    public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }


    public void obtenerEdad() {
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        System.out.println( "El usuario " + nombre + " tiene " + edad + " años");;

    }




    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", fechaNacimiento='").append(fechaNacimiento).append('\'');
        sb.append(", run=").append(run);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Su nombre es: " + nombre + " y su rut es: " + run);
    }
}
