package tech.zebrabg.roadsigns;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class HomeScreenTabs extends AppCompatActivity {

   private TabLayout tabLayout;
   private ViewPager viewPager;
   private HomeScreenPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_tabs);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        adapter = new HomeScreenPagerAdapter(getSupportFragmentManager());

        //Add Fragment Here

        adapter.AddFragment(new FragmentCategories(), "Категории");
        adapter.AddFragment(new FragmentFavorites(), "Запазени");
        adapter.AddFragment(new FragmentAll(), "Всички");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }


}