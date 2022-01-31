package com.pranav.trogonml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class TopCourseAdapter extends RecyclerView.Adapter<TopCourseAdapter.ViewHolder> {

    Context context;
    List<TopCourse> modelList = new ArrayList<>();

    public TopCourseAdapter(Context context, List<TopCourse> modelList) {
        this.context = context;
        this.modelList = modelList;
    }
    public void UpdateAdapter(List<TopCourse> modelList){
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_course_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvClass.setText(modelList.get(position).getTitle());
        holder.tvPrice.setText(modelList.get(position).getPrice());
        Glide.with(context).load(modelList.get(position).getThumbnail()).into(holder.imvImage);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvImage;
        TextView tvClass;
        TextView tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvImage=itemView.findViewById(R.id.imvImage);
            tvClass=itemView.findViewById(R.id.tvClass);
            tvPrice=itemView.findViewById(R.id.tvPrice);

        }
    }
}
