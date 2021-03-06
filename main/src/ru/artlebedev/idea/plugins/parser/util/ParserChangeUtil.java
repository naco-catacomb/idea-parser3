package ru.artlebedev.idea.plugins.parser.util;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import ru.artlebedev.idea.plugins.parser.file.ParserFileType;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserMethod;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserParameterList;

import java.util.ArrayList;
import java.util.List;

/**
 * idea-parser3: the most advanced parser3 ide.
 * <p/>
 * Copyright 2011 <a href="mailto:dwr@design.ru">Valeriy Yatsko</a>
 * Copyright 2006 <a href="mailto:a4blank@yahoo.com">Jay Bird</a>
 * Copyright 2006-2011 ArtLebedev Studio
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

public class ParserChangeUtil {
  private static final String DUMMY = "dummy.";

  public static ASTNode createNameIdentifier(Project project, String name) throws IncorrectOperationException {
    final PsiFile dummyFile = PsiFileFactory.getInstance(project).createFileFromText(DUMMY + ParserFileType.PARSER_FILE_TYPE.getDefaultExtension(), name);
    final PsiElement expressionStatement = dummyFile.getFirstChild();
    assert expressionStatement != null;
    return expressionStatement.getNode();
  }

  public static List<PsiElement> createExpressionFromText(Project project, @NonNls String text) throws IncorrectOperationException {
    // XXX why we need this?
    //ParserDefinition def = ParserFileType.PARSER_FILE_TYPE.getLanguage().getParserDefinition();
    //assert def != null;

    StringBuilder builder = new StringBuilder("@main[]\n");
    builder.append(text).append("\n");

    final PsiFile dummyFile = PsiFileFactory.getInstance(project).createFileFromText(DUMMY + ParserFileType.PARSER_FILE_TYPE.getDefaultExtension(), builder.toString());

    ParserMethod method = PsiTreeUtil.getChildOfType(dummyFile, ParserMethod.class);
    PsiElement[] children = method.getChildren();

    List<PsiElement> toReturn = new ArrayList<PsiElement>();

    for (PsiElement element : children) {
      if (element instanceof ParserParameterList || element.getText().equals("\n"))
        continue;
      toReturn.add(element);
    }

    return toReturn;
  }

}