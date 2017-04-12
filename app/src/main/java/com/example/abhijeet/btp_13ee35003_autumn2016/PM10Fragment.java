package com.example.abhijeet.btp_13ee35003_autumn2016;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.macroyau.thingspeakandroid.ThingSpeakChannel;
import com.macroyau.thingspeakandroid.ThingSpeakLineChart;
import com.macroyau.thingspeakandroid.model.ChannelFeed;

import java.util.Calendar;
import java.util.Date;

import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PM10Fragment extends Fragment {

    private ThingSpeakChannel tsChannel;
    private ThingSpeakLineChart tsChart;
    private LineChartView chartView;

    int field_id = 7 ;

    public PM10Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thing_speak_plot, container, false);
        /**  Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

        ThingSpeakActivity activity = (ThingSpeakActivity) getActivity();
        int channel_id = activity.getMyData();

        /** Insert all the code from the -Activity’s onCreate() method after the setContentView method call */
        // Connect to ThinkSpeak Channel channel_id
        tsChannel = new ThingSpeakChannel(channel_id);
        // Set listener for Channel feed update events
        tsChannel.setChannelFeedUpdateListener(new ThingSpeakChannel.ChannelFeedUpdateListener() {
            @Override
            public void onChannelFeedUpdated(long channelId, String channelName,
                                             ChannelFeed channelFeed) {
                // Show Channel ID and name on the Action Bar
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(channelName);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Channel " + channelId);
                // Notify last update time of the Channel feed through a Toast message
                Date lastUpdate = channelFeed.getChannel().getUpdatedAt();
                // used getActivity
                Toast.makeText(getActivity(), "Channel last update time: " + lastUpdate.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Fetch the specific Channel feed
        tsChannel.loadChannelFeed();

        // Create a Calendar object dated 5 minutes ago
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -5);

        // Configure LineChartView
        //rootView
        chartView = (LineChartView) rootView.findViewById(R.id.chart);
        chartView.setZoomEnabled(true);
        chartView.setValueSelectionEnabled(true);

        // Create a line chart from Field1 of ThinkSpeak Channel 9
        //syntax
        //tsChart = new ThingSpeakLineChart(CHANNEL_ID, FIELD_ID);
        tsChart = new ThingSpeakLineChart(channel_id, field_id);

        // Get 200 entries at maximum
        tsChart.setNumberOfEntries(200);
        // Set value axis labels on 2-unit interval
        tsChart.setValueAxisLabelInterval(2);
        // Set date axis labels on 5-minute interval
        tsChart.setDateAxisLabelInterval(1);
        // Show the line as a cubic spline
        tsChart.useSpline(true);
        // Set the line color
        tsChart.setLineColor(Color.parseColor("#D32F2F"));
        // Set the axis color
        tsChart.setAxisColor(Color.parseColor("#455a64"));
        // Set the starting date (5 minutes ago) for the default viewport of the chart
        tsChart.setChartStartDate(calendar.getTime());

        // Set listener for chart data update
        tsChart.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
            @Override
            public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData
                    lineChartData, Viewport maxViewport, Viewport initialViewport) {
                // Set chart data to the LineChartView
                chartView.setLineChartData(lineChartData);
                // Set scrolling bounds of the chart
                chartView.setMaximumViewport(maxViewport);
                // Set the initial chart bounds
                chartView.setCurrentViewport(initialViewport);
            }
        });
        // Load chart data asynchronously
        tsChart.loadChartData();

        return rootView;
    }

}
