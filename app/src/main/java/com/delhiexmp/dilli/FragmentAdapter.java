package com.delhiexmp.dilli;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

        public FragmentAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            switch (position){
                case 0:
                    return new Historical_Fragment();
                case 1:
                    return new AmusementFragment();
                case 2:
                    return new ShoppingFragment();
                case 3:
                    return new FoodFragment();
                default: return null;
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }

}
