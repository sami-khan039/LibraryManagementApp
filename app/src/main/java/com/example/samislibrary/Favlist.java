package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class Favlist extends AppCompatActivity {
RecyclerView rvfav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favlist);
        rvfav=findViewById(R.id.rvfav);
        RvAdapter adapter=new RvAdapter(this,"FavActivity");
        rvfav.setAdapter(adapter);
        rvfav.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getFavouritebooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Favlist.this,MainActivity.class) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}