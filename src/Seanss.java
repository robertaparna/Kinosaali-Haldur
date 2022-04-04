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
    private List<List<Integer>> kohaplaan;
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

    public List<List<Integer>> getKohaplaan() {
        return kohaplaan;
    }

    @Override
    public int compareTo(Seanss o) {
        return vahemik.getStart().compareTo(o.getVahemik().getStart());
    }

    public void valjastaKohaplaan() {
        for (List<Integer> rida : kohaplaan) {
            for (Integer koht : rida) {
                if(koht == 1){
                    System.out.print("\uD83D\uDFE5");
                }
                else if(koht == 0){
                    System.out.print("\uD83D\uDFE9");
                }
                else if(koht == 2) {
                    System.out.print("\uD83D\uDFEA");
                }
            }
        }
    }

    public int vabuKohti() {
        int kohti = 0;
        for (List<Integer> integers : kohaplaan) {
            for (Integer integer : integers) {
                if(integer == 0) {
                    kohti++;
                }
            }
        }
        return kohti;
    }
}
