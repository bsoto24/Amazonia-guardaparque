package pe.openlab.amazoniaapp.data.entity;

/**
 * Created by Bryam Soto on 30/11/2017.
 */

public class Measure {

    private int nacional;
    private int extranjero;
    private int paseLibre;
    private String comment;

    public Measure(int nacional, int extranjero, int paseLibre) {
        this.nacional = nacional;
        this.extranjero = extranjero;
        this.paseLibre = paseLibre;
    }

    public int getNacional() {
        return nacional;
    }

    public void setNacional(int nacional) {
        this.nacional = nacional;
    }

    public int getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(int extranjero) {
        this.extranjero = extranjero;
    }

    public int getPaseLibre() {
        return paseLibre;
    }

    public void setPaseLibre(int paseLibre) {
        this.paseLibre = paseLibre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
