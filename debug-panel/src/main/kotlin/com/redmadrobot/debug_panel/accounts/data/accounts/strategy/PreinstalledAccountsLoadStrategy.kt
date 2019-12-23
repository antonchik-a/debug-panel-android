package com.redmadrobot.debug_panel.accounts.data.accounts.strategy

import com.redmadrobot.debug_panel.accounts.data.model.DebugUserCredentials

class PreinstalledAccountsLoadStrategy : AccountsLoadStrategy {

    override fun loadAccounts(): List<DebugUserCredentials> {
        return listOf(
            DebugUserCredentials(
                "7882340482",
                "Qq!11111"
            ),
            DebugUserCredentials(
                "2777248041",
                "Qq!11111"
            ),
            DebugUserCredentials(
                "4183730054",
                "Ww!11111"
            ),
            DebugUserCredentials(
                "1944647499",
                "Qq!11111"
            )
        )
    }
}
