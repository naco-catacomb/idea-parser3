package ru.artlebedev.idea.plugins.parser.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.artlebedev.idea.plugins.parser.lang.ParserLanguageConstants;
import ru.artlebedev.idea.plugins.parser.lang.psi.ParserPsiUtil;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserCallingReference;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserClass;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserDocParameterInfo;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserMethod;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserObject;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserObjectAndMethodReference;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserParameter;
import ru.artlebedev.idea.plugins.parser.lang.psi.api.ParserStrictClass;
import ru.artlebedev.idea.plugins.parser.lang.psi.lookup.ParserLookupUtil;
import ru.artlebedev.idea.plugins.parser.lang.psi.resolve.ParserResolveUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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

public class ParserObjectAndMethodReferenceImpl extends ParserElementImpl implements ParserObjectAndMethodReference, PsiReference {
  public ParserObjectAndMethodReferenceImpl(ASTNode astNode) {
    super(astNode);
  }

  public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
    return null;
  }

  public PsiElement getElement() {
    return this;
  }

  public PsiReference getReference() {
    return this;
  }

  public TextRange getRangeInElement() {
    final PsiElement firstChild = getFirstChild();
    final int startOffsetInParent = firstChild.getStartOffsetInParent();
    return new TextRange(startOffsetInParent, startOffsetInParent + getNode().getTextLength());
  }

  @Nullable
  public PsiElement resolve() {
    return null;
  }

  @NotNull
  public String getCanonicalText() {
    return "";
  }

  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    return null;
  }

  public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
    return null;
  }

  public boolean isReferenceTo(PsiElement element) {
    return false;
  }

  /**
   * Listening to Nightwish - End of All Hope when altering this method.
   *
   * We have construction like:
   * ^self.db.getSomething[]
   *
   * Where self should be interpretered as our own object reference and nothing else.
   * On the other hand, we have getReferenceObjects()[0], from the [1] index of which
   * we could eject the object we need.
   *
   * @return variants for autocomplete (and resolution)
   */
  @NotNull
  public Object[] getVariants() {
    boolean isInAuto = ParserPsiUtil.isInAutoMethod(this);

    PsiElement prevSibling = getPrevSibling();

    /**
     * ^self routine
     */
    if(getParent() != null) {
      if(getParent() instanceof ParserCallingReference) {
//        PsiDevUtil.printPsiElements(((ParserCallingReference) getParent()).getReferenceObjects());
        if(((ParserCallingReference) getParent()).getReferenceObjects()[0].getName().equals(ParserLanguageConstants.SELF_CLASS_NAME) && !isInAuto &&
                (((ParserCallingReference) getParent()).getReferenceObjects().length == 1)) {
          ParserClass parserObject = PsiTreeUtil.getParentOfType(this, ParserClass.class, true);

          if (parserObject == null)
            return new Object[0];

          ParserMethod[] methods = parserObject.getMethods();

          HashSet<PsiElement> result = new HashSet<PsiElement>();
          for (ParserMethod method : methods) {
            if(!method.isConstructor()) {
              result.add(method);
            }

            for(PsiElement methodChild : method.getChildren()) {
              if(parserObject instanceof ParserStrictClass) {
                result.addAll(ParserResolveUtil.collectGlobalObjectDeclarations(methodChild));
              } else {
                result.addAll(ParserResolveUtil.collectObjectDeclarations(methodChild));
              }
            }
          }

          Iterator<PsiElement> iterator = result.iterator();
          while(iterator.hasNext()) {
            PsiElement element = iterator.next();
            if(element instanceof PsiNamedElement) {
              if("result".equals(((PsiNamedElement) element).getName()))
                iterator.remove();
            }
          }

          List<PsiElement> list = new ArrayList<PsiElement>();
          list.addAll(result);
          return ParserLookupUtil.createSmartLookupItems(list);
        }
      }
    }

    /**
     * In-method routine, also inc. length > 1 check for referenceObjects to skip $self for
     * inner-object detection.
     * -- dwr
     */
    ParserObjectReferenceImpl parserObjectReference;
    if(((ParserCallingReference) getParent()).getReferenceObjects()[0].getName().equals(ParserLanguageConstants.SELF_CLASS_NAME) && !isInAuto &&
            (((ParserCallingReference) getParent()).getReferenceObjects().length > 1)) {
      parserObjectReference = (ParserObjectReferenceImpl) ((ParserCallingReference) getParent()).getReferenceObjects()[((ParserCallingReference) getParent()).getReferenceObjects().length - 1];
    } else {
      while (!(prevSibling instanceof ParserObjectReferenceImpl)) {
        prevSibling = prevSibling.getPrevSibling();
      }

      parserObjectReference = (ParserObjectReferenceImpl) prevSibling;
    }

    PsiElement resolveResult = parserObjectReference.resolve();
    if (resolveResult instanceof ParserObject) {
      ParserObject parserObject = (ParserObject) resolveResult;

      if (parserObject == null)
        return new Object[0];

      ParserClass type = parserObject.getType();
      if (type != null) {
        ParserMethod[] methods = type.getMethods();
        List<PsiElement> list = new ArrayList<PsiElement>();
        HashSet<PsiElement> hs = new HashSet<PsiElement>();
        for (ParserMethod method : methods) {
          if(!method.isConstructor()) {
            list.add(method);
          }

          for(PsiElement methodChild : method.getChildren()) {
            if(parserObject instanceof ParserStrictClass) {
              hs.addAll(ParserResolveUtil.collectGlobalObjectDeclarations(methodChild));
            } else {
              hs.addAll(ParserResolveUtil.collectObjectDeclarations(methodChild));
            }
          }
        }

        Iterator<PsiElement> iterator = hs.iterator();
        while(iterator.hasNext()) {
          PsiElement element = iterator.next();
          if(element instanceof PsiNamedElement) {
            if("result".equals(((PsiNamedElement) element).getName()))
              iterator.remove();
          }
        }
        list.addAll(hs);
        return ParserLookupUtil.createSmartLookupItems(list);
      }
    }
    if (resolveResult instanceof ParserParameter) {
      String paramName = resolveResult.getText();
      ParserMethod parserMethod = PsiTreeUtil.getParentOfType(resolveResult, ParserMethod.class, true);
      if (parserMethod != null) {
        ParserDocParameterInfo[] info = parserMethod.getParameterInfo();
        for (ParserDocParameterInfo parameterInfo : info) {
          if (parameterInfo.getName().equals(paramName)) {
            ParserClass[] parserClasses = parameterInfo.getType();
            List<PsiElement> list = new ArrayList<PsiElement>();
            for (ParserClass parserClass : parserClasses) {
              list.addAll(Arrays.asList(parserClass.getMethods()));
            }
            return ParserLookupUtil.createSmartLookupItems(list);
          }
        }
      }
    }
    return new Object[0];
  }

  public boolean isSoft() {
    return false;
  }
}
