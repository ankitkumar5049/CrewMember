package com.example.crew.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
interface UserDao {
    /*@Query("SELECT * FROM En")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);*/

    @Insert
    void insertAll(CrewEntity... entities);


}