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

public class CategoriesModelAdapter extends RecyclerView.Adapter<CategoriesModelAdapter.ViewHolder> {

    Context context;
    List<CategoriesModel> modelList = new ArrayList<>();

    public CategoriesModelAdapter(Context context, List<CategoriesModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    public void UpdateAdapter(List<CategoriesModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categorie_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCaName.setText(modelList.get(position).getName());
        holder.tvCourseNum.setText(Integer.toString(modelList.get(position).getNumberOfCourses()));
        Glide.with(context).load(modelList.get(position).getThumbnail()).into(holder.imvTumb);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imvTumb;
        TextView tvCaName;
        TextView tvCourseNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvTumb=itemView.findViewById(R.id.imvTumb);
            tvCaName=itemView.findViewById(R.id.tvCaName);
            tvCourseNum=itemView.findViewById(R.id.tvCourseNum);
        }
    }
}
