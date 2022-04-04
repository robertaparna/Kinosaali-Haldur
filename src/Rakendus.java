import org.joda.time.DateTime;

import java.util.*;

public class Rakendus {
    public static void main(String[] args) {
        List<Saal> saalid = new ArrayList<>();
        while(true) {
            Scanner in = new Scanner(System.in);
            Integer kasutajaSisestus = in.nextInt();
            System.out.println("Tere tulemast!");
            System.out.println("Sisestage nr 1, kui Te soovite pileteid osta.");
            System.out.println("Sisestage nr 2, kui Te soovite saale hallata.");
            System.out.println("Sisestage nr 3, kui Te soovite kinokava hallata.");
            System.out.println("Sisestage nr 0, kui Te ei soovi kinopileteid osta.");
            if (kasutajaSisestus == 1){
                System.out.println("Palun sisestage kuupäeva ees olev number: " +
                        "Valige endale sobiv kuupäev: ");
                for (int i = 0; i < getKuupäevad(saalid).size(); i++) {
                    System.out.println(i+1 + ". "  + getKuupäevad(saalid).get(i));
                }
                Scanner in2 = new Scanner(System.in);
                Integer kasutajaValik = in.nextInt();
                String kasutajaValitudKuupaev = getKuupäevad(saalid).get(kasutajaValik-1);
                List<Seanss> toimuvadSeansid = new ArrayList<>(); //kõik kasutaja valitul kuupäeval toimuvad seansid kõikidest saalidest
                for (int i = 0; i < saalid.size(); i++) { //lisame kõik asjakohased seansid listi
                    toimuvadSeansid.addAll(saalid.get(i).getBroneeringud(kasutajaValitudKuupaev));
                }
                System.out.println("Palun sisestage seansi ees olev number." +
                        "Valitud kuupäeval toimuvad järgmised seansid: ");
                for (int i = 0; i < toimuvadSeansid.size(); i++) {
                    System.out.println(i+1 + ". "  + toimuvadSeansid.get(i));
                }
                System.out.println("Sisestage soovitud piletite arv: ");






            }
            else if (kasutajaSisestus == 2){

            }
            else if (kasutajaSisestus == 3){

            }
            else if (kasutajaSisestus == 0){
                break;
            }
            //kas soovid piletit myya
            //kas soovid saale hallata
            //kas soovid kinokava hallata
            //kas soovid lopetada -> break
            break;
        }
    }
    public static void piletiMüümine() {
        //pileti myymise flow on straight forward, valikud voiksid ikka olla eraldi meetodid
    }

    public static List<String> getKuupäevad(List<Saal> saalid) {
        Set<DateTime> kuupaevad = new HashSet<>();
        for (Saal saal : saalid) {
            for (Seanss seanss : saal.getBroneeringud()) {
                kuupaevad.add(DateTime.parse(seanss.getKuupäev()));
            }
        }
        List<DateTime> k = new ArrayList<>(kuupaevad);
        k.sort(null);
        List<String> u = new ArrayList<>();
        for (DateTime dateTime : k) {
            u.add(String.valueOf(dateTime));
        }
        return u;
    }

    public static void saalideMuutmine() {
        //lisamine, vaatamine, eemaldamine
    }
    public static void kinokavaMuutmine() {
        //lisamine, vaatamine, eemaldamine
    }
    public static void kohtadeValimine(Seanss seanss, int pileteid) {
        if(seanss.vabuKohti() < pileteid){

        }
        Random r = new Random();
        int rida;
        boolean mahub = false;
        for(List<Integer> a : seanss.getKohaplaan()) {
            if (a.size() >= pileteid) {
                mahub = true;
                break;
            }
        }
        if (!mahub){
            kasutajaValibKohad(pileteid);
        }
        else {
            int i = 0;
            do {
                i++;
                rida = r.nextInt(seanss.getKohaplaan().size());
            } while (seanss.getKohaplaan().get(rida).size() < pileteid);
            int koht = r.nextInt(seanss.getKohaplaan().get(rida).size()-pileteid);
        }
    }

    public static void kasutajaValibKohad(int pileteid) {

    }
}
