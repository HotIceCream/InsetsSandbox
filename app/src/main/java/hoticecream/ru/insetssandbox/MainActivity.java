package hoticecream.ru.insetssandbox;

import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewParent {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
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
    public void initTabLayout(ViewPager viewpager) {
        tabLayout.setVisibility(viewpager == null ? View.GONE : View.VISIBLE);
        tabLayout.setupWithViewPager(viewpager);
    }


}
