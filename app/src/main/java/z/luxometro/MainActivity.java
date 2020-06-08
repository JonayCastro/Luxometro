package z.luxometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private ControlLuz controlLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlLuz = new ControlLuz(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        controlLuz.inicio();
    }

    @Override
    protected void onPause() {
        super.onPause();

        controlLuz.stop();
    }
}
