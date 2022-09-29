package com.shoppi.kotlin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shoppi.kotlin.model.CartItem

@Dao
interface CartItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cartItem: CartItem)

    @Query("SELECT * FROM cart_item")
    fun load(): List<CartItem>
}
