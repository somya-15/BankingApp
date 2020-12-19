package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="transfer")
data class TransferEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="receiver_name") val receiverName: String,
    @ColumnInfo(name="money_received") val moneyReceived: Int
)