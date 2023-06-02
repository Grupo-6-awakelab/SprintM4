package capacitacion;

import usuario.Cliente;


public class Capacitacion {
    private int id;
    private Cliente cliente;
    //Testear despues.
    private int runCliente = cliente.getRun();
    private String dia;

    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    public Capacitacion() {

    }

    public Capacitacion(int id, int runCliente, String dia, String hora, String lugar, String duracion, int cantidadAsistentes) {
        this.id = id;
        this.runCliente = runCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getRunCliente() {
        return runCliente;
    }



    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Capacitacion{");
        sb.append("id=").append(id);
        sb.append(", runCliente=").append(runCliente);
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", duracion='").append(duracion).append('\'');
        sb.append(", cantidadAsistentes=").append(cantidadAsistentes);
        sb.append('}');
        return sb.toString();
    }
}

