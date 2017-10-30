package org.underworldlabs.swing;


import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import javax.swing.*;
import java.time.LocalDateTime;

public class EQDateTimePicker extends JPanel {
    public DatePicker datePicker;
    public EQTimePicker timePicker;

    public EQDateTimePicker() {
        datePicker = new DatePicker();
        timePicker = new EQTimePicker(false);
        init();
    }

    void init() {
        datePicker.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent dateChangeEvent) {
                timePicker.setEnable(!datePicker.getDateStringOrEmptyString().equals(""));

            }
        });
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(datePicker)
                        .addGap(10)
                        .addComponent(timePicker)

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(datePicker)
                        .addComponent(timePicker)
        );
    }

    public String getStringValue() {
        return (datePicker.getDateStringOrEmptyString() + " " + timePicker.getStringValue()).trim();
    }

    public void setDateTimePermissive(LocalDateTime time) {
        if(time!=null) {
            datePicker.setDate(time.toLocalDate());
            timePicker.setTime(time.toLocalTime());
        }
        else {
            datePicker.setDate(null);
            timePicker.setTime(null);
        }
    }

    public void clear() {
        datePicker.clear();
        timePicker.setEnabled(false);
    }
}
