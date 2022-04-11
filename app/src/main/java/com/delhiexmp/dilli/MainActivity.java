package com.delhiexmp.dilli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager2 = (ViewPager2) findViewById(R.id.viewPagerMain);
        viewPager2.setAdapter(new FragmentAdapter(this));
        settingUpFragments();

        // Setting up fade to exclude bottom navigation bar from animation
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        Toast.makeText(this, "Click on a card to explore more...", Toast.LENGTH_LONG).show();

    }

    private void settingUpFragments(){

        tabLayout.addTab(tabLayout.newTab().setText("Historic"));
        tabLayout.addTab(tabLayout.newTab().setText("Amusement"));
        tabLayout.addTab(tabLayout.newTab().setText("Shopping"));
        tabLayout.addTab(tabLayout.newTab().setText("Food"));

        TabLayoutMediator layoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Monuments");
                        tab.setIcon(R.drawable.monumentslogo);
                        break;
                    case 1:
                        tab.setText("Amusement");
                        tab.setIcon(R.drawable.ferrislogo);
                        break;
                    case 2:
                        tab.setText("Shopping");
                        tab.setIcon(R.drawable.shoppinglogo);
                        break;
                    case 3:
                        tab.setText("Food|Clubs");
                        tab.setIcon(R.drawable.foodlogo);

                        break;
                }

            }
        });
        layoutMediator.attach();
    }
}