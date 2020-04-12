package com.redmadrobot.debug_panel.ui.toggles.item

import com.redmadrobot.debug_panel.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_preference_value.view.*

class PreferenceValueItem(
    private val key: String,
    private val value: Any?
) : Item() {

    override fun getLayout() = R.layout.item_preference_value

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.containerView) {
            setting_label.text = key
            setting_value.setText(value.toString())
            setting_value.clearFocus()
        }
    }
}
