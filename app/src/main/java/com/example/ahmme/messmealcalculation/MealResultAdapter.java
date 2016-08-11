package com.example.ahmme.messmealcalculation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Laptop Dream on 08-Jul-16.
 */
public class MealResultAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<MealInfo> contactList;
    ViewHolder viewHolder;
    public MealResultAdapter(Context context, ArrayList<MealInfo> contactList) {
        super(context, R.layout.result_row_layout,contactList);
        this.context=context;
        this.contactList=contactList;

    }
    public class ViewHolder{
        TextView sirialNoRRTV;
        TextView nameRRTV;
        TextView dipositRRTV;
        TextView millRRTV;
        TextView millCostRRTV;
        TextView restMoneyRRTV;
        TextView extraRRTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.result_row_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.sirialNoRRTV = (TextView) convertView.findViewById(R.id.sirialNoRR);
            viewHolder.nameRRTV = (TextView) convertView.findViewById(R.id.nameRR);
            viewHolder.dipositRRTV = (TextView) convertView.findViewById(R.id.dipositRR);
            viewHolder.millRRTV =(TextView)convertView.findViewById(R.id.millRR);
            viewHolder.millCostRRTV =(TextView)convertView.findViewById(R.id.millCostRR);
            viewHolder.extraRRTV=(TextView)convertView.findViewById(R.id.extraRR);
            viewHolder.restMoneyRRTV =(TextView)convertView.findViewById(R.id.restMonyRR);

            viewHolder.sirialNoRRTV.setText("No");
            viewHolder.nameRRTV.setText("Name");
            viewHolder.dipositRRTV.setText("Deposit");
            viewHolder.millRRTV.setText("Mill");
            viewHolder.millCostRRTV.setText("Mill Cost");
            viewHolder.extraRRTV.setText("Extra");
            viewHolder.restMoneyRRTV.setText("Rest Mony");
            convertView.setTag(viewHolder);


        }
        else {
            convertView.getTag();
        }

        DecimalFormat precision = new DecimalFormat("0.00");



        viewHolder.sirialNoRRTV.setText(String.valueOf(position+1));
        viewHolder.nameRRTV.setText(contactList.get(position).getName());
        viewHolder.dipositRRTV.setText(String.valueOf(contactList.get(position).getDeposit()));
        viewHolder.millRRTV.setText(String.valueOf(contactList.get(position).getMeal()));
        viewHolder.millCostRRTV.setText(String.valueOf(precision.format(contactList.get(position).getMealCost())));
        viewHolder.extraRRTV.setText(String.valueOf(precision.format(contactList.get(position).getEachPersonExtra())));
        viewHolder.restMoneyRRTV.setText(String.valueOf(precision.format(contactList.get(position).getRestMony())));
        return convertView;
    }

}
