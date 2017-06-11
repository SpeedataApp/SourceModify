package com.android.control;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.os.ServiceManager;

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
 * @author :Reginer in  2017/6/8 8:42.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class ControlManager {

    private IDeviceControl deviceControl;

    public ControlManager() {
        deviceControl = IDeviceControl.Stub.asInterface(ServiceManager.getService
                (Context.DEVICE_CONTROL));
    }

    public ControlManager(Context mContext, IDeviceControl deviceControl) {
        this.deviceControl = deviceControl;
    }

    private static ControlManager sControlManager;

    /**
     * 获取实例.
     *
     * @param context context
     * @return ControlManager
     */
    public static ControlManager getDeviceControl(Context context) {
        if (sControlManager == null) {
            sControlManager = new ControlManager();
        }
        return sControlManager;
    }

    /**
     * 重启.
     */
    public void rebootDevice() {
        try {
            deviceControl.rebootDevice();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关机.
     */
    public void shutdownDevice() {
        try {
            deviceControl.shutdownDevice();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复出厂设置.
     */
    public void recoveryDevice() {
        try {
            deviceControl.recoveryDevice();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置系统时间.
     *
     * @param time 时间 -  long
     */
    public void setSystemTime(long time) {
        try {
            deviceControl.setSystemTime(time);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建apn.
     *
     * @param values apn值
     * @return 创建结果
     */
    public int createApn(ContentValues values) {
        try {
            return deviceControl.createApn(values);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 卸载应用.
     *
     * @param packageName 应用包名
     */
    public void uninstallApp(String packageName) {
        try {
            deviceControl.uninstallApp(packageName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    /**
     * 安装程序.
     *
     * @param packageURI apk地址
     */
    public void installApp(Uri packageURI) {
        try {
            deviceControl.installApp(packageURI);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
