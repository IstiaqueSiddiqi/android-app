package com.example.istiaqhaq.legistify;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

import model.Lawyer;

/**
 * Created by Istiaq Haq on 11-Oct-15.
 */
public class FilterLawyer extends Activity {

    private ArrayList<String> lawFiled_list, state_list, city_list;
    private Spinner lawField, state, city;
    private String lawFieldName, stateName, cityName;
    private Button filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_lawyer);

        lawField = (Spinner)findViewById(R.id.lawField_cbx);
        lawFiled_list = new ArrayList<String>();
        lawFiled_list.add("");
        lawFiled_list.add("Notary");
        lawFiled_list.add("Property");
        lawFiled_list.add("Matrimonial");
        lawFiled_list.add("Criminal");
        lawFiled_list.add("Family");
        lawFiled_list.add("Civil");
        lawFiled_list.add("Consumer");
        Collections.sort(lawFiled_list);

        ArrayAdapter<String> lawFieldAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, lawFiled_list);
        lawFieldAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lawField.setAdapter(lawFieldAdapter);

        lawField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lawFieldName = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        state = (Spinner)findViewById(R.id.state_cbx);
        state_list = new ArrayList<String>();
        state_list.add("");
        state_list.add("Gujarat");
        state_list.add("Karnataka");
        state_list.add("Punjab");
        state_list.add("Tamil Nadu");
        state_list.add("Delhi");
        state_list.add("Maharashtra");
        state_list.add("Haryana");
        state_list.add("Telangana");
        state_list.add("Madhya Pradesh");
        state_list.add("Rajasthan");
        state_list.add("West Bengal");
        Collections.sort(state_list);

        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, state_list);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(stateAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stateName = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        city = (Spinner)findViewById(R.id.city_cbx);
        city_list = new ArrayList<String>();
        city_list.add("");
        city_list.add("Ahmedabad");
        city_list.add("Bangalore");
        city_list.add("Chandigarh");
        city_list.add("Chennai");
        city_list.add("Coimbatore");
        city_list.add("Delhi");
        city_list.add("Goa");
        city_list.add("Gurgaon");
        city_list.add("Hyderabad");
        city_list.add("Indore");
        city_list.add("Jaipur");
        city_list.add("Kolkata");
        city_list.add("Mumbai");
        Collections.sort(city_list);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, city_list);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(cityAdapter);

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityName = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        filter = (Button) findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Lawyer> filterList = getData();
                if (filterList.size() == 0) {
                    AlertDialog alertDialog = new AlertDialog.Builder(FilterLawyer.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No Record Found !!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(FilterLawyer.this, MainActivity.class);
                                    startActivity(i);
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    Intent i = new Intent(FilterLawyer.this, MainActivity.class);
                    i.putExtra("filterValue", filterList);
                    startActivity(i);
                }

            }
        });

    }

    private ArrayList<Lawyer> getData() {
        ArrayList<Lawyer> lawyerArrayList = (ArrayList<Lawyer>)getIntent().getSerializableExtra("DataStore");
        ArrayList<Lawyer> filterList = null;
        if(lawyerArrayList.size()>0) {
            filterList = new ArrayList<Lawyer>();
            for (Lawyer lawyerDetails : lawyerArrayList) {
                if (lawFieldName.equals("") &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if (lawFieldName.equals("") &&
                        stateName.equals("") &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getNotary().equals("true") && lawFieldName.equals("Notary")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getNotary().equals("true") && lawFieldName.equals("Notary")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getNotary().equals("true") && lawFieldName.equals("Notary")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getNotary().equals("true") &&
                        lawFieldName.equals("Notary")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getMatrimonial().equals("true") && lawFieldName.equals("Matrimonial")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getMatrimonial().equals("true") && lawFieldName.equals("Matrimonial")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getMatrimonial().equals("true") && lawFieldName.equals("Matrimonial")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getMatrimonial().equals("true") &&
                        lawFieldName.equals("Matrimonial")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getDivorce().equals("true") && lawFieldName.equals("Divorce")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getDivorce().equals("true") && lawFieldName.equals("Divorce")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getDivorce().equals("true") && lawFieldName.equals("Divorce")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getDivorce().equals("true") &&
                        lawFieldName.equals("Divorce")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getProperty().equals("true") && lawFieldName.equals("Property")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getProperty().equals("true") && lawFieldName.equals("Property")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getProperty().equals("true") && lawFieldName.equals("Property")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getProperty().equals("true") &&
                        lawFieldName.equals("Property")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCriminal().equals("true") && lawFieldName.equals("Criminal")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCriminal().equals("true") && lawFieldName.equals("Criminal")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCriminal().equals("true") && lawFieldName.equals("Criminal")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCriminal().equals("true") &&
                        lawFieldName.equals("Criminal")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getFamily().equals("true") && lawFieldName.equals("Family")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getFamily().equals("true") && lawFieldName.equals("Family")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getFamily().equals("true") && lawFieldName.equals("Family")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getFamily().equals("true") &&
                        lawFieldName.equals("Family")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCivil().equals("true") && lawFieldName.equals("Civil")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCivil().equals("true") && lawFieldName.equals("Civil")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCivil().equals("true") && lawFieldName.equals("Civil")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getCivil().equals("true") &&
                        lawFieldName.equals("Civil")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getConsumer().equals("true") && lawFieldName.equals("Consumer")) &&
                        stateName.equals("") && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getConsumer().equals("true") && lawFieldName.equals("Consumer")) &&
                        stateName.equals(lawyerDetails.getState()) && cityName.equals("")) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getConsumer().equals("true") && lawFieldName.equals("Consumer")) &&
                        stateName.equals("") && cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                } else if ((lawyerDetails.getConsumer().equals("true") &&
                        lawFieldName.equals("Consumer")) &&
                        stateName.equals(lawyerDetails.getState()) &&
                        cityName.equals(lawyerDetails.getCity())) {
                    filterList.add(lawyerDetails);
                }
            }
        }
        return filterList;
    }
}
