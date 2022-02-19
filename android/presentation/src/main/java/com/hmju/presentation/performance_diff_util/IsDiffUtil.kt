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
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        return when (oldList[oldPos]) {
            is Model1 -> {
                compareSame<Model1>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model2 -> {
                compareSame<Model2>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model3 -> {
                compareSame<Model3>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model4 -> {
                compareSame<Model4>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model5 -> {
                compareSame<Model5>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model6 -> {
                compareSame<Model6>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model7 -> {
                compareSame<Model7>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model8 -> {
                compareSame<Model8>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model9 -> {
                compareSame<Model9>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model10 -> {
                compareSame<Model10>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model11 -> {
                compareSame<Model11>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model12 -> {
                compareSame<Model12>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model13 -> {
                compareSame<Model13>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model14 -> {
                compareSame<Model14>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model15 -> {
                compareSame<Model15>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model16 -> {
                compareSame<Model16>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model17 -> {
                compareSame<Model17>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model18 -> {
                compareSame<Model18>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model19 -> {
                compareSame<Model19>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model20 -> {
                compareSame<Model20>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model21 -> {
                compareSame<Model21>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model22 -> {
                compareSame<Model22>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model23 -> {
                compareSame<Model23>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model24 -> {
                compareSame<Model24>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model25 -> {
                compareSame<Model25>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model26 -> {
                compareSame<Model26>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model27 -> {
                compareSame<Model27>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model28 -> {
                compareSame<Model28>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model29 -> {
                compareSame<Model29>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model30 -> {
                compareSame<Model30>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model31 -> {
                compareSame<Model31>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model32 -> {
                compareSame<Model32>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model33 -> {
                compareSame<Model33>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model34 -> {
                compareSame<Model34>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model35 -> {
                compareSame<Model35>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model36 -> {
                compareSame<Model36>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model37 -> {
                compareSame<Model37>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model38 -> {
                compareSame<Model38>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model39 -> {
                compareSame<Model39>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model40 -> {
                compareSame<Model40>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model41 -> {
                compareSame<Model41>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model42 -> {
                compareSame<Model42>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model43 -> {
                compareSame<Model43>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model44 -> {
                compareSame<Model44>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model45 -> {
                compareSame<Model45>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model46 -> {
                compareSame<Model46>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model47 -> {
                compareSame<Model47>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model48 -> {
                compareSame<Model48>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model49 -> {
                compareSame<Model49>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model50 -> {
                compareSame<Model50>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model51 -> {
                compareSame<Model51>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model52 -> {
                compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model53 -> {
                compareSame<Model53>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model54 -> {
                compareSame<Model54>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model55 -> {
                compareSame<Model55>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model56 -> {
                compareSame<Model56>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model57 -> {
                compareSame<Model57>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model58 -> {
                compareSame<Model58>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model59 -> {
                compareSame<Model59>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model60 -> {
                compareSame<Model60>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        return when (oldList[oldPos]) {
            is Model1 -> {
                compareSame<Model1>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model2 -> {
                compareSame<Model2>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model3 -> {
                compareSame<Model3>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model4 -> {
                compareSame<Model4>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model5 -> {
                compareSame<Model5>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model6 -> {
                compareSame<Model6>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model7 -> {
                compareSame<Model7>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model8 -> {
                compareSame<Model8>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model9 -> {
                compareSame<Model9>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model10 -> {
                compareSame<Model10>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model11 -> {
                compareSame<Model11>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model12 -> {
                compareSame<Model12>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model13 -> {
                compareSame<Model13>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model14 -> {
                compareSame<Model14>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model15 -> {
                compareSame<Model15>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model16 -> {
                compareSame<Model16>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model17 -> {
                compareSame<Model17>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model18 -> {
                compareSame<Model18>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model19 -> {
                compareSame<Model19>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model20 -> {
                compareSame<Model20>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model21 -> {
                compareSame<Model21>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model22 -> {
                compareSame<Model22>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model23 -> {
                compareSame<Model23>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model24 -> {
                compareSame<Model24>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model25 -> {
                compareSame<Model25>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model26 -> {
                compareSame<Model26>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model27 -> {
                compareSame<Model27>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model28 -> {
                compareSame<Model28>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model29 -> {
                compareSame<Model29>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model30 -> {
                compareSame<Model30>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model31 -> {
                compareSame<Model31>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model32 -> {
                compareSame<Model32>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model33 -> {
                compareSame<Model33>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model34 -> {
                compareSame<Model34>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model35 -> {
                compareSame<Model35>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model36 -> {
                compareSame<Model36>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model37 -> {
                compareSame<Model37>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model38 -> {
                compareSame<Model38>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model39 -> {
                compareSame<Model39>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model40 -> {
                compareSame<Model40>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model41 -> {
                compareSame<Model41>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model42 -> {
                compareSame<Model42>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model43 -> {
                compareSame<Model43>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model44 -> {
                compareSame<Model44>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model45 -> {
                compareSame<Model45>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model46 -> {
                compareSame<Model46>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model47 -> {
                compareSame<Model47>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model48 -> {
                compareSame<Model48>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model49 -> {
                compareSame<Model49>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model50 -> {
                compareSame<Model50>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model51 -> {
                compareSame<Model51>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model52 -> {
                compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model53 -> {
                compareSame<Model53>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model54 -> {
                compareSame<Model54>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model55 -> {
                compareSame<Model55>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model56 -> {
                compareSame<Model56>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model57 -> {
                compareSame<Model57>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model58 -> {
                compareSame<Model58>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model59 -> {
                compareSame<Model59>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model60 -> {
                compareSame<Model60>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }
}