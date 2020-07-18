package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class wishList extends AppCompatActivity {
RecyclerView rvWish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        rvWish=findViewById(R.id.rvWish);
        RvAdapter adapter=new RvAdapter(this,"Wis");
        rvWish.setAdapter(adapter);
        rvWish.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getWishlistbooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(wishList.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}