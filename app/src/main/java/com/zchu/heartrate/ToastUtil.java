package com.zchu.heartrate;

import android.content.Context;
import android.widget.Toast;


//show toast


public class ToastUtil {
    private static Toast sToast = null;
    public static boolean isShow = true;


    public static void showToast(Context context,String msg) {
        if (!isShow) {
            return;
        }
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
        }
        sToast.show();
    }

    public static void showToast(Context context,int resId) {
        if (!isShow) {
            return;
        }
        if (sToast == null) {
            sToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(resId);
        }
        sToast.show();
    }

    public static void showToastLong( Context context,String msg) {
        if (!isShow) {
            return;
        }
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            sToast.setText(msg);
        }
        sToast.show();
    }

    public static void showToastLong(Context context, int resId) {
        if (!isShow) {
            return;
        }
        if (sToast == null) {
            sToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
        } else {
            sToast.setText(resId);
        }
        sToast.show();
    }


    public static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }
}
