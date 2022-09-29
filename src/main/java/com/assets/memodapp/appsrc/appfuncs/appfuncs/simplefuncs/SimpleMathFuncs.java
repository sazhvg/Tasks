package com.assets.memodapp.appsrc.appfuncs.appfuncs.simplefuncs;

public class SimpleMathFuncs {

    // визначити, є a множитилем b
    public static boolean isFactor (int a, int b){
        if ((b%a) == 0) return true;
        return false;
    }

    // повернуту найменьший загальний для a та b
    public static int lcf (int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a < b ? a : b;

        for (int i = 2; i <= min/2; i++){
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }
    // повернуту найбільший загальний для a та b

    public static int gcf(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        int min = a < b ? a : b;

        for (int i = 2; i >= min/2; i--){
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }
}
