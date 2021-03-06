package ru.artlebedev.idea.plugins.parser.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiElementFilter;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import ru.artlebedev.idea.plugins.parser.file.ParserFileType;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.HasMethods;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserElement;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserMethod;

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

public class ParserFile extends PsiFileBase implements ParserElement, HasMethods {
  public ParserFile(FileViewProvider fileViewProvider) {
    super(fileViewProvider, ParserFileType.PARSER_LANGUAGE);
  }

  @NotNull
  public FileType getFileType() {
    return ParserFileType.PARSER_FILE_TYPE;
  }

  public String toString() {
    return "ParserFile:" + getName();
  }

  public boolean processDeclarations(@NotNull PsiScopeProcessor processor,
                                     @NotNull ResolveState substitutor,
                                     PsiElement lastParent,
                                     @NotNull PsiElement place) {
    final PsiElement[] children = getChildren();
    for (PsiElement child : children) {
      if (child == lastParent) break;
      if (!child.processDeclarations(processor, substitutor, lastParent, place)) return false;
    }
    return true;
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParserElementVisitor) {
      visitor.visitElement(this);
    } else {
      super.accept(visitor);
    }
  }

  public ParserMethod[] getMethods() {
    PsiElement[] methods = PsiTreeUtil.collectElements(this, new PsiElementFilter() {
      public boolean isAccepted(PsiElement element) {
        return element instanceof ParserMethod;
      }
    });
    ParserMethod[] result = new ParserMethod[methods.length];
    for (int i = 0; i < methods.length; i++) {
      result[i] = (ParserMethod) methods[i];
    }
    return result;
  }
}

