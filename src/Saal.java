import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

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

    //public static list<seanss> get koik broneeringud

    //public static list<seanss> getBroneerringud(päev)

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
