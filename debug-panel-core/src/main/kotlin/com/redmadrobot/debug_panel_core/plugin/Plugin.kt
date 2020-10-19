package com.redmadrobot.debug_panel_core.plugin

import androidx.fragment.app.Fragment
import com.redmadrobot.debug_panel_core.CommonContainer
import com.redmadrobot.debug_panel_core.DebugPanelInstance
import com.redmadrobot.debug_panel_core.internal.DebugEvent

abstract class Plugin {
    private lateinit var pluginContainer: PluginDependencyContainer

    internal fun start(commonContainer: CommonContainer): Plugin {
        pluginContainer = getPluginContainer(commonContainer)
        return this
    }

    fun pushEvent(debugEvent: DebugEvent) {
        DebugPanelInstance.instance?.pushEvent(debugEvent)
    }

    fun <T> getContainer() = pluginContainer as T

    open fun getFragment(): Fragment? = null

    open fun getSettingFragment(): Fragment? = null

    abstract fun getPluginContainer(commonContainer: CommonContainer): PluginDependencyContainer

    abstract fun getName(): String
}