package database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName= "user")
data class UserEntity(
    @PrimaryKey val name: String,
    @ColumnInfo val email: String,
    @ColumnInfo var amount: Int): Parcelable