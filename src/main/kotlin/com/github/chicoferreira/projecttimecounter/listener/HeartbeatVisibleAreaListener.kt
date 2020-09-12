package com.github.chicoferreira.projecttimecounter.listener

import com.github.chicoferreira.projecttimecounter.HeartbeatService
import com.intellij.openapi.editor.event.VisibleAreaEvent
import com.intellij.openapi.editor.event.VisibleAreaListener
import com.intellij.openapi.fileEditor.FileDocumentManager

class HeartbeatVisibleAreaListener : VisibleAreaListener {

    override fun visibleAreaChanged(event: VisibleAreaEvent) {
        val instance = FileDocumentManager.getInstance()
        val file = instance.getFile(event.editor.document)

        if (file != null) {
            HeartbeatService.registerHeartbeat(file)
        }
    }
}