package com.hmju.presentation.performance_diff_util

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import com.hmju.presentation.JLogger
import com.hmju.presentation.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executors
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Description : DiffUtil에 대해서 개선할 방향에 대해서 다시 생각해보니 너무 아니다 싶어서
 * 더 좋은 방안이 없는지..에 대한 고민을 한 TIL
 *
 * Created by juhongmin on 2022/02/19
 */
class DiffUtilPerformanceFragment : Fragment(R.layout.f_performance_diff_util) {

    private lateinit var npCount: NumberPicker
    private lateinit var npListCount: NumberPicker
    private lateinit var tvCurrCount: TextView
    private lateinit var tvListCount: TextView
    private lateinit var tvLegacy: TextView
    private lateinit var tvBetterLegacy: TextView
    private lateinit var tvBetter: TextView

    private val legacyTimeList = mutableListOf<Long>()
    private val betterLegacyTimeList = mutableListOf<Long>()
    private val betterTimeList = mutableListOf<Long>()


    private var countNumber = 100
    private var listCount = 1000

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            npCount = findViewById(R.id.npCount)
            npListCount = findViewById(R.id.npListCount)
            tvCurrCount = findViewById(R.id.tvCurrCount)
            tvListCount = findViewById(R.id.tvListCount)

            tvLegacy = findViewById(R.id.tvLegacy)
            tvBetterLegacy = findViewById(R.id.tvBetterLegacy)
            tvBetter = findViewById(R.id.tvBetter)

            npCount.wrapSelectorWheel = false
            npCount.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            npCount.minValue = 1
            npCount.maxValue = 50

            npCount.setOnValueChangedListener { picker, oldVal, newVal ->
                countNumber = newVal * 50
                tvCurrCount.text = "$countNumber 번 반복"
            }

            npListCount.wrapSelectorWheel = false
            npListCount.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            npListCount.minValue = 1
            npListCount.maxValue = 50

            npListCount.setOnValueChangedListener { picker, oldVal, newVal ->
                listCount = newVal * 500
                tvListCount.text = "리스트 $listCount 개"
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
            workList.add(flowableList(listCount))
        }
        Flowable.fromIterable(workList)
            .map { it.blockingFirst() }
            .map { newList ->
                val time = System.currentTimeMillis()
                val diffResult = DiffUtil.calculateDiff(IsLegacyDiffUtil(dumpList, newList))
                dumpList.clear()
                dumpList.addAll(newList)
                legacyTimeList.add(System.currentTimeMillis() - time)
                JLogger.d("Legacy Count ${legacyTimeList.size}")
                return@map newList
            }
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(2)))
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                var sumTime = 0L
                legacyTimeList.forEach {
                    sumTime += it
                }
                tvLegacy.text = "Legacy ${sumTime / legacyTimeList.size}MS"
                Toast.makeText(requireContext(), "Legacy The End", Toast.LENGTH_SHORT).show()
            }
            .subscribe({

            }, {

            })
    }

    @SuppressLint("SetTextI18n")
    private fun performBetterLegacy(count: Int) {
        betterLegacyTimeList.clear()
        val dumpList = mutableListOf<Any>()
        val workList = mutableListOf<Flowable<List<Any>>>()
        for (idx in 0 until count) {
            workList.add(flowableList(listCount))
        }
        Flowable.fromIterable(workList)
            .map { it.blockingFirst() }
            .map { newList ->
                val time = System.currentTimeMillis()
                val diffResult = DiffUtil.calculateDiff(IsDiffUtil(dumpList, newList))
                dumpList.clear()
                dumpList.addAll(newList)
                betterLegacyTimeList.add(System.currentTimeMillis() - time)
                JLogger.d("Better Legacy Count ${betterLegacyTimeList.size}")
                return@map newList
            }
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(2)))
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                var sumTime = 0L
                betterLegacyTimeList.forEach {
                    sumTime += it
                }
                tvBetterLegacy.text = "Better Legacy ${sumTime / betterLegacyTimeList.size}MS"
                Toast.makeText(requireContext(), "Better Legacy The End", Toast.LENGTH_SHORT).show()
            }
            .subscribe({

            }, {

            })
    }

    @SuppressLint("SetTextI18n")
    private fun performBetter(count: Int) {
        betterTimeList.clear()
        val dumpList = mutableListOf<Any>()
        val workList = mutableListOf<Flowable<List<Any>>>()
        for (idx in 0 until count) {
            workList.add(flowableList(listCount))
        }
        Flowable.fromIterable(workList)
            .map { it.blockingFirst() }
            .map { newList ->
                val time = System.currentTimeMillis()
                val diffResult = DiffUtil.calculateDiff(BetterDiffUtil(dumpList, newList))
                dumpList.clear()
                dumpList.addAll(newList)
                betterTimeList.add(System.currentTimeMillis() - time)
                JLogger.d("Better Count ${betterTimeList.size}")
                return@map newList
            }
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(2)))
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                var sumTime = 0L
                betterTimeList.forEach {
                    sumTime += it
                }
                tvBetter.text = "Better ${sumTime / betterTimeList.size}MS"
                Toast.makeText(requireContext(), "Better The End", Toast.LENGTH_SHORT).show()
            }
            .subscribe({

            }, {

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
        return when (Random.nextInt(0..110)) {
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
            59 -> Model60()
            60 -> Model61()
            61 -> Model62()
            62 -> Model63()
            63 -> Model64()
            64 -> Model65()
            65 -> Model66()
            66 -> Model67()
            67 -> Model68()
            68 -> Model69()
            69 -> Model70()
            70 -> Model71()
            71 -> Model72()
            72 -> Model73()
            73 -> Model74()
            74 -> Model75()
            75 -> Model76()
            76 -> Model77()
            77 -> Model78()
            78 -> Model79()
            79 -> Model80()
            80 -> Model81()
            81 -> Model82()
            82 -> Model83()
            83 -> Model84()
            84 -> Model85()
            85 -> Model86()
            86 -> Model87()
            87 -> Model88()
            88 -> Model89()
            89 -> Model90()
            90 -> Model91()
            91 -> Model92()
            92 -> Model93()
            93 -> Model94()
            94 -> Model95()
            95 -> Model96()
            96 -> Model97()
            97 -> Model98()
            98 -> Model99()
            99 -> Model100()
            100 -> Model101()
            101 -> Model102()
            102 -> Model103()
            103 -> Model104()
            104 -> Model105()
            105 -> Model106()
            106 -> Model107()
            107 -> Model108()
            108 -> Model109()
            109 -> Model110()
            else -> Model110()
        }
    }
}