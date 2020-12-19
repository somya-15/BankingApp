package database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userEntity: UserEntity)
    @Delete
    fun  deleteUser(userEntity: UserEntity)

    @Query("SELECT * FROM user")
    abstract fun readAllData(): LiveData<List<UserEntity>>

//    @Query("SELECT * FROM user where email= :email")
//    fun showTransfer(email: String): UserEntity


}