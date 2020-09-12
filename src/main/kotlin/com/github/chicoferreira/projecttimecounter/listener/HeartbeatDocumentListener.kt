package com.github.chicoferreira.projecttimecounter.listener

import com.github.chicoferreira.projecttimecounter.HeartbeatService
import com.intellij.notification.Notification
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project

class HeartbeatDocumentListener : DocumentListener {

    override fun beforeDocumentChange(event: DocumentEvent) {
        val instance = FileDocumentManager.getInstance()
        val file = instance.getFile(event.document)

        if (file != null) {
            HeartbeatService.registerHeartbeat(file)
        }
    }

}