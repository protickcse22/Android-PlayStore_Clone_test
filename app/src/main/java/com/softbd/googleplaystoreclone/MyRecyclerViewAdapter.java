package com.softbd.googleplaystoreclone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.softbd.googleplaystoreclone.model.ModelData;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private ArrayList<ModelData> myArrayList;
    private ArrayList<ModelData> myArrayListFull;
    private Filter listFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<ModelData> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(myArrayListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ModelData item : myArrayListFull) {
                    if (item.getTitle().toLowerCase().trim().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            myArrayList.clear();
            myArrayList.addAll((ArrayList) results.values);
            notifyDataSetChanged();

        }
    };

    public MyRecyclerViewAdapter(Context context, ArrayList<ModelData> myArrayList) {
        this.context = context;
        this.myArrayList = myArrayList;
        myArrayListFull = new ArrayList<>(this.myArrayList);
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

    @Override
    public Filter getFilter() {
        return listFilter;
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




