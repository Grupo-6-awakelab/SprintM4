package usuario;

import java.time.LocalDate;

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    public Administrativo() {
    }

    public Administrativo(String nombre, LocalDate fechaNacimiento, int run, String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, run);
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
