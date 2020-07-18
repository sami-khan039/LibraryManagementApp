package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentReadingBooks extends AppCompatActivity {
RecyclerView rvCurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_reading_books);
        rvCurrent=findViewById(R.id.rvCurrent);
        RvAdapter adapter=new RvAdapter(this,"Cur");
        rvCurrent.setAdapter(adapter);
        rvCurrent.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getCurentReadingbooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}