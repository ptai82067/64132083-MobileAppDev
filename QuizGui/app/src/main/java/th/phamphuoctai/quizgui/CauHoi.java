package th.phamphuoctai.quizgui;

// Lớp CauHoi
class CauHoi {
    private String loiHoi;
    private String pa1;
    private String pa2;
    private String pa3;
    private String pa4;
    private String paDung;

    public CauHoi(String loiHoi, String pa1, String pa2, String pa3, String pa4, String paDung) {
        this.loiHoi = loiHoi;
        this.pa1 = pa1;
        this.pa2 = pa2;
        this.pa3 = pa3;
        this.pa4 = pa4;
        this.paDung = paDung;
    }

    public String getLoiHoi() {
        return loiHoi;
    }

    public String getPa1() {
        return pa1;
    }

    public String getPa2() {
        return pa2;
    }

    public String getPa3() {
        return pa3;
    }

    public String getPa4() {
        return pa4;
    }

    public String getPaDung() {
        return paDung;
    }
}