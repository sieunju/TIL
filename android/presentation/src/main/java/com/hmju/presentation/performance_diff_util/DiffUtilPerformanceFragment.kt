package com.hmju.presentation.performance_diff_util

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hmju.presentation.JLogger
import com.hmju.presentation.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.internal.functions.Functions
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Description : DiffUtil에 대해서 개선할 방향에 대해서 다시 생각해보니 너무 아니다 싶어서
 * 더 좋은 방안이 없는지..에 대한 고민을 한 TIL
 *
 * Created by juhongmin on 2022/02/19
 */
class DiffUtilPerformanceFragment : Fragment(R.layout.f_performance_diff_util) {

    private lateinit var number: NumberPicker
    private lateinit var tvCurrCount: TextView
    private lateinit var tvLegacy: TextView
    private lateinit var tvBetterLegacy: TextView
    private lateinit var tvBetter: TextView

    private val legacyTimeList = mutableListOf<Long>()
    private val betterLegacyTimeList = mutableListOf<Long>()
    private val betterTimeList = mutableListOf<Long>()

    private var countNumber = 100

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            number = findViewById(R.id.number)
            tvCurrCount = findViewById(R.id.tvCurrCount)
            tvLegacy = findViewById(R.id.tvLegacy)
            tvBetterLegacy = findViewById(R.id.tvBetterLegacy)
            tvBetter = findViewById(R.id.tvBetter)

            number.wrapSelectorWheel = false
            number.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            number.minValue = 100
            number.maxValue = 500

            number.setOnValueChangedListener { picker, oldVal, newVal ->
                countNumber = newVal
                tvCurrCount.text = "$newVal 번 반복"
            }

            findViewById<Button>(R.id.legacy).setOnClickListener {
                performLegacy(countNumber)
            }

            findViewById<Button>(R.id.betterLegacy).setOnClickListener {
                performBetterLegacy(countNumber)
            }

            findViewById<Button>(R.id.better).setOnClickListener {
                performBetter(countNumber)
            }
        }
    }

    class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }

    private fun flowableList(count: Int): Flowable<List<Any>> {
        return Flowable.just(count)
            .map { ranList(it) }
            .subscribeOn(Schedulers.io())
    }

    @SuppressLint("SetTextI18n")
    private fun performLegacy(count: Int) {
        legacyTimeList.clear()
        val dumpList = mutableListOf<Any>()
        val workList = mutableListOf<Flowable<List<Any>>>()
        for (idx in 0 until count) {
            workList.add(flowableList(1_000))
        }
        Flowable.fromIterable(workList)
            .map { it.blockingFirst() }
            .map { newList->
                val time = System.currentTimeMillis()
                val diffResult = DiffUtil.calculateDiff(IsLegacyDiffUtil(dumpList, newList))
                dumpList.clear()
                dumpList.addAll(newList)
                legacyTimeList.add(System.currentTimeMillis() - time)
                JLogger.d("Legacy Count ${dumpList.size}")
                return@map newList
            }
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                var sumTime = 0L
                legacyTimeList.forEach {
                    sumTime += it
                }
                tvLegacy.text = "AVG ${sumTime / legacyTimeList.size}MS"
                Toast.makeText(requireContext(), "The End", Toast.LENGTH_SHORT).show()
            }
            .subscribe({

            },{

            })
    }

    private fun performBetterLegacy(count: Int) {
        betterLegacyTimeList.clear()
        val dumpList = mutableListOf<Any>()
        val workList = mutableListOf<Flowable<List<Any>>>()
        for (idx in 0 until count) {
            workList.add(flowableList(1_000))
        }
        Flowable.fromIterable(workList)
            .map { it.blockingFirst() }
            .map { newList->
                val time = System.currentTimeMillis()
                val diffResult = DiffUtil.calculateDiff(IsLegacyDiffUtil(dumpList, newList))
                dumpList.clear()
                dumpList.addAll(newList)
                betterLegacyTimeList.add(System.currentTimeMillis() - time)
                JLogger.d("Legacy Count ${dumpList.size}")
                return@map newList
            }
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                var sumTime = 0L
                betterLegacyTimeList.forEach {
                    sumTime += it
                }
                tvBetterLegacy.text = "AVG ${sumTime / betterLegacyTimeList.size}MS"
                Toast.makeText(requireContext(), "The End", Toast.LENGTH_SHORT).show()
            }
            .subscribe({

            },{

            })
    }

    private fun performBetter(count: Int) {
        betterTimeList.clear()
        Flowable.fromCallable {
            val dumpList = mutableListOf<Any>()
            for (idx in 0 until count) {
                val time = System.currentTimeMillis()
                val newList = ranList(5_000)
                val diffResult = DiffUtil.calculateDiff(IsLegacyDiffUtil(dumpList, newList))
                dumpList.clear()
                dumpList.addAll(newList)
                betterTimeList.add(System.currentTimeMillis() - time)
                JLogger.d("Legacy Count ${dumpList.size}")
            }
            return@fromCallable dumpList
        }.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                var sumTime = 0L
                betterTimeList.forEach {
                    sumTime += it
                }
                tvBetter.text = "AVG ${sumTime / betterTimeList.size}MS"
            }
            .subscribe({

            }, {
                JLogger.e("ERROR $it")
            })
    }

    private fun ranList(size: Int): List<Any> {
        val list = mutableListOf<Any>()
        for (idx in 0 until size) {
            list.add(ranDataModel())
        }
        return list
    }

    private fun ranDataModel(): Any {
        return when (Random.nextInt(0..59)) {
            0 -> Model1()
            1 -> Model2()
            2 -> Model3()
            3 -> Model4()
            4 -> Model5()
            5 -> Model6()
            6 -> Model7()
            7 -> Model8()
            8 -> Model9()
            9 -> Model10()
            10 -> Model11()
            11 -> Model12()
            12 -> Model13()
            13 -> Model14()
            14 -> Model15()
            15 -> Model16()
            16 -> Model17()
            17 -> Model18()
            18 -> Model19()
            19 -> Model20()
            20 -> Model21()
            21 -> Model22()
            22 -> Model23()
            23 -> Model24()
            24 -> Model25()
            25 -> Model26()
            26 -> Model27()
            27 -> Model28()
            28 -> Model29()
            29 -> Model30()
            30 -> Model31()
            31 -> Model32()
            32 -> Model33()
            33 -> Model34()
            34 -> Model35()
            35 -> Model36()
            36 -> Model37()
            37 -> Model38()
            38 -> Model39()
            39 -> Model40()
            40 -> Model41()
            41 -> Model42()
            42 -> Model43()
            43 -> Model44()
            44 -> Model45()
            45 -> Model46()
            46 -> Model47()
            47 -> Model48()
            48 -> Model49()
            49 -> Model50()
            50 -> Model51()
            51 -> Model52()
            52 -> Model53()
            53 -> Model54()
            54 -> Model55()
            55 -> Model56()
            56 -> Model57()
            57 -> Model58()
            58 -> Model59()
            else -> Model60()
        }
    }
}