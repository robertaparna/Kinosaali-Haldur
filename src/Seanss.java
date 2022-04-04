import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

public class Seanss implements Comparable<Seanss>{
    private String pealkiri;
    private Saal saal;
    private Interval vahemik;
    private String algus;
    private String kuupäev;
    private int kestus;
    private List<List<Boolean>> kohaplaan;
    // interval.overlaps(interval)\
    //datetime.plusMinutes(minuteid)
    //datetime string "yyyy-mm-ddThh:mm"
    public Seanss(String pealkiri, String kuupäev, String algus, int kestus, Saal saal) {
        String a = kuupäev+ "T"+ algus; // teeme uhe stringi kus on oiges formaadis kuupaev ja kellaaeg
        DateTime b = DateTime.parse(a); // votame sellest datetime objekti alguseks
        DateTime c = b.plusMinutes(kestus); // lisame algusele kestuse et lopp saada
        Interval vahemik = new Interval(b, c); //teeme nendest vahemiku
        if (saal.aegOnVaba(vahemik)){
            this.pealkiri = pealkiri;
            this.kuupäev = kuupäev;
            this.algus = algus;
            this.kestus = kestus;
            this.kohaplaan = new ArrayList<>(saal.getKohaplaan());
            this.vahemik = vahemik;
            saal.lisaBroneering(this);
        }
        else {
            System.out.println("Selleks ajaks on saal juba broneeritud!");
        }
    }

    public String getPealkiri() {
        return pealkiri;
    }

    public Saal getSaal() {
        return saal;
    }

    public String getAlgus() {
        return algus;
    }

    public String getKuupäev() {
        return kuupäev;
    }

    public int getKestus() {
        return kestus;
    }

    public Interval getVahemik() {
        return vahemik;
    }

    @Override
    public int compareTo(Seanss o) {
        return vahemik.getStart().compareTo(o.getVahemik().getStart());
    }
}
