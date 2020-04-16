package com.example.drugbank.components;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

public class ToastMessage {
    public static void showMessage(@Nullable View view, @NonNull String message, int duration) {
        if (view != null) {
            Snackbar.make(view, message, duration).show();
        }
    }
    public static void showMessageOption(@NonNull View view, @NonNull String message, int duration, @NonNull String name, @NonNull View.OnClickListener onClickListener)
    {
        final Snackbar snackbar = Snackbar.make(view, message, duration);
        snackbar.setAction(name, onClickListener);
        snackbar.show();
    }

}
