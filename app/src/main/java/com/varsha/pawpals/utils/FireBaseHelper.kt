package com.varsha.pawpals.utils

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.varsha.pawpals.model.FireBaseCommunity
import kotlinx.coroutines.tasks.await

fun savePostToFirestore(title: String, content: String, category: String) {
    val db = FirebaseFirestore.getInstance()
    val post = hashMapOf(
        "title" to title,
        "content" to content,
        "category" to category,
        "timestamp" to System.currentTimeMillis()
    )

    db.collection("posts")
        .add(post)
        .addOnSuccessListener { documentReference ->
            val postId = documentReference.id
            Log.d("Firestore", "DocumentSnapshot added with ID: $postId")
        }
        .addOnFailureListener { e ->
            Log.w("Firestore", "Error adding document", e)
        }
}


suspend fun getPostsFromFirestore(category: String = "All", searchQuery: String = ""): List<FireBaseCommunity> {
    val db = FirebaseFirestore.getInstance()
    return try {
        var query = db.collection("posts").limit(50)

        if (category != "All") {
            query = query.whereEqualTo("category", category)
        }
        if (searchQuery.isNotEmpty()) {
            query = query.whereGreaterThanOrEqualTo("title", searchQuery)
                .whereLessThanOrEqualTo("title", "$searchQuery\uF7FF")
        }

        val snapshot = query.get().await()
        snapshot.documents.map { document ->
            document.toObject(FireBaseCommunity::class.java)?.copy(id = document.id) ?: FireBaseCommunity()
        }
    } catch (e: Exception) {
        emptyList()
    }
}

suspend fun getPostsFromFirestore(): List<FireBaseCommunity> {
    val db = FirebaseFirestore.getInstance()
    return try {
        val querySnapshot = db.collection("posts").get().await()
        querySnapshot.documents.mapNotNull { document ->
            document.toObject(FireBaseCommunity::class.java)?.copy(id = document.id)
        }
    } catch (e: Exception) {
        emptyList()
    }
}

suspend fun getPostFromFirestore(postId: String): FireBaseCommunity? {
    val db = FirebaseFirestore.getInstance()
    return try {
        val documentSnapshot = db.collection("posts").document(postId).get().await()
        documentSnapshot.toObject(FireBaseCommunity::class.java)?.copy(id = documentSnapshot.id)
    } catch (e: Exception) {
        null
    }
}


fun deletePostFromFirestore(postId: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("posts").document(postId)
        .delete()
        .addOnSuccessListener {
            Log.d("Firestore", "DocumentSnapshot successfully deleted with ID: $postId")
            onSuccess()
        }
        .addOnFailureListener { e ->
            Log.w("Firestore", "Error deleting document with ID: $postId", e)
            onFailure(e)
        }
}
