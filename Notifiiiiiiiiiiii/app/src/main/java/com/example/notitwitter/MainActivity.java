package com.example.notitwitter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.example.notitwitter.fragment.CommunityFragment;
import com.example.notitwitter.fragment.HomeFragment;
import com.example.notitwitter.fragment.MailFragment;
import com.example.notitwitter.fragment.NotificationFragment;
import com.example.notitwitter.fragment.SearchFragment;
import com.example.notitwitter.fragment.SlashFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.graphics.PorterDuff;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Set up the ViewPager with the sections adapter
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);
        viewPager.setAdapter(sectionsPagerAdapter);

        // Disable swiping between pages
        viewPager.setUserInputEnabled(false);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setIcon(R.drawable.home);
                                break;
                            case 1:
                                tab.setIcon(R.drawable.search);
                                break;
                            case 2:
                                tab.setIcon(R.drawable.slash);
                                break;
                            case 3:
                                tab.setIcon(R.drawable.community);
                                break;
                            case 4:
                                tab.setIcon(R.drawable.notification);
                                break;
                            case 5:
                                tab.setIcon(R.drawable.mail);
                                break;
                        }
                        // Set the color filter for the icons
                        tab.view.setOnClickListener(v -> {
                            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                                TabLayout.Tab t = tabLayout.getTabAt(i);
                                if (t != null && t.getIcon() != null) {
                                    if (t == tab) {
                                        t.getIcon().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.tab_selected_icon_color), PorterDuff.Mode.SRC_IN);
                                    } else {
                                        t.getIcon().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.tab_unselected_icon_color), PorterDuff.Mode.SRC_IN);
                                    }
                                }
                            }
                        });
                    }
                }).attach();

        // Set the initial tab selection and color
        TabLayout.Tab initialTab = tabLayout.getTabAt(0);
        if (initialTab != null) {
            initialTab.select();
            if (initialTab.getIcon() != null) {
                initialTab.getIcon().setColorFilter(ContextCompat.getColor(this, R.color.tab_selected_icon_color), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    private static class SectionsPagerAdapter extends FragmentStateAdapter {
        public SectionsPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new SearchFragment();
                case 2:
                    return new SlashFragment();
                case 3:
                    return new CommunityFragment();
                case 4:
                    return new NotificationFragment();
                case 5:
                    return new MailFragment();
                default:
                    return new HomeFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 6; // Number of tabs
        }
    }
}
