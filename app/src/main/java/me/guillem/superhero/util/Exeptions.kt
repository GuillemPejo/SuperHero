package me.guillem.superhero.util

/**
 ** Created by Guillem on 05/02/21.
 */
open class NetworkException(error: Throwable): RuntimeException(error)

class NoNetworkException(error: Throwable): NetworkException(error)

class ServerUnreachableException(error: Throwable): NetworkException(error)

class HttpCallFailureException(error: Throwable): NetworkException(error)

class MaxRetriesExceededException(error: Throwable): NetworkException(error)