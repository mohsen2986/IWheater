package com.iweather.domain.base

sealed class DataHolder<out T:Any>

data class Success<out T:Any>(val data:T): DataHolder<T>()
data class Failure(val exception: Throwable): DataHolder<Nothing>()
object Loading: DataHolder<Nothing>()

fun <In: Any , Out: Any> Success<In>.map(mapperFunction: (input: In) -> Out): Success<Out> =
    Success(mapperFunction(data))

fun <In: Any , Out: Any> DataHolder<In>.map(mapperFunction: (value: In) -> Out): DataHolder<Out> =
    when(this){
        is Success -> Success(mapperFunction(this.data))
        is Failure -> Failure(this.exception)
        is Loading -> Loading
    }