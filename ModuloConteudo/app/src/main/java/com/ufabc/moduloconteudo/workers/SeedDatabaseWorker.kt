package com.ufabc.moduloconteudo.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ufabc.moduloconteudo.data.AppDatabase
import com.ufabc.moduloconteudo.data.aula.Aula
import com.ufabc.moduloconteudo.data.discente.Discente
import com.ufabc.moduloconteudo.data.discente_turma.DiscenteTurma
import com.ufabc.moduloconteudo.data.turma.Turma
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class SeedDatabaseWorker (
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters){
    override suspend fun doWork(): Result = coroutineScope{
        try {
            // TODO: SEED DATABASE AUTOMATICALLY
            // https://github.com/android/sunflower/blob/master/app/src/main/java/com/google/samples/apps/sunflower/workers/SeedDatabaseWorker.kt

            val database = AppDatabase.getInstance(applicationContext)

            database.discenteDao().insertDiscente(
                Discente(
                    "123123",
                    "wesley",
                    "pereira"
                )
            )

            database.discenteDao().insertDiscente(
                Discente(
                    "123124",
                    "wesley",
                    "pereira"
                )
            )

            database.aulaDao().insertAula(
                Aula(
                    "A123FUV",
                    8,
                    10,
                    0,
                    "Funções de uma Variável",
                    0,
                    "Denise",
                    "Goya",
                    true,
                    true,
                    "302-1"
                )
            )

            database.aulaDao().insertAula(
                Aula(
                    "A123GA",
                    10,
                    12,
                    0,
                    "Geometria Analítica",
                    0,
                    "Denise",
                    "Goya",
                    true,
                    true,
                    "302-1"
                )
            )

            Result.success()

        } catch (ex: Exception) {
            Log.e(SeedDatabaseWorker::class.java.simpleName, "Error seeding database", ex)
            Result.failure()
        }
    }

}