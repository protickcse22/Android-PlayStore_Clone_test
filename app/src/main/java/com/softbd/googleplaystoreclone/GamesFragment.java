package com.softbd.googleplaystoreclone;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softbd.googleplaystoreclone.model.ModelData;

import java.util.ArrayList;
import java.util.List;

public class GamesFragment extends Fragment {
    private List<ModelData> dataList;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private Context mContext;


    public GamesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games2, container, false);

        mRecyclerView = view.findViewById(R.id.gamesRV);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL, false));
        dataList = new ArrayList<>();
        mContext = container.getContext();

        dataList.add(new ModelData(R.drawable.image1, "Games 1", "123 MB"));
        dataList.add(new ModelData(R.drawable.image2, "Games 2", "123 MB"));
        dataList.add(new ModelData(R.drawable.image3, "Games 3", "123 MB"));
        dataList.add(new ModelData(R.drawable.image4, "Games 4", "123 MB"));
        dataList.add(new ModelData(R.drawable.image1, "Games 1", "123 MB"));
        dataList.add(new ModelData(R.drawable.image2, "Games 2", "123 MB"));
        dataList.add(new ModelData(R.drawable.image3, "Games 3", "123 MB"));
        dataList.add(new ModelData(R.drawable.image4, "Games 4", "123 MB"));
        dataList.add(new ModelData(R.drawable.image1, "Games 1", "123 MB"));
        dataList.add(new ModelData(R.drawable.image2, "Games 2", "123 MB"));
        dataList.add(new ModelData(R.drawable.image3, "Games 3", "123 MB"));
        dataList.add(new ModelData(R.drawable.image4, "Games 4", "123 MB"));

        adapter = new MyRecyclerViewAdapter(mContext, (ArrayList<ModelData>) dataList);
        mRecyclerView.setAdapter(adapter);

        return view;
    }
}
