package database

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<UserEntity>> = userDao.readAllData()
    suspend fun insertUser(userEntity: UserEntity) {
        userDao.addUser(userEntity)

    }
}