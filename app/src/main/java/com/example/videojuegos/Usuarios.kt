package com.example.videojuegos

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
class Usuarios(private val contexto: Context) {
    companion object{
        val Context.dataStore: DataStore<Preferences>
                by preferencesDataStore(name = "configuraciones")
        val AGE = intPreferencesKey(name = "age")
        val NAME = stringPreferencesKey(name = "name")
        val CASH = floatPreferencesKey(name = "cashmoney")
    }

    //modo lectura de la info
    val age: Flow<Int> = contexto.dataStore.data.map { preferences ->
        preferences[AGE] ?: 0
    }

    val name: Flow<String> = contexto.dataStore.data.map { preferences ->
        preferences[NAME] ?: "Sin nombre asignado"
    }

    val cash: Flow<Float> = contexto.dataStore.data.map { preferences ->
        preferences[CASH] ?: 0f
    }

    //Guardar los datos
    suspend fun guardarDatosPersonales(
        edad: Int, nombre: String, cashmoney:Float
    ){
        contexto.dataStore.edit{settings->
            settings[AGE]= edad
            settings[NAME]= nombre
            settings[CASH]= cashmoney
        }
    }

}
