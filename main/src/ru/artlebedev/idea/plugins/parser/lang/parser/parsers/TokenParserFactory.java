package ru.artlebedev.idea.plugins.parser.lang.parser.parsers;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import ru.artlebedev.idea.plugins.parser.lang.lexer.ParserTokenTypes;

import java.util.HashMap;
import java.util.Map;

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

public class TokenParserFactory {
  private static Map<BaseTokenParser, TokenSet> parsers;
  public static final BaseTokenParser indifferent = new IndifferentParser();

  static {
    parsers = new HashMap<BaseTokenParser, TokenSet>();
    parsers.put(new IncludeParser(), TokenSet.create(ParserTokenTypes.USE_KEYWORD));
    parsers.put(new ClassParser(), TokenSet.create(ParserTokenTypes.CLASS_KEYWORD));
//		parsers.put(new WhiteSpaceParser(), TokenSet.create(ParserTokenTypes.NEW_LINE, ParserTokenTypes.WHITE_SPACE));
    parsers.put(new MethodParser(), TokenSet.create(ParserTokenTypes.KEY_AT_SIGN));
    parsers.put(new MethodReferenceParser(), TokenSet.create(ParserTokenTypes.HAT_SIGN));
    parsers.put(new ObjectParser(), TokenSet.create(ParserTokenTypes.DOLLAR));
    parsers.put(new ClassParentParser(), TokenSet.create(ParserTokenTypes.BASE_KEYWORD));
    parsers.put(new ParserDocParser(), TokenSet.create(ParserTokenTypes.PARSERDOC_START));
  }

  /**
   * @param builder a psi builder that knows the current token type
   * @return associated parser if it is found or indifferent parser if not
   */
  public static BaseTokenParser getParser(PsiBuilder builder) {
    IElementType currentType = builder.getTokenType();
    if (currentType != null)
      //System.out.println("requested for parser [" + currentType.toString() + "]");
      for (BaseTokenParser parser : parsers.keySet()) {
        TokenSet tokenSet = parsers.get(parser);
        if (tokenSet.contains(builder.getTokenType())) {
          //System.out.println("returned [" + parser.toString() + "]");
          return parser;
        }
      }

    return indifferent;
  }
}

