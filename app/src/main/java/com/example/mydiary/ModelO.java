package com.example.mydiary;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalTime;

public class ModelO {
    private LocalDate date;
    private LocalTime time;
    private double money;
    private String name;
    private String type;
    ModelO()
    {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ModelO(double money, String name, String type) {
        this.money = money;
        this.name = name;
        this.type = type;
        time=LocalTime.now();
        date=LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
