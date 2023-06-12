package capacitacion;

import java.util.Scanner;

/**
 * Revision esta relacionada con una visita a terreno, la cual indica el detalle a revisar.
 */
public class Revision {

    private int id;

    private EstadoRevision estadoRevision;

    private VisitaTerreno visitaTerreno;
    private String nombreRevision;
    private String detelleParaRevisar;

    public Revision() {

    }

    public Revision(EstadoRevision estadoRevision, VisitaTerreno visitaTerreno, String nombreRevision, String detelleParaRevisar) {
        this.id = id();
        this.estadoRevision = estadoRevision;
        this.visitaTerreno = visitaTerreno;
        this.nombreRevision = nombreRevision;
        this.detelleParaRevisar = detelleParaRevisar;
    }

    /**
     * Valida el largo del nombre de la revision
     * @param s nombre de la revision.
     * @return el valor ingresado si pasa la validación.
     */
    public String validarNombre(String s) {

        if (s.length() < 10 || s.length() > 100) {
            System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
            System.out.println("Por favor, ingrese nuevamente el nombre de la revisión:");
            Scanner scanner = new Scanner(System.in);
            s = validarNombre(scanner.nextLine());
        }
        return s;

    }

    /**
     * Valida el largo del detalle de la revision
     * @param s nombre de la revision.
     * @return el valor ingresado si pasa la validación.
     */
    public String validarDetalle(String s) {

        if (s.length() > 100) {
            System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
            System.out.println("Por favor, ingrese nuevamente el nombre de la revisión:");
            Scanner scanner = new Scanner(System.in);
            s = validarDetalle(scanner.nextLine());
        }
        return s;

    }


    public EstadoRevision getEstadoRevision() {
        return estadoRevision;
    }

    public void setEstadoRevision(EstadoRevision estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    public VisitaTerreno getVisitaTerreno() {
        return visitaTerreno;
    }

    public void setVisitaTerreno(VisitaTerreno visitaTerreno) {
        this.visitaTerreno = visitaTerreno;
    }

    public String getNombreRevision() {
        return nombreRevision;
    }

    public void setNombreRevision(String nombreRevision) {
        this.nombreRevision = nombreRevision;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Genera un id random.
     * @return el id generado.
     */
    public int id() {
        return (int) (Math.random() * 8999999) + 1000000;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Revision{");
        sb.append("id=").append(id);
        sb.append(", estadoRevision=").append(estadoRevision);
        sb.append(", visitaTerreno=").append(visitaTerreno);
        sb.append(", nombreRevision='").append(nombreRevision).append('\'');
        sb.append(", detelleParaRevisar='").append(detelleParaRevisar).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
