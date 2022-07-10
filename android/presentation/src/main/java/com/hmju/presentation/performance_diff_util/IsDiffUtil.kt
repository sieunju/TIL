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
        return when (val oldItem = oldList[oldPos]) {
            is Model1 -> {
                compareSame<Model1>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model2 -> {
                compareSame<Model2>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model3 -> {
                compareSame<Model3>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model4 -> {
                compareSame<Model4>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model5 -> {
                compareSame<Model5>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model6 -> {
                compareSame<Model6>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model7 -> {
                compareSame<Model7>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model8 -> {
                compareSame<Model8>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model9 -> {
                compareSame<Model9>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model10 -> {
                compareSame<Model10>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model11 -> {
                compareSame<Model11>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model12 -> {
                compareSame<Model12>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model13 -> {
                compareSame<Model13>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model14 -> {
                compareSame<Model14>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model15 -> {
                compareSame<Model15>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model16 -> {
                compareSame<Model16>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model17 -> {
                compareSame<Model17>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model18 -> {
                compareSame<Model18>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model19 -> {
                compareSame<Model19>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model20 -> {
                compareSame<Model20>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model21 -> {
                compareSame<Model21>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model22 -> {
                compareSame<Model22>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model23 -> {
                compareSame<Model23>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model24 -> {
                compareSame<Model24>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model25 -> {
                compareSame<Model25>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model26 -> {
                compareSame<Model26>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model27 -> {
                compareSame<Model27>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model28 -> {
                compareSame<Model28>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model29 -> {
                compareSame<Model29>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model30 -> {
                compareSame<Model30>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model31 -> {
                compareSame<Model31>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model32 -> {
                compareSame<Model32>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model33 -> {
                compareSame<Model33>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model34 -> {
                compareSame<Model34>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model35 -> {
                compareSame<Model35>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model36 -> {
                compareSame<Model36>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model37 -> {
                compareSame<Model37>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model38 -> {
                compareSame<Model38>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model39 -> {
                compareSame<Model39>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model40 -> {
                compareSame<Model40>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model41 -> {
                compareSame<Model41>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model42 -> {
                compareSame<Model42>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model43 -> {
                compareSame<Model43>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model44 -> {
                compareSame<Model44>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model45 -> {
                compareSame<Model45>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model46 -> {
                compareSame<Model46>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model47 -> {
                compareSame<Model47>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model48 -> {
                compareSame<Model48>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model49 -> {
                compareSame<Model49>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model50 -> {
                compareSame<Model50>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model51 -> {
                compareSame<Model51>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model52 -> {
                compareSame<Model52>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model53 -> {
                compareSame<Model53>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model54 -> {
                compareSame<Model54>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model55 -> {
                compareSame<Model55>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model56 -> {
                compareSame<Model56>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model57 -> {
                compareSame<Model57>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model58 -> {
                compareSame<Model58>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model59 -> {
                compareSame<Model59>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model60 -> {
                compareSame<Model60>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model61 -> {
                compareSame<Model61>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model62 -> {
                compareSame<Model62>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model63 -> {
                compareSame<Model63>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model64 -> {
                compareSame<Model64>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model65 -> {
                compareSame<Model65>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model66 -> {
                compareSame<Model66>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model67 -> {
                compareSame<Model67>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model68 -> {
                compareSame<Model68>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model69 -> {
                compareSame<Model69>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model70 -> {
                compareSame<Model70>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model71 -> {
                compareSame<Model71>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model72 -> {
                compareSame<Model72>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model73 -> {
                compareSame<Model73>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model74 -> {
                compareSame<Model74>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model75 -> {
                compareSame<Model75>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model76 -> {
                compareSame<Model76>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model77 -> {
                compareSame<Model77>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model78 -> {
                compareSame<Model78>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model79 -> {
                compareSame<Model79>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model80 -> {
                compareSame<Model80>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model81 -> {
                compareSame<Model81>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model82 -> {
                compareSame<Model82>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model83 -> {
                compareSame<Model83>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model84 -> {
                compareSame<Model84>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model85 -> {
                compareSame<Model85>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model86 -> {
                compareSame<Model86>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model87 -> {
                compareSame<Model87>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model88 -> {
                compareSame<Model88>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model89 -> {
                compareSame<Model89>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model90 -> {
                compareSame<Model90>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model91 -> {
                compareSame<Model91>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model92 -> {
                compareSame<Model92>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model93 -> {
                compareSame<Model93>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model94 -> {
                compareSame<Model94>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model95 -> {
                compareSame<Model95>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model96 -> {
                compareSame<Model96>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model97 -> {
                compareSame<Model97>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model98 -> {
                compareSame<Model98>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model99 -> {
                compareSame<Model99>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model100 -> {
                compareSame<Model100>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model101 -> {
                compareSame<Model101>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model102 -> {
                compareSame<Model102>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model103 -> {
                compareSame<Model103>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model104 -> {
                compareSame<Model104>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model105 -> {
                compareSame<Model105>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model106 -> {
                compareSame<Model106>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model107 -> {
                compareSame<Model107>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model108 -> {
                compareSame<Model108>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model109 -> {
                compareSame<Model109>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model110 -> {
                compareSame<Model110>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        return when (val oldItem = oldList[oldPos]) {
            is Model1 -> {
                compareSame<Model1>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model2 -> {
                compareSame<Model2>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model3 -> {
                compareSame<Model3>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model4 -> {
                compareSame<Model4>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model5 -> {
                compareSame<Model5>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model6 -> {
                compareSame<Model6>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model7 -> {
                compareSame<Model7>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model8 -> {
                compareSame<Model8>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model9 -> {
                compareSame<Model9>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model10 -> {
                compareSame<Model10>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model11 -> {
                compareSame<Model11>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model12 -> {
                compareSame<Model12>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model13 -> {
                compareSame<Model13>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model14 -> {
                compareSame<Model14>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model15 -> {
                compareSame<Model15>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model16 -> {
                compareSame<Model16>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model17 -> {
                compareSame<Model17>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model18 -> {
                compareSame<Model18>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model19 -> {
                compareSame<Model19>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model20 -> {
                compareSame<Model20>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model21 -> {
                compareSame<Model21>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model22 -> {
                compareSame<Model22>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model23 -> {
                compareSame<Model23>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model24 -> {
                compareSame<Model24>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model25 -> {
                compareSame<Model25>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model26 -> {
                compareSame<Model26>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model27 -> {
                compareSame<Model27>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model28 -> {
                compareSame<Model28>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model29 -> {
                compareSame<Model29>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model30 -> {
                compareSame<Model30>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model31 -> {
                compareSame<Model31>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model32 -> {
                compareSame<Model32>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model33 -> {
                compareSame<Model33>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model34 -> {
                compareSame<Model34>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model35 -> {
                compareSame<Model35>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model36 -> {
                compareSame<Model36>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model37 -> {
                compareSame<Model37>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model38 -> {
                compareSame<Model38>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model39 -> {
                compareSame<Model39>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model40 -> {
                compareSame<Model40>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model41 -> {
                compareSame<Model41>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model42 -> {
                compareSame<Model42>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model43 -> {
                compareSame<Model43>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model44 -> {
                compareSame<Model44>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model45 -> {
                compareSame<Model45>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model46 -> {
                compareSame<Model46>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model47 -> {
                compareSame<Model47>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model48 -> {
                compareSame<Model48>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model49 -> {
                compareSame<Model49>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model50 -> {
                compareSame<Model50>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model51 -> {
                compareSame<Model51>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model52 -> {
                compareSame<Model52>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model53 -> {
                compareSame<Model53>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model54 -> {
                compareSame<Model54>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model55 -> {
                compareSame<Model55>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model56 -> {
                compareSame<Model56>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model57 -> {
                compareSame<Model57>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model58 -> {
                compareSame<Model58>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model59 -> {
                compareSame<Model59>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model60 -> {
                compareSame<Model60>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model61 -> {
                compareSame<Model61>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model62 -> {
                compareSame<Model62>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model63 -> {
                compareSame<Model63>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model64 -> {
                compareSame<Model64>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model65 -> {
                compareSame<Model65>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model66 -> {
                compareSame<Model66>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model67 -> {
                compareSame<Model67>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model68 -> {
                compareSame<Model68>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model69 -> {
                compareSame<Model69>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model70 -> {
                compareSame<Model70>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model71 -> {
                compareSame<Model71>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model72 -> {
                compareSame<Model72>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model73 -> {
                compareSame<Model73>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model74 -> {
                compareSame<Model74>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model75 -> {
                compareSame<Model75>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model76 -> {
                compareSame<Model76>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model77 -> {
                compareSame<Model77>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model78 -> {
                compareSame<Model78>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model79 -> {
                compareSame<Model79>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model80 -> {
                compareSame<Model80>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model81 -> {
                compareSame<Model81>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model82 -> {
                compareSame<Model82>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model83 -> {
                compareSame<Model83>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model84 -> {
                compareSame<Model84>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model85 -> {
                compareSame<Model85>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model86 -> {
                compareSame<Model86>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model87 -> {
                compareSame<Model87>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model88 -> {
                compareSame<Model88>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model89 -> {
                compareSame<Model89>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model90 -> {
                compareSame<Model90>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model91 -> {
                compareSame<Model91>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model92 -> {
                compareSame<Model92>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model93 -> {
                compareSame<Model93>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model94 -> {
                compareSame<Model94>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model95 -> {
                compareSame<Model95>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model96 -> {
                compareSame<Model96>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model97 -> {
                compareSame<Model97>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model98 -> {
                compareSame<Model98>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model99 -> {
                compareSame<Model99>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model100 -> {
                compareSame<Model100>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model101 -> {
                compareSame<Model101>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model102 -> {
                compareSame<Model102>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model103 -> {
                compareSame<Model103>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model104 -> {
                compareSame<Model104>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model105 -> {
                compareSame<Model105>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model106 -> {
                compareSame<Model106>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model107 -> {
                compareSame<Model107>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model108 -> {
                compareSame<Model108>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model109 -> {
                compareSame<Model109>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            is Model110 -> {
                compareSame<Model110>(oldItem, newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }
}