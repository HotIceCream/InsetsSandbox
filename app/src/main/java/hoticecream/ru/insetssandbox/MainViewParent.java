package hoticecream.ru.insetssandbox;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

/**
 * Created by vitalan69 on 10/22/16.
 */

public interface MainViewParent {
    void initTabLayout(ViewPager viewpager);

    void setSupportActionBar(Toolbar toolbar);

    void replaceAppBar(AppBarLayout appBarLayout);
}
