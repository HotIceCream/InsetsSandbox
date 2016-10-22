package hoticecream.ru.insetssandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vitalan69 on 10/23/16.
 */

public class SecondFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AppBarLayout appBarLayout = (AppBarLayout) inflater.inflate(R.layout.toolbar_second, container, false);
        getViewParent().replaceAppBar(appBarLayout);
        getViewParent().setSupportActionBar((Toolbar) appBarLayout.findViewById(R.id.toolbar));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public MainViewParent getViewParent() {
        return (MainViewParent) getActivity();
    }
}
