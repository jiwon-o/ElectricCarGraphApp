package com.appforest.electriccardata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.tabs.TabLayout;

public class RangeActivity extends Fragment {

    private LineChart chart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_range, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout_range);

        tabLayout.addTab(tabLayout.newTab().setText("WEEK"));
        tabLayout.addTab(tabLayout.newTab().setText("MONTH"));
        tabLayout.addTab(tabLayout.newTab().setText("YEAR"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = view.findViewById(R.id.pager_range);
        final PagerAdapterRange adapter = new PagerAdapterRange
                (getFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });

//        {   // // Chart Style // //
//            chart = view.findViewById(R.id.chart1);
//
//            // background color
//            chart.setBackgroundColor(Color.WHITE);
//
//            // disable description text
//            chart.getDescription().setEnabled(false);
//
//            // enable touch gestures
//            chart.setTouchEnabled(true);
//
//            // set listeners
////            chart.setOnChartValueSelectedListener(this);
//            chart.setDrawGridBackground(false);
//
//            // create marker to display box when values are selected
//            MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
//
//            // Set the marker to the chart
//            mv.setChartView(chart);
//            chart.setMarker(mv);
//
//            // enable scaling and dragging
//            chart.setDragEnabled(true);
//            chart.setScaleEnabled(true);
//
//            // force pinch zoom along both axis
//            chart.setPinchZoom(true);
//        }
//
//        final ArrayList<String> xLabel = new ArrayList<>();
//        xLabel.add("MON");
//        xLabel.add("TUE");
//        xLabel.add("WED");
//        xLabel.add("THR");
//        xLabel.add("FRI");
//        xLabel.add("SAT");
//        xLabel.add("SUN");
//
//        XAxis xAxis;
//        {   // // X-Axis Style // //
//            xAxis = chart.getXAxis();
//            xAxis.setLabelCount(7, true);
//            xAxis.setTextColor(Color.GRAY);
//            xAxis.setTextSize(11);
//            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//            xAxis.setDrawGridLines(false);
//            xAxis.setAxisLineColor(Color.WHITE);
//            chart.getAxisRight().setEnabled(false);
//            xAxis.setValueFormatter(new IndexAxisValueFormatter() {
//                @Override
//                public String getFormattedValue(float value) {
//                    return xLabel.get((int) value);
//                }
//            });
//
//        }
//
//        YAxis yAxis;
//        {   // // Y-Axis Style // //
//            yAxis = chart.getAxisLeft();
//            yAxis.setLabelCount(3, true);
//            yAxis.setTextColor(Color.GRAY);
//            yAxis.setTextSize(12);
//            yAxis.setAxisMaximum(100f);
//            yAxis.setAxisMinimum(0f);
//            yAxis.setGranularity(50f);
//            yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//            yAxis.setDrawGridLines(true);
//            yAxis.setAxisLineColor(Color.WHITE);
//            chart.getAxisRight().setEnabled(false);
//        }
//
//        setData(7, 100);
//        chart.getLegend().setEnabled(false);
//
//        chart.animateXY(1000, 1000);
//
//        // don't forget to refresh the drawing
//        chart.invalidate();
        return view;
    }

//    private void setData(int count, float range) {
//
//        ArrayList<Entry> values = new ArrayList<>();
//
//        for (int i = 0; i < count; i++) {
//
//            float val = (float) (Math.random() * range) ;
//            values.add(new Entry(i, val, getResources()));
//        }
//
//        LineDataSet set1;
//
//        if (chart.getData() != null &&
//                chart.getData().getDataSetCount() > 0) {
//            set1 = (LineDataSet) chart.getData().getDataSetByIndex(0);
//            set1.setValues(values);
//            set1.notifyDataSetChanged();
//            chart.getData().notifyDataChanged();
//            chart.notifyDataSetChanged();
//        } else {
//
//            set1 = new LineDataSet(values, "");
//
//            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//            set1.setCubicIntensity(0.2f);
//            set1.setDrawFilled(true);
//            set1.setDrawCircles(true);
//            set1.setDrawValues(!set1.isDrawValuesEnabled());
//            set1.setLineWidth(1.8f);
//            set1.setCircleRadius(4f);
//            set1.setCircleColor(Color.rgb(255, 35, 102));
//            set1.setHighLightColor(Color.GRAY);
//            set1.setColor(Color.rgb(255, 35, 102));
//            set1.setFillColor(Color.WHITE);
//            set1.setFillAlpha(100);
//            set1.setDrawHorizontalHighlightIndicator(false);
//
//            set1.setFillFormatter(new IFillFormatter() {
//                @Override
//                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
//                    return chart.getAxisLeft().getAxisMinimum();
//                }
//
//            });
//
//            // set color of filled area
//            if (Utils.getSDKInt() >= 18) {
//                // drawables only supported on api level 18 and above
//                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
//                set1.setFillDrawable(drawable);
//            } else {
//                set1.setFillColor(Color.BLACK);
//            }
//
//            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//            dataSets.add(set1); // add the data sets
//
//            // create a data object with the data sets
//            LineData data = new LineData(dataSets);
//
//            // set data
//            chart.setData(data);
//
//
//        }
//    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
}
