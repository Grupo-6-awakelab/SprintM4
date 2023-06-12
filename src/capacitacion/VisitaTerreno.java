package capacitacion;

import usuario.Cliente;

import java.util.List;

public class VisitaTerreno {

    private int id;
    private Cliente cliente;
    private List<Revision> revisiones;
    private String dia;
    private String hora;
    private String lugar;
    private String comentarios;


    public VisitaTerreno() {
    }

    public VisitaTerreno(int id, Cliente cliente, List<Revision> revisiones, String dia, String hora, String lugar, String comentarios) {
        this.id = id;
        this.cliente = cliente;
        this.revisiones = revisiones;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public int getId() {
        return id;
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

    public void verificarRevison(){
        if (revisiones != null){

        }else {
            System.out.println("Las visitas a terrenos deben tener una o mas revisiones por ocasion");
        }
    }
    @Override
    public String   toString() {
        final StringBuffer sb = new StringBuffer("VisitaTerreno{");
        sb.append("id=").append(id);
        sb.append(", rutCliente=").append(cliente.getRun());
        sb.append(", dia='").append(dia).append('\'');
        sb.append(", hora='").append(hora).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append(", comentarios='").append(comentarios).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
