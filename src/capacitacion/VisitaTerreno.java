package capacitacion;

import usuario.Cliente;

public class VisitaTerreno {

    private int id;
    private Cliente cliente;
    private int rutCliente = cliente.getRun();
    private String dia;
    private String hora;
    private String lugar;
    private String comentarios;

    public VisitaTerreno() {
    }

    public VisitaTerreno(int id, int rutCliente, String dia, String hora, String lugar, String comentarios) {
        this.id = id;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public int getRutCliente() {
        return rutCliente;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String   toString() {
        final StringBuffer sb = new StringBuffer("VisitaTerreno{");
        sb.append("id=").append(id);
        sb.append(", rutCliente=").append(rutCliente);
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", comentarios='").append(comentarios).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
