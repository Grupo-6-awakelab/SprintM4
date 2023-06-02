package capacitacion;

import usuario.Cliente;

public class Accidente {
    private int id;
    private Cliente cliente;
    private int runCliente = cliente.getRun();
    private String dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencia;

    public Accidente() {
    }

    public Accidente(int id, int runCliente, String dia, String hora, String lugar, String origen, String consecuencia) {
        this.id = id;
        this.runCliente = runCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencia = consecuencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Accidente{");
        sb.append("id=").append(id);
        sb.append(", runCliente=").append(runCliente);
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", origen='").append(origen).append('\'');
        sb.append(", consecuencia='").append(consecuencia).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
