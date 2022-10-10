/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        fun rand(start: Int, end: Int): Int {
            require(start <= end) { "Illegal Argument" }
            return (start..end).shuffled().first()
        }

        val drawableResource = when (rand(1,5)) {
            1 -> R.drawable.capi1_adobe_express
            2 -> R.drawable.capi2_adobe_express
            3 -> R.drawable.capi3_adobe_express
            4 -> R.drawable.capi4_adobe_express
            else -> R.drawable.capi5_adobe_express
        }

        diceImage.setImageResource(drawableResource)
    }
}
