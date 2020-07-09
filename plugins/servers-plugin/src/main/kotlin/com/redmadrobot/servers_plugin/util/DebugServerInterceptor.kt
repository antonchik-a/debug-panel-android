package com.redmadrobot.servers_plugin.util

import com.redmadrobot.core.extension.getPlugin
import com.redmadrobot.servers_plugin.plugin.ServersPlugin
import com.redmadrobot.servers_plugin.plugin.ServersPluginContainer
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.URI

class DebugServerInterceptor : Interceptor {

    private val panelSettingsRepository by lazy {
        getPlugin<ServersPlugin>()
            .getContainer<ServersPluginContainer>()
            .pluginSettingsRepository
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val debugServer = panelSettingsRepository.getSelectedServerHost()

        if (debugServer != null && debugServer.isNotEmpty()) {
            val newUrl = request.getNewUrl(debugServer)
            request = request.newBuilder()
                .url(newUrl)
                .build()
        }
        return chain.proceed(request)
    }

    private fun Request.getNewUrl(debugServer: String): HttpUrl {
        val serverUri = URI(debugServer)
        return this.url.newBuilder()
            .scheme(serverUri.scheme)
            .host(serverUri.host)
            .build()
    }
}
