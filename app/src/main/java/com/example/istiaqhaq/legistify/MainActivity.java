package com.example.istiaqhaq.legistify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import adapter.CustomLawyerAdapter;
import model.Lawyer;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Lawyer> lawyerArrayList;
    private CustomLawyerAdapter adapter;
    private ListView lawyersListView;
    private EditText search_txt;
    private ProgressBar progressBar;
    private Handler mHandler;
    private boolean hasCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();
        //inflate the progress bar from the footer, it is wrapped in a RelativeLayout since
        //ListViews don't shrink in height when a child is set to visibility gone, but
        //a RelativeLayout with height of wrap_content will
        View footer = getLayoutInflater().inflate(R.layout.load_more, null);
        progressBar = (ProgressBar) footer.findViewById(R.id.progressBar);

        // Getting ListView object ID from xml
        lawyersListView = (ListView)findViewById(R.id.lawyer_list);
        lawyersListView.addFooterView(footer);
        setListView();

        lawyersListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && !adapter.endReached() && !hasCallback) { //check if we've reached the bottom
                    mHandler.postDelayed(showMore, 500);
                    hasCallback = true;
                }
            }
        });

        ImageButton filter_btn = (ImageButton)findViewById(R.id.filterButton);
        filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FilterLawyer.class);
                i.putExtra("DataStore", lawyerArrayList);
                startActivity(i);
            }
        });

        search_txt = (EditText) findViewById(R.id.searchBox);
        search_txt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (search_txt.getText().length() != 0) {
                    SearchBoxResult(search_txt.getText().toString());
                } else {
                    setListView();
                }
            }
        });
    }

    // Adding data to the listview
    public void setListView() {
        lawyerArrayList = new LawyerInformation().getData();
        try {
            filterData();
        } catch(Exception e) {
            if(lawyerArrayList.size()>10) {
                setMyAdapter(this, lawyerArrayList, 10, 10);
            } else {
                setMyAdapter(this, lawyerArrayList, lawyerArrayList.size(), lawyerArrayList.size());
                progressBar.setVisibility((10 < lawyerArrayList.size()) ? View.VISIBLE : View.GONE);
            }
        }
    }

    private void setMyAdapter(Activity context, ArrayList<Lawyer> list, int startCount, int stepNumber) {
        adapter = new CustomLawyerAdapter(this, list, startCount, stepNumber);
        lawyersListView.setAdapter(adapter);
    }

    // Extracting lawyer object based on user selected options
    public void filterData() {
        ArrayList<Lawyer> filteredLawyerList = (ArrayList<Lawyer>) getIntent().getSerializableExtra("filterValue");
        if (filteredLawyerList.size() > 0) {
            if(filteredLawyerList.size()>10) {
                setMyAdapter(this, filteredLawyerList, 10, 10);
            } else {
                setMyAdapter(this, filteredLawyerList, filteredLawyerList.size(), filteredLawyerList.size());
                progressBar.setVisibility((10 < filteredLawyerList.size()) ? View.VISIBLE : View.GONE);
            }
        }
    }

    public void SearchBoxResult(String str) {
        ArrayList<Lawyer> searchList = new ArrayList<Lawyer>();
        for(Lawyer lawyer : lawyerArrayList){
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

        if(searchList.size()>10) {
            setMyAdapter(this, searchList, 10, 10);
        } else {
            setMyAdapter(this, searchList, searchList.size(), searchList.size());
            progressBar.setVisibility((10 < searchList.size()) ? View.VISIBLE : View.GONE);
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
        if (id == R.id.action_reset) {
            //adapter.reset(); //reset the adapter to its initial configuration
            //lawyersListView.setSelection(0); //go to the top
            if(lawyerArrayList.size()>10) {
                setMyAdapter(this, lawyerArrayList, 10, 10);
            } else {
                setMyAdapter(this, lawyerArrayList, lawyerArrayList.size(), lawyerArrayList.size());
                progressBar.setVisibility((10 < lawyerArrayList.size()) ? View.VISIBLE : View.GONE);
            }
            search_txt.setText("");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Runnable showMore = new Runnable(){
        @Override
        public void run(){
            boolean noMoreToShow = adapter.showMore(); //show more views and find out if
            progressBar.setVisibility(noMoreToShow? View.GONE : View.VISIBLE);
            hasCallback = false;
        }
    };
}
