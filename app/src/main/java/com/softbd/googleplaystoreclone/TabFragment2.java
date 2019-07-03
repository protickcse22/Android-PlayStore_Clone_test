package com.softbd.googleplaystoreclone;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softbd.googleplaystoreclone.model.InstalledAppModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {
    Context context;
    private RecyclerView installedAppRV;
    private InstalledAppAdapter adapter;
    private List<InstalledAppModel> appList;
    private View view;

    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = container.getContext();
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        installedAppRV = view.findViewById(R.id.installedAppRV);
        appList = getInstalledApps();
        adapter = new InstalledAppAdapter(appList, context);
        installedAppRV.setAdapter(adapter);
        return view;
    }

    private List<InstalledAppModel> getInstalledApps() {
        PackageManager pm = getActivity().getPackageManager();
        List<InstalledAppModel> apps = new ArrayList<>();
        List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);
        //List<PackageInfo> packs = getPackageManager().getInstalledPackages(PackageManager.GET_PERMISSIONS);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            String appName = p.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
            Drawable icon = p.applicationInfo.loadIcon(getActivity().getPackageManager());
            String packages = p.applicationInfo.packageName;
            apps.add(new InstalledAppModel(appName, icon, packages));
        }
        return apps;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

}
