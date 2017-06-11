package com.speedata.uhf;

import android.content.Context;
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
 * @author :Reginer in  2017/4/20 15:23.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class UhfManager {
    private IUhfManager uhfManager;

    private UhfManager() {
        uhfManager = IUhfManager.Stub.asInterface(ServiceManager.getService
                (Context.UHF_SERVICE));
    }

    private static UhfManager sUhfManager;

    /**
     * 获取实例.
     *
     * @param context context
     * @return UhfManager
     */
    public static UhfManager getUHFService(Context context) {
        if (sUhfManager == null) {
            sUhfManager = new UhfManager();
        }
        return sUhfManager;
    }

    public UhfManager(Context mContext, IUhfManager uhfManager) {
        this.uhfManager = uhfManager;
    }

    /**
     * 上电.
     *
     * @return result
     */
    public int openDev() throws RemoteException {
        return uhfManager.openDev();
    }

    /**
     * 下电.
     */
    public void closeDev() throws RemoteException {
        uhfManager.closeDev();
    }

    /**
     * 开始盘点.
     */
    public void inventoryStart() throws RemoteException {
        uhfManager.inventoryStart();
    }

    /**
     * 停止盘点
     */
    public void inventoryStop() throws RemoteException {
        uhfManager.inventoryStop();
    }

    /**
     * 读卡
     * 从标签area区的addr位置（以word计算）读取count个值（以byte计算），passwd是访问密码，如果区域没被锁就给0值.
     *
     * @param area  area
     * @param addr  addr
     * @param count count
     * @param pwd   pwd
     * @return byte[]
     * @throws RemoteException RemoteException
     */
    public byte[] readAreaByte(int area, int addr, int count, int pwd) throws RemoteException {
        return uhfManager.readAreaByte(area, addr, count, pwd);
    }

    /**
     * 读卡.
     * 同上，只是参数类型不一样返回String
     *
     * @param area     area
     * @param strAddr  strAddr
     * @param strCount strCount
     * @param strPwd   strPwd
     * @return String
     * @throws RemoteException RemoteException
     */
    public String readArea(int area, String strAddr, String strCount, String strPwd) throws RemoteException {
        return uhfManager.readArea(area, strAddr, strCount, strPwd);
    }

    /**
     * 写卡
     * 把content中的数据写到标签area区中addr（以word计算）开始的位置.
     *
     * @param area    area
     * @param addr    addr
     * @param pwd     pwd
     * @param count   count
     * @param content content
     * @return int
     * @throws RemoteException RemoteException
     */
    public int writeArea(int area, String addr, String pwd, String count, String content) throws RemoteException {
        return uhfManager.writeArea(area, addr, pwd, count, content);
    }

    /**
     * 写卡.
     *
     * @param area    area
     * @param addr    addr
     * @param pwd     pwd
     * @param content content
     * @return int
     * @throws RemoteException RemoteException
     */
    public int writeAreaByte(int area, int addr, int pwd, byte[] content) throws RemoteException {
        return uhfManager.writeAreaByte(area, addr, pwd, content);
    }

    /**
     * 选中要进行操作的epc标签.
     *
     * @param epc epc
     * @return int
     * @throws RemoteException RemoteException
     */
    public int selectCard(String epc) throws RemoteException {
        return uhfManager.selectCard(epc);
    }

    /**
     * 设置天线功率.
     *
     * @param power power
     * @return int  0---30
     * @throws RemoteException RemoteException
     */
    public int setAntennaPower(int power) throws RemoteException {
        return uhfManager.setAntennaPower(power);
    }

    /**
     * 读取天线功率值.
     *
     * @return int
     * @throws RemoteException RemoteException
     */
    public int getAntennaPower() throws RemoteException {
        return uhfManager.getAntennaPower();
    }

    /**
     * 设置频率区域.
     *
     * @param region region
     * @return int
     * @throws RemoteException RemoteException
     */
    public int setFreqRegion(int region) throws RemoteException {
        return uhfManager.setFreqRegion(region);
    }

    /**
     * 获取频率区域.
     *
     * @return int
     * @throws RemoteException RemoteException
     */
    public int getFreqRegion() throws RemoteException {
        return uhfManager.getFreqRegion();
    }

    /**
     * 设置密码
     *
     * @param which  which
     * @param curPwd 原密码
     * @param newPwd 新密码
     * @return int
     * @throws RemoteException RemoteException
     */
    public int setPassword(int which, String curPwd, String newPwd) throws RemoteException {
        return uhfManager.setPassword(which, curPwd, newPwd);
    }

    /**
     * 设定区域锁定状态 .
     *
     * @param type type
     * @param area area
     * @param pwd  pwd
     * @return int
     * @throws RemoteException RemoteException
     */
    public int setLock(int type, int area, int pwd) throws RemoteException {
        return uhfManager.setLock(type, area, pwd);
    }
}
