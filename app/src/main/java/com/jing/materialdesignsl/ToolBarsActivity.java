package com.jing.materialdesignsl;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ToolBarsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bars);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        setTitle("Collapsing Toolbar");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this));

    }


    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;

        public MyAdapter(Context cxt) {

            this.context = cxt;

        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            final View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            MyHolder myHolder = (MyHolder) holder;

            ((MyHolder) holder).textview.setText("As shown in the code below, our recycler view uses the layout_behavior attribute in-order to allow the RecyclerView to work with our Coordinator layout. This means that the layout is able to react to the RecyclerViews scroll events. The code also shows that the Toolbar has its layout_scrollFlags attribute set, meaning that when the RecyclerView is scrolled, its scroll events are captured and our ToolBar will slide out of view. However, we haven’t declared this attribute for our TabLayout, so this will remain pinned at the top of the screen");


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
