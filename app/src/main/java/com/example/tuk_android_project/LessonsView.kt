package com.example.tuk_android_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class LessonsView {
    private val modifierColumn = Modifier
        .fillMaxSize()

    @Preview(showBackground = true, device = "id:pixel_7_pro")
    @Composable
    fun MainMenuLessons(){
        Column(
            modifier = modifierColumn
        ) {
            
        }
    }

}