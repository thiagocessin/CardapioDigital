package com.fiap.cardapiodigital.data.signUp.useCases

import com.fiap.cardapiodigital.domain.helpers.DomainError
import com.fiap.cardapiodigital.domain.usecases.signUp.MakeSignUpContract
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class MakeSignUp(
    private val auth: FirebaseAuth
) : MakeSignUpContract{

    override fun execute(
        name: String,
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (DomainError) -> Unit
    ) {
       auth.createUserWithEmailAndPassword(email, password)
           .addOnSuccessListener {
               println("onlistenerSucces")
               val currentUser = auth.currentUser

               val userProfileChangeRequest =
                   UserProfileChangeRequest.Builder().
                           setDisplayName(name).build()

               currentUser!!.updateProfile(userProfileChangeRequest)
                   .addOnCompleteListener{
                       println("onlistenerSucces1")
                       onSuccessListener()
                   }
                   .addOnFailureListener{
                       println("onlistenerErro")
                       onFailureListener(DomainError.GENERIC_ERROR)
                   }

           }
    }


}