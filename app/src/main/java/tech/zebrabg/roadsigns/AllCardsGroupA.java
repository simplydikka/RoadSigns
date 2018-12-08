package tech.zebrabg.roadsigns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class AllCardsGroupA extends AppCompatActivity {
    private ArrayList<ItemTemplateAllCardsGroupA> mExampleList;


    private RecyclerView mRecyclerView;
    private ItemTemplateAllCardsGroupAadapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cards_group_a);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// TODO: Add adView to your view hierarchy.

        createExampleList();
        buildRecyclerView();
    }

    public void createExampleList() {

//        mExampleList = new ArrayList<>();
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A1_title), getString(R.string.A1_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A2_title), getString(R.string.A2_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A3_title), getString(R.string.A3_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A4_title), getString(R.string.A4_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A5_title), getString(R.string.A5_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A6_title), getString(R.string.A6_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A7_title), getString(R.string.A7_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A8_title), getString(R.string.A8_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A9_title), getString(R.string.A9_description)));
//        mExampleList.add(new ItemTemplateAllCardsGroupA(R.drawable.signa1, getString(R.string.A10_title), getString(R.string.A10_description)));

        mExampleList = DataCollection.getData(this);
    }

    public void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemTemplateAllCardsGroupAadapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

//        mAdapter.setOnItemClickListener(new ItemTemplateAllCardsGroupAadapter.OnItemClickListener() {
//
//                                            @Override
//                                            public void onItemClick(int position) {
//                                                if(position ==0){
//                                                    Intent Intent = new Intent(AllCardsGroupA.this, HomeScreenTabs.class);
//                                                    startActivity(Intent);
//
//
//                                                }
//                                                if(position ==1){
//                                                    Intent intent = new Intent (AllCardsGroupA.this, something.class);
//                                                    startActivity(intent);
//
//                                                }
//                                                //SETS ITEM CLICK TO LEAD TO A SPECIFIC TAB OF TABBED ACTIVITY
//                                                if(position ==2){
//                                                    int page = 1;
//                                                    Intent intent = new Intent (AllCardsGroupA.this, HomeScreenTabs.class);
//                                                    intent.putExtra("One", page);// One is your argument
//                                                    startActivity(intent);
//
//
//                                                }
//                                            }
//                                        }
//
//        );

        mAdapter.setOnItemClickListener(new ItemTemplateAllCardsGroupAadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(AllCardsGroupA.this, SingleCardGroupA.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
    @Override

    public void onBackPressed()
    {
        Intent intent=new Intent(AllCardsGroupA.this,HomeScreenTabs.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String s) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               mAdapter.getFilter().filter(newText);
               return false;
           }
       });
        return true;

    }
}