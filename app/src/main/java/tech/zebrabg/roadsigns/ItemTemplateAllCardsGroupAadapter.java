package tech.zebrabg.roadsigns;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemTemplateAllCardsGroupAadapter extends RecyclerView.Adapter<ItemTemplateAllCardsGroupAadapter.ItemTemplateAllCardsGroupAViewHolder> implements Filterable {

    private ArrayList<ItemTemplateAllCardsGroupA> mExampleList;
    private List<ItemTemplateAllCardsGroupA> mExampleListFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ItemTemplateAllCardsGroupAViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextTitle;
        public TextView mTextDescription;





        public ItemTemplateAllCardsGroupAViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageSignAllGroupA);
            mTextTitle = itemView.findViewById(R.id.signNameAllGroupA);
            mTextDescription = itemView.findViewById(R.id.signDescriptionAllGroupA);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);

                        }
                    }
                }
            });
        }
    }

    public ItemTemplateAllCardsGroupAadapter(ArrayList<ItemTemplateAllCardsGroupA> exampleList){

        mExampleList = exampleList;
        mExampleListFull = new ArrayList<>(exampleList);
    }
    @NonNull
    @Override
    public ItemTemplateAllCardsGroupAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template_all_cards_group_a,parent, false);
        ItemTemplateAllCardsGroupAViewHolder evh = new ItemTemplateAllCardsGroupAViewHolder(v, mListener);
            return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTemplateAllCardsGroupAViewHolder holder, int position) {
            ItemTemplateAllCardsGroupA currentItem = mExampleList.get(position);
            holder.mImageView.setImageResource(currentItem.getImageResource());
            holder.mTextTitle.setText(currentItem.getTextTitle());
            holder.mTextDescription.setText(currentItem.getmTextDescription());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public Filter getFilter(){
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemTemplateAllCardsGroupA> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(mExampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(ItemTemplateAllCardsGroupA item : mExampleListFull){
                    if (item.getTextTitle().toLowerCase().contains(filterPattern) || item.getmTextDescription().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mExampleList.clear();
            mExampleList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


}
