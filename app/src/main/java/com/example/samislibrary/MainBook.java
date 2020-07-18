package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainBook extends AppCompatActivity {
    Button curentR, addtoW, AlreadyR, AddtoF;
    ImageView bookimg;
    TextView name, author, authors, page, pages, description, descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_book);
        init();
        Intent intent = getIntent();
        if (intent != null) {
            int id = intent.getIntExtra("buksid", -1);
            if (id != -1) {
                book incomingbuk = Utils.getInstance().GetbookById(id);
                if (null != incomingbuk) {
                    setData(incomingbuk);
                    HandleAlreadyReadBuks(incomingbuk);
                    HandleCurrentReadBuks(incomingbuk);
                    Handlewishlistbuks(incomingbuk);
                    HandleFav(incomingbuk);
                }
            }
        }
    }

    private void HandleFav(final book incomingbuk) {
        ArrayList<book>  Favbuks=Utils.getInstance().getFavouritebooks();
        boolean existinFav=false;
        for(book b:Favbuks){
            if(b.getId()==incomingbuk.getId()){
                existinFav=true;
            }
        }
        if(existinFav){
            AddtoF.setEnabled(false);
        }
        else{
            AddtoF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().AddtoFav(incomingbuk)){
                        Toast.makeText(MainBook.this, "Book Added !", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainBook.this,Favlist.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainBook.this, "Something went wrong ! try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void Handlewishlistbuks(final book incomingbuk) {
        ArrayList<book>  Wishlistbuks=Utils.getInstance().getWishlistbooks();
        boolean exitinWishlist=false;
        for(book b:Wishlistbuks){
            if(b.getId()==incomingbuk.getId()){
                exitinWishlist=true;
            }
        }
        if(exitinWishlist){
            addtoW.setEnabled(false);
        }
        else{
            addtoW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().AddtoWishLIst(incomingbuk)){
                    Toast.makeText(MainBook.this, "book Added !", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainBook.this,wishList.class);
                    startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainBook.this, "Something went wrong ! try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void HandleCurrentReadBuks(final book incomingbuk) {
        ArrayList<book>  CurrentReadB=Utils.getInstance().getCurentReadingbooks();
        boolean existinCurentReadbuks=false;
        for(book b:CurrentReadB){
            if(b.getId()==incomingbuk.getId()){
                existinCurentReadbuks=true;
            }
        }
        if(existinCurentReadbuks){
            curentR.setEnabled(false);
        }
        else{
            curentR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().AddtoCurrentreadingbuks(incomingbuk)){
                        Toast.makeText(MainBook.this, "Book Selected !", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainBook.this,CurrentReadingBooks.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainBook.this, "Something went Wrong! try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void HandleAlreadyReadBuks(final book incomingbuk) {
        ArrayList<book> AlreadyReadB = Utils.getInstance().getAlreadyReadbooks();
        boolean existinAlreadyReadBuks=false;
        for (book b : AlreadyReadB) {
            if (b.getId() == incomingbuk.getId()) {
             existinAlreadyReadBuks=true;
            } }
        if(existinAlreadyReadBuks){
            AlreadyR.setEnabled(false);
        }
        else{
            AlreadyR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().AddtoAlreadyReadBuks(incomingbuk)){
                        Toast.makeText(MainBook.this, "book added !", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainBook.this,AllreadyReadBooks.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainBook.this, "Something went wrong ! try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        }


    private void setData(book buk) {
        name.setText(buk.getName());
        authors.setText(buk.getAuthor());
        pages.setText(String.valueOf(buk.getPages()));
        descriptions.setText(buk.getDescription());
        Glide.with(this).asBitmap().load(buk.getImgurl()).into(bookimg);

    }

    private void init() {
        curentR = findViewById(R.id.btnCurent);
        AlreadyR = findViewById(R.id.btnAlreadyread);
        addtoW = findViewById(R.id.btnwishlist);
        AddtoF = findViewById(R.id.btnfav);
        bookimg = findViewById(R.id.imageView);
        name = findViewById(R.id.bname);
        author = findViewById(R.id.author);
        authors = findViewById(R.id.authors);
        page = findViewById(R.id.page);
        pages = findViewById(R.id.pages);
        description = findViewById(R.id.description);
        descriptions = findViewById(R.id.descriptions);

    }
}