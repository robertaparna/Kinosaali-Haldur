import java.sql.Time;
import java.util.Date;

public class Seanss {
    private String pealkiri;
    private Date kuupäev;
    private Time algus;
    private Time lõpp;

    Saal saal = new Saal();

    public Seanss(String pealkiri, Date kuupäev, Time algus, Time lõpp, Saal saal) {
        this.pealkiri = pealkiri;
        this.kuupäev = kuupäev;
        this.algus = algus;
        this.lõpp = lõpp;
        this.saal = saal;
    }
    public boolean kasSaalVaba() {
        if (kuupäev == Saal.kuupäev) {
            if (algus.after(Saal.algus) && algus.before(Saal.lõpp)) { //kui algus on peale seansi algust
                //ja kui algus on enne seansi lõppu
                System.out.println("Saal pole vaba!");
                return false;
            }
        } else {
            return true;
        }
    }

}
