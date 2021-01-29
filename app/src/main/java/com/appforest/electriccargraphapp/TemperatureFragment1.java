package com.appforest.electriccargraphapp;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TemperatureFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TemperatureFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private BarChart chart;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TemperatureFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TemperatureActivity1.
     */
    // TODO: Rename and change types and number of parameters
    public static TemperatureFragment1 newInstance(String param1, String param2) {
        TemperatureFragment1 fragment = new TemperatureFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature1, container, false);

        //get today
        TextView tv = view.findViewById(R.id.editBirth_temp_1);
        Calendar cal = Calendar.getInstance();
        tv.setText("Week " + cal.get(Calendar.WEEK_OF_MONTH) + ", " + (cal.get(Calendar.MONTH) + 1));

        LinearLayout btnLogin = (LinearLayout) view.findViewById(R.id.btn_tempDatePicker_1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickerDialog_WeekMonth pd = new PickerDialog_WeekMonth();
                pd.setListener(d);
                pd.show(getFragmentManager(), "MonthWeekPickerTest");
            }
        });

        chart = view.findViewById(R.id.chart_bar);

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);

        chart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(true);

        chart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        chart.animateXY(2000, 2000);


        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setTextColor(Color.GRAY);
        String[] xAxisLables = new String[]{"", "MON", "TUE", "WED", "THR", "FRI", "SAT", "SUN"};

        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLables));


        YAxis yAxis = chart.getAxisLeft();
        yAxis.setLabelCount(3, true);
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setTextSize(12);
        yAxis.setTextColor(Color.GRAY);
        yAxis.setAxisMaximum(122f);
        yAxis.setAxisMinimum(14f);
        yAxis.setGranularity(65f);
        yAxis.setDrawGridLines(true);
        yAxis.setDrawAxisLine(false);
        yAxis.setDrawLabels(true);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);

        chart.getLegend().setEnabled(false);


        TemperatureMarkerView mv = new TemperatureMarkerView(getActivity(), R.layout.custom_marker_view);
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart

        // setting data
        setData(7, 100);

        return view;
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int weekOfMonth) {
            TextView tv = getActivity().findViewById(R.id.editBirth_temp_1);
            tv.setText(String.format("Week %d, %d ", weekOfMonth, monthOfYear));
        }
    };


    private void setData(int count, float range) {

        float start = 1f;

        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = (int) start; i < start + count; i++) {
            float val = (float) (Math.random() * (range + 1));
            values.add(new BarEntry(i, val, getResources()));
        }

        BarDataSet set1;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            set1.notifyDataSetChanged();
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "");
//
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
//
            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.5f);
            set1.setDrawValues(!set1.isDrawValuesEnabled()); //Invisible numbers
            chart.setData(data);

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}