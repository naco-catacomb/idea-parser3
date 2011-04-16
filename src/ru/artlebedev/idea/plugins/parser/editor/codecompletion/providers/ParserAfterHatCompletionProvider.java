package ru.artlebedev.idea.plugins.parser.editor.codecompletion.providers;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import ru.artlebedev.idea.plugins.parser.editor.codecompletion.elements.ParserClassLookupElement;
import ru.artlebedev.idea.plugins.parser.editor.codecompletion.elements.ParserMethodLookupElement;

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

public class ParserAfterHatCompletionProvider extends CompletionProvider<CompletionParameters> {
  public final static String[] methodLookupElements = new String[]{
          "rem",
          "taint",
          "apply-taint",
          "untaint",
          "if",
          "break",
          "continue",
          "connect",
          "use",
          "cache",
          "eval",
          "process",
          "self.",
          "caller.",
          "throw",
          "try",
          "for",
          "while",
          "switch"
  };

  public final static String[] classLookupElements = new String[]{
          "MAIN"
  };

  @Override
  protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
    for (String methodLookupElement : methodLookupElements) {
      result.addElement(new ParserMethodLookupElement(methodLookupElement));
    }

    for (String classLookupElement: classLookupElements) {
      result.addElement(new ParserClassLookupElement(classLookupElement));
    }

//    Collection<ParserFile> parserFiles = parameters.getPosition().getProject().getComponent(ParserFileIndex.class).getLoadedClasses().values();
//    Collection<ParserClass> parserClasses = ParserResolveUtil.getClassesFromFiles(parserFiles);
//    for(ParserClass parserClass : parserClasses) {
//      if(ParserResolveUtil.collectStaticObjectDeclarations(parserClass).size() > 0) {
//        result.addElement(new ParserLookupElement(parserClass.getName() + ":"));
//      }
//    }
  }
}