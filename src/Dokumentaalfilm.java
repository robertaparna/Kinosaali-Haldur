import java.sql.Time;
import java.util.Date;

public class Dokumentaalfilm extends Seanss{

    public Dokumentaalfilm(String pealkiri, String kuupäev, String algus, int kestus, Saal saal, String tegijad, String teema) {
        super(pealkiri, algus, kuupäev, kestus, saal);
        this.tegijad = tegijad;
        this.teema = teema;
    }
    private String tegijad; //Dokumentaali autorid
    private String teema; //Dokumentaali teema

    @Override
    public String toString() {
        return  "Film: " + super.getPealkiri() + '\n' + "Dokumentaali teema on: " +
                teema + '\n' + "Dokumentaali tegijateks on: " + tegijad + '\n' +
                "Teie seanss toimub: " + super.getKuupäev() + " kell: " + super.getAlgus() + '\n' +
                "Seanss kestab: " + super.getKestus() + " minutit." + '\n' + "Saalis: " + super.getSaal();

    }
}
