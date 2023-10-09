package Ex2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_expirare;

    static private float incasari;
    public Produs(String denumire, float pret, int cantitate, LocalDate data_expirare) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirare = data_expirare;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", data_expirare=" + data_expirare +
                '}';
    }

    public LocalDate getData_expirare() {
        return data_expirare;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getCantitate() {
        return cantitate;
    }

    public float getPret() {
        return pret;
    }

    public void vinde(String denumire, int cantitate){
        if(this.cantitate>=cantitate){
            incasari = incasari + cantitate*this.pret;
            this.cantitate = this.cantitate - cantitate;
        }
    }
}
