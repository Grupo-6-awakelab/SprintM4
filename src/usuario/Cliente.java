package usuario;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private String apellidos;
    private String telefono;
    private String afp;


  private SistemaSalud sistemaSalud;

    private String direccion;
    private String comuna;
    private int edad;

   public Cliente (){


   }


    public Cliente(String nombre, LocalDate fechaNacimiento, int run, String apellidos, String telefono, String afp, SistemaSalud sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String obtenerNombre() {
        return getNombre() + "" + apellidos;
    }
    public String obtenerSistemaDeSalud(){

        switch (sistemaSalud.ordinal() + 1) {
            case 1:
                return "Su sistema de salud es Fonasa";

            case 2:
               return "Su sistema de salud es Isapre";

            default:

            }
            return null;
        }




    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");

        sb.append(", apellidos='").append(apellidos).append('\'');
        sb.append("telefono='").append(telefono).append('\'');
        sb.append(", afp='").append(afp).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", comuna='").append(comuna).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}





