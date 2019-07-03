package com.softbd.googleplaystoreclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softbd.googleplaystoreclone.model.InstalledAppModel;

import java.util.List;

public class InstalledAppAdapter extends RecyclerView.Adapter<InstalledAppAdapter.AppViewHolder> {

    private List<InstalledAppModel> appList;
    private Context context;

    public InstalledAppAdapter(List<InstalledAppModel> appList, Context context) {
        this.appList = appList;
        this.context = context;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_installes_app, null);

        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder appViewHolder, int i) {
        InstalledAppModel modelData = appList.get(i);
        appViewHolder.app_icon.setImageDrawable(modelData.getIcon());
        appViewHolder.list_app_name.setText(modelData.getName());
        appViewHolder.app_package.setText(modelData.getPackages());


    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder {
        private ImageView app_icon;
        private TextView list_app_name;
        private TextView app_package;


        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            app_icon = itemView.findViewById(R.id.app_icon);
            list_app_name = itemView.findViewById(R.id.list_app_name);
            app_package = itemView.findViewById(R.id.app_package);
        }
    }

}
