package ru.artlebedev.idea.plugins.parser.editor.liveTemplates;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;

/**
 * idea-parser3: the most advanced parser3 ide.
 * <p/>
 * Copyright 2011 <a href="mailto:dwr@design.ru">Valeriy Yatsko</a>
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

public class ParserDefaultLiveTemplatesProvider implements DefaultLiveTemplatesProvider {
  public String[] getDefaultLiveTemplateFiles() {
    return new String[] {
            "/ru/artlebedev/idea/plugins/parser/editor/liveTemplates/parser-lang",
            "/ru/artlebedev/idea/plugins/parser/editor/liveTemplates/completionContributor/parser-method-lookup",
            "/ru/artlebedev/idea/plugins/parser/editor/liveTemplates/parser-html",
            "/ru/artlebedev/idea/plugins/parser/editor/liveTemplates/parser-zen-html"
    };
  }

  @Override
  public String[] getHiddenLiveTemplateFiles() {
    return null;
  }
}
