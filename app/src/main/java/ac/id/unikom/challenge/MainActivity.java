// NIM  : 10121142
// Nama : Asifa Lestari
// Tugas Convert MVC to MVP

package ac.id.unikom.challenge;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText meter;
    private EditText kilometer;
    private EditText centimeter;
    private MainPresenter presenter; // Menggantikan MainController

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        initView();
    }

    private void initView() {
        meter = findViewById(R.id.meter);
        kilometer = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeter);

        meter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.calculateLength();
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public String getMeter() {
        return meter.getText().toString();
    }

    @Override
    public void showKilometer(String kilometer) {
        this.kilometer.setText(kilometer);
    }

    @Override
    public void showCentimeter(String centimeter) {
        this.centimeter.setText(centimeter);
    }
}
