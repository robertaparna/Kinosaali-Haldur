import java.sql.Time;
import java.util.Date;

public class Õudusfilm extends Mängufilm{
    public Õudusfilm(String pealkiri, Date kuupäev, Time algus, Time lõpp, Saal saal, String žanr, String näitlejad) {
        super(pealkiri, kuupäev, algus, lõpp, saal, žanr, näitlejad);
    }
    private int vanusepiirang; //vanusepiirang 14.a (k.a)

    public boolean kasSaabSeansile(){
        if (/*sisestatud vanus*/ < 14){
            System.out.println("Kahjuks ei ole Te seansile lubatud." +
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
