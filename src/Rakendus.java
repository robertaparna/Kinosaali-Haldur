import org.joda.time.DateTime;

import java.util.*;

public class Rakendus {
    static List<Saal> saalid = new ArrayList<>();
    public static void main(String[] args) {
        while(true) {
            Scanner in = new Scanner(System.in);
            int kasutajaSisestus = in.nextInt();
            System.out.println("Tere tulemast!");
            System.out.println("Sisestage nr 1, kui Te soovite pileteid osta.");
            System.out.println("Sisestage nr 2, kui Te soovite saale hallata.");
            System.out.println("Sisestage nr 3, kui Te soovite kinokava hallata.");
            System.out.println("Sisestage nr 0, kui Te ei soovi kinopileteid osta.");

            if (kasutajaSisestus == 1){
                valiKuupaev();

            }
            else if (kasutajaSisestus == 2){
                saalid();

            }
            else if (kasutajaSisestus == 3){
                kinokavaMuutmine(); //vaatamine on puudu

            }
            else if (kasutajaSisestus == 0){
                break;
            }
            //kas soovid piletit myya
            //kas soovid saale hallata
            //kas soovid kinokava hallata
            //kas soovid lopetada -> break

        }
    }

    /**
     * PILET STEP 1
     * valjastab koik kuupaevad millele on broneeritud seansid, laseb kasutajal valida, millise kuupaeva kava vaadata
     **/
    public static void valiKuupaev() {
        System.out.println("Palun sisestage kuupäeva ees olev number: " +
                "Valige endale sobiv kuupäev: ");
        for (int i = 0; i < getKuupäevad().size(); i++) {
            System.out.println(i+1 + ". "  + getKuupäevad().get(i));
        }
        Scanner in = new Scanner(System.in);
        int kasutajaValik = in.nextInt();
        String kasutajaValitudKuupaev = getKuupäevad().get(kasutajaValik-1);
        valiSeanss(kasutajaValitudKuupaev);
    }

    /**
     * PILET STEP 2
     * valjastab koik seansid, mis on broneeritud kuupaevale kuupaev ja laseb kasutajal valida, millisele pilet osta
     * @param kuupaev valitud kuupaev
     */
    public static void valiSeanss(String kuupaev) {
        List<Seanss> toimuvadSeansid = new ArrayList<>(); //kõik kasutaja valitul kuupäeval toimuvad seansid kõikidest saalidest
        Scanner in = new Scanner(System.in);
        int kasutajaValik = in.nextInt();
        for (int i = 0; i < saalid.size(); i++) { //lisame kõik asjakohased seansid listi
            toimuvadSeansid.addAll(saalid.get(i).getBroneeringud(kuupaev));
        }
        System.out.println("Palun sisestage seansi ees olev number." +
                "Valitud kuupäeval toimuvad järgmised seansid: ");
        for (int i = 0; i < toimuvadSeansid.size(); i++) {
            System.out.println(i+1 + ". "  + toimuvadSeansid.get(i));
        }
        Seanss kasutajaValitudSeanss = toimuvadSeansid.get(kasutajaValik-1);
        piletiteValimine(kasutajaValitudSeanss); //lisasin
    }

    /**
     * PILET STEP 3
     * laseb valida mitu piletit osta valitud seansile ja suunab kohtade valimisse
     * @param seanss valitud seanss
     */
    public static void piletiteValimine(Seanss seanss){
        System.out.println("Palun sisestage soovitud piletide arv: ");
        Scanner in = new Scanner(System.in);
        int valitudPiletiteArv = in.nextInt();
        if (seanss instanceof Õudusfilm) {
            valitudPiletiteArv = vanuseKontroll(seanss,valitudPiletiteArv);
        }
        kohtadeValimine(seanss, valitudPiletiteArv);
    }

    /**
     * PILET STEP 4
     * tagastab mitu inimest on oudusfilmile lubatud
     * @param seanss valitud seanss
     * @param piletiteArv mitu inimest soovivad seansile
     * @return mitu inimest saavad seansile
     */
    public static int vanuseKontroll(Seanss seanss, int piletiteArv) {
        Scanner in = new Scanner(System.in);
        int lubatudPileteid = 0;
        for (int i = 1; i < piletiteArv; i++) {
            System.out.println("Sisestage palun pileti kasutaja vanus: ");
            int kasutajaVanus = in.nextInt();
            if (seanss.kasSaabSeansile(kasutajaVanus)) {
                lubatudPileteid++;
            }
        }
        return  lubatudPileteid;
    }

