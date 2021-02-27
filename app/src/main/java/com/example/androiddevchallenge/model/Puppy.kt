/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import java.io.Serializable

data class Puppy(
    var name: String = "",
    var age: String = "",
    var image: Int = 0
) : Serializable {
    fun getDescription(): String {
        when (name) {
            "Bella" -> {
                return "Bella loves a run, so if you’re looking for a jogging companion or someone to take long walks with, then Bella’s your best choice"
            }
            "Luna" -> {
                return "Luna will be the perfect companion for a family who wants a quiet, friendly pet with good house manners"
            }
            "Charlie" -> {
                return "Charlie does need a secure yard with high fences, but his long legs make Charlie a very good looking boy. Everyone comments on how handsome he is"
            }
            "Lucy" -> {
                return "Lucy loves a run, so if you’re looking for a jogging companion or someone to take long walks with, then Lucy’s your best choice"
            }
            "Cooper" -> {
                return "Cooper will be the perfect companion for a family who wants a quiet, friendly pet with good house manners"
            }
            "Max" -> {
                return "Max does need a secure yard with high fences, but his long legs make Max a very good looking boy. Everyone comments on how handsome he is"
            }
            "Bailey" -> {
                return "Bailey loves a run, so if you’re looking for a jogging companion or someone to take long walks with, then Bailey’s your best choice"
            }
            "Daisy" -> {
                return "Daisy will be the perfect companion for a family who wants a quiet, friendly pet with good house manners"
            }
            "Rocky" -> {
                return "Rocky does need a secure yard with high fences, but his long legs make Rocky a very good looking boy. Everyone comments on how handsome he is"
            }
            "Gary" -> {
                return "Gary loves a run, so if you’re looking for a jogging companion or someone to take long walks with, then Gary’s your best choice"
            }
            else -> {
                return ""
            }
        }
    }
}
