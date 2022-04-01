import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Seanss {
    private String pealkiri;
    private Saal saal;
    private Interval vahemik;
    private String algus;
    private String kuupäev;
    private int kestus;
    // interval.overlaps(interval)\
    //datetime.plusMinutes(minuteid)
    //datetime string "yyyy-mm-ddThh:mm"
    public Seanss(String pealkiri, String kuupäev, String algus, int kestus, Saal saal) {
        String a = kuupäev+"T"+ algus; // teeme uhe stringi kus on oiges formaadis kuupaev ja kellaaeg
        DateTime b = DateTime.parse(a); // votame sellest datetime objekti alguseks
        DateTime c = b.plusMinutes(kestus); // lisame algusele kestuse et lopp saada
        Interval vahemik = new Interval(b, c); //teeme nendest vahemiku
        if (saal.aegOnVaba(vahemik)){
            this.pealkiri = pealkiri;
            this.kuupäev = kuupäev;
            this.algus = algus;
            this.kestus = kestus;
            this.saal = saal;
            this.vahemik = vahemik;
            saal.lisaBroneering(this);
        }
        else {
            System.out.println("Selleks ajaks on saal juba broneeritud!");
        }
    }

    public Interval getVahemik() {
        return vahemik;
    }
}
