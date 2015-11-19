package applicate.com.sigma.applicate;

import android.graphics.drawable.Drawable;

/**
 * Created by raul.molina on 18/11/15.
 */
public class Alumno {

    private String nom;
    private String apellido1;
    private String apellido2;
    private String status;
    private Drawable foto;

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    public Alumno(String nom, String apellido1, String apellido2, String status, String foto) {
        this.nom = nom;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.status = status;
        //this.foto = foto;
    }
}
