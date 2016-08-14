package com.example.ahmme.messmealcalculation.MealChart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ahmme.messmealcalculation.MealInfo;
import com.example.ahmme.messmealcalculation.R;

import java.util.ArrayList;

/**
 * Created by Laptop Dream on 07-Jul-16.
 */
public class MealChartAddAdupter extends ArrayAdapter {

    private Context context;
    private String[] contactList;
    ViewHolder viewHolder;
    MealInfo mealInfo=new MealInfo();
    public MealChartAddAdupter(Context context, String[] contactList) {
        super(context, R.layout.meal_chart_add_row_layout,contactList);
        this.context=context;
        this.contactList=contactList;
    }
    public class ViewHolder{
        TextView sirialNoTV;
        TextView nameTV;
        EditText mealET;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.meal_chart_add_row_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.sirialNoTV = (TextView) convertView.findViewById(R.id.serialNoCA);
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.name1CA);
            viewHolder.mealET = (EditText) convertView.findViewById(R.id.meal1CA);

            convertView.setTag(viewHolder);
        }
        else {
            convertView.getTag();
        }

        viewHolder.sirialNoTV.setText(String.valueOf(position+1));
        viewHolder.nameTV.setText(contactList[position]);
        viewHolder.mealET.setText("");
        return convertView;
    }
}
