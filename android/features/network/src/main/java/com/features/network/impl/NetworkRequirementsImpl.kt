package com.features.network.impl

import android.content.Context
import android.content.Intent
import com.features.network.NetworkActivity
import com.features.network_requirements.NetworkRequirements
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Description : Network Requirements 구현체 클래스
 *
 * Created by juhongmin on 2022/07/22
 */
internal class NetworkRequirementsImpl(
    @ApplicationContext private val context: Context
) : NetworkRequirements {
    override fun moveToNetworkPage() {
        Intent(context, NetworkActivity::class.java).apply {
            context.startActivity(this)
        }
    }
}
