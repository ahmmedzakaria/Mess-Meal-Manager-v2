package com.example.ahmme.messmealcalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DialogActivity extends AppCompatActivity {
    MealInfo mealInfo;
    MealInfoManager manager;
    EditText totalBazarET;
    EditText totalExtraET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        totalBazarET=(EditText)findViewById(R.id.totalBazar);
        totalExtraET=(EditText)findViewById(R.id.totalExtra);
        mealInfo=new MealInfo();
        manager=new MealInfoManager(this);

        /*MealInfo info=manager.getBazarAndExtra();
        totalExtraET.setText(String.valueOf(info.getTotalBazar()));
        totalExtraET.setText(String.valueOf(info.getTotalExtra()));*/
    }


    public void calculate(View view) {
        mealInfo.setTotalBazar(Float.valueOf(totalBazarET.getText().toString()));
        mealInfo.setTotalExtra(Float.valueOf(totalExtraET.getText().toString()));

        /*MealInfo updateInfo=new MealInfo(mealInfo.getTotalBazar(),mealInfo.getTotalExtra());
        manager.updateBazarAndExtra(1,updateInfo);*/
        Intent nexPageIntent=new Intent(this,MealResultActivity.class);
        nexPageIntent.putExtra("totalBazar",mealInfo.getTotalBazar());
        nexPageIntent.putExtra("totalExtra",mealInfo.getTotalExtra());
        finish();
        startActivity(nexPageIntent);

    }
}
