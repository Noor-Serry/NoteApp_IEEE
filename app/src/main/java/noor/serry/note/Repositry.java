package noor.serry.note;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Repositry {
    DataAO dataAO;
    public Repositry (Context context){
        RoomDB roomDB=RoomDB.getDataBase (context);
        dataAO=roomDB.dao ();
    }
    public void insert( TableNotes tableNotes){
        dataAO.inserNote (tableNotes).subscribeOn (Schedulers.computation ())
                .subscribe (new CompletableObserver ( ) {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    public void getdata( AllNotes allNotes)

    {


        dataAO.getAllNote ( ). subscribeOn (Schedulers.computation ( ))
                .observeOn (AndroidSchedulers.mainThread ( ))
                .subscribe (new SingleObserver<List<TableNotes>> ( ) {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<TableNotes> tableNotes) {
                        allNotes.getAllNotes (tableNotes);
                    }


                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });


    }
}
