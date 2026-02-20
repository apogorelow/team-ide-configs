package com.github.apogorelow.teamideconfigs.templates

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.icons.AllIcons

class CreateZustandStoreAction : CreateFileFromTemplateAction(
    "Zustand Store",
    "Creates a new Zustand Store",
    AllIcons.Nodes.DataTables
) {
    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle("New Zustand Store")
            // The template name here must match your .ft file name exactly
            .addKind("Zustand Store", AllIcons.Nodes.DataTables, "Zustand_Store")
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String {
        return "Creating Zustand Store $newName"
    }
}