public class Mängufilm extends Seanss{
    private String žanr;
    private String näitlejad;

    public Mängufilm(String pealkiri, Date kuupäev, Time algus, Time lõpp, Saal saal, String žanr, String näitlejad) {
        super(pealkiri, kuupäev, algus, lõpp, saal);
        this.žanr = žanr;
        this.näitlejad = näitlejad;
    }

    @Override
    public String toString() {
        return "Mängufilm{" + "žanr='" + žanr + '\'' + ", näitlejad='" + näitlejad + '\'' + super.toString() +
                '}';
    }
}
