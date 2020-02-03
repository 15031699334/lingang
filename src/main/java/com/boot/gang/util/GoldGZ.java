package com.boot.gang.util;

public enum GoldGZ {

    DAY1(1, 2),
    DAY2(2, 2),
    DAY3(3, 4),
    DAY4(4, 4),
    DAY5(5, 8),
    DAY6(6, 8),
    DAY7(7, 16);

    private int index;
    private int dou;

    private GoldGZ(int index, int dou) {
        this.index = index;
        this.dou = dou;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int days) {
        this.index = days;
    }

    public int getDou() {
        return dou;
    }

    public void setDou(int dou) {
        this.dou = dou;
    }

    /**
     * 判断数值是否属于枚举类的值
     * @param key
     * @return
     */
    public static boolean isInclude(int key){
        boolean include = false;
        for (GoldGZ e: GoldGZ.values()){
            if(e.getIndex() == key){
                include = true;
                break;
            }
        }
        return include;
    }



}
