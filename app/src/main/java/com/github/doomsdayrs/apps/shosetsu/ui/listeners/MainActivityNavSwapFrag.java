package com.github.doomsdayrs.apps.shosetsu.ui.listeners;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.MenuItem;

import com.github.doomsdayrs.apps.shosetsu.MainActivity;
import com.github.doomsdayrs.apps.shosetsu.R;

/**
 * This file is part of Shosetsu.
 * Shosetsu is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Shosetsu.  If not, see https://www.gnu.org/licenses/ .
 * ====================================================================
 * Shosetsu
 * 18 / 06 / 2019
 *
 * @author github.com/doomsdayrs
 */
public class MainActivityNavSwapFrag implements NavigationView.OnNavigationItemSelectedListener {

    private MainActivity mainActivity;

    public MainActivityNavSwapFrag(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        mainActivity.navigationView.setCheckedItem(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.nav_library: {
                Log.e("Nav", "Library selected");
                mainActivity.getSupportFragmentManager().beginTransaction()
                        .addToBackStack("tag")
                        .replace(R.id.fragment_container, mainActivity.libraryFragment)
                        .commit();
            }
            break;
            case R.id.nav_catalogue: {
                Log.e("Nav", "Catalogue selected");
                mainActivity.getSupportFragmentManager().beginTransaction()
                        .addToBackStack("tag")
                        .replace(R.id.fragment_container, mainActivity.cataloguesFragment)
                        .commit();
            }
            break;
            case R.id.nav_settings: {
                Log.e("Nav", "Settings selected");
                mainActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("tag")
                        .replace(R.id.fragment_container, mainActivity.settingsFragment)
                        .commit();
            }
            break;
        }
        mainActivity.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}