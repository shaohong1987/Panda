package com.thesethree.panda.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Eric on 2017-4-19.
 */

public class ViewUtils {

    public static String getAppFile(Context context, String uniqueName) {
        String cachePath = null;
        if ((Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable())
                && context.getExternalCacheDir() != null) {
            cachePath = context.getCacheDir().getParent();
        }
        return cachePath + File.separator + uniqueName;
    }
}
