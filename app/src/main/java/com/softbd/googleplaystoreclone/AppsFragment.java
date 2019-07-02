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


/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends Fragment {
    private List<ModelData> datalist;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private Context mContext;


    public AppsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apps2, container, false);
        mRecyclerView = view.findViewById(R.id.appsRV);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,false));
        datalist = new ArrayList<>();
        mContext = container.getContext();

        datalist.add(new ModelData(R.drawable.image2, "Games 1", "123 MB"));
        datalist.add(new ModelData(R.drawable.image1, "Games 2", "124 MB"));
        datalist.add(new ModelData(R.drawable.image4, "Games 3", "125 MB"));
        datalist.add(new ModelData(R.drawable.image3, "Games 4", "126 MB"));
        datalist.add(new ModelData(R.drawable.image2, "Games 1", "127 MB"));
        datalist.add(new ModelData(R.drawable.image1, "Games 2", "128 MB"));
        datalist.add(new ModelData(R.drawable.image4, "Games 3", "129 MB"));
        datalist.add(new ModelData(R.drawable.image3, "Games 4", "121 MB"));
        datalist.add(new ModelData(R.drawable.image1, "Games 1", "122 MB"));
        datalist.add(new ModelData(R.drawable.image2, "Games 2", "123 MB"));
        datalist.add(new ModelData(R.drawable.image3, "Games 3", "124 MB"));
        datalist.add(new ModelData(R.drawable.image4, "Games 4", "121 MB"));

        adapter = new MyRecyclerViewAdapter(mContext, (ArrayList<ModelData>) datalist);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

}
