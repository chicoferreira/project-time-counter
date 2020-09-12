package com.github.chicoferreira.projecttimecounter

import com.github.chicoferreira.projecttimecounter.listener.HeartbeatVisibleAreaListener
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.vfs.VirtualFile

class HeartbeatServiceImpl() : HeartbeatService {

    override val heartbeats: MutableList<Heartbeat> = mutableListOf()

    override fun registerHeartbeat(heartbeat: Heartbeat) {
        heartbeats += heartbeat
    }

    override fun registerHeartbeat(file: VirtualFile) {
        registerHeartbeat(Heartbeat(file))
    }

}