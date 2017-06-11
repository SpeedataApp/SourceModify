// IDeviceControl.aidl
package com.android.control;

// Declare any non-default types here with import statements
import android.content.ContentValues;
import android.net.Uri;
interface IDeviceControl {
     void rebootDevice();
     void shutdownDevice();
     void  recoveryDevice();
     void setSystemTime(long time);
     int createApn(in ContentValues values);
     void uninstallApp(String packageName);
     void installApp(in Uri packageURI);
}
