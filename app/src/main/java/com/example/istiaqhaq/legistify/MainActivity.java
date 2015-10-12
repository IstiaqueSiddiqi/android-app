package com.example.istiaqhaq.legistify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import adapter.CustomLawyerAdapter;
import model.Lawyer;


public class MainActivity extends ActionBarActivity {

    private ArrayList<Lawyer> list;
    private CustomLawyerAdapter adapter;
    private ListView lawyersList;
    private EditText search_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();

        search_txt = (EditText) findViewById(R.id.searchBox);
        search_txt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (0 != search_txt.getText().length()) {
                    SearchBoxResult(search_txt.getText().toString());
                } else {
                    setData();
                }
            }
        });

        ImageButton filter_btn = (ImageButton)findViewById(R.id.filterButton);
        filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,FilterLawyer.class);
                startActivity(i);
            }
        });
    }

    public void SearchBoxResult(String str) {
        ArrayList<Lawyer> searchList = new ArrayList<Lawyer>();
        for(Lawyer lawyer : list){
            if (lawyer.getName().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getState().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getCity().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getNotary().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getProperty().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getDivorce().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getMatrimonial().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getCriminal().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getFamily().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getCivil().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
            if (lawyer.getConsumer().toLowerCase().contains(str.toLowerCase())) {
                searchList.add(lawyer);
                adapter.notifyDataSetChanged();
            }
        }
        adapter = new CustomLawyerAdapter(this, searchList);
        lawyersList.setAdapter(adapter);
    }

    // Adding data to the listview
    public void setData() {

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

        list = new ArrayList<Lawyer>();
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

        try {
            filterData();
        } catch(Exception e) {
            adapter = new CustomLawyerAdapter(this, list);
        }
        // Getting ListView object ID from xml
        lawyersList = (ListView)findViewById(R.id.lawyer_list);
        lawyersList.setAdapter(adapter);
    }

    // Extracting lawyer object based on user selected options
    public void filterData() {
        ArrayList<String> filterValue = (ArrayList<String>) getIntent().getSerializableExtra("filterValue");
        if(filterValue.size()>0) {
            ArrayList<Lawyer> filterList = new ArrayList<Lawyer>();
            for(Lawyer lawyerDetails : list) {
                if(filterValue.get(0).equals("") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(filterValue.get(0).equals("") &&
                        filterValue.get(1).equals("") &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                }else if(lawyerDetails.getNotary().equals("true") && filterValue.get(0).equals("Notary") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getNotary().equals("true") && filterValue.get(0).equals("Notary") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getNotary().equals("true") && filterValue.get(0).equals("Notary") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getNotary().equals("true") &&
                        filterValue.get(0).equals("Notary")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getMatrimonial().equals("true") && filterValue.get(0).equals("Matrimonial") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getMatrimonial().equals("true") && filterValue.get(0).equals("Matrimonial") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getMatrimonial().equals("true") && filterValue.get(0).equals("Matrimonial") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getMatrimonial().equals("true") &&
                        filterValue.get(0).equals("Matrimonial")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getDivorce().equals("true") && filterValue.get(0).equals("Divorce") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getDivorce().equals("true") && filterValue.get(0).equals("Divorce") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getDivorce().equals("true") && filterValue.get(0).equals("Divorce") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getDivorce().equals("true") &&
                        filterValue.get(0).equals("Divorce")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getProperty().equals("true") && filterValue.get(0).equals("Property") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getProperty().equals("true") && filterValue.get(0).equals("Property") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getProperty().equals("true") && filterValue.get(0).equals("Property") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getProperty().equals("true") &&
                        filterValue.get(0).equals("Property")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCriminal().equals("true") && filterValue.get(0).equals("Criminal") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCriminal().equals("true") && filterValue.get(0).equals("Criminal") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCriminal().equals("true") && filterValue.get(0).equals("Criminal") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCriminal().equals("true") &&
                        filterValue.get(0).equals("Criminal")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getFamily().equals("true") && filterValue.get(0).equals("Family") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getFamily().equals("true") && filterValue.get(0).equals("Family") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getFamily().equals("true") && filterValue.get(0).equals("Family") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getFamily().equals("true") &&
                        filterValue.get(0).equals("Family")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCivil().equals("true") && filterValue.get(0).equals("Civil") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCivil().equals("true") && filterValue.get(0).equals("Civil") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCivil().equals("true") && filterValue.get(0).equals("Civil") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getCivil().equals("true") &&
                        filterValue.get(0).equals("Civil")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getConsumer().equals("true") && filterValue.get(0).equals("Consumer") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getConsumer().equals("true") && filterValue.get(0).equals("Consumer") &&
                        filterValue.get(1).equals(lawyerDetails.getState()) && filterValue.get(2).equals("")) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getConsumer().equals("true") && filterValue.get(0).equals("Consumer") &&
                        filterValue.get(1).equals("") && filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if(lawyerDetails.getConsumer().equals("true") &&
                        filterValue.get(0).equals("Consumer")&&
                        filterValue.get(1).equals(lawyerDetails.getState()) &&
                        filterValue.get(2).equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                }
            }
            adapter = new CustomLawyerAdapter(this, filterList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
