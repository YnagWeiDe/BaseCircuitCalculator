package com.example.myapplication.Tool;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;
//This is the adapter class for the listview is created.
//适配器类，用于ListView的显示。
public class MyList extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<DataView > juList;
    private   Context context;
    public MyList(Context context, List<DataView > juList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.juList = juList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return juList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        KongJian kongJian ;
        if(view == null){
            view = layoutInflater.inflate(R.layout.listview_all,null);
            kongJian = new KongJian(view);
            view.setTag(kongJian);
        }else{
            kongJian = (KongJian) view.getTag();
            view.setTag(kongJian);
        }

        kongJian.text.setText(juList.get(i).getStr());
        kongJian.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(juList.get(i).getIndex());
            }
        });


        return view;
    }
    //This is the inner class for the adapter.
    public class KongJian {
        public TextView  text ;
        public Button button;
        public KongJian(View view){
            this.text =view.findViewById(R.id.tv_str);
            this.button = view.findViewById(R.id.btn_yes);
        }
    }
}

