package app.lucys.lib.lucytheme.ui.atom.images

import androidx.annotation.DrawableRes
import app.lucys.lib.lucytheme.R

enum class LucyFilledIcon(@DrawableRes val resourceId: Int) {
    QuickOrder(R.drawable.icon_filled_quick_order),
    Booking(R.drawable.icon_filled_booking),
    Delivery(R.drawable.icon_filled_delivery),
    Reservation(R.drawable.icon_filled_reservation),
    Queue(R.drawable.icon_filled_queue),
    ActiveOrder(R.drawable.icon_filled_active_order),
    HistoryTransaction(R.drawable.icon_filled_history_transaction),
    Customer(R.drawable.icon_filled_customer),
    Logo(R.drawable.drawable_lucy_logo_small),
    Printer(R.drawable.icon_filled_printer),
    PayLater(R.drawable.icon_filled_paylater),
    Clear(R.drawable.icon_filled_x_circle),
    Lock(R.drawable.icon_filled_lock_closed),
    Mail(R.drawable.icon_filled_mail),
    Eye(R.drawable.icon_filled_eye),
    EyeOff(R.drawable.icon_filled_eye_off),

    ChevronLeft(R.drawable.icon_filled_chevron_left),
    ChevronRight(R.drawable.icon_filled_chevron_right),
    ChevronUp(R.drawable.icon_filled_chevron_up),
    ChevronDown(R.drawable.icon_filled_chevron_down),

    SortAscending(R.drawable.icon_filled_sort_ascending),
    SortDescending(R.drawable.icon_filled_sort_descending),
    Filter(R.drawable.icon_filled_filter),
    Server(R.drawable.icon_filled_server)
}