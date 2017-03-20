package com.juwan.jzalgorithms.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juwan.jzalgorithms.R;
import com.juwan.jzalgorithms.databinding.ItemAlgorithmsListBinding;
import com.juwan.jzalgorithms.model.Algorithm;

import java.util.ArrayList;

/**
 * Created by javan on 17-3-20.
 */
public class AlgorithmsListAdapter extends RecyclerView.Adapter<AlgorithmsListAdapter.AlgorithmsViewHolder> {
    private Context mContext;

    private ArrayList<Algorithm> mAlgorithmses;

    public AlgorithmsListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void replaceContent(ArrayList<Algorithm> algorithmses) {
        mAlgorithmses = algorithmses;
        notifyDataSetChanged();
    }

    @Override
    public AlgorithmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlgorithmsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_algorithms_list, parent, false));
    }

    @Override
    public void onBindViewHolder(AlgorithmsViewHolder holder, int position) {
        holder.mItemAlgorithmsListBinding.setAlgorithm(mAlgorithmses.get(position));
        holder.mItemAlgorithmsListBinding.setAlgorithmViewHolder(holder);
        holder.mItemAlgorithmsListBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mAlgorithmses != null ? mAlgorithmses.size() : 0;
    }

    public class AlgorithmsViewHolder extends RecyclerView.ViewHolder {
        public ItemAlgorithmsListBinding mItemAlgorithmsListBinding;

        public AlgorithmsViewHolder(View itemView) {
            super(itemView);
            mItemAlgorithmsListBinding = DataBindingUtil.bind(itemView);
        }

        public void onItemClicked(View itemView) {
            Toast.makeText(mContext, mAlgorithmses.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
