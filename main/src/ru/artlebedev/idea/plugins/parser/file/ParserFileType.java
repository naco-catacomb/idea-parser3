package ru.artlebedev.idea.plugins.parser.file;

import com.intellij.lang.Language;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.ex.FileTypeIdentifiableByVirtualFile;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.artlebedev.idea.plugins.parser.Parser;
import ru.artlebedev.idea.plugins.parser.ParserIcons;
import ru.artlebedev.idea.plugins.parser.editor.highlighting.ParserSyntaxHighlighter;
import ru.artlebedev.idea.plugins.parser.lang.ParserLanguage;

import javax.swing.*;
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

public class ParserFileType extends LanguageFileType implements FileTypeIdentifiableByVirtualFile {
  private static final Logger LOG = Logger.getInstance("#ParserFileType");
  public static final ParserFileType PARSER_FILE_TYPE = new ParserFileType();
  public static final Language PARSER_LANGUAGE = PARSER_FILE_TYPE.getLanguage();

  /**
   * The default file extension of parser scripts.
   */
  public static final String DEFAULT_EXTENSION = "p";
  public static final String IMPRIMATUR_BLOCK_PROCESSOR_EXTENSION = "bp";
  public static final String IMPRIMATUR_PAGE_PROCESSOR_EXTENSION = "pp";
  public static final String PARSERED_XML_EXTENSION = "pxml";

  /**
   * All extensions which are associated with this plugin.
   */
  public static final String[] extensions = {
          DEFAULT_EXTENSION,
          IMPRIMATUR_BLOCK_PROCESSOR_EXTENSION,
          IMPRIMATUR_PAGE_PROCESSOR_EXTENSION,
          PARSERED_XML_EXTENSION
  };
  public static final List<String> extensionList = Arrays.asList(extensions);

  public ParserFileType() {
    super(new ParserLanguage());
    FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, new EditorHighlighterProvider() {
      @Override
      public EditorHighlighter getEditorHighlighter(@Nullable Project project,
                                                    @NotNull FileType fileType, @Nullable VirtualFile virtualFile,
                                                    @NotNull EditorColorsScheme colors) {
        return new ParserSyntaxHighlighter(project, virtualFile, colors);
      }
    });
  }

  @NotNull
  public String getName() {
    return Parser.lanuageName;
  }

  @NotNull
  public String getDescription() {
    return Parser.languageDescription;
  }

  @NotNull
  @NonNls
  public String getDefaultExtension() {
    return extensions[0];
  }

  /*
   * We have:
   * - Parser file
   * - Parser class
   * - Imprimatur page processor
   * - Imprimatur block processor
   * - auto.p
   * file icons actually, should we put them here?
   * -- dwr
   */
  public Icon getIcon() {
    return ParserIcons.PARSER_FILE_ICON;
  }

  @Override
  public boolean isJVMDebuggingSupported() {
    return false;
  }

  /**
   * Here we check if a given file belongs to our plugin.
   * We take this road because we need the actual file and not a filename to check files without extension.
   * <p/>
   * A file is checked according to the rules defined in the facet settings.
   * A file can be set to ignored, accepted or auto. Auto means that the content is checked.
   *
   * @param file The file to check
   * @return True if Parser Plugin wants to take that file
   */
  @Override
  public boolean isMyFileType(VirtualFile file) {
    if (file == null) {
      return false;
    }

    if (file.isDirectory()) {
      return false;
    }

    if (extensionList.contains(file.getExtension())) {
      return true;
    } else if (!file.isInLocalFileSystem()) {
      return false;
    }

    return false;
  }

  public EditorHighlighter getEditorHighlighter(@Nullable final Project project, @Nullable final VirtualFile virtualFile, @NotNull EditorColorsScheme colors) {
    return new ParserSyntaxHighlighter(project, virtualFile, colors);
  }
}
