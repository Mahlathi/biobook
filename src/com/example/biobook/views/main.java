package com.example.biobook.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.biobook.R;

public class main extends Activity {
    /**
     * Called when the activity is first created.
     */
    EditText one;
    EditText two;

    ImageButton btnOne;
    ImageButton btnTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        one = (EditText) findViewById(R.id.txtuser);
        two = (EditText) findViewById(R.id.txtpass);
        btnOne = (ImageButton) findViewById(R.id.btnlog);
        btnTwo = (ImageButton) findViewById(R.id.btncan);

        btnOne.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.btnlog :
                        if( one.getText().toString().equalsIgnoreCase("f") && two.getText().toString().equalsIgnoreCase("1"))
                        {
                            Intent intent = new Intent( "com.example.addressbook.REG" );
                            startActivity(intent);
                        }
                }
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View view) {
                                          switch (view.getId()) {
                                              case R.id.btncan:
                                                  one.setText(" ");
                                                  two.setText(" ");
                                          }
                                      }
                                  }
        );
    }
}
