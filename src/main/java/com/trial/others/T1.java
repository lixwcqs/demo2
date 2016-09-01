package com.trial.others;

/**
 * Created by li on 2016/3/24.
 */
public class T1 {

    int lessThan100(double d) {
        if (d < 100.0) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Near {
    int it;
    public int getItNear() {
        return getIt();
    }
    private int getIt() {
        return it;
    }

    public String f1(int price,String name){
        return name;
    }
}

class Far extends Near {
    int getItFar() {
        return super.getItNear();
    }

    @Override
    public String f1(int price, String name) {

        return super.f1(price, name);
    }
}