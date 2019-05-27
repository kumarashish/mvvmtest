package room;

import androidx.room.RoomDatabase;
@androidx.room.Database(entities = Data.class,version = 1)
public abstract class Database extends RoomDatabase {
    public abstract MyDao Dao();
}