    /**
     * ABI
     * tagaastab nimekirja kuupaevadest millal on broneeritud seansse
     * @return nimekiri kuupaevadest millal on broneeritud seansse
     */
    public static List<String> getKuupäevad() {
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

    /**
     * SAAL ALGUS
     * kasutaja valib kas saale vaadata voi lisada
     */
    public static void saalid(){
        System.out.println("Sisestage 1, kui te soovite saali vaadata: ");
        System.out.println("Sisestage 2, kui te soovite saale lisada: ");
        Scanner in = new Scanner(System.in);
        int kasutajaValik = in.nextInt();
        if (kasutajaValik == 1){
            saaliVaatamine();
        }
        else if(kasutajaValik == 2){
            saaliLisamine();
        }

    }

    /**
     * kasutaja saab saali lisada
     */
    public static void saaliLisamine(){
        System.out.println("Kas igas reas on sama arv kohti?");
        System.out.println("Sisestage 1, kui teie vastus on 'jah': ");
        System.out.println("Sisestage 0, kui teie vastus on 'ei': ");
        Scanner in = new Scanner(System.in);
        int kasutajaValik = in.nextInt();
        if (kasutajaValik == 1){
            System.out.println("Sisestage palun saali nimi: ");
            Scanner in2 = new Scanner(System.in);
            String kasutajaValitudNimi = in2.nextLine();
            System.out.println("Sisestage palun ridade arv: ");
            int ridadeArv = kasutajaValik;
            System.out.println("Sisestage palun kohtade arv: ");
            int kohtadeArv = kasutajaValik;
            saalid.add(new Saal(kasutajaValitudNimi, ridadeArv, kohtadeArv));
        }
        else if (kasutajaValik == 0){
            System.out.println("Sisestage palun saali nimi: ");
            Scanner in2 = new Scanner(System.in);
            String kasutajaValitudNimi = in2.nextLine();
            System.out.println("Sisestage palun ridade arv: ");
            int ridadeArv = kasutajaValik;
            saalid.add(new Saal(kasutajaValitudNimi, ridadeArv));
        }
        System.out.println("Saal lisatud!");
        System.out.println("-------------------------------------");
    }

    /**
     * kasutaja saab saale vaadata
     */
    public static void saaliVaatamine(){
        for (Saal saal : saalid) {
            System.out.println(saal.saaliInfo());
        }

    }

    public static void kinokavaMuutmine() {
        System.out.println("Palun sisestage 1, kui te soovite seansse lisada: ");
        System.out.println("Palun sisestage 2, kui te soovite kinokava vaadata: ");
        Scanner in = new Scanner(System.in);
        int kasutajaValik = in.nextInt();
        if (kasutajaValik == 1){
            seansiLisamine();

        }

        //lisamine, vaatamine, eemaldamine
    }
    public static void seansiLisamine(){
        System.out.println("Sisestage filmi žanr: ");
        Scanner in = new Scanner(System.in);
        String kasutajaValik = in.nextLine();
        kasutajaValik = kasutajaValik.substring(0, 1).toUpperCase();
        if (kasutajaValik.equals("Dokumentaalfilm")){
            dokFilmiLisamine();
        }
        else if (kasutajaValik.equals("Mängufilm")){
            mängufilmilisamine();
        }
        else if (kasutajaValik.equals("Õudusfilm")){
            õudusfilmilisamine();
        }
    }
    public static void dokFilmiLisamine(){
        Scanner in = new Scanner(System.in);
        String kasutajaValik = in.nextLine();
        System.out.println("Sisestage dokumentaalfilmi pealkiri: ");
        String pealkiri = kasutajaValik;
        System.out.println("Sisestage seansi toimumise kuupäev (kujul yyy-mm-dd): ");
        String kuupäev = kasutajaValik;
        System.out.println("Sisestage seansi algus (kujul hh:mm): ");
        String algus = kasutajaValik;
        System.out.println("Sisestage filmi kestus (minutites): ");
        int kestus = Integer.parseInt(kasutajaValik);
        //väljasta saalide list koos numbritega nagu kuupäevadega
        System.out.println("Valige üks saal ja sisestage selle saali ees olev number: ");
        for (int i = 0; i < saalid.size(); i++) {
            System.out.println(i+1 + ". "  + saalid.get(i));
        }
        Saal saal = saalid.get(Integer.parseInt(kasutajaValik)-1);
        System.out.println("Sisestage filmi tegijad: ");
        String tegijad = kasutajaValik;
        System.out.println("Sisestage dokumentaali teema: ");
        String teema = kasutajaValik;
        new Dokumentaalfilm(pealkiri,kuupäev,algus, kestus, saal, tegijad, teema);
    }
    public static void mängufilmilisamine(){
        Scanner in = new Scanner(System.in);
        String kasutajaValik = in.nextLine();
        System.out.println("Sisestage mängufilmi pealkiri: ");
        String pealkiri = kasutajaValik;
        System.out.println("Valige üks saal ja sisestage selle saali ees olev number: ");
        for (int i = 0; i < saalid.size(); i++) {
            System.out.println(i+1 + ". "  + saalid.get(i));
        }
        Saal saal = saalid.get(Integer.parseInt(kasutajaValik)-1);
        System.out.println("Sisestage filmi žanr: ");
        String žanr = kasutajaValik;
        System.out.println("Sisestage filmi peaosatäitjad: ");
        String näitlejad = kasutajaValik;
        System.out.println("Sisestage seansi toimumise kuupäev (kujul yyy-mm-dd): ");
        String kuupäev = kasutajaValik;
        System.out.println("Sisestage seansi algus (kujul hh:mm): ");
        String algus = kasutajaValik;
        System.out.println("Sisestage filmi kestus (minutites): ");
        int kestus = Integer.parseInt(kasutajaValik);
        new Mängufilm(pealkiri, saal, žanr, näitlejad, kuupäev, algus, kestus);
    }
    public static void õudusfilmilisamine(){
        Scanner in = new Scanner(System.in);
        String kasutajaValik = in.nextLine();
        System.out.println("Sisestage õudusfilmi pealkiri: ");
        String pealkiri = kasutajaValik;
        System.out.println("Valige üks saal ja sisestage selle saali ees olev number: ");
        for (int i = 0; i < saalid.size(); i++) {
            System.out.println(i+1 + ". "  + saalid.get(i));
        }
        Saal saal = saalid.get(Integer.parseInt(kasutajaValik)-1);
        System.out.println("Sisestage filmi žanr: ");
        String žanr = kasutajaValik;
        System.out.println("Sisestage filmi peaosatäitjad: ");
        String näitlejad = kasutajaValik;
        System.out.println("Sisestage vanusepiirang seansile pääsemiseks: ");
        int vanusepiirang = Integer.parseInt(kasutajaValik);
        System.out.println("Sisestage seansi toimumise kuupäev (kujul yyy-mm-dd): ");
        String kuupäev = kasutajaValik;
        System.out.println("Sisestage seansi algus (kujul hh:mm): ");
        String algus = kasutajaValik;
        System.out.println("Sisestage filmi kestus (minutites): ");
        int kestus = Integer.parseInt(kasutajaValik);
        new Õudusfilm(pealkiri, saal, žanr, näitlejad, vanusepiirang, kuupäev, algus, kestus);
    }


    /**
     * pakub suvalised jarjest vabad kohad vastavalt piletite arvule voi saadab kasutaja edasi ise valima(kui ei leia jarjest)
     * @param seanss valitud seanss
     * @param pileteid pakutavate piletite arv
     */
    public static void kohtadeValimine(Seanss seanss, int pileteid) {
        if(seanss.vabuKohti() < pileteid){
            System.out.println("Kahjuks sellel seansil ei ole piisavalt kohti!");
            System.out.println("Kui tahad valida uue piletite arvu sisesta 1");
            System.out.println("Kui tahad valida uue seansi sisesta 2");

            Scanner in = new Scanner(System.in);
            int valik = in.nextInt();
            if(valik == 1) {
                piletiteValimine(seanss);
            }
            else if(valik == 2) {
                valiKuupaev();
            }
        }
        Random r = new Random();
        int rida;
        boolean mahub = false;
        boolean valitud = false;
        for (int i = 0; i < 20; i++) {
            rida = r.nextInt(seanss.getKohaplaan().size());
            int jarjest=0;
            for (int j = 0; j < rida; j++) { //poolik
                if(seanss.getKohaplaan().get(rida).get(j) == 0) {
                    jarjest++;
                    seanss.valiKoht(rida, j);
                    if(jarjest == pileteid) {
                        seanss.valjastaKohaplaan();
                        System.out.println("Kui valitud kohad sobivad sisesta 1");
                        System.out.println("Kui soovid valida teised kohad sisesta 2");
                        Scanner in = new Scanner(System.in);
                        int sisend = in.nextInt();
                        if (sisend == 1) {
                            seanss.müüValitudKohad();
                            System.out.println("Valitud kohad on müüdud!");
                            System.out.println("------------------------------------------");
                        }
                        //else if( )

                    }
                }
                else{
                    jarjest = 0;
                    seanss.tühistaValitudKohad();
                }
            }
        }
    }

    public static void kasutajaValibKohad(Seanss seanss, int pileteid) {

    }
}
