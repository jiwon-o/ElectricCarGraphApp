package com.appforest.electriccardata;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class PickerDialog_WeekMonth extends DialogFragment {

    private static final int MAX_WEEK = 5;
    private static final int MIN_WEEK = 1;

    private DatePickerDialog.OnDateSetListener listener;
    public Calendar cal = Calendar.getInstance();

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    Button btnConfirm;
    Button btnCancel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialog = inflater.inflate(R.layout.picker_week_month, null);

        btnConfirm = dialog.findViewById(R.id.btn_confirm);
        btnCancel = dialog.findViewById(R.id.btn_cancel);

        final NumberPicker monthPicker = (NumberPicker) dialog.findViewById(R.id.weeklyPicker_month);
        final NumberPicker weekPicker = (NumberPicker) dialog.findViewById(R.id.weeklyPicker_week);

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                PickerDialog_WeekMonth.this.getDialog().cancel();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onDateSet(null, 0, monthPicker.getValue(), weekPicker.getValue());
                PickerDialog_WeekMonth.this.getDialog().cancel();
            }
        });

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        monthPicker.setValue(cal.get(Calendar.MONTH) + 1);

        int week = cal.get(Calendar.WEEK_OF_MONTH);
        weekPicker.setMinValue(MIN_WEEK);
        weekPicker.setMaxValue(MAX_WEEK);
        weekPicker.setValue(week);

        builder.setView(dialog);

        return builder.create();
    }
}