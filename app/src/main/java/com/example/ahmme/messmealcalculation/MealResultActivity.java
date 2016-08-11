package com.example.ahmme.messmealcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MealResultActivity extends AppCompatActivity {
    MealInfo mealInfo;
    MealInfoManager manager;
    ArrayList<MealInfo> mealResultInfoList;
    MealResultAdapter adapter;
    TextView mealRetTV;
    TextView totalBazarTV;
    TextView totalMealTV;
    TextView totalExtraTV;
    private ListView listView;
    DecimalFormat precision = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_result);
        mealInfo=new MealInfo();
        mealResultInfoList=new ArrayList<>();
        manager=new MealInfoManager(this);

        mealRetTV =(TextView)findViewById(R.id.mealRetR);
        totalBazarTV=(TextView)findViewById(R.id.totalBazarR);
        totalMealTV=(TextView)findViewById(R.id.totalMealR);
        totalExtraTV=(TextView)findViewById(R.id.totalExtraR);
        listView=(ListView)findViewById(R.id.resultListView);

        mealInfo.setTotalBazar(getIntent().getFloatExtra("totalBazar",0.0f));
        mealInfo.setTotalExtra(getIntent().getFloatExtra("totalExtra",0.0f));

        mealInfo.setTotalMeal(manager.getTotalMeal());
        mealInfo.setMealRet(mealInfo.getTotalBazar()/mealInfo.getTotalMeal());
        mealInfo.setEachPersonExtra(mealInfo.getTotalExtra()/manager.getTotalMessMember());

        mealRetTV.setText(String.valueOf("Meal Ret : "+precision.format(mealInfo.getMealRet())));
        totalMealTV.setText(String.valueOf("Total Meal :"+mealInfo.getTotalMeal()));
        totalBazarTV.setText("Total Bazar : "+String.valueOf(mealInfo.getTotalBazar()));
        totalExtraTV.setText("Total Extra : "+String.valueOf(mealInfo.getTotalExtra()));

        ArrayList<MealInfo> mealInfoList=manager.getAllMealInfo();
        for(MealInfo info: mealInfoList){
            mealInfo.setId(info.getId());
            mealInfo.setName(info.getName());
            mealInfo.setDeposit(info.getDeposit());
            mealInfo.setMeal(info.getMeal());
            mealInfo.setMealCost(info.getMeal()*mealInfo.getMealRet());
            mealInfo.setRestMony(info.getDeposit()-mealInfo.getMealCost());
            MealInfo resultInfo=new MealInfo(mealInfo.getId(),mealInfo.getName(),mealInfo.getDeposit(),mealInfo.getMeal(),
                    mealInfo.getMealCost(),mealInfo.getEachPersonExtra(),mealInfo.getRestMony());
            mealResultInfoList.add(resultInfo);
        }
        adapter=new MealResultAdapter(MealResultActivity.this,mealResultInfoList);
        listView.setAdapter(adapter);
    }

}
