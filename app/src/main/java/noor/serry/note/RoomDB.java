package noor.serry.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {TableNotes.class},version = 16,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static  RoomDB instance;
    public abstract DataAO dao();


public synchronized static RoomDB getDataBase(Context context){
    if(instance==null){

        instance= Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,"noteDB").fallbackToDestructiveMigration ().build();
    }
    return instance;
}

}
