package com.github.chicoferreira.projecttimecounter

import com.github.chicoferreira.projecttimecounter.listener.HeartbeatDocumentListener
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.util.concurrency.AppExecutorUtil

class ProjectTimeCounter : StartupActivity {

    override fun runActivity(project: Project) {
    }

}