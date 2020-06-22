package com.example.surfaceviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Android Draw SurfaceView In Thread Example.");

        // Hide app title bar.
        getSupportActionBar().hide();

        // Make app full screen to hide top status bar.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create the SurfaceViewThread object.
        final SurfaceViewThread surfaceViewThread = new SurfaceViewThread(getApplicationContext());

        // Get text drawing LinearLayout canvas.
        LinearLayout drawTextCanvas = (LinearLayout)findViewById(R.id.drawTextCanvas);

        // Add surfaceview object to the LinearLayout object.
        drawTextCanvas.addView(surfaceViewThread);

        // Get the edittext input text box.
        final EditText inputText = (EditText)findViewById(R.id.inputText);

        // Add key listener to listen to key type event.
        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Set the text to custom SurfaceView object.
                if(s.length()>0) {
                    surfaceViewThread.setText(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}