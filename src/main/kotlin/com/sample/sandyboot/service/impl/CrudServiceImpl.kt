package com.sample.sandyboot.service.impl

import com.sample.sandyboot.dto.FirebaseDTO
import com.sample.sandyboot.service.CrudService
import com.sample.sandyboot.service.FirebaseService
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service

@Service
class CrudServiceImpl(val firebaseService: FirebaseService):CrudService {

    override fun createDocs(firebaseDTO: FirebaseDTO): Boolean {

        return try {
            val mapData = mapOf(
                "a1" to firebaseDTO.a1,
                "a2" to firebaseDTO.a2,
                "networkImage" to firebaseDTO.networkImage,
                "question" to firebaseDTO.question,
                "uid" to firebaseDTO.uid,
                "id" to RandomStringUtils.randomAlphanumeric(20)
            )
            firebaseService.writeDocument("sample", mapData["id"].toString(), mapData)
            true
        } catch (e: Exception){
            println(e.message)
            false
        }
    }

    override fun updateDocs(firebaseDTO: FirebaseDTO): Boolean {
       return try {
           val mapData = mapOf(
               "a1" to firebaseDTO.a1,
               "a2" to firebaseDTO.a2,
               "networkImage" to firebaseDTO.networkImage,
               "question" to firebaseDTO.question,
               "uid" to firebaseDTO.uid,
               "id" to firebaseDTO.id

           )
         val future = firebaseService.updateDocument("sample", mapData["id"].toString(), mapData)
           future
           true
       } catch (e:Exception){
           println(e.message)
           false
       }
    }

    override fun deleteDocs(id: String): Boolean {
       return try {
           firebaseService.deleteDocument("sample", id)
           true
       } catch (e: Exception){
           print(e.message)
           false
       }
    }

}