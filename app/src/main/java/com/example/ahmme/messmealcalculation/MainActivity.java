package com.example.ahmme.messmealcalculation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private ListView listView;
    private EditText nameET;
    private EditText depositET;
    private EditText mealET;
    private Button addBtn;
    MealInfo mealInfo;
    MealAdapter adapter;
    ArrayList<MealInfo> messMealArrayList;
    //    ArrayList<MealInfo> messMillArrayList;
    MealInfoManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        nameET = (EditText) findViewById(R.id.name);
        depositET = (EditText) findViewById(R.id.deposit);
        mealET = (EditText) findViewById(R.id.meal);
        addBtn=(Button)findViewById(R.id.add);
        mealInfo=new MealInfo();
        messMealArrayList = new ArrayList<MealInfo>();
        manager=new MealInfoManager(this);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        try{
            showListView();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Please Insert Data", Toast.LENGTH_SHORT).show();
        }
    }



    public void addToList(View view) {
        mealInfo.setName(nameET.getText().toString());
        mealInfo.setDeposit(Float.valueOf(depositET.getText().toString()));
        mealInfo.setMeal(Float.valueOf(mealET.getText().toString()));

        if (mealInfo.getName().length()>0 && mealInfo.getDeposit()>=0 && mealInfo.getMeal()>=0) {
            mealInfo = new MealInfo(mealInfo.getName(), mealInfo.getDeposit(), mealInfo.getMeal());
            manager.addMealInfo(mealInfo);
            showListView();
            clearEditTExt();

        } else {
            Toast toast = Toast.makeText(MainActivity.this, "Please Insert Data", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void showListView() {
        messMealArrayList=manager.getAllMealInfo();
        adapter = new MealAdapter(MainActivity.this, messMealArrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mealInfo.setId(i+1);
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,view);
                popupMenu.setOnMenuItemClickListener(MainActivity.this);
                MenuInflater inflater=popupMenu.getMenuInflater();
                inflater.inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
            }
        });
    }


    public void calculate(View view) {
        Intent intent =new Intent(MainActivity.this,DialogActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.deleteAll:
                new AlertDialog.Builder(this)
                        .setTitle("Delete All")
                        .setMessage("Are you sure you want to delete all data?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                try{manager.deleteAllContact();
                                    showListView();
                                }catch (Exception e){
                                    Toast.makeText(MainActivity.this, "All Data Deleted", Toast.LENGTH_SHORT).show();

                                }
                                showListView();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                return true;
            case R.id.changePassword:
                Toast.makeText(MainActivity.this, "password", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.exit:
                finish();
                System.exit(0);
                Toast.makeText(MainActivity.this, "exit", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearAll(View view) {
        try{manager.deleteAllContact();
            messMealArrayList=manager.getAllMealInfo();
            adapter = new MealAdapter(MainActivity.this, messMealArrayList);

        }catch (Exception e){
            Toast.makeText(MainActivity.this, "All Data Deleted", Toast.LENGTH_SHORT).show();
            listView.setAdapter(adapter);
        }
    }


    public void clearEditTExt(){
        nameET.setText("");
        depositET.setText("");
        mealET.setText("");
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                new AlertDialog.Builder(this)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete data?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                manager.deleteMealInfo(mealInfo.getId());
                                showListView();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                break;
            case R.id.edit:
                MealInfo mealInfoById=manager.getMemberMealInfoById(mealInfo.getId());
                nameET.setText(mealInfoById.getName());
                depositET.setText(String.valueOf(mealInfoById.getDeposit()));
                mealET.setText(String.valueOf(mealInfoById.getMeal()));

                addBtn.setText("DONE");
                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addBtn.setText("ADD");
                        mealInfo.setName(nameET.getText().toString());
                        mealInfo.setDeposit(Float.valueOf(depositET.getText().toString()));
                        mealInfo.setMeal(Float.valueOf(mealET.getText().toString()));

                        MealInfo newInfo=new MealInfo(mealInfo.getName(),mealInfo.getDeposit(),mealInfo.getMeal());
                        manager.updateContact(mealInfo.getId(),newInfo);
                        clearEditTExt();
                        showListView();

                    }
                });

                Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
