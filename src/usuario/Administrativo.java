package usuario;

import java.time.LocalDate;

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    public Administrativo(String nombre, String apellidos, int run, String area, String experienciaPrevia) {
    }

    public Administrativo(String nombreCompleto, LocalDate fechaNacimiento, int run, String area, String experienciaPrevia) {
        super(nombreCompleto, fechaNacimiento, run);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Administrativo{");
        sb.append("area='").append(area).append('\'');
        sb.append(", experienciaPrevia='").append(experienciaPrevia).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
