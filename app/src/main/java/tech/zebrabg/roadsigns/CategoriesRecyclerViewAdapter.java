package tech.zebrabg.roadsigns;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesViewHolder> {

    Context mContext;
    private List<ItemTemplateCategories> mCategoryItemsList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public CategoriesRecyclerViewAdapter(Context mContext, List<ItemTemplateCategories> mCategoryItemsList) {
        this.mContext = mContext;
        this.mCategoryItemsList = mCategoryItemsList;
    }


    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_template_categories, parent, false);
        CategoriesViewHolder vHolder = new CategoriesViewHolder(v, mListener);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        holder.imageView.setImageResource(mCategoryItemsList.get(position).getCategoryCardImage());
        holder.textTitle.setText(mCategoryItemsList.get(position).getCategoryTextTitle());
        holder.textDescription.setText(mCategoryItemsList.get(position).getCategoryTextDescription());
    }

    @Override
    public int getItemCount() {
        return mCategoryItemsList.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textTitle;
        public TextView textDescription;

        public CategoriesViewHolder (View itemView, final OnItemClickListener listener){
            super(itemView);
            imageView = itemView.findViewById(R.id.cardImage);
            textTitle = itemView.findViewById(R.id.cardTitle);
            textDescription = itemView.findViewById(R.id.cardDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
        }



    }


