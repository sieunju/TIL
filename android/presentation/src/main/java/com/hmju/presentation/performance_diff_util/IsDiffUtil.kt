package com.hmju.presentation.performance_diff_util

import androidx.recyclerview.widget.DiffUtil

/**
 * Description : InstanceOf 개선된 방식
 *
 * Created by juhongmin on 2022/02/19
 */
class IsDiffUtil(
    private val oldList: List<Any>,
    private val newList: List<Any>
) : DiffUtil.Callback() {
    companion object {
        inline fun <reified T : Any> compareSame(
            old: Any,
            new: Any,
            function: (T, T) -> Boolean
        ): Boolean {
            return if (old is T && new is T) {
                function(old, new)
            } else {
                false
            }
        }

        inline fun <reified R : Any> compareSame2(
            old: R,
            new: Any,
            function: (R, R) -> Boolean
        ): Boolean {
            return if (new is R) {
                function(old, new)
            } else {
                false
            }
        }
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        return when (val oldItem = oldList[oldPos]) {
            is Model1 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model2 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model3 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model4 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model5 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model6 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model7 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model8 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model9 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model10 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model11 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model12 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model13 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model14 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model15 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model16 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model17 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model18 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model19 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model20 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model21 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model22 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model23 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model24 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model25 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model26 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model27 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model28 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model29 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model30 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model31 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model32 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model33 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model34 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model35 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model36 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model37 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model38 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model39 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model40 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model41 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model42 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model43 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model44 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model45 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model46 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model47 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model48 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model49 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model50 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model51 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model52 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model53 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model54 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model55 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model56 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model57 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model58 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model59 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model60 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model61 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model62 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model63 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model64 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model65 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model66 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model67 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model68 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model69 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model70 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model71 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model72 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model73 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model74 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model75 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model76 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model77 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model78 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model79 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model80 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model81 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model82 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model83 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model84 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model85 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model86 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model87 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model88 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model89 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model90 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model91 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model92 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model93 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model94 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model95 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model96 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model97 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model98 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model99 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model100 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model101 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model102 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model103 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model104 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model105 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model106 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model107 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model108 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model109 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model110 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        return when (val oldItem = oldList[oldPos]) {
            is Model1 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model2 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model3 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model4 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model5 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model6 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model7 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model8 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model9 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model10 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model11 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model12 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model13 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model14 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model15 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model16 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model17 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model18 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model19 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model20 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model21 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model22 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model23 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model24 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model25 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model26 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model27 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model28 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model29 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model30 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model31 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model32 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model33 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model34 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model35 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model36 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model37 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model38 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model39 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model40 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model41 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model42 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model43 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model44 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model45 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model46 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model47 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model48 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model49 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model50 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model51 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model52 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model53 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model54 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model55 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model56 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model57 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model58 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model59 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model60 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model61 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model62 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model63 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model64 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model65 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model66 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model67 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model68 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model69 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model70 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model71 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model72 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model73 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model74 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model75 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model76 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model77 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model78 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model79 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model80 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model81 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model82 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model83 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model84 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model85 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model86 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model87 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model88 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model89 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model90 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model91 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model92 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model93 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model94 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model95 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model96 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model97 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model98 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model99 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model100 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model101 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model102 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model103 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model104 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model105 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model106 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model107 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model108 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model109 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model110 -> {
                compareSame2(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }
}