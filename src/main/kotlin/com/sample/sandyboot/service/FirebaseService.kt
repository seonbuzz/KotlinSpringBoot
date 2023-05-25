package com.sample.sandyboot.service
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.QueryDocumentSnapshot
import  com.sample.sandyboot.dto.*

interface  FirebaseService {

//    read
    fun getDocuments(): List<FirebaseDTO>?
//    create
    fun writeDocument(collection: String, docId: String, data: Map<String, Any?>): Boolean

    fun writeDocument(collection: String, data: Map<String, Any?>): String

//    update
    fun updateDocument(collection: String, document: String, data: Map<String, Any?>): String?

//    delete
    fun deleteDocument(collection: String, document: String): String?

//    search
    fun searchDocument(collection: String, searchField: String, searchKeyword: String): List<QueryDocumentSnapshot>?
}