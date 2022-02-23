package noor.serry.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Notes extends AppCompatActivity {
 EditText note;
 Intent intent;
RoomDB instance;
Repositry repositry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        note = findViewById(R.id.Note);
        receveNote();
instance=RoomDB.getDataBase (this);
repositry=new Repositry (this);
    }
    public void receveNote(){
     intent = getIntent();
     String textReceve = intent.getStringExtra("noteClicked");
     note.setText(textReceve);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy ( );
        repositry.insert (new TableNotes (note.getText ().toString ()));
    }



}