package ro.tuc.model;

public class Monom {
    private int coeficient;
    private int putere;

    public Monom(int coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    @Override
    public String toString() {
        return "Monom{" +
                "coeficient=" + coeficient +
                ", putere=" + putere +
                '}';
    }
}
