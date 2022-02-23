package noor.serry.note;


import static io.reactivex.schedulers.Schedulers.computation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    Intent intent;
    Repositry repositry;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            }

    @Override
    protected void onStart() {
        super.onStart ( );
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.RecyclerView1);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        repositry=new Repositry (this);
        setDataInRecycler ();
    }

    public void setDataInRecycler(){
        repositry.getdata (new AllNotes ( ) {
            @Override
            public void getAllNotes(List<TableNotes> tableNotes) {
                customAdapter=new CustomAdapter (tableNotes,new RecyclerListenerclass ());
                recyclerView=findViewById(R.id.RecyclerView1);
                recyclerView.setAdapter (customAdapter);
            }
        });
    }

    public void goToNotesActivity(View v){
         intent=new Intent(getBaseContext(),Notes.class);
         startActivity(intent);
    }

 private class RecyclerListenerclass implements RecyclerListener{
     @Override
     public void onItemClickListener(String text) {
         intent=new Intent(getBaseContext(),Notes.class);
         intent.putExtra("noteClicked",text);
         startActivity(intent);

     }
 }

    }

