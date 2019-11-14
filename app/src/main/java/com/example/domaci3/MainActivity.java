package com.example.domaci3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter notesAdapter;
    private ArrayList<NoteItem> notes = new ArrayList<>();
    private EditText noteInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteInput = findViewById(R.id.note_input);
        Button addNoteBtn = findViewById(R.id.add_note_btn);
        RecyclerView recyclerView = findViewById(R.id.recycler_list);

        notes.add(new NoteItem("Test 1"));
        notes.add(new NoteItem("Test 2"));
        notes.add(new NoteItem("Test 3"));
        notes.add(new NoteItem("Lorem ipsum dolor sit amet"));

        notesAdapter = new NotesAdapter(this, notes);
        recyclerView.setAdapter(notesAdapter);

        addNoteBtn.setOnClickListener(view -> addNote());

    }

    public void addNote() {
        if (noteInput.getText().toString().length() > 0) {
            notes.add(new NoteItem(noteInput.getText().toString()));
            noteInput.setText("");
            notesAdapter.notifyDataSetChanged();
        } else {
            noteInput.setError("Empty input!");
        }
    }

}
