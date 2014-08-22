package com.example.biobook.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.biobook.R;

/**
 * Created by akhona on 2014/08/21.
 */
public class listclass extends ArrayAdapter<String> {
    private Activity contexts;
    private String[] lastnames;
    private String[] cells;
    private int[] buttons;

    public listclass( Activity contexts, String[] lastnames, String[] cells, int[] buttons )
    {
        super(contexts, R.layout.list_single, lastnames );
        this.contexts = contexts;
        this.lastnames = lastnames;
        this.cells = cells;
        this.buttons = buttons;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = contexts.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);

        TextView txtView = (TextView) rowView.findViewById(R.id.lastname);
        TextView txtView2 = (TextView) rowView.findViewById(R.id.cellno);
        Button txtView3 = (Button) rowView.findViewById(R.id.btndt);

        txtView.setText(lastnames[position]);
        txtView2.setText(cells[position]);
        txtView3.setClickable(true);
        return rowView;
    }

    public listclass(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        }
}
