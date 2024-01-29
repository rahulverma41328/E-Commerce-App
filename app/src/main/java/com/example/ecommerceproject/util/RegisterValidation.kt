package com.example.ecommerceproject.util
// what is sealed class
sealed class RegisterValidation(){
    object Success: RegisterValidation()
    data class Failed(val message:String): RegisterValidation()
}
// why we create data class
data class RegisterFieldState(
    val email: RegisterValidation,
    val password: RegisterValidation
)