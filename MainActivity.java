package com.example.periodtracker_faqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //We will need a recyclerView, arrayList for questions(& answers?), questionsAdapter, column counts

    private RecyclerView recyclerView;
    private ArrayList<Questions> questionsArrayList;
    private FAQsAdapter faqsAdapter;

    private EditText searchEditText;
    private Button searchButton;

    private  int gridColumnCount; //use column # in integers.xml


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.search_edit_txt);
        searchButton = findViewById(R.id.search_button);


        gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //gets column count as int from integer resource file

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount)); //uses the value from the integers.xml file

        questionsArrayList = new ArrayList<>();
        faqsAdapter = new FAQsAdapter(this, questionsArrayList);
        recyclerView.setAdapter(faqsAdapter); //adapter connects data with the view

        loadQuestions();

    }

    private void loadQuestions() {
        questionsArrayList.clear();

        String [] questionTitles = getResources().getStringArray(R.array.questions_titles);
        String [] answersToQuestions = getResources().getStringArray(R.array.answers);

        for(int i =0; i<questionTitles.length; i++){
            questionsArrayList.add(new Questions(questionTitles[i], answersToQuestions[i]));
        }

        faqsAdapter.notifyDataSetChanged();

    }

    public void searchLocation(View view) {
        String location = searchEditText.getText().toString();

        Uri geoLoc = Uri.parse("geo: 0, 0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoLoc);

        startActivity(intent);
    }
}