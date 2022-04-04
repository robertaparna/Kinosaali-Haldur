public class Mängufilm extends Seanss{
    private String žanr;
    private String näitlejad;

    public Mängufilm(String pealkiri, Saal saal, String žanr, String näitlejad,
                     String kuupäev, String algus, int kestus) {
        super(pealkiri, kuupäev, algus, kestus, saal);
        this.žanr = žanr;
        this.näitlejad = näitlejad;
    }

    public String getŽanr() {
        return žanr;
    }

    public String getNäitlejad() {
        return näitlejad;
    }

    @Override
    public String toString() {
        return "Film: " + super.getPealkiri() + '\n' + "Žanr: " +
                žanr + '\n' + "Peaosas mängivad näitlejad: " + näitlejad + '\n' +
                "Teie seanss toimub: " + super.getKuupäev() + " kell: " + super.getAlgus() + '\n' +
                "Seanss kestab: " + super.getKestus() + " minutit." + '\n' + "Saalis: " + super.getSaal();
    }


}
