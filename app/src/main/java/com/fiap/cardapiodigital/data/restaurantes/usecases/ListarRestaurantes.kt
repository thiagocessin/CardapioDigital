package com.fiap.cardapiodigital.data.restaurantes.usecases

import android.util.Log
import com.fiap.cardapiodigital.data.restaurantes.model.RestaurantesModel
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum
import com.fiap.cardapiodigital.domain.usecases.restaurantes.ListarRestaurantesContract
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class ListarRestaurantes() : ListarRestaurantesContract {

    val db = FirebaseFirestore.getInstance()
    val user= Firebase.auth.currentUser!!


    override fun listarTodosRestaurantes(onResult: (ArrayList<RestauranteEntity>) -> Unit) {

        db.collection("restaurantes")
            .addSnapshotListener(){ value, _ ->
                val listaRetorno = arrayListOf<RestauranteEntity>()
                for(document in value!!){

                    val tiposRestauranteEnum = TiposRestauranteEnum.valueOf(document["tipo"].toString())
                    val restaurante = RestauranteEntity(
                        document["nome"].toString(),
                        tiposRestauranteEnum)

                    listaRetorno.add(restaurante)
                }

                Log.e("#LISTARRESTAURANTES",listaRetorno.toString())
                onResult(listaRetorno)
            }

    }

    override fun listarTodosRestaurantesPorTipo(onResult: (ArrayList<RestauranteEntity>) -> Unit) {
        TODO("Not yet implemented")
    }


    override fun criarLitaRestaurantes() {

        val arr = arrayListOf<RestaurantesModel>();
        arr.add(RestaurantesModel("Restaurante Italiano", TiposRestauranteEnum.ITALIANO))
        arr.add(RestaurantesModel("Restaurante Mexicano", TiposRestauranteEnum.MEXICANO))

        for(item: RestaurantesModel in arr){
            db.collection("restaurantes")
                .add(item)
                .addOnSuccessListener {
                    Log.e("#success", it.toString())
                }
                .addOnFailureListener(){
                    Log.e("#erro", it.message.toString())
                }
        }

    }




}
