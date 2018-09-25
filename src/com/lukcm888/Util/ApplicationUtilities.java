package com.lukcm888.Util;

import java.util.ArrayList;

public class ApplicationUtilities {


    public static boolean isNumeric(String number) {
        boolean bool = false;


        return bool;
    }

    public static boolean isNumeric(ArrayList<String> numbers) {

        boolean bool = true;

        for (String num : numbers) {

            if (!num.matches("[0-9]+")) {
                bool = false;
                break;
            }
        }

        return bool;
    }

    public static boolean isNullorEmpty() {
        boolean bool = false;

        return bool;
    }


}
