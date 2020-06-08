package z.luxometro;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;

public class ControlLuz implements SensorEventListener {

    public Activity activity;
    private SensorManager manager;
    private Sensor luxSensor;
    private TextView lumenes;

    public ControlLuz(Activity activity){
        this.activity = activity;
        lumenes = (TextView) activity.findViewById(R.id.lumenes);
        manager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);

        luxSensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    public void inicio(){
        if (luxSensor != null){
            manager.registerListener(this, luxSensor, SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            Toast.makeText(activity.getApplicationContext(), activity.getApplicationContext().getString(R.string.msnErrorSensLux), Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(){
        manager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String valor = String.valueOf((int)sensorEvent.values[0]);
        lumenes.setText(valor+" lux");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
