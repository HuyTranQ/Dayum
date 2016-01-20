package huytranq.dayum.views.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import huytranq.dayum.R;
import huytranq.dayum.views.adapters.AccessAdapter;

public class AccessActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AccessAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        initialize();
    }

    private void initialize() {
        viewPager = (ViewPager) findViewById(R.id.activity_access_viewPager);
        tabLayout = (TabLayout) findViewById(R.id.activity_access_tabLayout);

        setup();
    }

    private void setup() {
        adapter = new AccessAdapter(this , getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
