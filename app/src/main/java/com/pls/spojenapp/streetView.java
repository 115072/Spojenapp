package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public class streetView extends AppCompatActivity implements SensorEventListener {

    GyroscopeObserver gyros;
    PanoramaImageView panor;
    ImageView nyilElore,nyilHatra,nyilJobbra,nyilBallra;
    int pozi = 0;
    SensorEventListener sensorEventListener;
    SensorManager manager;
    Sensor gyroscope;
    float x,y,z;

    float[] mGravity = new float[3];
    float[] mGeomagnetic = new float[3];
    float azimuth = 0f;
    float currectAzimuth = 0f;
    SensorManager mSensorManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        nyilElore = findViewById(R.id.imageView18);
        nyilHatra = findViewById(R.id.imageView19);
        nyilJobbra = findViewById(R.id.imageView20);
        nyilBallra = findViewById(R.id.imageView21);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = manager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        mindenNyilatEltuntetoMetodus();
        nyilElore.setVisibility(View.VISIBLE);

        gyros = new GyroscopeObserver();
        gyros.setMaxRotateRadian(Math.PI/2);



        panor =findViewById(R.id.panor);
        panor.setGyroscopeObserver(gyros);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                x = sensorEvent.values[0];
                y = sensorEvent.values[1];
                z = sensorEvent.values[2];

                Log.d("asdx","x: " +String.valueOf(x));
                Log.d("asdy","y: " +String.valueOf(y));
                Log.d("asdz","z: " +String.valueOf(z));

                if(x > 0){
                    nyilElore.animate().rotation(nyilElore.getRotation()-3).start();
                }
                else if(x < 0){
                    nyilElore.animate().rotation(nyilElore.getRotation()+3).start();
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {



            }
        };


        nyilElore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //nyilElore.animate().rotation(nyilElore.getRotation()-x).start();


           if(pozi == 0){
                    panor.setImageResource(R.drawable.kep2);
                    nyilHatra.setVisibility(View.VISIBLE);
                    pozi = 1;
                }
               else if(pozi == 1){
                    panor.setImageResource(R.drawable.kep3);
                    nyilElore.setVisibility(View.GONE);
                    nyilBallra.setVisibility(View.VISIBLE);
                    nyilJobbra.setVisibility(View.VISIBLE);
                    pozi = 2;
                }

            }
        });

        nyilHatra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pozi == 1 ){

                    panor.setImageResource(R.drawable.kep1);
                    nyilHatra.setVisibility(View.GONE);
                    pozi = 0;
                }
                else if(pozi == 2){
                    panor.setImageResource(R.drawable.kep2);
                    nyilBallra.setVisibility(View.GONE);
                    nyilJobbra.setVisibility(View.GONE);
                    pozi = 1;
                }

            }
        });

        nyilJobbra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(streetView.this, "erdő", Toast.LENGTH_SHORT).show();
            }
        });

        nyilBallra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(streetView.this, "szőlő", Toast.LENGTH_SHORT).show();
            }
        });




    }



    @Override
    public void onResume() {
        super.onResume();
        gyros.register(this);
      //  manager.registerListener(sensorEventListener,gyroscope,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        gyros.unregister();
     //   manager.unregisterListener(sensorEventListener);
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        final float alpha = 0.97f;
        synchronized (this){
            if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                mGravity[0] = alpha*mGravity[0]+(1-alpha)*sensorEvent.values[0];
                mGravity[1] = alpha*mGravity[1]+(1-alpha)*sensorEvent.values[1];
                mGravity[2] = alpha*mGravity[2]+(1-alpha)*sensorEvent.values[2];
            }
            if(sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
                mGeomagnetic[0] = alpha*mGeomagnetic[0]+(1-alpha)*sensorEvent.values[0];
                mGeomagnetic[1] = alpha*mGeomagnetic[1]+(1-alpha)*sensorEvent.values[1];
                mGeomagnetic[2] = alpha*mGeomagnetic[2]+(1-alpha)*sensorEvent.values[2];
            }
            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R,I,mGravity,mGeomagnetic);
            if(success){
                float orientation[] = new float[3];
                SensorManager.getOrientation(R,orientation);
                azimuth = (float)Math.toDegrees(orientation[0]);
                azimuth = (azimuth+360)%360;

                Animation anim = new RotateAnimation(-currectAzimuth,-azimuth,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                currectAzimuth = azimuth;

                anim.setDuration(500);
                anim.setRepeatCount(0);
                anim.setFillAfter(true);

                nyilElore.startAnimation(anim);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void mindenNyilatEltuntetoMetodus(){
        nyilBallra.setVisibility(View.GONE);
        nyilJobbra.setVisibility(View.GONE);
        nyilHatra.setVisibility(View.GONE);
        nyilElore.setVisibility(View.GONE);
    }
}