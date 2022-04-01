import java.sql.Time;
import java.util.Date;

public class Dokumentaalfilm extends Seanss{

    public Dokumentaalfilm(String pealkiri, Date kuupäev, Time algus, Time lõpp, Saal saal, String tegijad, String teema) {
        super(pealkiri, kuupäev, algus, lõpp, saal);
        this.tegijad = tegijad;
        this.teema = teema;
    }
    private String tegijad; //Dokumentaali autorid
    private String teema; //Dokumentaali teema
}
