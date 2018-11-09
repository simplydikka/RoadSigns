package tech.zebrabg.roadsigns;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class HomeScreenTabs extends AppCompatActivity {

    private static final String TAG = "homeScreen";

    private HomeScreenTabsAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_tabs);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new HomeScreenTabsAdapter(getSupportFragmentManager());
        //Set up the ViewPager with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        //creates a tab layout object and sets the id to tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    //creates a sections pager adapter and adds the fragments to the sections pager adapter and give them titles (like you're adding items to a list)
    private void setupViewPager(ViewPager viewPager) {
        HomeScreenTabsAdapter adapter = new HomeScreenTabsAdapter(getSupportFragmentManager());
        //adapter.addFragment(new Tab1Categories(), "Категории");
        //adapter.addFragment(new Tab2Favorites(), "Запазени");
       // adapter.addFragment(new Tab3All(), "Всички");
        //viewPager.setAdapter(adapter);


    }

}