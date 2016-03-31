package com.nutstudio.nutslab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerFragment extends Fragment {
    @Bind(R.id.recycler)
    RecyclerView recyclerView;
    private View rootView;
    private RecyclerAdapter mAdapter;
    private ArrayList<Map<String, Object>> dataSet = new ArrayList<Map<String, Object>>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initRecyclerView();
        recyclerView.setNestedScrollingEnabled(true);
        return rootView;
    }

    private void initView() {
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecyclerAdapter(getActivity(), getData());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickLitener(new RecyclerAdapter.OnItemClickCall() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                mAdapter.removeItem(position);
                Toast.makeText(getActivity(), position + "long_click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Map<String, Object>> getData() {
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("item_img", "https://www.baidu.com/img/bd_logo1.png");
            map.put("item_text", "picture" + i);
            dataSet.add(map);
        }
        return dataSet;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
