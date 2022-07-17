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
    ":features:core",
    ":features:proxy"
)
