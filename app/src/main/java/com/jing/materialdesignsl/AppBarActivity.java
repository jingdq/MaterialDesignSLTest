package com.jing.materialdesignsl;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AppBarActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.addTab(tablayout.newTab().setText("Tab One").setIcon(R.drawable.ic_dashboard));
        tablayout.addTab(tablayout.newTab().setText("Tab Two").setIcon(R.drawable.ic_event));
        tablayout.addTab(tablayout.newTab().setText("Tab There").setIcon(R.drawable.ic_event));


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this));

    }


    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
      Context context;
        public MyAdapter(Context cxt){

            this.context = cxt;

        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            final View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            MyHolder myHolder = (MyHolder) holder;

            ((MyHolder) holder).textview.setText("fasdfsafsafewrf");



        }

        @Override
        public int getItemCount() {
            return 15;
        }


        public class MyHolder extends RecyclerView.ViewHolder {

            TextView textview;

            public MyHolder(View itemView) {
                super(itemView);
                textview = (TextView) itemView.findViewById(R.id.textview);
            }
        }

    }

}
