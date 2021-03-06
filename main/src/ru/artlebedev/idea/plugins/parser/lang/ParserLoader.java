package ru.artlebedev.idea.plugins.parser.lang;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectManagerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
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

public class ParserLoader implements ApplicationComponent {
  public final List<String> constructorNames = Arrays.asList(
          "new", "init", "create", "load",
          "now", "unix-timestamp", "stat",
          "cgi", "exec", "base64", "open",
          "measure", "_has_no_constructor_");

  /**
   * You can get constructor names which user has defined. (since every method in a class could be a constructor it's useful to have a filter)
   *
   * @return list of constuctor names
   */
  public List<String> getConstructorNames() {
    return constructorNames;
  }

  public static ParserLoader getInstance() {
    return ApplicationManager.getApplication().getComponent(ParserLoader.class);
  }

  public ParserLoader() {
  }

  public void initComponent() {
    ProjectManager.getInstance().addProjectManagerListener(new ProjectManagerAdapter() {
      public void projectOpened(final Project project) {
      }
    });
  }

  public void disposeComponent() {
  }

  @NotNull
  public String getComponentName() {
    return "parser.support.loader";
  }
}
