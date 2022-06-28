package com.example.periodtracker_faqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //We will need a recyclerView, arrayList for questions(& answers?), questionsAdapter, column counts
    private RecyclerView recyclerView;
    private ArrayList<Questions> questionsArrayList;
    private FAQsAdapter faqsAdapter;

    private  int gridColumnCount; //use column # in integers.xml


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //gets column count as int from integer resource file

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount)); //uses the value from the integers.xml file

        questionsArrayList = new ArrayList<>();
        faqsAdapter = new FAQsAdapter(this, questionsArrayList);
        recyclerView.setAdapter(faqsAdapter); //adapter connects data with the view

        loadQuestions(); //method defined below
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
}