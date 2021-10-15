package com.iweather.domain.base

sealed class Result<out T:Any>

data class Success<out T:Any>(val data:T): Result<T>()
data class Failure(val exception: Throwable): Result<Nothing>()

fun <In: Any , Out: Any> Success<In>.map(mapperFunction: (input: In) -> Out): Success<Out> =
    Success(mapperFunction(data))

fun <In: Any , Out: Any> Result<In>.map(mapperFunction: (value: In) -> Out): Result<Out> =
    when(this){
        is Success -> Success(mapperFunction(this.data))
        is Failure -> Failure(this.exception)
    }