package noor.serry.note;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface DataAO {
    @Insert
    Completable inserNote(TableNotes tableNotes);
    @Query ("select * from TableNotes ")
    Single<List<TableNotes>> getAllNote();

}
