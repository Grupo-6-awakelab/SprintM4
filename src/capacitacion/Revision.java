package capacitacion;

import usuario.Cliente;

import java.util.List;
import java.util.Scanner;

public class Revision {
    public Revision(int id, int idVisita, String nombreRevision, String detalle, String eRevision) {
        this.id = id;
        this.idVisita = idVisita;
        this.nombreRevision = nombreRevision;
        this.detalle = detalle;
        this.eRevision = eRevision;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "id=" + id +
                ", idVisita=" + idVisita +
                ", nombreRevision='" + nombreRevision + '\'' +
                ", detalle='" + detalle + '\'' +
                ", eRevision='" + eRevision + '\'' +
                '}';
    }

    private int id;
    private int idVisita;
    private String nombreRevision;
    private String detalle;
    private String eRevision;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public String getNombreRevision() {
        return nombreRevision;
    }

    public void setNombreRevision(String nombreRevision) {
        this.nombreRevision = nombreRevision;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String geteRevision() {
        return eRevision;
    }

    public void seteRevision(String eRevision) {
        this.eRevision = eRevision;
    }



    public void solicitarDatos(Scanner scanner) {
        System.out.println("Ingrese ID");
        setId(scanner.nextInt());
        System.out.println("Ingrese ID Visita");
        setIdVisita(scanner.nextInt());
        System.out.println("Ingrese nombre de la revision");
        setNombreRevision(validarNomRevision(scanner.nextLine()));
        System.out.println("Ingrese el detalle de la revision");
        setDetalle(validarDetalle(scanner.nextLine()));

    }
         public String validarNomRevision(String nomRevision) {
        if (nomRevision.length() <10 || nomRevision.length() >50){
            System.out.println("El nombre ingresado debe tener entre 10 y 50 caracteres.");
            System.out.println("Por favor, ingrese un nuevamente:");
            Scanner scanner = new Scanner(System.in);
            nomRevision = validarDetalle(scanner.nextLine());

        }
        return nomRevision;
    }
        public String validarDetalle(String deta){
        if (deta.length() >100 ){
            System.out.println("El detalle ingresado debe tener mas de 100 caracteres.");
            System.out.println("Por favor, ingrese un nuevamente:");
            Scanner scanner = new Scanner(System.in);
            deta = validarDetalle(scanner.nextLine());

        }
        return deta;
    }
}


