package ru.hoticecream.insetssandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vitalan69 on 10/22/16.
 */

public class FirstLeftFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_left, container, false);
        ButterKnife.bind(this, view);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new SampleAdapter());
        return view;
    }

    public static class SampleAdapter extends RecyclerView.Adapter<SampleHolder> {

        private List<Object> items = Arrays.asList(new Object(), new Object(), new Object(), new Object(), new Object(), new Object(), new Object(), new Object());

        @Override
        public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SampleHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_sample, parent, false));
        }

        @Override
        public void onBindViewHolder(SampleHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    public static class SampleHolder extends RecyclerView.ViewHolder {

        public SampleHolder(View itemView) {
            super(itemView);
        }
    }
}
