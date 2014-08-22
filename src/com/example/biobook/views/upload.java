package com.example.biobook.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.biobook.R;
import com.example.biobook.domain.Address;
import com.example.biobook.domain.Student;
import com.example.biobook.repository.Impl.addressDatasourceDAOImpl;
import com.example.biobook.repository.Impl.studentDatasourceDAOImpl;
import com.example.biobook.repository.addressDatasourceDAO;
import com.example.biobook.repository.studentDatasourceDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhona on 2014/08/19.
 */
public class upload extends Activity {
    EditText one;
    Button btndisp;
    TextView lbldisp;
    List<Student> studentList = new ArrayList<Student>();
    List<Address> addList = new ArrayList<Address>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadlay);

        final studentDatasourceDAO daoa = new studentDatasourceDAOImpl(this);
        final addressDatasourceDAO daob = new addressDatasourceDAOImpl(this);

        String[] info = new String[10];

        Student stud = new Student.Builder(" ").lastname(" ").email(" ").cell(" ").build();
        Address address = new Address.Builder(" ").street_name(" ").town(" ").postal_code(" ").build();




       // lbldisp = (TextView) findViewById(R.id.lbldisp);
       // btndisp = (Button) findViewById(R.id.btndisp);




        Bundle intent = getIntent().getExtras();
        if( intent != null ) {
            info = intent.getStringArray("things");

        }
        else
        {
            Toast.makeText( getApplicationContext(), "Fail!", Toast.LENGTH_SHORT ).show();
        }

        Toast.makeText( getApplicationContext(), "Success " + info[0] , Toast.LENGTH_LONG ).show();




        stud = new Student.Builder(info[0]).lastname(info[1]).email(info[2]).cell(info[3]).build();
        address = new Address.Builder(info[4]).street_name(info[5]).town(info[6]).postal_code(info[7]).build();


        daoa.createStudent(stud);
        daob.createAddress(address);

        studentList = daoa.getStudentList();
        addList = daob.getAddressList();

        String[] lasties = new String[ studentList.size() ];
        String[] cellies = new String[ studentList.size() ];

        last(lasties);
        cells(cellies);

//        lbldisp.setText("Lastname: " + daoa.getStudent().getStud_last().toLowerCase() + " Phone: "
            //     + daoa.getStudent().getStud_cell().toLowerCase());



        /*btndisp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.btndisp :
                        lbldisp.setText(" NAME: " + daoa.getStudent().getStud_name().toLowerCase()
                                + " SURNAME: " + daoa.getStudent().getStud_last().toLowerCase()
                                + " EMAIL: " + daoa.getStudent().getStud_mail().toLowerCase()
                                + " PHONE: " + daoa.getStudent().getStud_cell()
                                + " STREET NO: " + daob.getAddress().getStreet_number()
                                + " STREET NM: " + daob.getAddress().getStreet_name().toLowerCase()
                                + " TOWN: " + daob.getAddress().getTown().toLowerCase()
                                + " CODE: " + daob.getAddress().getPostal_code());
                }
            }
        });*/

        ListView list;
        String[] lastnames = {};
        String[] cells = {""};




        final int[] buttons = new int[100];



        listclass adapter = new
                listclass(upload.this, lasties, cellies, buttons);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // int z = 0;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int z = position;

                switch (view.getId()) {
                    case 0 :
                    Toast.makeText(getApplicationContext(), "You clicked button " + z, Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    public void last( String[] values )
    {
        int count = 0;

        for( Student s : studentList )
        {
            values[count] = s.getStud_last();
            count++;
        }
    }

    public void cells( String[] values )
    {
        int count = 0;

        for( Student s : studentList )
        {
            values[count] = s.getStud_cell();
            count++;
        }
    }
}