package moe.shizuku.manager.app;

import android.content.Context;

import androidx.annotation.StyleRes;

import moe.shizuku.manager.R;
import moe.shizuku.manager.ShizukuManagerSettings;
import rikka.core.util.ResourceUtils;

public class ThemeHelper {

    private static final String THEME_DEFAULT = "DEFAULT";
    private static final String THEME_BLACK = "BLACK";

    public static final String KEY_LIGHT_THEME = "light_theme";
    public static final String KEY_BLACK_NIGHT_THEME = "black_night_theme";

    public static boolean isBlackNightTheme() {
        return ShizukuManagerSettings.getPreferences().getBoolean(KEY_BLACK_NIGHT_THEME, false);
    }

    public static String getTheme(Context context) {
        if (isBlackNightTheme()
                && ResourceUtils.isNightMode(context.getResources().getConfiguration()))
            return THEME_BLACK;

        return ShizukuManagerSettings.getPreferences().getString(KEY_LIGHT_THEME, THEME_DEFAULT);
    }
    @StyleRes
    public static int getThemeStyleRes(Context context) {
        switch (getTheme(context)) {
            case THEME_BLACK:
                return R.style.ThemeOverlay_Black;
            case THEME_DEFAULT:
            default:
                return R.style.ThemeOverlay;
        }
    }
}
