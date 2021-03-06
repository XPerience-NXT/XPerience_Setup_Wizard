/*
 * Copyright (C) 2011-2014 The XPerience Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.klozz.xperience.setupwizard.util;

import com.klozz.xperience.setupwizard.XPeSetupWizard;
import com.klozz.xperience.setupwizard.R;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

public class XPeAccountUtils {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private static Intent getWifiSetupIntent(Context context) {
        Intent intent = new Intent(XPeSetupWizard.ACTION_SETUP_WIFI);
        intent.putExtra(XPeSetupWizard.EXTRA_FIRST_RUN, true);
        intent.putExtra(XPeSetupWizard.EXTRA_ALLOW_SKIP, true);
        intent.putExtra(XPeSetupWizard.EXTRA_SHOW_BUTTON_BAR, true);
        intent.putExtra(XPeSetupWizard.EXTRA_ONLY_ACCESS_POINTS, true);
        intent.putExtra(XPeSetupWizard.EXTRA_SHOW_SKIP, true);
        intent.putExtra(XPeSetupWizard.EXTRA_AUTO_FINISH, true);
        intent.putExtra(XPeSetupWizard.EXTRA_PREF_BACK_TEXT, context.getString(R.string.skip));
        return intent;
    }

public static void launchWifiSetup(Activity context) {
        XPeAccountUtils.tryEnablingWifi(context);
        Intent intent = getWifiSetupIntent(context);
        context.startActivityForResult(intent, XPeSetupWizard.REQUEST_CODE_SETUP_WIFI);
    }

    public static void launchWifiSetup(Fragment fragment) {
        final Context context = fragment.getActivity();
        XPeAccountUtils.tryEnablingWifi(context);
        Intent intent = getWifiSetupIntent(context);
        fragment.startActivityForResult(intent, XPeSetupWizard.REQUEST_CODE_SETUP_WIFI);
    }

 
   public static void tryEnablingWifi(Context context) {
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
    }
}
