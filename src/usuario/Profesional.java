package usuario;

public class Profesional extends Usuario {
    private String titulo;
    private String fechaIngreso;

    public Profesional(){
    }

    public Profesional(String nombreCompleto, String fechaNacimiento, int run, String titulo, String fechaIngreso) {
        super(nombreCompleto, fechaNacimiento, run);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }


    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Profesional{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", fechaIngreso='").append(fechaIngreso).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
