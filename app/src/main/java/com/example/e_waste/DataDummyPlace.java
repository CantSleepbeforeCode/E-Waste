package com.example.e_waste;

import java.util.ArrayList;

public class DataDummyPlace {
    public static String[][] dataPlaces = new String[][] {
            {
                    "A",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                    "-1.256951",
                    "116.867540",
                    "300 m",
                    "@drawable/bin_green"
            },
            {
                    "B",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                    "-1.255758",
                    "116.868562",
                    "300 m",
                    "@drawable/bin_green"
            },
            {
                    "C",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                    "-1.256951",
                    "116.867540",
                    "300 m",
                    "@drawable/bin_green"
            },
            {
                    "D",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                    "-1.256951",
                    "116.867540",
                    "300 m",
                    "@drawable/bin_green"
            }
    };

    public static ArrayList<NearestPlace> getListDataPlaces() {
        ArrayList<NearestPlace> listPlace = new ArrayList<>();
        for(String[] aData: dataPlaces) {
            NearestPlace nearestPlace = new NearestPlace();
            nearestPlace.setName(aData[0]);
            nearestPlace.setDescription(aData[1]);
            nearestPlace.setLatitude(aData[2]);
            nearestPlace.setLongtitude(aData[3]);
            nearestPlace.setRange(aData[4]);
            nearestPlace.setImageBin(aData[5]);

            listPlace.add(nearestPlace);
        }
        return listPlace;
    }
}
