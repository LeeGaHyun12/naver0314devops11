package snack;

public class SnackDto {

    private String food_cd;
    private String food_nm;
    private int kcal;
    private int prot;
    private int fat;
    private int tansu;
    private int sugar;
    private int sicke;
    private int ca;
    private int nat;
    private int chole;
    private int serv_size;
    private String mfr_nm; // 수정된 부분: 제조사명은 문자열로 변경
    private double food_size; // 수정된 부분: 음식 크기는 double 타입으로 변경

    public String getFood_cd() {
        return food_cd;
    }

    public void setFood_cd(String food_cd) {
        this.food_cd = food_cd;
    }

    public String getFood_nm() {
        return food_nm;
    }

    public void setFood_nm(String food_nm) {
        this.food_nm = food_nm;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProt() {
        return prot;
    }

    public void setProt(int prot) {
        this.prot = prot;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getTansu() {
        return tansu;
    }

    public void setTansu(int tansu) {
        this.tansu = tansu;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getSicke() {
        return sicke;
    }

    public void setSicke(int sicke) {
        this.sicke = sicke;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getNat() {
        return nat;
    }

    public void setNat(int nat) {
        this.nat = nat;
    }

    public int getChole() {
        return chole;
    }

    public void setChole(int chole) {
        this.chole = chole;
    }

    public int getServ_size() {
        return serv_size;
    }

    public void setServ_size(int serv_size) {
        this.serv_size = serv_size;
    }

    public String getMfr_nm() {
        return mfr_nm;
    }

    public void setMfr_nm(String mfr_nm) {
        this.mfr_nm = mfr_nm;
    }

    public double getFood_size() {
        return food_size;
    }

    public void setFood_size(double food_size) {
        this.food_size = food_size;
    }
}
