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

    public List<String> getKuupäevad(List<Saal> saalid) {
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
    public static void kohtadeValimine(Seanss seanss){
        //Random
    }
}
