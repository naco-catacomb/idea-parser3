package ru.artlebedev.idea.plugins.parser.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.ReadonlyStatusHandler;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * idea-parser3: slightly useful plugin.
 * <p/>
 * Copyright 2011 Valeriy Yatsko <dwr@design.ru>
 * Copyright 2011 ArtLebedev Studio
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public abstract class AbstractTextReplaceAction extends AnAction {
  public void actionPerformed(AnActionEvent e)
  {
    final Editor editor = (Editor)e.getDataContext().getData("editor");
    if ((editor == null) || (editor.getSelectionModel() == null)) {
      return;
    }
    final String sel = editor.getSelectionModel().getSelectedText();
    final Project project = (Project)e.getDataContext().getData("project");
    if (project == null) {
      return;
    }
    final VirtualFile virtualFile = (VirtualFile)e.getDataContext().getData("virtualFile");
    if (virtualFile == null) {
      return;
    }
    if ((sel != null) || (sel.trim().length() != 0))
      ApplicationManager.getApplication().runWriteAction(new Runnable() {
        public void run() {
          CommandProcessor.getInstance().executeCommand(project, new Runnable() {
            public void run() {
              if (!ReadonlyStatusHandler.getInstance(project).ensureFilesWritable(new VirtualFile[] { virtualFile }).hasReadonlyFiles())
                EditorModificationUtil.insertStringAtCaret(editor, transform(sel), true, true);
            }
          }
          , "replace", "replace");
        }
      });
  }

  public abstract String transform(String selectedText);

  public void update(AnActionEvent e) {
    Presentation presentation = e.getPresentation();
    presentation.setEnabled(shouldBeEnabled(e));
  }

  boolean shouldBeEnabled(AnActionEvent e) {
    Editor editor = (Editor)e.getDataContext().getData("editor");
    if ((editor == null) || (editor.getSelectionModel() == null)) {
      return false;
    }

    String sel = editor.getSelectionModel().getSelectedText();

    return (sel != null) && (sel.trim().length() != 0);
  }
}
