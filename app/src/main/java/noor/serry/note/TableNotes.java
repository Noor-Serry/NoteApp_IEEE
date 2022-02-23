package noor.serry.note;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableNotes {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String note;

    public TableNotes(String note){
        this.note=note;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }



}
