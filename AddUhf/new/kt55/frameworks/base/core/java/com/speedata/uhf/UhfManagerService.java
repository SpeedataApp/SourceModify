package com.speedata.uhf;

import android.content.Context;
import android.os.RemoteException;

import com.speedata.libuhf.IUHFService;
import com.speedata.libuhf.UHFManager;

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
 * @author :Reginer in  2017/4/20 15:31.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class UhfManagerService extends IUhfManager.Stub {

    private Context mContext;
    private IUHFService mService;

    public UhfManagerService(Context context) {
        mContext = context;
        mService = UHFManager.getUHFService(context);
    }

    @Override
    public int openDev() throws RemoteException {
        return mService.OpenDev();
    }

    @Override
    public void closeDev() throws RemoteException {
        mService.CloseDev();
    }

    @Override
    public void inventoryStart() throws RemoteException {
        mService.inventory_start();
    }

    @Override
    public void inventoryStop() throws RemoteException {
        mService.inventory_stop();
    }

    @Override
    public byte[] readAreaByte(int area, int addr, int count, int pwd) throws RemoteException {
        return mService.read_area(area, addr, count, pwd);
    }

    @Override
    public String readArea(int area, String strAddr, String strCount, String strPwd) throws RemoteException {
        return mService.read_area(area, strAddr, strCount, strPwd);
    }

    @Override
    public int writeArea(int area, String addr, String pwd, String count, String content) throws RemoteException {
        return mService.write_area(area, addr, pwd, count, content);
    }

    @Override
    public int writeAreaByte(int area, int addr, int pwd, byte[] content) throws RemoteException {
        return mService.write_area(area, addr, pwd, content);
    }

    @Override
    public int selectCard(String epc) throws RemoteException {
        return mService.select_card(epc);
    }

    @Override
    public int setAntennaPower(int power) throws RemoteException {
        return mService.set_antenna_power(power);
    }

    @Override
    public int getAntennaPower() throws RemoteException {
        return mService.get_antenna_power();
    }

    @Override
    public int setFreqRegion(int region) throws RemoteException {
        return mService.set_freq_region(region);
    }

    @Override
    public int getFreqRegion() throws RemoteException {
        return mService.get_freq_region();
    }

    @Override
    public int setPassword(int which, String curPwd, String newPwd) throws RemoteException {
        return mService.set_Password(which, curPwd, newPwd);
    }

    @Override
    public int setLock(int type, int area, int pwd) throws RemoteException {
        return mService.setlock(type, area, pwd);
    }
}
