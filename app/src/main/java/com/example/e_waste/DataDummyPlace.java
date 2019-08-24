package com.example.e_waste;

import java.util.ArrayList;

public class DataDummyPlace {
    public static String[][] dataPlaces = new String[][] {
            {
                    "A",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "-1.256951",
                    "116.867540",
                    "300 m",
                    "20%",
                    "@drawable/ic_green"
            },
            {
                    "B",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "-1.255758",
                    "116.868562",
                    "300 m",
                    "20%",
                    "@drawable/ic_red"
            },
            {
                    "C",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "-1.256951",
                    "116.867540",
                    "300 m",
                    "20%",
                    "@drawable/ic_yellow"
            },
            {
                    "D",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "-1.256951",
                    "116.867540",
                    "300 m",
                    "20%",
                    "@drawable/ic_red"
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
            nearestPlace.setPercentage(aData[5]);
            nearestPlace.setImageBin(aData[6]);

            listPlace.add(nearestPlace);
        }
        return listPlace;
    }
}
