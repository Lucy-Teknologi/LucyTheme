package app.lucys.lib.lucytheme.ui.atom.icon

import androidx.annotation.DrawableRes
import app.lucys.lib.lucytheme.R

enum class LucyFilledIcon(@DrawableRes val resourceId: Int) {
    QuickOrder(R.drawable.outline_quick_order_fill),
    Booking(R.drawable.outline_booking_fill),
    Delivery(R.drawable.outline_delivery_fill),
    Reservation(R.drawable.outline_reservation_fill),
    Queue(R.drawable.outline_queue_fill),
    ActiveOrder(R.drawable.active_order_fill),
    HistoryTransaction(R.drawable.history_transaction_fill),
    Customer(R.drawable.customer_fill),
    Logo(R.drawable.lucy_logo_small),
    Printer(R.drawable.printer_fill),
    PayLater(R.drawable.paylater_fill),
    Clear(R.drawable.x_circle),
}