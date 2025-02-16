// NIM  : 10121142
// Nama : Asifa Lestari
// Tugas Convert MVC to MVP

package ac.id.unikom.challenge;

public class Meter {
    private static Meter instance;
    private double meter;

    private Meter() {
        this.meter = 0;
    }

    public static synchronized Meter getInstance() {
        if (instance == null) {
            instance = new Meter();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public String toKilometer() {
        double kilometerValue = meter / 1000;
        return String.valueOf(kilometerValue);
    }

    public String toCentimeter() {
        double centimeterValue = meter * 100;
        return String.valueOf(centimeterValue);
    }
}
