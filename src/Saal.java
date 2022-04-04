import org.joda.time.Interval;

import java.util.*;

public class Saal {

    private List<List<Integer>> kohaplaan;
    private List<Seanss> broneeringud;

    public List<List<Integer>> getKohaplaan() {
        return kohaplaan;
    }

    public Saal(int read, int kohad) {
        this.broneeringud = new ArrayList<>();
        this.kohaplaan = new ArrayList<>();
        for (int i = 0; i < read; i++) {
            List<Integer> rida = new ArrayList<>();
            for (int j = 0; j < kohad; j++) {
                rida.add(0);
            }
            kohaplaan.add(rida);
        }
    }

    public Saal(int read) {
        this.broneeringud = new ArrayList<>();
        this.kohaplaan = new ArrayList<>();
        for (int i = 0; i < read; i++) {
            int kohad = 0;
            System.out.println("Mitu kohta on " + i+1 + ". reas?");
            Scanner scanner = new Scanner(System.in);
            List<Integer> rida = new ArrayList<>();
            for (int j = scanner.nextInt(); j < kohad; j++) {
                rida.add(0);
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
