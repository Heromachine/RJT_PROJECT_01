package com.example.jessi.rjt_project_01.ui.main.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.ui.main.uicategories.View_Categories;
import com.example.jessi.rjt_project_01.ui.main.uiproductlist.ViewMainActivityProductList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener, IMainActivity{

    ViewPager viewPager;
    TabLayout tabLayout;

    TextView viewAllCategory;
    IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iPresenter= new PresenterMain();
        viewAllCategory = findViewById(R.id.tv_viewallcat);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.mainTabLayout);
        viewPager = findViewById(R.id.mainpager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_shopbag));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_clothes));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_electronics));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_fashion));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_homeappliance));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_jewlry));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_mobile));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_personalcare));
        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);

        tabLayout.setOnTabSelectedListener(this);


        PagerMain myPager = new PagerMain
                (
                        getSupportFragmentManager(),
                        tabLayout.getTabCount()
                );

        viewPager.setAdapter(myPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //actionBar.setSelectedNavigationItem(postion);
                tabLayout.setScrollPosition(position,0,true);
                tabLayout.setSelected(true);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.groupcategory) {
            Intent i = new Intent(this, View_Categories.class);
            this.startActivity(i);
        } else if (id == R.id.nav_productlist) {
            Intent i = new Intent(this, ViewMainActivityProductList.class);
            this.startActivity(i);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void clickHandler(View view){

        iPresenter.iPresenter_OnButtonClicked(view, this);

    }

}
