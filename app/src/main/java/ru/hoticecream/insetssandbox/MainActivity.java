package ru.hoticecream.insetssandbox;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewParent {

    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;
    @BindView(R.id.activity_main)
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_first:
                        showFirst();
                        break;
                    case R.id.tab_second:
                        showSecond();
                        break;

                }
            }
        });

    }

    private void showSecond() {
        initTabLayout(null);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SecondFragment())
                .commit();
    }

    private void showFirst() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FirstFragment())
                .commit();
    }

    @Override
    public void replaceAppBar(AppBarLayout appBarLayout) {
        for (int i=0; i< layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            if (view instanceof AppBarLayout) {
                layout.removeView(view);
            }
        }
        layout.addView(appBarLayout);
        ViewCompat.requestApplyInsets(appBarLayout);
    }

    @Override
    public void initTabLayout(ViewPager viewpager) {
//        tabLayout.setVisibility(viewpager == null ? View.GONE : View.VISIBLE);
//        tabLayout.setupWithViewPager(viewpager);
    }


}
