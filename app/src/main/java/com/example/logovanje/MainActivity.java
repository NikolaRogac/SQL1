package com.example.logovanje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView korIme,lozinka,title;
    EditText eKorIme,eLozinka;
    Button bDalje;

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        korIme = (TextView)findViewById(R.id.tvKor);
        lozinka = (TextView)findViewById(R.id.tvLoz);
        title = (TextView)findViewById(R.id.tvTitle);

        eKorIme = (EditText) findViewById(R.id.etKor);
        eLozinka = (EditText) findViewById(R.id.etLoz);

        bDalje = (Button) findViewById(R.id.btnDalje);

        dbHelper = new DbHelper(this);

        bDalje.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String kor = eKorIme.getText().toString();
                String loz = eLozinka.getText().toString();

                if (kor.equals("") || loz.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Nisu popunjena sva polja!",Toast.LENGTH_SHORT).show();
                } else
                    {
                        boolean proveri = dbHelper.proveraPodataka(kor,loz);
                        if (proveri == true)
                        {
                            Toast.makeText(MainActivity.this, "Uspesno logovanje", Toast.LENGTH_SHORT).show();
                        } else
                            {
                                Toast.makeText(MainActivity.this,"Neuspesno logovanje",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                                startActivity(i);
                            }
                    }

            }
        });
    }
}