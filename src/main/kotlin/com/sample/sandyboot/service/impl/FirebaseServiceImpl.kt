package com.sample.sandyboot.service.impl

import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.firebase.cloud.FirestoreClient
import com.sample.sandyboot.dto.FirebaseDTO
import com.sample.sandyboot.service.FirebaseService
import org.springframework.stereotype.Service

@Service
class FirebaseServiceImpl():FirebaseService {
    override fun getDocuments(): List<FirebaseDTO>? {
        val db: Firestore = FirestoreClient.getFirestore()
        val future = db.collection("sample").get()

        val result = mutableListOf<FirebaseDTO>()
        val docs = future.get().documents

        if (docs != null) {
            for (doc in docs) {
                result.add(doc.toObject(FirebaseDTO::class.java))
            }

        }
        return result
    }

    override fun writeDocument(collection: String, docId: String, data: Map<String, Any?>): Boolean {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).document(docId).set(data)
            future
            true
        } catch (e: Exception) {
            println(e.message)
            false
        }
    }

    override fun writeDocument(collection: String, data: Map<String, Any?>): String {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).add(data)
            future.get().id
        } catch (e: Exception) {
            println(e.message)
            ""
        }
    }

//update

    override fun updateDocument(collection: String, document: String, data: Map<String, Any?>): String? {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).document(document).update(data)
            future.get().updateTime.toString()
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

//delete
    override fun deleteDocument(collection: String, document: String): String? {
        return try{
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).document(document).delete()
            future.get().updateTime.toString()
        } catch (e: Exception) {
            print(e.message)
            null
        }
    }

//search
    override fun searchDocument(
        collection: String,
        searchField: String,
        searchKeyword: String
    ): List<QueryDocumentSnapshot>? {
        return try{
            val db:Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).whereGreaterThanOrEqualTo(searchField, searchKeyword)
                .get()
            future.get().documents
        } catch (e:Exception){
            println(e.message)
            null
        }
    }
}