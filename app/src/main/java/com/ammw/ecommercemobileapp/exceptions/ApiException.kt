package com.ammw.ecommercemobileapp.exceptions

class ApiException(val code: Int, message: String): Exception(message)