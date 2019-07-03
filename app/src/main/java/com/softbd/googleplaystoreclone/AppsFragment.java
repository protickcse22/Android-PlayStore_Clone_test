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
    static MyRecyclerViewAdapter adapter;
    private List<ModelData> datalist;
    private RecyclerView mRecyclerView;
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
                        LinearLayoutManager.HORIZONTAL, false));
        datalist = new ArrayList<>();
        mContext = container.getContext();

        datalist.add(new ModelData(R.drawable.image2, "Dolphin", "123 MB"));
        datalist.add(new ModelData(R.drawable.image1, "Firefox", "124 MB"));
        datalist.add(new ModelData(R.drawable.image4, "Opera", "125 MB"));
        datalist.add(new ModelData(R.drawable.image3, "LinkedIn", "126 MB"));
        datalist.add(new ModelData(R.drawable.image2, "Snapchat", "127 MB"));
        datalist.add(new ModelData(R.drawable.image1, "Textra", "128 MB"));
        datalist.add(new ModelData(R.drawable.image4, "Wickr Me", "129 MB"));
        datalist.add(new ModelData(R.drawable.image3, "Cookpad", "121 MB"));
        datalist.add(new ModelData(R.drawable.image1, "Seamless", "122 MB"));
        datalist.add(new ModelData(R.drawable.image2, "Untappd", "123 MB"));
        datalist.add(new ModelData(R.drawable.image3, "Yelp", "124 MB"));
        datalist.add(new ModelData(R.drawable.image4, "Clue", "121 MB"));

        adapter = new MyRecyclerViewAdapter(mContext, (ArrayList<ModelData>) datalist);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

}
