package com.example.mydiary;


import java.util.ArrayList;


public class Diary {
ArrayList<ModelO> array;
static Diary d;

public static Diary createObject()
{
    if(d==null) {
        d = new Diary();
    }
        return d;
}
    private Diary()
    {
        array=new ArrayList<>();
    }
public void add(ModelO model)
{
    array.add(model);
}
public void clear()
{
    array.clear();
}
public ArrayList getListCategories(String categories)
{
    ArrayList<ModelO> temp=new ArrayList<>();
    if(categories.contains("Health"))
    {
        for (ModelO model: array) {
            if(model.getType()=="Health")
            temp.add(model);

        }
    }
    if(categories.contains("Food"))
    {
        for (ModelO model: array) {
            if(model.getType()=="Food")
                temp.add(model);

        }
    }
    if(categories.contains("Car"))
    {
        for (ModelO model: array) {
            if(model.getType()=="Car")
                temp.add(model);

        }
    }
    if(categories.contains("Clothes"))
    {
        for (ModelO model: array) {
            if(model.getType()=="Clothes")
                temp.add(model);

        }
    }
    if(categories.contains("Ent"))
    {
        for (ModelO model: array) {
            if(model.getType()=="Ent")
                temp.add(model);

        }
    }

    return temp;
}
public double getmoneycategories(String categories)
{
    double money=0;
    for (ModelO object:array) {
        if(object.getType().equals(categories))
        {
            money+=object.getMoney();
        }

    }
    return money;
}
}
