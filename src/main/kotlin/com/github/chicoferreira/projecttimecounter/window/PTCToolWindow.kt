package com.github.chicoferreira.projecttimecounter.window

import com.github.chicoferreira.projecttimecounter.HeartbeatService
import com.github.chicoferreira.projecttimecounter.window.model.PTCRowBean
import com.github.chicoferreira.projecttimecounter.window.model.PTCTableModel
import com.github.chicoferreira.projecttimecounter.window.renderer.FirstColumnRenderer
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.table.JBTable
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JScrollPane


class PTCToolWindow(private val toolWindow: ToolWindow) {

    private val table: JBTable = JBTable().apply {
        autoResizeMode = JBTable.AUTO_RESIZE_ALL_COLUMNS

        model = PTCTableModel().apply {
            rowHeight = 30
            update(this)
        }

        showVerticalLines = false

        getColumn(PTCRowBean.columnNames[0]).cellRenderer = FirstColumnRenderer()
    }

    private val refreshToolWindowButton = JButton("Refresh").apply {
        addActionListener { update(table.model as PTCTableModel) }
    }

    val content: JPanel = JPanel().apply {
        layout = GridLayout(2, 1)

        add(refreshToolWindowButton, BorderLayout.PAGE_START)

        add(JScrollPane(table), BorderLayout.CENTER)
    }

    fun update(model: PTCTableModel) {
        model.clear()

        for (heartbeat in HeartbeatService.heartbeats) {
            model.rows += PTCRowBean(heartbeat.virtualFile.name, heartbeat.millis.toString())
        }
    }

}
