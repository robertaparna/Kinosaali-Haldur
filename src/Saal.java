import org.joda.time.Interval;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Saal {

    private List<List<Boolean>> kohaplaan;
    private List<Seanss> broneeringud;

    public Saal(int read, int kohad) {
        this.broneeringud = new ArrayList<>();
        this.kohaplaan = new ArrayList<>();
        for (int i = 0; i < read; i++) {
            List<Boolean> rida = new ArrayList<>();
            for (int j = 0; j < kohad; j++) {
                rida.add(false);
            }
            kohaplaan.add(rida);
        }
    }

    public Saal(int read) {
        this.broneeringud = new ArrayList<>();
        this.kohaplaan = new ArrayList<>();
        for (int i = 0; i < read; i++) {
            int kohad = 0;
            //kusib: mitu kohta i+1 reas ja paneb selle kohad vaartuseks
            List<Boolean> rida = new ArrayList<>();
            for (int j = 0; j < kohad; j++) {
                rida.add(false);
            }
            kohaplaan.add(rida);
        }
    }

    public List<Seanss> getBroneeringud() {
        return broneeringud;
    }

    public List<Seanss> getBroneeringud(String kuupaev) {
        List<Seanss> broneeringudPaeval = new ArrayList<>();
        for (Seanss seanss : broneeringud) {
            if(seanss.getKuupäev().equals(kuupaev)) {
                broneeringudPaeval.add(seanss);
            }
        }
        return broneeringud;
    }

    public boolean aegOnVaba(Interval interval){
        for (Seanss seanss : broneeringud) {
            if(interval.overlaps(seanss.getVahemik())) {
                return false;
            }
        }
        return true;
    }

    public void lisaBroneering(Seanss seanss) {
        broneeringud.add(seanss);
    }

}
