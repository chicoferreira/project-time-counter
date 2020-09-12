package com.github.chicoferreira.projecttimecounter

import com.intellij.openapi.vfs.VirtualFile

class Heartbeat(val virtualFile: VirtualFile, val millis: Long = System.currentTimeMillis()) {

}