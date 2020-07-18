package com.example.samislibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView logoimg;
Button btnall,btncurrent,btnalready,btnwishlist,btnfav,btnAbout;
TextView license;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inti();
       SeeAllbooks();
       Alreadyreadbooks();
       CurrentlyReadingbook();
       wishList();
       FavLIst();
       about();
      Utils instance=new Utils();
    }

    private void about() {
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
                ad.setTitle(getString(R.string.app_name));
                ad.setMessage("Developed by Sami Khan,this is a dummy Application made for only learning purpose and refining concepts of android development. you can touch me at my social media handles");
                ad.setNegativeButton("dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ad.setPositiveButton("Visit profile", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,WebviewActivity.class);
                        startActivity(intent);

                    }
                });
                ad.create().show();
            }
        });
    }

    private void FavLIst() {
        btnfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Favlist.class);
                startActivity(intent);
            }
        });
    }

    private void wishList() {
        btnwishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,wishList.class);
                startActivity(intent);
            }
        });
    }

    private void CurrentlyReadingbook() {
        btncurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CurrentReadingBooks.class);
                startActivity(intent);
            }
        });
    }

    private void Alreadyreadbooks() {
        btnalready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AllreadyReadBooks.class);
                startActivity(intent);
            }
        });
    }

    private void SeeAllbooks() {
        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt=new Intent(MainActivity.this,SeeAllBooks.class);
                startActivity(intnt);
            }
        });
    }

    private void inti() {
        logoimg=findViewById(R.id.logoimg);
        btnall=findViewById(R.id.btnallbooks);
        btncurrent=findViewById(R.id.btncurrent);
        btnalready=findViewById(R.id.btnAlreadyread);
        btnwishlist=findViewById(R.id.btnwishlist);
        btnfav=findViewById(R.id.btnfav);
        btnAbout=findViewById(R.id.btnabout);
        license=findViewById(R.id.license);
    }
}