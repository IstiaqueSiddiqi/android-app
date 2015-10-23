package com.example.istiaqhaq.legistify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Lawyer;

/**
 * Created by Istiaq Haq on 18-Oct-15.
 */
public class LawyerInformation {

    public ArrayList<Lawyer> getData() {

        // Defined Array values to show in ListView
        String[][] lawyerArray =  {
                {"Name","Notary","Property","Divorce","Matrimonial","Criminal","Family","Civil","Consumer","Contact","Address","City","State"},
                {"Surendra Rakhashia", "true", "false", "true", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Ahmedabad", "Gujarat"},
                {"Kaushik Dave And Associates", "false", "false", "true", "true", "false", "false", "true", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Bangalore", "Karnataka"},
                {"Jani And Company", "true", "false", "true", "false", "true", "false", "false", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Chandigarh", "Punjab"},
                {"Rajendra D Raval",  "true", "false", "true", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Chennai", "Tamil Nadu"},
                {"Pradip Rajput",  "true", "false", "false", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Coimbatore", "Tamil Nadu"},
                {"NOTERY -KIRTIKUMAR R KAPADIA",  "false", "false", "true", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Ramdas Rathor", "true", "true", "true", "false", "false", "false", "false", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Goa", "Maharashtra", },//
                {"Meenaben Thakkar",  "false", "false", "false", "false", "false", "true", "true", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Gurgaon", "Haryana"},
                {"Hasmukh L Patel", "false", "true", "false", "true", "false", "false", "false", "true", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Coimbatore", "Tamil Nadu"},
                {"Ashok M Patel",  "false", "true", "false", "false", "true", "false", "true", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Nanji G Thakor", "false", "false", "false", "true", "false", "true", "true", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Goa", "Maharashtra"},
                {"Bharat C Sheth", "false", "false", "true", "false", "false", "true", "false", "true", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Bangalore", "Karnataka"},
                {"Kiran D Khunti", "false", "false", "false", "false", "false", "false", "false", "true", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Chandigarh", "Punjab"},
                {"Surendra Rakhashia", "false", "false", "true", "false", "true", "false", "true", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Vishal J Brahmbhatt", "false", "true", "false", "true", "false", "true", "false", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Goa", "Maharashtra"},
                {"Sharad N Darji", "true", "false", "false", "false", "false", "true", "false", "true", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Ahmedabad", "Gujarat"},
                {"Khalida Momin", "false", "true", "false", "false", "true", "false", "true", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Surendra Rakhashia", "true", "false", "true", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Ahmedabad", "Gujarat"},
                {"Kaushik Dave And Associates", "false", "false", "true", "true", "false", "false", "true", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Bangalore", "Karnataka"},
                {"Jani And Company", "true", "false", "true", "false", "true", "false", "false", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Chandigarh", "Punjab"},
                {"Rajendra D Raval",  "true", "false", "true", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Chennai", "Tamil Nadu"},
                {"Pradip Rajput",  "true", "false", "false", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Coimbatore", "Tamil Nadu"},
                {"NOTERY -KIRTIKUMAR R KAPADIA",  "false", "false", "true", "false", "false", "false", "false", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Ramdas Rathor", "true", "true", "true", "false", "false", "false", "false", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Goa", "Maharashtra", },//
                {"Meenaben Thakkar",  "false", "false", "false", "false", "false", "true", "true", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Gurgaon", "Haryana"},
                {"Hasmukh L Patel", "false", "true", "false", "true", "false", "false", "false", "true", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Coimbatore", "Tamil Nadu"},
                {"Ashok M Patel",  "false", "true", "false", "false", "true", "false", "true", "false", "+(91)-9687008080","555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Nanji G Thakor", "false", "false", "false", "true", "false", "true", "true", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Goa", "Maharashtra"},
                {"Bharat C Sheth", "false", "false", "true", "false", "false", "true", "false", "true", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Bangalore", "Karnataka"},
                {"Kiran D Khunti", "false", "false", "false", "false", "false", "false", "false", "true", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Chandigarh", "Punjab"},
                {"Surendra Rakhashia", "false", "false", "true", "false", "true", "false", "true", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Delhi", "Delhi"},
                {"Vishal J Brahmbhatt", "false", "true", "false", "true", "false", "true", "false", "false", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Goa", "Maharashtra"},
                {"Sharad N Darji", "true", "false", "false", "false", "false", "true", "false", "true", "+(91)-9687008080", "555, Lakha Patel Pole, Shankadi Lane, Manek Chowk", "Ahmedabad", "Gujarat"},
                {"Istiaque Siddiqi", "true", "true", "true", "true", "true", "true", "true", "true", "+(91)-9163179724", "4, Black Burn Shankadi Lane, Manek Chowk", "Kolkata", "West Bengal"}};

        ArrayList<Lawyer> list = new ArrayList<Lawyer>();
        for(int i=1; i<lawyerArray.length; i++) {
            Lawyer lawyerInfo = new Lawyer();

            lawyerInfo.setName(lawyerArray[i][0]);

            lawyerInfo.setNotary(lawyerArray[i][1]);
            lawyerInfo.setProperty(lawyerArray[i][2]);
            lawyerInfo.setDivorce(lawyerArray[i][3]);
            lawyerInfo.setMatrimonial(lawyerArray[i][4]);
            lawyerInfo.setCriminal(lawyerArray[i][5]);
            lawyerInfo.setFamily(lawyerArray[i][6]);
            lawyerInfo.setCivil(lawyerArray[i][7]);
            lawyerInfo.setConsumer(lawyerArray[i][8]);

            lawyerInfo.setContact(lawyerArray[i][9]);

            lawyerInfo.setAddress(lawyerArray[i][10]);
            lawyerInfo.setCity(lawyerArray[i][11]);
            lawyerInfo.setState(lawyerArray[i][12]);

            list.add(lawyerInfo);
        }

        //Sorting list alphabetically based on Lawyers name
        if (list.size() > 0) {
            Collections.sort(list, new Comparator<Lawyer>() {
                @Override
                public int compare(final Lawyer lawyerObject1, final Lawyer lawyerObject2) {
                    return lawyerObject1.getName().compareTo(lawyerObject2.getName());
                }
            });
        }
        return list;
    }
}
