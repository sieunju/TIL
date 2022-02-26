package com.hmju.presentation.performance_diff_util

import androidx.recyclerview.widget.DiffUtil

/**
 * Description :
 *
 * Created by juhongmin on 2022/02/19
 */
class BetterDiffUtil(
    private val oldList: List<Any>,
    private val newList: List<Any>
) : DiffUtil.Callback() {

    companion object {
        val diffMap: HashMap<Any, String> by lazy { HashMap() }
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    private fun getSimpleNameMap(obj: Any): String {
        if (!diffMap.containsKey(obj)) {
            diffMap[obj] = obj::class.java.simpleName
        }
        return diffMap[obj] ?: ""
    }

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
//        val simpleName = getSimpleNameMap(oldList[oldPos])
//        JLogger.d("SimpleName $simpleName")
        return when (getSimpleNameMap(oldList[oldPos])) {
            "Model1" -> {
                IsDiffUtil.compareSame<Model1>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model2" -> {
                IsDiffUtil.compareSame<Model2>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model3" -> {
                IsDiffUtil.compareSame<Model3>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model4" -> {
                IsDiffUtil.compareSame<Model4>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model5" -> {
                IsDiffUtil.compareSame<Model5>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model6" -> {
                IsDiffUtil.compareSame<Model6>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model7" -> {
                IsDiffUtil.compareSame<Model7>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model8" -> {
                IsDiffUtil.compareSame<Model8>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model9" -> {
                IsDiffUtil.compareSame<Model9>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model10" -> {
                IsDiffUtil.compareSame<Model10>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model11" -> {
                IsDiffUtil.compareSame<Model11>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model12" -> {
                IsDiffUtil.compareSame<Model12>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model13" -> {
                IsDiffUtil.compareSame<Model13>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model14" -> {
                IsDiffUtil.compareSame<Model14>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model15" -> {
                IsDiffUtil.compareSame<Model15>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model16" -> {
                IsDiffUtil.compareSame<Model16>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model17" -> {
                IsDiffUtil.compareSame<Model17>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model18" -> {
                IsDiffUtil.compareSame<Model18>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model19" -> {
                IsDiffUtil.compareSame<Model19>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model20" -> {
                IsDiffUtil.compareSame<Model20>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model21" -> {
                IsDiffUtil.compareSame<Model21>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model22" -> {
                IsDiffUtil.compareSame<Model22>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model23" -> {
                IsDiffUtil.compareSame<Model23>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model24" -> {
                IsDiffUtil.compareSame<Model24>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model25" -> {
                IsDiffUtil.compareSame<Model25>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model26" -> {
                IsDiffUtil.compareSame<Model26>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model27" -> {
                IsDiffUtil.compareSame<Model27>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model28" -> {
                IsDiffUtil.compareSame<Model28>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model29" -> {
                IsDiffUtil.compareSame<Model29>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model30" -> {
                IsDiffUtil.compareSame<Model30>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model31" -> {
                IsDiffUtil.compareSame<Model31>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model32" -> {
                IsDiffUtil.compareSame<Model32>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model33" -> {
                IsDiffUtil.compareSame<Model33>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model34" -> {
                IsDiffUtil.compareSame<Model34>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model35" -> {
                IsDiffUtil.compareSame<Model35>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model36" -> {
                IsDiffUtil.compareSame<Model36>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model37" -> {
                IsDiffUtil.compareSame<Model37>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model38" -> {
                IsDiffUtil.compareSame<Model38>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model39" -> {
                IsDiffUtil.compareSame<Model39>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model40" -> {
                IsDiffUtil.compareSame<Model40>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model41" -> {
                IsDiffUtil.compareSame<Model41>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model42" -> {
                IsDiffUtil.compareSame<Model42>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model43" -> {
                IsDiffUtil.compareSame<Model43>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model44" -> {
                IsDiffUtil.compareSame<Model44>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model45" -> {
                IsDiffUtil.compareSame<Model45>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model46" -> {
                IsDiffUtil.compareSame<Model46>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model47" -> {
                IsDiffUtil.compareSame<Model47>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model48" -> {
                IsDiffUtil.compareSame<Model48>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model49" -> {
                IsDiffUtil.compareSame<Model49>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model50" -> {
                IsDiffUtil.compareSame<Model50>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model51" -> {
                IsDiffUtil.compareSame<Model51>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model52" -> {
                IsDiffUtil.compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model53" -> {
                IsDiffUtil.compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model54" -> {
                IsDiffUtil.compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model55" -> {
                IsDiffUtil.compareSame<Model55>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model56" -> {
                IsDiffUtil.compareSame<Model56>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model57" -> {
                IsDiffUtil.compareSame<Model57>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model58" -> {
                IsDiffUtil.compareSame<Model58>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model59" -> {
                IsDiffUtil.compareSame<Model59>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model60" -> {
                IsDiffUtil.compareSame<Model60>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model61" -> {
                IsDiffUtil.compareSame<Model61>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model62" -> {
                IsDiffUtil.compareSame<Model62>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model63" -> {
                IsDiffUtil.compareSame<Model63>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model64" -> {
                IsDiffUtil.compareSame<Model64>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model65" -> {
                IsDiffUtil.compareSame<Model65>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model66" -> {
                IsDiffUtil.compareSame<Model66>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model67" -> {
                IsDiffUtil.compareSame<Model67>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model68" -> {
                IsDiffUtil.compareSame<Model68>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model69" -> {
                IsDiffUtil.compareSame<Model69>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model70" -> {
                IsDiffUtil.compareSame<Model70>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model71" -> {
                IsDiffUtil.compareSame<Model71>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model72" -> {
                IsDiffUtil.compareSame<Model72>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model73" -> {
                IsDiffUtil.compareSame<Model73>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model74" -> {
                IsDiffUtil.compareSame<Model74>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model75" -> {
                IsDiffUtil.compareSame<Model75>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model76" -> {
                IsDiffUtil.compareSame<Model76>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model77" -> {
                IsDiffUtil.compareSame<Model77>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model78" -> {
                IsDiffUtil.compareSame<Model78>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model79" -> {
                IsDiffUtil.compareSame<Model79>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model80" -> {
                IsDiffUtil.compareSame<Model80>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model81" -> {
                IsDiffUtil.compareSame<Model81>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model82" -> {
                IsDiffUtil.compareSame<Model82>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model83" -> {
                IsDiffUtil.compareSame<Model83>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model84" -> {
                IsDiffUtil.compareSame<Model84>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model85" -> {
                IsDiffUtil.compareSame<Model85>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model86" -> {
                IsDiffUtil.compareSame<Model86>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model87" -> {
                IsDiffUtil.compareSame<Model87>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model88" -> {
                IsDiffUtil.compareSame<Model88>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model89" -> {
                IsDiffUtil.compareSame<Model89>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model90" -> {
                IsDiffUtil.compareSame<Model90>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model91" -> {
                IsDiffUtil.compareSame<Model91>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model92" -> {
                IsDiffUtil.compareSame<Model92>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model93" -> {
                IsDiffUtil.compareSame<Model93>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model94" -> {
                IsDiffUtil.compareSame<Model94>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model95" -> {
                IsDiffUtil.compareSame<Model95>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model96" -> {
                IsDiffUtil.compareSame<Model96>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model97" -> {
                IsDiffUtil.compareSame<Model97>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model98" -> {
                IsDiffUtil.compareSame<Model98>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model99" -> {
                IsDiffUtil.compareSame<Model99>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model100" -> {
                IsDiffUtil.compareSame<Model100>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model101" -> {
                IsDiffUtil.compareSame<Model101>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model102" -> {
                IsDiffUtil.compareSame<Model102>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model103" -> {
                IsDiffUtil.compareSame<Model103>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model104" -> {
                IsDiffUtil.compareSame<Model104>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model105" -> {
                IsDiffUtil.compareSame<Model105>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model106" -> {
                IsDiffUtil.compareSame<Model106>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model107" -> {
                IsDiffUtil.compareSame<Model107>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model108" -> {
                IsDiffUtil.compareSame<Model108>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model109" -> {
                IsDiffUtil.compareSame<Model109>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model110" -> {
                IsDiffUtil.compareSame<Model110>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        return when (getSimpleNameMap(oldList[oldPos])) {
            "Model1" -> {
                IsDiffUtil.compareSame<Model1>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model2" -> {
                IsDiffUtil.compareSame<Model2>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model3" -> {
                IsDiffUtil.compareSame<Model3>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model4" -> {
                IsDiffUtil.compareSame<Model4>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model5" -> {
                IsDiffUtil.compareSame<Model5>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model6" -> {
                IsDiffUtil.compareSame<Model6>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model7" -> {
                IsDiffUtil.compareSame<Model7>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model8" -> {
                IsDiffUtil.compareSame<Model8>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model9" -> {
                IsDiffUtil.compareSame<Model9>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model10" -> {
                IsDiffUtil.compareSame<Model10>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model11" -> {
                IsDiffUtil.compareSame<Model11>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model12" -> {
                IsDiffUtil.compareSame<Model12>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model13" -> {
                IsDiffUtil.compareSame<Model13>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model14" -> {
                IsDiffUtil.compareSame<Model14>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model15" -> {
                IsDiffUtil.compareSame<Model15>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model16" -> {
                IsDiffUtil.compareSame<Model16>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model17" -> {
                IsDiffUtil.compareSame<Model17>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model18" -> {
                IsDiffUtil.compareSame<Model18>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model19" -> {
                IsDiffUtil.compareSame<Model19>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model20" -> {
                IsDiffUtil.compareSame<Model20>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model21" -> {
                IsDiffUtil.compareSame<Model21>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model22" -> {
                IsDiffUtil.compareSame<Model22>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model23" -> {
                IsDiffUtil.compareSame<Model23>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model24" -> {
                IsDiffUtil.compareSame<Model24>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model25" -> {
                IsDiffUtil.compareSame<Model25>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model26" -> {
                IsDiffUtil.compareSame<Model26>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model27" -> {
                IsDiffUtil.compareSame<Model27>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model28" -> {
                IsDiffUtil.compareSame<Model28>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model29" -> {
                IsDiffUtil.compareSame<Model29>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model30" -> {
                IsDiffUtil.compareSame<Model30>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model31" -> {
                IsDiffUtil.compareSame<Model31>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model32" -> {
                IsDiffUtil.compareSame<Model32>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model33" -> {
                IsDiffUtil.compareSame<Model33>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model34" -> {
                IsDiffUtil.compareSame<Model34>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model35" -> {
                IsDiffUtil.compareSame<Model35>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model36" -> {
                IsDiffUtil.compareSame<Model36>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model37" -> {
                IsDiffUtil.compareSame<Model37>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model38" -> {
                IsDiffUtil.compareSame<Model38>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model39" -> {
                IsDiffUtil.compareSame<Model39>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model40" -> {
                IsDiffUtil.compareSame<Model40>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model41" -> {
                IsDiffUtil.compareSame<Model41>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model42" -> {
                IsDiffUtil.compareSame<Model42>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model43" -> {
                IsDiffUtil.compareSame<Model43>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model44" -> {
                IsDiffUtil.compareSame<Model44>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model45" -> {
                IsDiffUtil.compareSame<Model45>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model46" -> {
                IsDiffUtil.compareSame<Model46>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model47" -> {
                IsDiffUtil.compareSame<Model47>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model48" -> {
                IsDiffUtil.compareSame<Model48>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model49" -> {
                IsDiffUtil.compareSame<Model49>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model50" -> {
                IsDiffUtil.compareSame<Model50>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model51" -> {
                IsDiffUtil.compareSame<Model51>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model52" -> {
                IsDiffUtil.compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model53" -> {
                IsDiffUtil.compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model54" -> {
                IsDiffUtil.compareSame<Model52>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model55" -> {
                IsDiffUtil.compareSame<Model55>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model56" -> {
                IsDiffUtil.compareSame<Model56>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model57" -> {
                IsDiffUtil.compareSame<Model57>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model58" -> {
                IsDiffUtil.compareSame<Model58>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model59" -> {
                IsDiffUtil.compareSame<Model59>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            "Model60" -> {
                IsDiffUtil.compareSame<Model60>(oldList[oldPos], newList[newPos]) { old, new ->
                    old.id == new.id
                }
            }
            else -> false
        }
    }
}