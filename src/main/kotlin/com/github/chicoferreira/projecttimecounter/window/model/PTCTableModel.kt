package com.github.chicoferreira.projecttimecounter.window.model

import javax.swing.table.AbstractTableModel

class PTCTableModel : AbstractTableModel() {

    val rows = mutableListOf<PTCRowBean>()

    override fun getRowCount(): Int = rows.size

    override fun getColumnCount(): Int = PTCRowBean.size

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any = rows[rowIndex][columnIndex]

    override fun getColumnName(column: Int): String = PTCRowBean.columnNames[column]

    fun clear() {
        if (rows.isEmpty()) return

        rows.clear()
        fireTableRowsDeleted(0, rowCount - 1)
    }

}

data class PTCRowBean(val firstColumn: String, val secondColumn: String) {

    companion object {
        const val size = 2
        val columnNames = arrayOf("File", "Time Spent")
    }

    operator fun get(index: Int): String = when (index) {
        0 -> firstColumn
        1 -> secondColumn
        else -> throw IndexOutOfBoundsException()
    }

}

