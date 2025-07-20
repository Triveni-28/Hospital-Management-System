package com.hospitl management system.hospitalapp;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    // Show a quick toast message
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    // Validate name input
    public static boolean isValidName(String name) {
        return name != null && name.trim().length() >= 2;
    }

    // Validate age
    public static boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            return age > 0 && age < 120;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Convert emergency level to readable string (optional)
    public static String getEmergencyLabel(int level) {
        switch (level) {
            case 1: return "🔴 Critical";
            case 2: return "🟠 High";
            case 3: return "🟡 Moderate";
            case 4: return "🟢 Low";
            default: return "Unknown";
        }
    }
}
