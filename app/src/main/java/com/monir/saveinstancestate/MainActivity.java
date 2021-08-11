package com.monir.saveinstancestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.monir.saveinstancestate.model.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_KEY = "Counter";
    TextView textView;


    CounterViewModel mViewModel;


//    int counter = 0;
//
//    // getting value from saveInstanceState
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        textView.setText(String.valueOf(savedInstanceState.getInt(STATE_KEY)));
//    }
//
//    // Setting Value for instance
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        outState.putInt(STATE_KEY,counter);
//        super.onSaveInstanceState(outState);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // initializing for instance
//        if(savedInstanceState != null){
//            counter = savedInstanceState.getInt(STATE_KEY);
//        }
        setContentView(R.layout.activity_main);

        // setting thing up
        mViewModel = new ViewModelProvider(this).get(CounterViewModel.class);
        textView = findViewById(R.id.textViewCounter);
        displayCounter(mViewModel.getCounter());
    }

    public void Increment(View view) {
//        counter++;
//        textView.setText(String.valueOf(counter));

        incrementValue(view);
    }

    private void incrementValue(View view){
        mViewModel.setCounter(mViewModel.getCounter() + 1);
        displayCounter(mViewModel.getCounter());
    }

    private void displayCounter(int counter){
        textView.setText(String.valueOf(counter));
    }
}