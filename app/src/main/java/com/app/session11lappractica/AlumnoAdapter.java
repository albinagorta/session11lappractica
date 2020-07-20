package com.app.session11lappractica;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.app.session11lappractica.R;
import java.util.ArrayList;

public class AlumnoAdapter extends BaseAdapter {
    ArrayList<Alumno> mDataSet;
    Activity activity;

    public AlumnoAdapter(ArrayList<Alumno> mDataSet, Activity activity) {
        this.mDataSet = mDataSet;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View v=view;
        if(v==null){
            v=activity.getLayoutInflater().inflate(R.layout.item,null);
        }

        Alumno p=mDataSet.get(i);
        TextView id,pat,mat,nom;
        id= v.findViewById(R.id.txvid);
        pat=v.findViewById(R.id.txvpat);
        mat=v.findViewById(R.id.txvmat);
        nom=v.findViewById(R.id.txvnom);
        id.setText(p.getId());
        pat.setText(p.getPat());
        mat.setText(p.getMat());
        nom.setText(p.getNom());
        return v;
    }
}
