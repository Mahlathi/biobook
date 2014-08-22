package com.example.biobook.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.biobook.R;

/**
 * Created by akhona on 2014/08/19.
 */
public class reg extends Activity {


    EditText naam;
    EditText faan;
    EditText email;
    EditText cell;
    EditText stno;
    EditText stname;
    EditText sttown;
    EditText stpost;
    ImageButton btnOne;
    ImageButton btnTwo;

    String[] info = new String[10];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reglay);

        naam = (EditText) findViewById(R.id.txtname);
        faan = (EditText) findViewById(R.id.txtsururname);
        email = (EditText) findViewById(R.id.txtemail);
        cell = (EditText) findViewById(R.id.txtcell);
        stno = (EditText) findViewById(R.id.txtstr);
        stname = (EditText) findViewById(R.id.txtstrname);
        sttown = (EditText) findViewById(R.id.txttown);
        stpost = (EditText) findViewById(R.id.txtpost);
        btnOne = (ImageButton) findViewById(R.id.btnsub);
        btnTwo = (ImageButton) findViewById(R.id.btnclear);


        btnOne.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.btnsub :
                        info[0] = naam.getText().toString();
                        info[1] = faan.getText().toString();
                        info[2] = email.getText().toString();
                        info[3] = cell.getText().toString();
                        info[4] = stno.getText().toString();
                        info[5] = stname.getText().toString();
                        info[6] = sttown.getText().toString();
                        info[7] = stpost.getText().toString();

                        Intent intent = new Intent("com.example.addressbook.UPLOAD");
                        intent.putExtra( "things", info );
                        startActivity(intent);
                }
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          switch (view.getId()) {
                                              case R.id.btnclear:
                                              naam.setText(" ");
                                              faan.setText(" ");
                                              email.setText(" ");
                                              cell.setText(" ");
                                              stno.setText(" ");
                                              stname.setText(" ");
                                              sttown.setText(" ");
                                              stpost.setText(" ");
                                          }
                                      }
                                  }
        );
    }
}