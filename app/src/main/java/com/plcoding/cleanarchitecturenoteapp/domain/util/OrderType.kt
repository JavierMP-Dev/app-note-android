package com.plcoding.cleanarchitecturenoteapp.domain.util

import androidx.room.FtsOptions.Order

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}