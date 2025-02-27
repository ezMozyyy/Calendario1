package com.example.calendario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String endl = "\r\n";
    EditText nome =null,cognome=null;
    RadioGroup sesso=null;
    DatePicker DataNascita=null;
    CheckBox tecnologia=null,arte=null,musica=null,sport=null,auto=null;
    Button genera=null;
    TextView riassunto=null;

    private int mYear, mMonth,mDay,mHour,mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recuperaOggetti();
    }
    public void recuperaOggetti(){
    nome=(EditText) findViewById(R.id.nome);
    cognome=(EditText) findViewById(R.id.cognome);
    sesso=(RadioGroup) findViewById(R.id.sesso);
    DataNascita=(DatePicker) findViewById(R.id.DataNascita);
    tecnologia=(CheckBox) findViewById(R.id.tecnologia);
    arte=(CheckBox) findViewById(R.id.arte);
    musica=(CheckBox) findViewById(R.id.musica);
    sport=(CheckBox) findViewById(R.id.sport);
    auto=(CheckBox) findViewById(R.id.auto);
    genera=(Button) findViewById(R.id.genera);
}

    public void generaResoconto(View v){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        
        RadioButton selezionato = (RadioButton) findViewById(sesso.getCheckedRadioButtonId());
        String s = "Nome: " + nome.getText().toString() + endl
                + "Cognome: " + cognome.getText().toString() + endl
                + "Sesso: " + selezionato.getText().toString() + endl
                + "Data di nascita: " + DataNascita.getDayOfMonth()
                + "/" + (DataNascita.getMonth() + 1)
                + "/" + DataNascita.getYear() + endl
                + "Interessi: ";

        if(tecnologia.isChecked()){ s+= "Tecnologia"; }
        if(arte.isChecked()){ s+= "Arte"; }
        if(musica.isChecked()){ s+= "Musica"; }
        if(sport.isChecked()){ s+= "Sport"; }
        if(auto.isChecked()){ s+= "Auto"; }
        riassunto.setText(s);
    }
    //DatePickerDialog.show();





}