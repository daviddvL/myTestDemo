package com.example.davidliu.demo.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by david.liu on 2018/5/2.
 */

public class SnackbarUtil {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
