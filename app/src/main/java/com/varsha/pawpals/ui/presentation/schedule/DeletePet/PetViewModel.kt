package com.varsha.pawpals.ui.presentation.schedule.DeletePet

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.varsha.pawpals.data.DataPet
import com.varsha.pawpals.model.PetData
import com.varsha.pawpals.utils.SQLiteHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PetViewModel(application: Application) : AndroidViewModel(application) {

    private val dbHelper: SQLiteHelper = SQLiteHelper(application)

    private val _petLiveData = MutableLiveData<PetData?>()
    val petLiveData: LiveData<PetData?> = _petLiveData

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchPetById(petId: Int) {
        viewModelScope.launch {
            val db = SQLiteHelper(getApplication())
            val pet = db.getAllPets().firstOrNull { it.id == petId }
            _petLiveData.postValue(pet)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updatePet(pet: PetData, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dbHelper.updatePet(pet)
            if (result > 0) {
                onSuccess()
            }
        }
    }

    fun deletePet(petId: Int, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dbHelper.deletePet(petId)
            if (result > 0) {
                onSuccess()
            }
        }
    }
}