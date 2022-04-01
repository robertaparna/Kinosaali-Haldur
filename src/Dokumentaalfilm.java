import java.sql.Time;
import java.util.Date;

public class Dokumentaalfilm extends Seanss{

    public Dokumentaalfilm(String pealkiri, Date kuupäev, Time algus, Time lõpp, Saal saal) {
        super(pealkiri, kuupäev, algus, lõpp, saal);
    }
    private String tegijad; //Dokumentaali autorid
    private String teema; //Dokumentaali teema
}
