package hoticecream.ru.insetssandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vitalan69 on 10/22/16.
 */

public class FirstFragment extends Fragment {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ToolbarHolder toolbarHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        viewpager.setAdapter(new FirstPagerAdapter(getChildFragmentManager()));
        toolbarHolder = new ToolbarHolder(inflater.inflate(R.layout.toolbar_first, container, false));
        toolbarHolder.tabLayout.setupWithViewPager(viewpager);
        getViewParent().replaceAppBar(toolbarHolder.appBarLayout);
        getViewParent().setSupportActionBar(toolbarHolder.toolbar);
        return view;
    }

    public MainViewParent getViewParent() {
        return (MainViewParent) getActivity();
    }

    public static class ToolbarHolder {
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.tab_layout)
        TabLayout tabLayout;
        AppBarLayout appBarLayout;

        public ToolbarHolder(View view) {
            appBarLayout = (AppBarLayout) view;
            ButterKnife.bind(this, view);
        }
    }

    private static class FirstPagerAdapter extends FragmentStatePagerAdapter {
        public FirstPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            return new FirstLeftFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Title";
        }
    }
}
