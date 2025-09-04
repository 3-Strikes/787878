package _01_test;

import java.util.Objects;

public class Pai implements Comparable{
    private String mian;
    private String zhi;

    private int zhi1;

    public Pai(String mian, String zhi, int zhi1) {
        this.mian = mian;
        this.zhi = zhi;
        this.zhi1 = zhi1;
    }

    public String getMian() {
        return mian;
    }

    public void setMian(String mian) {
        this.mian = mian;
    }

    public String getZhi() {
        return zhi;
    }

    public void setZhi(String zhi) {
        this.zhi = zhi;
    }

    public int getZhi1() {
        return zhi1;
    }

    public void setZhi1(int zhi1) {
        this.zhi1 = zhi1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pai pai = (Pai) o;

        if (zhi1 != pai.zhi1) return false;
        if (!Objects.equals(mian, pai.mian)) return false;
        return Objects.equals(zhi, pai.zhi);
    }

    @Override
    public int hashCode() {
        int result = mian != null ? mian.hashCode() : 0;
        result = 31 * result + (zhi != null ? zhi.hashCode() : 0);
        result = 31 * result + zhi1;
        return result;
    }

    @Override
    public String toString() {
        return  mian + zhi +" ";
    }

    @Override
    public int compareTo(Object o) {
        return o.hashCode();
    }
}
