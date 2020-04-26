package com.example.drugbank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.drugbank.screens.SearchActivity;
import com.example.drugbank.controllers.BottomNavBehavior;
import com.example.drugbank.fragments.AccountFragment;
import com.example.drugbank.fragments.HomeFragment;
import com.example.drugbank.fragments.CategoryFragment;
import com.example.drugbank.fragments.PillFragment;
import com.example.drugbank.models.Account;
import com.example.drugbank.models.ItemSlider;
import com.example.drugbank.models.Pill;
import com.example.drugbank.screens.DetailsPillActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    BottomNavigationView bottom_nav;
    FrameLayout layout_view;
    TextView tvNameBar;
    ImageView imgSearch;

    @NonNull
    public static List<Account> accountList = new ArrayList<>();
    @NonNull
    public static List<ItemSlider> NOTIFICATION_LIST = new ArrayList<>();
    @NonNull
    public static List<Pill> pillList = new ArrayList<>();
    @NonNull
    public static List<Pill> pillListEdit = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));// set status background white
        }
        initView();
        loadFragment(new HomeFragment());
        AddListenerBottomNav();
    }

    private void AddListenerBottomNav() {
        bottom_nav.setOnNavigationItemSelectedListener(this);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottom_nav.getLayoutParams();
        layoutParams.setBehavior(new BottomNavBehavior());
    }

    private void initView() {
        bottom_nav = findViewById(R.id.bottom_nav);
        layout_view = findViewById(R.id.addFragment);
        tvNameBar = findViewById(R.id.tvNameBar);
        imgSearch = findViewById(R.id.imgSearch);
        imgSearch.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_home:
                tvNameBar.setText("Trang chủ");
                imgSearch.setVisibility(View.VISIBLE);
                loadFragment(new HomeFragment());
                return true;
            case R.id.action_pill:
                imgSearch.setVisibility(View.GONE);
                tvNameBar.setText("Danh sách thuốc");
                loadFragment(new PillFragment());
                return true;
            case R.id.action_menu:
                tvNameBar.setText("Danh mục");
                imgSearch.setVisibility(View.VISIBLE);
                loadFragment(new CategoryFragment());
                return true;
            case R.id.action_account:
                tvNameBar.setText("Tài khoản");
                imgSearch.setVisibility(View.VISIBLE);
                loadFragment(new AccountFragment());
                return true;
        }
        return false;
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.addFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(@NonNull View v) {
       if(v.getId() == R.id.imgSearch) {
           startActivity(new Intent(getApplicationContext(), SearchActivity.class));
       }
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent i=new Intent(Intent.ACTION_MAIN);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click thêm lần nữa để thoát ứng dụng", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
