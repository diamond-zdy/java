package com.bitedu.osm;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import org.omg.CORBA.PUBLIC_MEMBER;

public class OSResource {
    private static OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    private static final int DATA_LENGTH = 60;
    //记录 60 个坐标点，就是统计一个周期
    private static XYPair[] xyPairs = new XYPair[DATA_LENGTH];
    private static int firstIndex = DATA_LENGTH;
    static {
        for(int i = 0;i < xyPairs.length;++i){
            xyPairs[i] = new XYPair(0,0);
        }
    }
    public static class XYPair{
        private double x;//x 轴
        private double y;//y 轴

        public XYPair(double x,double y){
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
    public static XYPair[] getCPUPercetage(){
        double cpu = mxBean.getSystemCpuLoad();
        moveCPUData(cpu);
        return xyPairs;
    }
    public static String getOSName(){
        return mxBean.getName();
    }
    public static String getCPUArch(){
        return mxBean.getArch();
    }
    public static String getCPUCore(){
        //将int类型转化成String
        int i =  mxBean.getAvailableProcessors();
        String s = String.valueOf(i);
        return s;
    }
    private static void moveCPUData(double cpuPercetage){
        int movIdx = -1;
        if (firstIndex == 0){
            movIdx = firstIndex + 1;
        }else {
            movIdx = firstIndex;
            firstIndex--;
        }
        for (; movIdx < xyPairs.length; ++movIdx){
            xyPairs[movIdx-1].setX(xyPairs[movIdx].getX()-1);
            xyPairs[movIdx-1].setY(xyPairs[movIdx].getY());
        }
        movIdx--;
        xyPairs[movIdx] = new XYPair(movIdx, cpuPercetage);
    }
}
