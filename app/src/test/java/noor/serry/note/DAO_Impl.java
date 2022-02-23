package noor.serry.note;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAO_Impl {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TableNotes> __insertionAdapterOfTableNotes;

  private final EntityDeletionOrUpdateAdapter<TableNotes> __deletionAdapterOfTableNotes;

  private final EntityDeletionOrUpdateAdapter<TableNotes> __updateAdapterOfTableNotes;

  public DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTableNotes = new EntityInsertionAdapter<TableNotes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TableNotes` (`id`,`note`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableNotes value) {
        stmt.bindLong(1, value.getId());
        if (value.getNote() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNote());
        }
      }
    };
    this.__deletionAdapterOfTableNotes = new EntityDeletionOrUpdateAdapter<TableNotes>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TableNotes` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableNotes value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTableNotes = new EntityDeletionOrUpdateAdapter<TableNotes>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TableNotes` SET `id` = ?,`note` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableNotes value) {
        stmt.bindLong(1, value.getId());
        if (value.getNote() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNote());
        }
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public void insertNote(final TableNotes tableNotes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTableNotes.insert(tableNotes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletNote(final TableNotes tableNotes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTableNotes.handle(tableNotes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateNotes(final TableNotes tableNotes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTableNotes.handle(tableNotes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TableNotes> getDataFromDB(final int id) {
    final String _sql = "SELECT * from TableNotes where id =? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
      final List<TableNotes> _result = new ArrayList<TableNotes>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TableNotes _item;
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _item = new TableNotes(_tmpNote);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
