package com.github.chicoferreira.projecttimecounter.window.renderer

import com.intellij.icons.AllIcons
import java.awt.Component
import java.awt.Font
import javax.swing.JLabel
import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer

class FirstColumnRenderer : DefaultTableCellRenderer() {

    override fun getTableCellRendererComponent(
        table: JTable?,
        value: Any?,
        isSelected: Boolean,
        hasFocus: Boolean,
        row: Int,
        column: Int
    ): Component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column).apply {
        if (this is JLabel) {
            icon = AllIcons.FileTypes.Java
        }

        font = font.deriveFont(Font.BOLD).deriveFont(12F)
    }
}