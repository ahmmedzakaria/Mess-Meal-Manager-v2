package com.example.ahmme.messmealcalculation.MealChart;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ahmme.messmealcalculation.MainActivity;
import com.example.ahmme.messmealcalculation.MealInfo;
import com.example.ahmme.messmealcalculation.R;

public class MealAddActivity extends AppCompatActivity {
    MealChartManager manager;
    MealInfo mealInfo;
    MealChartAddAdupter adupter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_add);
        mealInfo.setContext(MealAddActivity.this);
        mealInfo=new MealInfo();
        manager=new MealChartManager(this);
        listView=(ListView)findViewById(R.id.chartAddListView);

        String[] allName=new String[manager.getTotalMessMember()];
        adupter =new MealChartAddAdupter(this,allName);
        listView.setAdapter(adupter);


    }
}
