import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    //NB! vaga poolik
//    public List<String> getKuupäevad() {
//        Set<String> kuupaevad = new HashSet<>();
//        for (Seanss seanss : broneeringud) {
//            kuupaevad.add(seanss.getKuupäev());
//        }
//        return new ArrayList<>(kuupaevad);
//    }

    public static void saalideMuutmine() {
        //lisamine, vaatamine, eemaldamine
    }
    public static void kinokavaMuutmine() {
        //lisamine, vaatamine, eemaldamine
    }
}
