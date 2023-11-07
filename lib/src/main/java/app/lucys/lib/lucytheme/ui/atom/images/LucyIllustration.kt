package app.lucys.lib.lucytheme.ui.atom.images

import androidx.annotation.DrawableRes
import app.lucys.lib.lucytheme.R

enum class LucyIllustration(@DrawableRes val resourceId: Int) {
    EmailCompleted(R.drawable.illust_email_completed),
    ErrorOccurred(R.drawable.illust_error_occurred),

    Welcome(R.drawable.illust_welcome),
    GoodBye(R.drawable.illust_goodbye),

    RippleTopEnd(R.drawable.illust_ripple_top_end),
    RippleBottomStart(R.drawable.illust_ripple_bottom_start),

    Communication(R.drawable.illust_communication),
    SocialMedia(R.drawable.illust_socialmedia),
    Workflow(R.drawable.illust_workflow)
}