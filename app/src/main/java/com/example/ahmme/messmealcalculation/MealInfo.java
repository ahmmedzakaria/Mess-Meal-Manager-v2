package com.example.ahmme.messmealcalculation;

/**
 * Created by ahmme on 30-07-16.
 */
public class MealInfo {
    private int id;
    private float totalBazar;
    private float totalExtra;
    private float eachPersonExtra;
    private String name;
    private float deposit;
    private float meal;
    private float totalMeal;
    private float mealCost;
    private float mealRet;
    private float RestMony;
    private int totalMassMember;

    public MealInfo(int id, String name, float deposit, float meal, float MealCost,float eachPersonExtra, float restMony) {
        this.id=id;
        this.name = name;
        this.deposit = deposit;
        this.meal = meal;
        this.mealCost = MealCost;
        this.eachPersonExtra=eachPersonExtra;
        RestMony = restMony;
    }

    public MealInfo(int id, String name, float deposit, float meal) {
        this.id = id;
        this.name = name;
        this.deposit = deposit;
        this.meal = meal;
    }
    public MealInfo(String name, float deposit, float meal) {
        this.name = name;
        this.deposit = deposit;
        this.meal = meal;
    }

    public MealInfo(int id, float totalBazar, float totalExtra) {
        this.id = id;
        this.totalBazar = totalBazar;
        this.totalExtra = totalExtra;
    }

    public MealInfo(float totalBazar, float totalExtra) {
        this.totalBazar = totalBazar;
        this.totalExtra = totalExtra;
    }

    public MealInfo() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalBazar() {
        return totalBazar;
    }

    public void setTotalBazar(float totalBazar) {
        this.totalBazar = totalBazar;
    }

    public float getTotalExtra() {
        return totalExtra;
    }

    public void setTotalExtra(float totalExtra) {
        this.totalExtra = totalExtra;
    }

    public float getEachPersonExtra() {
        return eachPersonExtra;
    }

    public void setEachPersonExtra(float eachPersonExtra) {
        this.eachPersonExtra = eachPersonExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String newName =name.toUpperCase();
        this.name=newName;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getMeal() {
        return meal;
    }

    public void setMeal(float meal) {
        this.meal = meal;
    }

    public float getTotalMeal() {
        return totalMeal;
    }

    public void setTotalMeal(float totalMeal) {
        this.totalMeal = totalMeal;
    }

    public float getMealCost() {
        return mealCost;
    }

    public void setMealCost(float MealCost) {
        this.mealCost = MealCost;
    }

    public float getMealRet() {
        return mealRet;
    }

    public void setMealRet(float mealRet) {
        this.mealRet = mealRet;
    }

    public float getRestMony() {
        return RestMony;
    }

    public void setRestMony(float restMony) {
        RestMony = restMony;
    }

    public int getTotalMassMember() {
        return totalMassMember;
    }

    public void setTotalMassMember(int totalMassMember) {
        this.totalMassMember = totalMassMember;
    }




}
