package ru.artlebedev.jreformator.language;

/**
 * jreformator
 * <p/>
 * Based on code originally written by <a href="mailto:vlalek@design.ru">Vladimir Tokmakov</a>
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

public class LanguageParams {
  private int limit = 5000;
  private int limitedParts = 5;

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setLimitedParts(int limitedParts) {
    this.limitedParts = limitedParts;
  }

  public int getLimit() {
    return limit;
  }

  public int getLimitedParts() {
    return limitedParts;
  }
}
