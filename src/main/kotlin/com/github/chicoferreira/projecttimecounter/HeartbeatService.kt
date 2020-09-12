package com.github.chicoferreira.projecttimecounter

import com.intellij.openapi.components.service
import com.intellij.openapi.vfs.VirtualFile

interface HeartbeatService {

    fun registerHeartbeat(heartbeat: Heartbeat)

    fun registerHeartbeat(file: VirtualFile)

    val heartbeats: List<Heartbeat>

    companion object : HeartbeatService by service<HeartbeatService>()

}