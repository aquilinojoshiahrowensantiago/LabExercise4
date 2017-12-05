package com.santiago.labexercise4;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etParagraph;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etParagraph = (EditText) findViewById(R.id.et_Paragraph);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }
    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("paragraph",etParagraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }

    public void loadInfo(View view){
        String para = preferences.getString("paragraph", "");
        tvDisplay.setText(para);

    }
    public void clear (View view){

        etParagraph.setText("");
    }
}
