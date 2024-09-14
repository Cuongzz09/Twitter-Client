package com.example.notitwitter.notifiiiii;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.notitwitter.fragment.CommunityFragment;
import com.example.notitwitter.fragment.HomeFragment;
import com.example.notitwitter.fragment.NotificationFragment;
import com.example.notitwitter.fragment.SearchFragment;
import com.example.notitwitter.fragment.SlashFragment;

public class NotificationViewPagerAdapter extends FragmentStatePagerAdapter {

    public NotificationViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new All();
            case 1:
                return new Verified();
            case 2:
                return new Mentions();

            default:
                return new All();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "All";
            case 1:
                return "Verified";
            case 2:
                return "Mentions";

            default:
                return "All";


        }
    }
}
