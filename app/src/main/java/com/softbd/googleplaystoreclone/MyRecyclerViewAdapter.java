package com.softbd.googleplaystoreclone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.softbd.googleplaystoreclone.model.ModelData;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ModelData> myArrayList;

    public MyRecyclerViewAdapter(Context context, ArrayList<ModelData> myArrayList) {
        this.context = context;
        this.myArrayList = myArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.games_row_item, null);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        ModelData modelData = myArrayList.get(i);
        myViewHolder.gamesIV.setImageResource(modelData.getImageId());
        myViewHolder.gamesTitleTV.setText(modelData.getTitle());
        myViewHolder.gamesSizeTV.setText(modelData.getSize());
        Log.d("Message Title", modelData.getTitle());
        Log.d("Message Size", modelData.getSize());

    }

    @Override
    public int getItemCount() {
        return myArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView gamesIV;
        private TextView gamesTitleTV, gamesSizeTV;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            gamesIV = itemView.findViewById(R.id.gamesIV);
            gamesTitleTV = itemView.findViewById(R.id.gamesTitleTV);
            gamesSizeTV = itemView.findViewById(R.id.gamesSizeTV);
            gamesIV.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ShowToast")
                @Override
                public void onClick(View v) {
                    Log.d("Test", gamesTitleTV.getText().toString());
                    Toast.makeText(itemView.getContext(), gamesTitleTV.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });

            gamesTitleTV.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ShowToast")
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), gamesTitleTV.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }


}
