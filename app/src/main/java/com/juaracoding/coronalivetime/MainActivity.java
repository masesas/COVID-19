package com.juaracoding.coronalivetime;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.juaracoding.coronalivetime.UI.DataDunia;
import com.juaracoding.coronalivetime.UI.DataIndonesia;
import com.juaracoding.coronalivetime.UI.DataProvinsi;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private SpaceNavigationView spaceNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);

        customBotNav();
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                loadFragment(new DataIndonesia());
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemName){
                    case "Data Dunia":
                            loadFragment(new DataDunia());
                        break;
                    case "Data Provinsi":
                        loadFragment(new DataProvinsi());
                        break;
                }
            }
            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });
    }

    public void customBotNav(){
        spaceNavigationView.addSpaceItem(new SpaceItem("Data Dunia", R.drawable.ic_flag));
        spaceNavigationView.addSpaceItem(new SpaceItem("Data Provinsi", R.drawable.ic_history));
        spaceNavigationView.shouldShowFullBadgeText(true);
        spaceNavigationView.setCentreButtonIconColorFilterEnabled(false);
        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_public);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
