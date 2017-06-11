package com.android.control;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemClock;

import com.android.internal.os.storage.ExternalStorageFormatter;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 *
 * @author :Reginer in  2017/6/8 8:47.
 *         联系方式:QQ:282921012
 *         功能描述:Speedata Device Control
 */
public class DeviceControlService extends IDeviceControl.Stub {

    private Context mContext;

    public DeviceControlService(Context context) {
        mContext = context;
    }

    @Override
    public void rebootDevice() throws RemoteException {
        PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
        pm.reboot(null);
    }

    @Override
    public void shutdownDevice() throws RemoteException {

        PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
        pm.shutdown(false, false);
    }

    @Override
    public void recoveryDevice() throws RemoteException {
//        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) mContext.getSystemService(Context.DEVICE_POLICY_SERVICE);
//        devicePolicyManager.wipeData(0);
        Intent intent = new Intent(ExternalStorageFormatter.FORMAT_AND_FACTORY_RESET);
        intent.putExtra(Intent.EXTRA_REASON, "MasterClearConfirm");
        intent.setComponent(ExternalStorageFormatter.COMPONENT_NAME);
        mContext.startService(intent);
    }

    @Override
    public void setSystemTime(long time) throws RemoteException {
        SystemClock.setCurrentTimeMillis(time);
    }

    @Override
    public int createApn(ContentValues values) throws RemoteException {
        Uri APN_LIST_URI = Uri.parse("content://telephony/carriers");
        int apnId = -1;
        ContentResolver resolver = mContext.getContentResolver();
        Cursor c = null;
        try {
            Uri newRow = resolver.insert(APN_LIST_URI, values);
            if (newRow != null) {
                c = resolver.query(newRow, null, null, null, null);
                int index = 0;
                if (c != null) {
                    index = c.getColumnIndex("_id");
                    c.moveToFirst();
                    apnId = c.getShort(index);
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (c != null)
            c.close();
        return apnId;
    }

    @Override
    public void uninstallApp(String packageName) throws RemoteException {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + packageName));
         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    @Override
    public void installApp(Uri packageURI) throws RemoteException {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(packageURI, "application/vnd.android.package-archive");
        mContext.startActivity(intent);
    }
}
