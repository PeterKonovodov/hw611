package com.example.hw611;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class LifeCycleActivity extends AppCompatActivity {

    static final String TAG = "LifeCycleActivity";

    TextView centerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        centerText = findViewById(R.id.centerText);
        centerText.setMovementMethod(new ScrollingMovementMethod());

        Log.i(TAG, "onCreate()");
        centerText.append("\n onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
        centerText.append("\n onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
        centerText.append("\n onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
        centerText.append("\n onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
        centerText.append("\n onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
        centerText.append("\n onResume");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.i(TAG, "onPostCreate()");
        centerText.append("\n onPostCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
        centerText.append("\n onRestart");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SPACE) {     //почему-то это срабатывает только 1 раз
            Log.i(TAG, "space!");
        }
        Log.i(TAG, "onKeyDown()" + keyCode);
        centerText.append("\n onKeyDown " + keyCode);
        event.startTracking();
        super.onKeyDown(keyCode, event);
        return true;        //не заметил разницы с return super.onKeyDown(keyCode, event);
//        return false;        //onKeyLongPress не работает и только-то
    }


    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i(TAG, "onKeyLongPress()" + keyCode);
        centerText.append("\n onKeyLongPress" + keyCode);
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed()");
        centerText.append("\n onBackPressed");
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");
        centerText.append("\n onSaveInstanceState");
        outState.putString("centerText", centerText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState()");
        centerText.append("\n onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        centerText.setText(savedInstanceState.getString("centerText"));

    }
}