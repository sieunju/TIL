rootProject.name = "til"

include(
    ":app",
    ":data",
    ":model",
    ":domain",
    ":presentation",
    ":loginmanager",
    ":likemanager",
    ":rxbus",
    ":lifecycle",
    ":rxhandling"
)
include(
    ":features:core"
)
include(":features:network")
include(":features:network-requirements")
