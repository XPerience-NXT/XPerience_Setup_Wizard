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

package com.klozz.xperience.setupwizard;

import android.app.Application;
import android.app.StatusBarManager;
import android.content.Context;

public class XPeSetupWizard extends Application {

    public static final String TAG = "XPerienceSetupWizard";
    // Leave this off for release
    public static final boolean DEBUG = false;

    public static final String ACCOUNT_TYPE_GOOGLE = "com.google";

    public static final String EXTRA_FIRST_RUN = "firstRun";
    public static final String EXTRA_ALLOW_SKIP = "allowSkip";

    public static final String GCM_PREFERENCES = "com.klozz.xperience.setupwizard.gcm";
    public static final String SETTINGS_PREFERENCES = "com.klozz.xperience.setupwizard_preferences";

    private StatusBarManager mStatusBarManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mStatusBarManager = (StatusBarManager) getSystemService(Context.STATUS_BAR_SERVICE);
    }

    public void disableStatusBar() {
        mStatusBarManager.disable(StatusBarManager.DISABLE_EXPAND
                | StatusBarManager.DISABLE_NOTIFICATION_ALERTS
                | StatusBarManager.DISABLE_NOTIFICATION_TICKER | StatusBarManager.DISABLE_RECENT
                | StatusBarManager.DISABLE_HOME
                | StatusBarManager.DISABLE_SEARCH);
    }

    public void enableStatusBar() {
        mStatusBarManager.disable(StatusBarManager.DISABLE_NONE);
    }

}
