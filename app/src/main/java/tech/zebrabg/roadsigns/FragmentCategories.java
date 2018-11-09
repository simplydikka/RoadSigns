package tech.zebrabg.roadsigns;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategories extends Fragment {

    View v;
    private RecyclerView mRecyclerView;
    private CategoriesRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemTemplateCategories> mCategoryItemsList;

    public FragmentCategories() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_categories, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.categories_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new CategoriesRecyclerViewAdapter(getContext(), mCategoryItemsList);
        mAdapter.setOnItemClickListener(new CategoriesRecyclerViewAdapter.OnItemClickListener() {

                                            @Override
                                            public void onItemClick(int position) {
                                                if(position ==0){
                                                    Intent Intent = new Intent(getActivity(), AllCardsGroupA.class);
                                                    startActivity(Intent);


                                                }
                                                if(position ==1){
                                                    Intent intent = new Intent (getActivity(), something.class);
                                                    startActivity(intent);

                                                }
                                            }
                                        }

        );


        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createCategoryItemsLIst();

    }

    public void createCategoryItemsLIst() {

        mCategoryItemsList = new ArrayList<>();
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_a_title), getString(R.string.group_a_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_b_title), getString(R.string.group_b_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_v_title), getString(R.string.group_v_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_g_title), getString(R.string.group_g_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_d_title), getString(R.string.group_d_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_e_title), getString(R.string.group_e_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_j_title), getString(R.string.group_j_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_t_title), getString(R.string.group_t_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_o_title), getString(R.string.group_o_description)));
        mCategoryItemsList.add(new ItemTemplateCategories(R.drawable.signa1, getString(R.string.group_r_title), getString(R.string.group_r_description)));

    }

}
