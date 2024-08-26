package com.gorgeous.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * <pre>
 *     author: Marco
 *     date  : 2024.08.26
 *     desc  : utils about bar
 * </pre>
 */
public class BarUtils {
    private final static String TAG = "BarUtils";

    /**
     * 获取底部导航栏高度
     *
     * @param activity Activity
     * @return 导航栏高度
     */
    public static int getNavigationBarHeight(Activity activity) {
        try {
            Resources resources = activity.getResources();
            @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
            int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
            return resources.getDimensionPixelSize(resourceId);
        } catch (Exception e) {
            LogUtils.e(TAG,"getNavigationBarHeight Fail ... ", e);
        }
        return -1;
    }

    /**
     * 获取屏幕高度，包括状态栏，导航栏高度
     *
     * @param context context
     * @return screen height
     */
    public static int getScreenHeight(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getApplicationContext().
                    getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            return  point.y;
        } catch (Exception e) {
            LogUtils.e(TAG,"getScreenHeight Fail ... ", e);
        }
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    /**
     * 获取屏幕宽度
     *
     * @param context context
     * @return screen width
     */
    public static int getScreenWidth(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getApplicationContext().
                    getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            return  point.x;
        } catch (Exception e) {
            LogUtils.e(TAG,"getScreenWidth Fail ... ", e);
        }
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }
}
