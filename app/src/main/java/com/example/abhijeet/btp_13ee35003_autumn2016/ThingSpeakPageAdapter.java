package com.example.abhijeet.btp_13ee35003_autumn2016;

/**
 * Created by ABHIJEET on 03-12-2016.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link ThingSpeakPageAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each  item based on a ThingSpeak channel
 */
public class ThingSpeakPageAdapter extends FragmentPagerAdapter{

    /**
     * Context of the app
     */
    private Context mContext;

    private int mChannelId ;
    /**
     * Create a new {@link ThingSpeakPageAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public ThingSpeakPageAdapter( Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TemperatureFragment();
        }else if (position == 1){
            return new HumidityFragment();
        }else if (position == 2){
            return new OzoneFragment();
        }else if (position == 3){
            return new CO2Fragment();
        }else if (position == 4){
            return new NOxFragment();
        }else if (position == 5){
            return new SO2Fragment();
        }else if (position == 6){
            return new PM10Fragment();
        }
        else {
            return new PM2Fragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.plot_temperature);
        } else if (position == 1){
            return mContext.getString(R.string.plot_humidity);
        }else if (position == 2){
            return mContext.getString(R.string.plot_ozone);
        }else if (position == 3){
            return mContext.getString(R.string.plot_co2);
        }else if (position == 4){
            return mContext.getString(R.string.plot_nox);
        }else if (position == 5){
            return mContext.getString(R.string.plot_so2);
        }else if (position == 6){
            return mContext.getString(R.string.plot_pm10);
        }else{
            return mContext.getString(R.string.plot_pm2);
        }
    }
}
