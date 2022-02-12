package com.example.logovanje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    TextView regKorIme,regLozinka,regTitle;
    EditText eRegKorIme,eRegLozinka;
    Button bRegistracija;

    DbHelper dbHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        regKorIme = (TextView)findViewById(R.id.tvRegKor);
        regLozinka = (TextView)findViewById(R.id.tvRegLoz);
        regTitle = (TextView)findViewById(R.id.tvRegTitle);

        eRegKorIme = (EditText) findViewById(R.id.etRegKor);
        eRegLozinka = (EditText) findViewById(R.id.etRegLoz);

        bRegistracija = (Button) findViewById(R.id.btnRegistracija);

        dbHelper2 =new DbHelper(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setCancelable(true);
        builder.setTitle("Registracija");
        builder.setMessage("Ukoliko niste registrovani u bazi podataka LOGOVANJE ovde mozete izvrsiti registraciju");
        builder.show();

        bRegistracija.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String regKor = eRegKorIme.getText().toString();
                String regLoz = eRegLozinka.getText().toString();

                if (regKor.equals("") || regLoz.equals(""))
                {
                    Toast.makeText(MainActivity2.this,"Nisu popunjena sva polja!",Toast.LENGTH_SHORT).show();
                } else
                    {
                        boolean unesen = dbHelper2.unosPodataka(regKor,regLoz);

                        if (unesen == true)
                        {
                            Toast.makeText(MainActivity2.this, "Uspesno ste se registrovali", Toast.LENGTH_SHORT).show();
                        } else
                        {
                            Toast.makeText(MainActivity2.this, "Registracija nije uspela-POKUSAJTE PONOVO", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });

    }
}