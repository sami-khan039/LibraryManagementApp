package com.example.samislibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private static final String TAG = "RvAdapter";
    private ArrayList<book> books = new ArrayList<book>();
    public Context contxt;
    private String ActivityName;

    public RvAdapter(Context c,String s) {
        this.contxt = c;
        this.ActivityName=s;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout parentrl, expandedrl, rl;
        ImageView downArrow, upArrow, img;
        CardView cv;
        TextView bookname, author, pages, description;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDelete=itemView.findViewById(R.id.btnDelete);
            parentrl = itemView.findViewById(R.id.parentrl);
            expandedrl = itemView.findViewById(R.id.exprl);
            rl = itemView.findViewById(R.id.cvrl);
            downArrow = itemView.findViewById(R.id.downarrow);
            upArrow = itemView.findViewById(R.id.uparrow);
            author = itemView.findViewById(R.id.author);
            pages = itemView.findViewById(R.id.pages);
            description = itemView.findViewById(R.id.description);
            cv = itemView.findViewById(R.id.cvbookitem);
            img = itemView.findViewById(R.id.img);
            bookname = itemView.findViewById(R.id.bookname);
            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    book b = books.get(getAdapterPosition());
                    b.setExpanded(!b.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    book b = books.get(getAdapterPosition());
                    b.setExpanded(!b.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvbookitem, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder :Started");
        holder.bookname.setText(books.get(position).getName());
        Glide.with(contxt).asBitmap().load(books.get(position).getImgurl()).into(holder.img);
        holder.author.setText(books.get(position).getAuthor());
        holder.pages.setText(Integer.toString(books.get(position).getPages()));
        holder.description.setText(books.get(position).getDescription());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent=new Intent(contxt,MainBook.class) ;
             intent.putExtra("buksid",books.get(position).getId());
             contxt.startActivity(intent);

            }
        });

        if (books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.cv);

            holder.expandedrl.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
            if(ActivityName.equals("SeeAllBooksActivity")){
               holder.btnDelete.setVisibility(View.GONE);
            }
            else if(ActivityName.toString().equals("Cur")){
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alertdialogue=new AlertDialog.Builder(contxt);
                        alertdialogue.setMessage("Are you Sure to Delete "+books.get(position).getName()+" ?");
                        alertdialogue.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().RemovefromCurrentList(books.get(position))){
                                    Toast.makeText(contxt, "Book Removed !", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                       alertdialogue.setNegativeButton("no", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {

                           }
                       })  ;
                       alertdialogue.create().show();
                    }
                });
            }
            else if(ActivityName.toString().equals("Wis")){
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alertdialogue=new AlertDialog.Builder(contxt);
                        alertdialogue.setMessage("Are you Sure to Delete "+books.get(position).getName()+" ?");
                        alertdialogue.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().RemovefromWishlist(books.get(position))){
                                    Toast.makeText(contxt, "Book Removed !", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        alertdialogue.setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })  ;
                        alertdialogue.create().show();
                    }
                });
            }
            else if(ActivityName.toString().equals("Al")){
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alertdialogue=new AlertDialog.Builder(contxt);
                        alertdialogue.setMessage("Are you Sure to Delete "+books.get(position).getName()+" ?");
                        alertdialogue.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().RemovefromAlreadyList(books.get(position))){
                                    Toast.makeText(contxt, "Book Removed !", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        alertdialogue.setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })  ;
                        alertdialogue.create().show();
                    }
                });
            }
            else if(ActivityName.toString().equals("FavActivity")){
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alertdialogue=new AlertDialog.Builder(contxt);
                        alertdialogue.setMessage("Are you Sure to Delete "+books.get(position).getName()+" ?");
                        alertdialogue.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().RemovefromFavList(books.get(position))){
                                    Toast.makeText(contxt, "Book Removed !", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        alertdialogue.setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })  ;
                        alertdialogue.create().show();
                    }
                });
            }
        } else {
            TransitionManager.beginDelayedTransition(holder.cv);

            holder.expandedrl.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<book> books) {
        this.books = books;
        notifyDataSetChanged();
    }
}
