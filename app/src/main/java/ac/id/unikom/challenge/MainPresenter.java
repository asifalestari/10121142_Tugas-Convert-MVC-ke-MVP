// NIM  : 10121142
// Nama : Asifa Lestari
// Tugas Convert MVC to MVP

package ac.id.unikom.challenge;

public class MainPresenter {
    private MainView view;
    private Meter model;

    public MainPresenter(MainView view) {
        this.view = view;
        this.model = Meter.getInstance();
    }

    public void calculateLength() {
        String meterStr = view.getMeter();
        if (meterStr.isEmpty()) {
            meterStr = "0";
        }

        double meterValue = Double.parseDouble(meterStr);
        model.setMeter(meterValue);

        String km = model.toKilometer();
        String cm = model.toCentimeter();

        view.showKilometer(km);
        view.showCentimeter(cm);
    }

    public void onDestroy() {
        view = null;
        Meter.destroy();
    }
}
