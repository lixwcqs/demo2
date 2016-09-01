package com.trial.annotation.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by li on 2015/10/31.
 */
public class OOOM {
    private double[] ds = new double[99999];
    private String id = "123";

    public OOOM() {
//        System.out.println(ds.length);
    }

    public static void main(String[] args) {
        List<OOOM> ooms = new ArrayList<OOOM>();
        OOOM oom = new OOOM();
        OOOM o3;
        ooms.add(oom);
        oom = null;
        System.out.println(ooms.get(0) == null);
        System.out.println(ooms.get(0).getId());
        System.out.println(oom == null);
        for (int i = 0; i < 3; i++) {
            oom = new OOOM();
            o3 = oom;
//            oom= null;
            System.out.println(oom + "\t" + o3);
            System.out.println(oom.equals(o3));
            ooms.add(oom);
            oom = null;
        }
        System.out.println(ooms.size());


        int count = 0;
        Vector v = new Vector(10);
        while (true) {
            OOOM ms = new OOOM();
            ooms.add(ms);
//            ms = null;
            System.out.println(++count);
//            o = null;
        }//

//        while(true){
//

//            oooms.add(ooom);
//        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
