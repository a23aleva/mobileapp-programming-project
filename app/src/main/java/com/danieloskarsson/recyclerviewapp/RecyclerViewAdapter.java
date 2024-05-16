package com.danieloskarsson.recyclerviewapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.Berry;
import com.example.project.R;
import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Berry> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Berry> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getName());
        holder.title2.setText(items.get(position).getCompany());
        holder.title3.setText(items.get(position).getLocation());
        holder.title4.setText(items.get(position).getCategory());
        String imageUrl = items.get(position).getAuxData();
        if (!imageUrl.isEmpty()) {
            Picasso.with(this.context)
                    .load(items.get(position).getAuxData())
                    .into(holder.title5);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView title2;
        TextView title3;
        TextView title4;
        ImageView title5;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.berryName);
            title2 = itemView.findViewById(R.id.berryLatin);
            title3 = itemView.findViewById(R.id.berryColor);
            title4 = itemView.findViewById(R.id.berryGenus);
            title5 = itemView.findViewById(R.id.ImageViewer);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }

    public void updateData (List<Berry> newBerryList) {
        Log.d("T", "TEST");
        items.clear();
        items.addAll(newBerryList);
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onClick(Berry item);
    }
}
