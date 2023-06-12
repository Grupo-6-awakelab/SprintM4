package capacitacion;

import usuario.Cliente;

import java.util.List;
import java.util.Scanner;

public class Revision {

    public Revision(int id, String nombreRevision, String detalle) {
        this.id = id;
        this.nombreRevision = nombreRevision;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Revision{" +
                "id=" + id +
                ", nombreRevision='" + nombreRevision + '\'' +
                ", detalle='" + detalle + '\'' +
                '}';
    }

    private int id;
    private String nombreRevision;
    private String detalle;

    public void solicitarDatos(Scanner scanner) {
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


