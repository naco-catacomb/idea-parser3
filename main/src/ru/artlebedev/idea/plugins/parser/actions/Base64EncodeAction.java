package ru.artlebedev.idea.plugins.parser.actions;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

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

public class Base64EncodeAction extends AbstractTextReplaceAction {
  @Override
  public String transform(String selectedText) {
    try {
      byte[] byteArray = Base64.encodeBase64(selectedText.getBytes("UTF-8"));
      return new String(byteArray, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return null;
    }
  }
}
