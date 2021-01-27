package com.appforest.electriccardata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.mikephil.charting.charts.BarChart;
import com.google.android.material.tabs.TabLayout;

public class TemperatureActivity extends Fragment {

    private BarChart chart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_temperature, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout1);

        tabLayout.addTab(tabLayout.newTab().setText("WEEK"));
        tabLayout.addTab(tabLayout.newTab().setText("MONTH"));
        tabLayout.addTab(tabLayout.newTab().setText("YEAR"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = view.findViewById(R.id.pager1);
        final PagerAdapterTemp adapter = new PagerAdapterTemp
                (getFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){
            }

        });


//        chart = view.findViewById(R.id.chart1);
//
//        chart.setDrawBarShadow(false);
//        chart.setDrawValueAboveBar(true);
//
//        chart.getDescription().setEnabled(false);
//
//        // if more than 60 entries are displayed in the chart, no values will be
//        // drawn
//        chart.setMaxVisibleValueCount(60);
//
//        // scaling can now only be done on x- and y-axis separately
//        chart.setPinchZoom(true);
//
//        chart.setDrawGridBackground(false);
//        // chart.setDrawYLabels(false);
//
//        chart.animateXY(2000, 2000);
//
//        XAxis xAxis = chart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setDrawGridLines(false);
//        xAxis.setGranularity(1f); // only intervals of 1 day
//        xAxis.setLabelCount(6);
//        xAxis.setTextColor(Color.GRAY);
//
//        YAxis yAxis = chart.getAxisLeft();
//        yAxis.setLabelCount(3, true);
//        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//        yAxis.setTextSize(12);
//        yAxis.setTextColor(Color.GRAY);
//        yAxis.setAxisMaximum(100f);
//        yAxis.setAxisMinimum(0f);
//        yAxis.setGranularity(50f);
//        yAxis.setDrawGridLines(true);
//        yAxis.setDrawAxisLine(false);
//        yAxis.setDrawLabels(true);
//
//        YAxis rightAxis = chart.getAxisRight();
//        rightAxis.setDrawLabels(false);
//        rightAxis.setDrawAxisLine(false);
//        rightAxis.setDrawGridLines(false);
//
//        chart.getLegend().setEnabled(false);
//
//
//        MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
//        mv.setChartView(chart); // For bounds control
//        chart.setMarker(mv); // Set the marker to the chart
//
//        // setting data
//        setData(6, 100);

        return view;

    }

//    private void setData(int count, float range) {
//
//        float start = 1f;
//
//        ArrayList<BarEntry> values = new ArrayList<>();
//
//        for (int i = (int) start; i < start + count; i++) {
//            float val = (float) (Math.random() * (range + 1));
//            values.add(new BarEntry(i, val, getResources()));
//        }
//
//        BarDataSet set1;
//
//        if (chart.getData() != null &&
//                chart.getData().getDataSetCount() > 0) {
//            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
//            set1.setValues(values);
//            set1.notifyDataSetChanged();
//            chart.getData().notifyDataChanged();
//            chart.notifyDataSetChanged();
//
//        } else {
//            set1 = new BarDataSet(values, "");
//
//            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
//            dataSets.add(set1);
//
//            BarData data = new BarData(dataSets);
//            data.setValueTextSize(10f);
//            data.setBarWidth(0.5f);
//            set1.setDrawValues(!set1.isDrawValuesEnabled()); //Invisible numbers
//            chart.setData(data);
//
//        }
//    }


//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
}
