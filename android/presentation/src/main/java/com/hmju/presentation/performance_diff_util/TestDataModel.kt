package com.hmju.presentation.performance_diff_util

import com.hmju.presentation.refactor_diff_util.BaseUiModel
import kotlin.random.Random

data class Model1(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model1"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model1) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model1) {
            id == diffItem.id
        } else {
            false
        }
    }
}

data class Model2(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model2"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model2) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model2) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model3(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model3"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model3) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model3) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model4(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model4"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model4) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model4) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model5(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model5"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model5) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model5) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model6(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model6"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model6) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model6) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model7(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model7"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model7) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model7) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model8(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model8"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model8) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model8) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model9(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model9"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model9) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model9) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model10(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model10"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model10) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model10) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model11(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model11"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model11) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model11) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model12(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model12"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model12) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model12) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model13(val id: Long = Random.nextLong()) : BaseUiModel(-1){
    override fun getClassName() = "Model13"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model13) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model13) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model14(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model14"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model14) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model14) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model15(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model15"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model15) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model15) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model16(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model16"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model16) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model16) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model17(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model17"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model17) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model17) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model18(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model18"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model18) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model18) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model19(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model19"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model19) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model19) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model20(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model20"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model20) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model20) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model21(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model21"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model21) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model21) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model22(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model22"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model22) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model22) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model23(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model23"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model23) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model23) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model24(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model24"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model24) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model24) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model25(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model25"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model25) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model25) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model26(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model26"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model26) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model26) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model27(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model27"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model27) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model27) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model28(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model28"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model28) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model28) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model29(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model29"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model29) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model29) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model30(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model30"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model30) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model30) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model31(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model31"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model31) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model31) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model32(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model32"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model32) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model32) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model33(val id: Long = Random.nextLong()) : BaseUiModel(-1){
    override fun getClassName() = "Model33"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model33) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model33) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model34(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model34"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model34) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model34) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model35(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model35"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model35) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model35) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model36(val id: Long = Random.nextLong()) : BaseUiModel(-1){
    override fun getClassName() = "Model36"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model36) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model36) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model37(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model37"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model37) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model37) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model38(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model38"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model38) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model38) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model39(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model39"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model39) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model39) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model40(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model40"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model40) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model40) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model41(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model41"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model41) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model41) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model42(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model42"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model42) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model42) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model43(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model43"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model43) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model43) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model44(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model44"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model44) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model44) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model45(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model45"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model45) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model45) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model46(val id: Long = Random.nextLong()): BaseUiModel(-1) {
    override fun getClassName() = "Model46"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model46) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model46) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model47(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model47"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model47) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model47) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model48(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model48"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model48) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model48) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model49(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model49"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model49) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model49) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model50(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model50"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model50) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model50) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model51(val id: Long = Random.nextLong()) : BaseUiModel(-1){
    override fun getClassName() = "Model51"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model51) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model51) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model52(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model52"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model52) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model52) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model53(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model53"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model53) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model53) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model54(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model54"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model54) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model54) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model55(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model55"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model55) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model55) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model56(val id: Long = Random.nextLong()) : BaseUiModel(-1){
    override fun getClassName() = "Model56"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model56) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model56) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model57(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model57"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model57) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model57) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model58(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model58"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model58) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model58) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model59(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model59"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model59) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model59) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model60(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model60"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model60) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model60) {
            id == diffItem.id
        } else {
            false
        }
    }
}

data class Model61(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model61"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model61) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model61) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model62(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model62"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model62) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model62) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model63(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model63"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model63) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model63) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model64(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model64"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model64) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model64) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model65(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model65"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model65) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model65) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model66(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model66"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model66) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model66) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model67(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model67"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model67) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model67) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model68(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model68"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model68) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model68) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model69(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model69"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model69) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model69) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model70(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model70"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model70) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model70) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model71(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model71"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model71) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model71) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model72(val id: Long = Random.nextLong()): BaseUiModel(-1) {
    override fun getClassName() = "Model72"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model72) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model72) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model73(val id: Long = Random.nextLong()) : BaseUiModel(-1){
    override fun getClassName() = "Model73"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model73) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model73) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model74(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model74"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model74) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model74) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model75(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model75"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model75) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model75) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model76(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model76"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model76) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model76) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model77(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model77"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model77) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model77) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model78(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model78"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model78) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model78) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model79(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model79"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model79) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model79) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model80(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model80"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model80) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model80) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model81(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model81"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model81) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model81) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model82(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model82"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model82) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model82) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model83(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model83"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model83) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model83) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model84(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model84"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model84) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model84) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model85(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model85"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model85) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model85) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model86(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model86"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model86) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model86) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model87(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model87"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model87) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model87) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model88(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model88"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model88) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model88) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model89(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model89"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model89) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model89) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model90(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model90"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model90) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model90) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model91(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model91"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model91) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model91) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model92(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model92"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model92) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model92) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model93(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model93"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model93) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model93) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model94(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model94"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model94) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model94) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model95(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model95"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model95) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model95) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model96(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model96"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model96) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model96) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model97(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model97"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model97) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model97) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model98(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model98"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model98) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model98) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model99(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model99"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model99) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model99) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model100(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model100"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model100) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model100) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model101(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model101"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model101) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model101) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model102(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model102"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model102) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model102) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model103(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model103"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model103) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model103) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model104(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model104"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model104) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model104) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model105(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model105"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model105) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model105) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model106(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model106"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model106) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model106) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model107(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model107"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model107) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model107) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model108(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model108"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model108) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model108) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model109(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model109"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model109) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model109) {
            id == diffItem.id
        } else {
            false
        }
    }
}
data class Model110(val id: Long = Random.nextLong()) : BaseUiModel(-1) {
    override fun getClassName() = "Model110"

    override fun areItemsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model110) {
            id == diffItem.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(diffItem: Any): Boolean {
        return if (diffItem is Model110) {
            id == diffItem.id
        } else {
            false
        }
    }
}
