package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SeeAllBooks extends AppCompatActivity {
RecyclerView rvallbooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_books);
        rvallbooks=findViewById(R.id.rvallbooks);
        RvAdapter adapt=new RvAdapter(this,"SeeAllBooksActivity");
        rvallbooks.setAdapter(adapt);
        rvallbooks.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<book> books=new ArrayList<>();
    adapt.setBooks(Utils.getInstance().getAllbooks());
    }
}