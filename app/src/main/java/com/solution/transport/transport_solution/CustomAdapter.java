package com.solution.transport.transport_solution;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomAdapter{

  private String nDays;
  private String pricePerDay;
  private int id;

    public CustomAdapter(String nDays, String pricePerDay, int id) {
        this.nDays = nDays;
        this.pricePerDay = pricePerDay;
        this.id = id;
    }

    public String getnDays() {
        return nDays;
    }

    public void setnDays(String nDays) {
        this.nDays = nDays;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
