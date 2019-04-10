package com.example.tabuada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> tabuada = new ArrayList<Integer>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>
                (this, android.R.layout.simple_list_item_1, tabuada);

        final Button button = findViewById(R.id.button);
        final ListView lista = findViewById(R.id.tabuada);
        lista.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText n = findViewById(R.id.numero);

                int numero = 0;

                try {
                    numero = Integer.parseInt(n.getText().toString());
                } catch (NumberFormatException e) {
                    System.out.println("Número invalido");
                    return ;
                }

                System.out.println("O numero digitado foi: " + numero);
                geraLista(numero);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }


    public void geraLista(int n) {
        if (this.tabuada.size() > 0) {
            for (int i = 0; i < 10; i++) {
                this.tabuada.set(i, Integer.valueOf(n * (i + 1)));
            }
        }  else {
            for (int i = 0; i < 10; i++) {
                this.tabuada.add(Integer.valueOf(n * (i + 1)));
            }
        }
    }


}
