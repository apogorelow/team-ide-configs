package com.github.apogorelow.teamideconfigs.templates

import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.ui.CreateFromTemplateDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.icons.AllIcons

class CreateZustandStoreAction : AnAction("Zustand Store", "Creates a new Zustand Store", AllIcons.Nodes.DataTables) {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val view = e.getData(LangDataKeys.IDE_VIEW) ?: return
        val directory = view.orChooseDirectory ?: return

        val templateManager = FileTemplateManager.getInstance(project)
        val template = templateManager.getInternalTemplate("Zustand_Store")

        if (template != null) {
            // We just fetch the default properties (like Date/Time) but we DO NOT
            // set the ATTRIBUTES_COMMA_SEPARATED property manually!
            val defaultProperties = templateManager.defaultProperties

            CreateFromTemplateDialog(project, directory, template, null, defaultProperties).show()
        }
    }


    // This ensures the button only appears when you right-click a valid directory
    override fun update(e: AnActionEvent) {
        val project = e.project
        val view = e.getData(LangDataKeys.IDE_VIEW)
        e.presentation.isEnabledAndVisible = project != null && view != null && view.directories.isNotEmpty()
    }
}