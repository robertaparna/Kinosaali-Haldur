import org.joda.time.Interval;

public class Seanss {
    private String pealkiri;
    private Saal saal;
    private Interval aeg;

    public String getPealkiri() {
        return pealkiri;
    }

    public Seanss(String pealkiri, Saal saal) {
        this.pealkiri = pealkiri;
        this.saal = saal;
    }

}
