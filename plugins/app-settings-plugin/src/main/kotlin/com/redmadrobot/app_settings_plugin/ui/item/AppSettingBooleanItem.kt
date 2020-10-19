package com.redmadrobot.app_settings_plugin.ui.item

import com.redmadrobot.app_settings_plugin.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_preference_boolean.view.*

internal class AppSettingBooleanItem(
    private val key: String,
    private var value: Boolean,
    private val onChanged: (key: String, newValue: Any) -> Unit
) : Item() {

    override fun getLayout() = R.layout.item_preference_boolean

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.containerView) {
            setting_label.text = key
            setting_type.text = value::class.java.simpleName
            setting_switch.isChecked = value

            setting_switch.setOnCheckedChangeListener { _, isChecked ->
                onChanged.invoke(key, isChecked)
                value = isChecked
            }
        }
    }
}