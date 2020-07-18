package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AllreadyReadBooks extends AppCompatActivity {
RecyclerView rvAlready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allready_read_books);
        rvAlready=findViewById(R.id.rvAlready);
        RvAdapter adapter=new RvAdapter(this,"Al");
        rvAlready.setAdapter(adapter);
        rvAlready.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getAlreadyReadbooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}