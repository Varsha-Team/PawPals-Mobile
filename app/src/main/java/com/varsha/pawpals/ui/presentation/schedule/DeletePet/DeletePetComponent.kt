package com.varsha.pawpals.ui.presentation.schedule.DeletePet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DeletePetComponent(
    petId: Int,
    petViewModel: PetViewModel,
    onDeleted: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            //.padding(16.dp, 8.dp)
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {
        IconButton(
            onClick = {  petViewModel.deletePet(petId){
                onDeleted()
            } },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(imageVector = Icons.Filled.Delete,
                contentDescription = "delete",
                
            )
        }
    }
}

@Preview
@Composable
private fun DeletePetPrev() {
  //  DeletePetComponent(petId = Int)
}