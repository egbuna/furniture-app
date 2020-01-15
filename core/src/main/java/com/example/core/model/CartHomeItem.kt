package com.example.core.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
class CartHomeItem() : Parcelable {
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "description")
    var description: String = ""
    @ColumnInfo(name = "rating")
    var rating: String = ""
    @ColumnInfo(name = "image")
    var image: String = ""
    @ColumnInfo(name = "price")
    var price: String = ""
    @ColumnInfo(name = "length")
    var length: String = ""
    @ColumnInfo(name = "height")
    var height: String = ""
    @ColumnInfo(name = "depth")
    var depth: String = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()!!
        description = parcel.readString()!!
        rating = parcel.readString()!!
        image = parcel.readString()!!
        price = parcel.readString()!!
        length = parcel.readString()!!
        height = parcel.readString()!!
        depth = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(rating)
        parcel.writeString(image)
        parcel.writeString(price)
        parcel.writeString(length)
        parcel.writeString(height)
        parcel.writeString(depth)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CartHomeItem> {
        override fun createFromParcel(parcel: Parcel): CartHomeItem {
            return CartHomeItem(parcel)
        }

        override fun newArray(size: Int): Array<CartHomeItem?> {
            return arrayOfNulls(size)
        }
    }
}