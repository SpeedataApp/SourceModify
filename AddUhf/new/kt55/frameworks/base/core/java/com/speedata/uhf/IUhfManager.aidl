// IUhfManager.aidl
package com.speedata.uhf;

interface IUhfManager {


   int openDev();
   void closeDev();
   void inventoryStart();
   void inventoryStop();
   byte[] readAreaByte(int area,int addr,int count,int passwd);
   String readArea(int area,String strAddr,String strCount,String strPwd);
    int writeArea(int area, String addr, String pwd, String count, String content);
    int writeAreaByte(int area, int addr, int pwd, in byte[] content);
    int selectCard(String epc);
    int setAntennaPower(int power);
    int getAntennaPower();
    int setFreqRegion(int region);
    int getFreqRegion();
    int setPassword(int which, String curPwd, String newPwd);
    int setLock(int type, int area, int pwd);


}
