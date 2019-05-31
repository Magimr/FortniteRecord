package com.example.fortniterecord;

import com.example.fortniterecord.duo.P10;
import com.example.fortniterecord.solo.P2;
import com.example.fortniterecord.squad.P9;

public class Stats {
    private P2 p2; //SOLO
    private P10 p10; //DUO
    private P9 p9; //ESCUADRON

    public P2 getP2() {
        return p2;
    }

    public void setP2(P2 p2) {
        this.p2 = p2;
    }

    public P10 getP10() {
        return p10;
    }

    public void setP10(P10 p10) {
        this.p10 = p10;
    }

    public P9 getP9() {
        return p9;
    }

    public void setP9(P9 p9) {
        this.p9 = p9;
    }
}
