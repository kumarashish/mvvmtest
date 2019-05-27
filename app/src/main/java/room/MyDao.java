package room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import model.Result;

@Dao
public interface MyDao {
    @Insert
    public void addResult(Data data);
    @Query("Select * from Results")
    public List<Data> getResult();
    @Query("DELETE FROM Results")
    public void clearTable();
}
