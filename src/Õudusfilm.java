public class Õudusfilm extends Mängufilm{

    private int vanusepiirang;

    public Õudusfilm(String pealkiri, Date kuupäev, Time algus, Time lõpp, Saal saal, String žanr, String näitlejad, int vanusepiirang) {
        super(pealkiri, kuupäev, algus, lõpp, saal, žanr, näitlejad);
        this.vanusepiirang = vanusepiirang;
    }
     //vanusepiirang 14.a (k.a)

    public boolean kasSaabSeansile(int vanus){
        if (vanus < vanusepiirang){
            System.out.println("Kahjuks ei ole Te seansile lubatud. " +
                    "Seansile pääasevad 14-aastased ja vanemad inimesed.");
            return false;
        }
        else {
            System.out.println("Olete seansile lubatud!");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Õudusfilm{" + super.toString() + "vanusepiirang=" + vanusepiirang +
                '}';
    }
}
