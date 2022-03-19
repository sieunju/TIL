package com.hmju.presentation.performance_diff_util

import androidx.recyclerview.widget.DiffUtil

/**
 * Description : InstanceOf 레거시한 방식
 *
 * Created by juhongmin on 2022/02/19
 */
class IsLegacyDiffUtil(
    private val oldList: List<Any>,
    private val newList: List<Any>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldList[oldPos]
        val newItem = newList[newPos]
        return if (oldItem is Model1 && newItem is Model1) {
            oldItem.id == newItem.id
        } else if (oldItem is Model2 && newItem is Model2) {
            oldItem.id == newItem.id
        } else if (oldItem is Model3 && newItem is Model3) {
            oldItem.id == newItem.id
        } else if (oldItem is Model4 && newItem is Model4) {
            oldItem.id == newItem.id
        } else if (oldItem is Model5 && newItem is Model5) {
            oldItem.id == newItem.id
        } else if (oldItem is Model6 && newItem is Model6) {
            oldItem.id == newItem.id
        } else if (oldItem is Model7 && newItem is Model7) {
            oldItem.id == newItem.id
        } else if (oldItem is Model8 && newItem is Model8) {
            oldItem.id == newItem.id
        } else if (oldItem is Model9 && newItem is Model9) {
            oldItem.id == newItem.id
        } else if (oldItem is Model10 && newItem is Model10) {
            oldItem.id == newItem.id
        } else if (oldItem is Model11 && newItem is Model11) {
            oldItem.id == newItem.id
        } else if (oldItem is Model12 && newItem is Model12) {
            oldItem.id == newItem.id
        } else if (oldItem is Model13 && newItem is Model13) {
            oldItem.id == newItem.id
        } else if (oldItem is Model14 && newItem is Model14) {
            oldItem.id == newItem.id
        } else if (oldItem is Model15 && newItem is Model2) {
            oldItem.id == newItem.id
        } else if (oldItem is Model16 && newItem is Model16) {
            oldItem.id == newItem.id
        } else if (oldItem is Model17 && newItem is Model17) {
            oldItem.id == newItem.id
        } else if (oldItem is Model18 && newItem is Model18) {
            oldItem.id == newItem.id
        } else if (oldItem is Model19 && newItem is Model19) {
            oldItem.id == newItem.id
        } else if (oldItem is Model20 && newItem is Model20) {
            oldItem.id == newItem.id
        } else if (oldItem is Model21 && newItem is Model21) {
            oldItem.id == newItem.id
        } else if (oldItem is Model22 && newItem is Model22) {
            oldItem.id == newItem.id
        } else if (oldItem is Model23 && newItem is Model23) {
            oldItem.id == newItem.id
        } else if (oldItem is Model24 && newItem is Model24) {
            oldItem.id == newItem.id
        } else if (oldItem is Model25 && newItem is Model25) {
            oldItem.id == newItem.id
        } else if (oldItem is Model26 && newItem is Model26) {
            oldItem.id == newItem.id
        } else if (oldItem is Model27 && newItem is Model27) {
            oldItem.id == newItem.id
        } else if (oldItem is Model28 && newItem is Model28) {
            oldItem.id == newItem.id
        } else if (oldItem is Model29 && newItem is Model29) {
            oldItem.id == newItem.id
        } else if (oldItem is Model30 && newItem is Model30) {
            oldItem.id == newItem.id
        } else if (oldItem is Model31 && newItem is Model31) {
            oldItem.id == newItem.id
        }
//        else if (oldItem is Model32 && newItem is Model32) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model33 && newItem is Model33) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model34 && newItem is Model34) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model35 && newItem is Model35) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model36 && newItem is Model36) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model37 && newItem is Model37) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model38 && newItem is Model38) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model39 && newItem is Model39) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model40 && newItem is Model40) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model41 && newItem is Model41) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model42 && newItem is Model42) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model43 && newItem is Model43) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model44 && newItem is Model44) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model45 && newItem is Model45) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model46 && newItem is Model46) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model47 && newItem is Model47) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model48 && newItem is Model48) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model49 && newItem is Model49) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model50 && newItem is Model50) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model51 && newItem is Model51) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model52 && newItem is Model52) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model53 && newItem is Model53) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model54 && newItem is Model54) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model55 && newItem is Model55) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model56 && newItem is Model56) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model57 && newItem is Model57) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model58 && newItem is Model58) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model59 && newItem is Model59) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model60 && newItem is Model60) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model61 && newItem is Model61) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model62 && newItem is Model62) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model63 && newItem is Model63) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model64 && newItem is Model64) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model65 && newItem is Model65) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model66 && newItem is Model66) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model67 && newItem is Model67) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model68 && newItem is Model68) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model69 && newItem is Model69) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model70 && newItem is Model70) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model71 && newItem is Model71) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model72 && newItem is Model72) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model73 && newItem is Model73) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model74 && newItem is Model74) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model75 && newItem is Model75) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model76 && newItem is Model76) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model77 && newItem is Model77) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model78 && newItem is Model78) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model79 && newItem is Model79) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model80 && newItem is Model80) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model81 && newItem is Model81) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model82 && newItem is Model82) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model83 && newItem is Model83) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model84 && newItem is Model84) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model85 && newItem is Model85) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model86 && newItem is Model86) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model87 && newItem is Model87) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model88 && newItem is Model88) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model89 && newItem is Model89) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model90 && newItem is Model90) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model91 && newItem is Model91) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model92 && newItem is Model92) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model93 && newItem is Model93) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model94 && newItem is Model94) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model95 && newItem is Model95) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model96 && newItem is Model96) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model97 && newItem is Model97) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model98 && newItem is Model98) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model99 && newItem is Model99) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model100 && newItem is Model100) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model101 && newItem is Model101) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model102 && newItem is Model102) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model103 && newItem is Model103) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model104 && newItem is Model104) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model105 && newItem is Model105) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model106 && newItem is Model106) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model107 && newItem is Model107) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model108 && newItem is Model108) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model109 && newItem is Model109) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model110 && newItem is Model110) {
//            oldItem.id == newItem.id
//        }
        else {
            false
        }
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        val oldItem = oldList[oldPos]
        val newItem = newList[newPos]
        return if (oldItem is Model1 && newItem is Model1) {
            oldItem.id == newItem.id
        } else if (oldItem is Model2 && newItem is Model2) {
            oldItem.id == newItem.id
        } else if (oldItem is Model3 && newItem is Model3) {
            oldItem.id == newItem.id
        } else if (oldItem is Model4 && newItem is Model4) {
            oldItem.id == newItem.id
        } else if (oldItem is Model5 && newItem is Model5) {
            oldItem.id == newItem.id
        } else if (oldItem is Model6 && newItem is Model6) {
            oldItem.id == newItem.id
        } else if (oldItem is Model7 && newItem is Model7) {
            oldItem.id == newItem.id
        } else if (oldItem is Model8 && newItem is Model8) {
            oldItem.id == newItem.id
        } else if (oldItem is Model9 && newItem is Model9) {
            oldItem.id == newItem.id
        } else if (oldItem is Model10 && newItem is Model10) {
            oldItem.id == newItem.id
        } else if (oldItem is Model11 && newItem is Model11) {
            oldItem.id == newItem.id
        } else if (oldItem is Model12 && newItem is Model12) {
            oldItem.id == newItem.id
        } else if (oldItem is Model13 && newItem is Model13) {
            oldItem.id == newItem.id
        } else if (oldItem is Model14 && newItem is Model14) {
            oldItem.id == newItem.id
        } else if (oldItem is Model15 && newItem is Model2) {
            oldItem.id == newItem.id
        } else if (oldItem is Model16 && newItem is Model16) {
            oldItem.id == newItem.id
        } else if (oldItem is Model17 && newItem is Model17) {
            oldItem.id == newItem.id
        } else if (oldItem is Model18 && newItem is Model18) {
            oldItem.id == newItem.id
        } else if (oldItem is Model19 && newItem is Model19) {
            oldItem.id == newItem.id
        } else if (oldItem is Model20 && newItem is Model20) {
            oldItem.id == newItem.id
        } else if (oldItem is Model21 && newItem is Model21) {
            oldItem.id == newItem.id
        } else if (oldItem is Model22 && newItem is Model22) {
            oldItem.id == newItem.id
        } else if (oldItem is Model23 && newItem is Model23) {
            oldItem.id == newItem.id
        } else if (oldItem is Model24 && newItem is Model24) {
            oldItem.id == newItem.id
        } else if (oldItem is Model25 && newItem is Model25) {
            oldItem.id == newItem.id
        } else if (oldItem is Model26 && newItem is Model26) {
            oldItem.id == newItem.id
        } else if (oldItem is Model27 && newItem is Model27) {
            oldItem.id == newItem.id
        } else if (oldItem is Model28 && newItem is Model28) {
            oldItem.id == newItem.id
        } else if (oldItem is Model29 && newItem is Model29) {
            oldItem.id == newItem.id
        } else if (oldItem is Model30 && newItem is Model30) {
            oldItem.id == newItem.id
        } else if (oldItem is Model31 && newItem is Model31) {
            oldItem.id == newItem.id
        }
//         else if (oldItem is Model32 && newItem is Model32) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model33 && newItem is Model33) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model34 && newItem is Model34) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model35 && newItem is Model35) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model36 && newItem is Model36) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model37 && newItem is Model37) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model38 && newItem is Model38) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model39 && newItem is Model39) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model40 && newItem is Model40) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model41 && newItem is Model41) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model42 && newItem is Model42) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model43 && newItem is Model43) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model44 && newItem is Model44) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model45 && newItem is Model45) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model46 && newItem is Model46) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model47 && newItem is Model47) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model48 && newItem is Model48) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model49 && newItem is Model49) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model50 && newItem is Model50) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model51 && newItem is Model51) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model52 && newItem is Model52) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model53 && newItem is Model53) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model54 && newItem is Model54) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model55 && newItem is Model55) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model56 && newItem is Model56) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model57 && newItem is Model57) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model58 && newItem is Model58) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model59 && newItem is Model59) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model60 && newItem is Model60) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model61 && newItem is Model61) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model62 && newItem is Model62) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model63 && newItem is Model63) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model64 && newItem is Model64) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model65 && newItem is Model65) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model66 && newItem is Model66) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model67 && newItem is Model67) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model68 && newItem is Model68) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model69 && newItem is Model69) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model70 && newItem is Model70) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model71 && newItem is Model71) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model72 && newItem is Model72) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model73 && newItem is Model73) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model74 && newItem is Model74) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model75 && newItem is Model75) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model76 && newItem is Model76) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model77 && newItem is Model77) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model78 && newItem is Model78) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model79 && newItem is Model79) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model80 && newItem is Model80) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model81 && newItem is Model81) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model82 && newItem is Model82) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model83 && newItem is Model83) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model84 && newItem is Model84) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model85 && newItem is Model85) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model86 && newItem is Model86) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model87 && newItem is Model87) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model88 && newItem is Model88) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model89 && newItem is Model89) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model90 && newItem is Model90) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model91 && newItem is Model91) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model92 && newItem is Model92) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model93 && newItem is Model93) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model94 && newItem is Model94) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model95 && newItem is Model95) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model96 && newItem is Model96) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model97 && newItem is Model97) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model98 && newItem is Model98) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model99 && newItem is Model99) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model100 && newItem is Model100) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model101 && newItem is Model101) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model102 && newItem is Model102) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model103 && newItem is Model103) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model104 && newItem is Model104) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model105 && newItem is Model105) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model106 && newItem is Model106) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model107 && newItem is Model107) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model108 && newItem is Model108) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model109 && newItem is Model109) {
//            oldItem.id == newItem.id
//        } else if (oldItem is Model110 && newItem is Model110) {
//            oldItem.id == newItem.id
//        }
        else {
            false
        }
    }
}
