package app.lucys.lib.lucytheme.ui.atom.icon

import androidx.annotation.DrawableRes
import app.lucys.lib.lucytheme.R

enum class LucyIllustration(@DrawableRes val resourceId: Int) {
    EmailCompleted(R.drawable.email_completed),
    ErrorOccurred(R.drawable.error_occurred),

    Welcome(R.drawable.welcome),
    GoodBye(R.drawable.goodbye),

    RippleTopEnd(R.drawable.ripple_top_end),
    RippleBottomStart(R.drawable.ripple_bottom_start),

    Communication(R.drawable.illust_communication),
    SocialMedia(R.drawable.illust_socialmedia),
    Workflow(R.drawable.illust_workflow)
}