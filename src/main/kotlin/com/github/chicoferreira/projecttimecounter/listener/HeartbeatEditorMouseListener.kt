package com.github.chicoferreira.projecttimecounter.listener

import com.github.chicoferreira.projecttimecounter.HeartbeatService
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.event.EditorMouseEvent
import com.intellij.openapi.editor.event.EditorMouseListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project

class HeartbeatEditorMouseListener : EditorMouseListener {

    override fun mousePressed(event: EditorMouseEvent) {
        val instance = FileDocumentManager.getInstance()
        val file = instance.getFile(event.editor.document)

        if (file != null) {
            HeartbeatService.registerHeartbeat(file)
        }
    }

}