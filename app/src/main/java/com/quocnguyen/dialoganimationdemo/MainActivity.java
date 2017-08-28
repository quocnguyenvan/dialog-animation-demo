package com.quocnguyen.dialoganimationdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnShowDialog;
    ArrayList<String> typeList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeList = new ArrayList<>();
        typeList.add("Slide left - right");
        typeList.add("Slide up - down");
        typeList.add("Scale");

        spinner = (Spinner) findViewById(R.id.spinner);
        btnShowDialog = (Button) findViewById(R.id.btnShowDialog);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                typeList);

        spinner.setAdapter(adapter);

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (spinner.getSelectedItemPosition()){
                    case 0:
                        showDialogAnimation(R.style.DialogSlide1, "Slide left - right");
                        break;
                    case 1:
                        showDialogAnimation(R.style.DialogSlide2, "Slide up - down");
                        break;
                    case 2:
                        showDialogAnimation(R.style.DialogScale, "Scale");
                }
            }
        });
    }

    private void showDialogAnimation(int type, String message){
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("Dialog Animation");
        dialog.setMessage(message);
        dialog.getWindow().getAttributes().windowAnimations = type;
        dialog.show();
    }
}
