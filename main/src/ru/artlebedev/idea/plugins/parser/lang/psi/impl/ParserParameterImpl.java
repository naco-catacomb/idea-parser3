package ru.artlebedev.idea.plugins.parser.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import ru.artlebedev.idea.plugins.parser.ParserIcons;
import ru.artlebedev.idea.plugins.parser.lang.lexer.ParserTokenTypes;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserClass;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserDocParameterInfo;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserMethod;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserParameter;
import ru.artlebedev.idea.plugins.parser.util.ParserChangeUtil;

import javax.swing.*;

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

public class ParserParameterImpl extends ParserElementImpl implements ParserParameter {
  public ParserParameterImpl(ASTNode astNode) {
    super(astNode);
  }

  public int getTextOffset() {
    final ASTNode name = findNameNode();
    return name != null ? name.getStartOffset() : super.getTextOffset();
  }

  public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
    ASTNode identifier = ParserChangeUtil.createNameIdentifier(getProject(), name);
    getNode().replaceChild(findNameNode(), identifier);
    return this;
  }

  private ASTNode findNameNode() {
    return getNode().findChildByType(ParserTokenTypes.IDENTIFIER);
  }

  public String getName() {
    ASTNode nameNode = findNameNode();
    if (nameNode != null)
      return nameNode.getText();
    return null;
  }

  public String toString() {
    return "ParserParameter";
  }

  public Icon getIcon(int i) {
    return ParserIcons.PARSER_PARAMETER_ICON;
  }

  public ParserClass getType() {
    ParserMethod parserMethod = PsiTreeUtil.getParentOfType(this, ParserMethod.class);
    if (parserMethod != null) {
      ParserDocParameterInfo[] info = parserMethod.getParameterInfo();
      for (ParserDocParameterInfo parameterInfo : info) {
        if (parameterInfo.getName().equals(getName())) {
          ParserClass[] parserClasses = parameterInfo.getType();
          if (parserClasses.length > 0)
            return parserClasses[0];
        }
      }
    }
    return null;
  }
}
