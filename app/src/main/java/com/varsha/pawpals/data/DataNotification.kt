package com.varsha.pawpals.data

import com.varsha.pawpals.R
import com.varsha.pawpals.model.Notification

data object DataNotification{
    val DataNotification = listOf(
        Notification(
            id = 1,
            user = "Pet Pals",
            content = "Give pet to Lily",
            photo = R.drawable.logo_pawpals,
            time = 1
        ),
        Notification(
            id = 2,
            user = "Pet Pals",
            content = "Give pet to Lily",
            photo = R.drawable.logo_pawpals,
            time = 1
        ),
        Notification(
            id = 3,
            user = "Pickle",
            content = "Wow Sangat Menarik",
                photo = R.drawable.profile_photo,
            time = 1
        )
    )
}