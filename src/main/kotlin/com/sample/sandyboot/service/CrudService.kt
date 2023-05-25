package com.sample.sandyboot.service

import com.sample.sandyboot.dto.FirebaseDTO

interface CrudService {
    //  create
    fun createDocs(firebaseDTO: FirebaseDTO): Boolean
    // update
    fun updateDocs(firebaseDTO: FirebaseDTO): Boolean
    // delete
    fun deleteDocs(id: String): Boolean

}