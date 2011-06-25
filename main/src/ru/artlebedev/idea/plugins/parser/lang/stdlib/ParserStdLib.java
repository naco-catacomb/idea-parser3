package ru.artlebedev.idea.plugins.parser.lang.stdlib;

/**
 * idea-parser3: the most advanced parser3 ide.
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

public class ParserStdLib {
  public static final String parser3_bool = "@CLASS\nbool\n\n@_has_no_constructor_[]\n###";
  public static final String parser3_console = "@CLASS\nconsole\n\n@_has_no_constructor_[]\n###\n\n@auto[]\n$line[]\n###";
  public static final String parser3_cookie = "@CLASS\ncookie\n\n@_has_no_constructor_[]\n###\n\n@auto[]\n$fieds[^hash::create[]]\n###";
  public static final String parser3_curl = "@CLASS\ncurl\n\n@version[]\n$result[]\n###\n\n@load[]\n###\n\n@load[options]\n###\n\n@session[code]\n###\n\n@options[options]\n###";
  public static final String parser3_date = "@CLASS\ndate\n\n@create[days_after_erosn_or_date]\n###\n\n@create[year;month]\n###\n\n@create[year;month;day]\n###\n\n@create[year;month;day;hour;minute;second]\n###\n\n@now[]\n###\n\n@now[days_offset]\n###\n\n@unix-timestamp[unix_datetime]\n###\n\n@roll[year;offset]\n$result[^void::_has_no_constructor[]]\n###\n\n@roll[month;offset]\n$result[^void::_has_no_constructor[]]\n###\n\n@roll[day;offset]\n$result[^void::_has_no_constructor[]]\n###\n\n@roll[TZ;new_timezone]\n$result[^void::_has_no_constructor[]]\n###\n\n@sql-string[]\n$result[]\n###\n\n@unix-timestamp[]\n$result[]\n###\n\n@last-day[]\n$result(1)\n###\n\n@gmt-string[]\n$result[]\n###\n\n@static:calendar[rus;year;month;day]\n$result[^table::create[]]\n###\n\n@static:calendar[eng;year;month;day]\n$result[^table::create[]]\n###\n\n@static:calendar[rus;year;month]\n$result[^table::create[]]\n###\n\n@static:calendar[eng;year;month]\n$result[^table::create[]]\n###\n\n@static:last-day[year;month]\n$result(1)\n###";
  public static final String parser3_double = "@CLASS\ndouble\n\n@sql[default]\n###\n\n@int[default]\n$result(1)\n###\n\n@double[default]\n$result(1)\n###\n\n@inc[number]\n$result(1)\n###\n\n@dec[number]\n$result(1)\n###\n\n@mul[number]\n$result(1)\n###\n\n@div[number]\n$result(1)\n###\n\n@mod[number]\n$result(1)\n###\n\n@format[options]\n$result(1)\n###";
  public static final String parser3_env = "@CLASS\nenv\n\n@_has_no_constructor_[]\n###\n\n@auto[]\n$PARSER_VERSION[]\n$GATEWAY_INTERFACE[]\n$PATH[]\n$QUERY_STRING[]\n$REMOTE_ADDR[]\n$REMOTE_PORT[]\n$REMOTE_USER[]\n$REDIRECT_REMOTE_USER[]\n$REQUEST_METHOD[]\n$REQUEST_URI[]\n$SCRIPT_FILENAME[]\n$SCRIPT_NAME[]\n$SERVER_ADDR[]\n$SERVER_ADMIN[]\n$SERVER_NAME[]\n$SERVER_PORT[]\n$SERVER_PROTOCOL[]\n$SERVER_SIGNATURE[]\n$SERVER_SOFTWARE[]\n$HTTP_ACCEPT[]\n$HTTP_ACCEPT_ENCODING[]\n$HTTP_ACCEPT_LANGUAGE[]\n$HTTP_CONNECTION[]\n$HTTP_COOKIE[]\n$HTTP_HOST[]\n$HTTP_REFERER[]\n$HTTP_USER_AGENT[]\n$DATE_GMT[]\n$DATE_LOCAL[]\n$DOCUMENT_ROOT[]\n$DOCUMENT_NAME[]\n$DOCUMENT_PATH_INFO[]\n$DOCUMENT_URI[]\n$LAST_MODIFIED[]\n$USER_NAME[]\n###";
  public static final String parser3_file = "@CLASS\nfile\n\n@load[format;filename]\n$name[]\n$size[]\n$text[]\n$cdate[^date::create[]]\n$mdate[^date::create[]]\n$adate[^date::create[]]\n$stderr[]\n$status[]\n$mode[]\n$content-type[]\n###\n\n@load[format;filename;download_options]\n###\n\n@load[format;filename;newname]\n###\n\n@load[format;filename;newname;download_options]\n###\n\n#:constructor\n@sql[query]\n###\n\n#:constructor\n@sql[query;options]\n###\n\n@stat[filename]\n###\n\n@cgi[filename]\n###\n\n@cgi[filename;env_hash]\n###\n\n@cgi[filename;env_hash;*args]\n###\n\n@cgi[format;filename;env_hash;*args]\n###\n\n@exec[filename]\n###\n\n@exec[filename;env_hash]\n###\n\n@exec[filename;env_hash;*args]\n###\n\n@exec[format;filename;env_hash;*args]\n###\n\n@base64[encoded]\n###\n\n@base64[text;filename;encoded]\n###\n\n@base64[binary;filename;encoded]\n###\n\n@create[format;filename;text]\n###\n\n@create[format;filename;text;options]\n###\n\n@save[format;filename]\n$result[^void::_has_no_constructor[]]\n###\n\n@save[format;filename;options]\n$result[^void::_has_no_constructor[]]\n###\n\n@sql-string[]\n$result[]\n###\n\n@base64[]\n$result[]\n###\n\n@md5[]\n$result[]\n###\n\n@crc32[]\n$result[]\n###\n\n@static:delete[path]\n$result[^void::_has_no_constructor[]]\n###\n\n@static:find[file]\n$result[^void::_has_no_constructor[]]\n###\n\n@static:find[file;default]\n$result[^void::_has_no_constructor[]]\n###\n\n@static:list[path]\n$result[^table::create[]]\n###\n\n@static:list[path;filter]\n$result[^table::create[]]\n###\n\n@static:copy[source;dest]\n$result[^void::_has_no_constructor[]]\n###\n\n@static:move[source;dest]\n$result[^void::_has_no_constructor[]]\n###\n\n@static:lock[lockfile;code]\n$result[^void::_has_no_constructor[]]\n###\n\n@static:dirname[filename]\n$result[]\n###\n\n@static:basename[filename]\n$result[]\n###\n\n@static:justname[filename]\n$result[]\n###\n\n@static:justext[filename]\n$result[]\n###\n\n@static:fullpath[filename]\n$result[]\n###\n\n@static:base64[filename]\n$result[]\n###\n\n@static:md5[filename]\n$result[]\n###\n\n@static:crc32[filename]\n$result[]\n###";
  public static final String parser3_form = "@CLASS\nform\n\n@auto[]\n$imap[^hash::create[]]\n$qtail[]\n$fields[^hash::create[]]\n$tables[^hash::create[]]\n$files[^hash::create[]]\n###\n\n@_has_no_constructor_[]\n###";
  public static final String parser3_hash = "@CLASS\nhash\n\n@create[]\n###\n\n#:constructor\n@sql[]\n###\n\n#:dynamic\n@_keys[]\n$result[^table::create[]]\n###\n\n#:dynamic\n@_keys[column]\n$result[^table::create[]]\n###\n\n#:dynamic\n@_count[]\n$result(1)\n###\n\n#:dynamic\n@_at[number]\n$result[]\n###\n\n#:dynamic\n@foreach[key;value;body]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@foreach[key;value;body;splitter]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@delete[]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@contains[key]\n$result[^bool::_has_no_constructor_[]]\n###\n\n#:dynamic\n@sub[hash]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@add[hash]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@union[hash]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@intersection[hash]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@intersects[hash]\n$result[^bool::_has_no_constructor_[]]\n###";
  public static final String parser3_hashfile = "@CLASS\nhashfile\n\n@open[]\n###\n\n#:dynamic\n@hash[]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@foreach[key;value;body]\n$result[^void::_has_no_constructor_]\n###\n\n#:dynamic\n@foreach[key;value;body;splitter]\n$result[^void::_has_no_constructor_]\n###\n\n#:dynamic\n@clear[]\n$result[^void::_has_no_constructor_]\n###\n\n#:dynamic\n@delete[key]\n$result[^void::_has_no_constructor_]\n###\n\n#:dynamic\n@delete[]\n$result[^void::_has_no_constructor_]\n###\n\n#:dynamic\n@cleanup[]\n$result[^void::_has_no_constructor_]\n###\n\n#:dynamic\n@release[]\n$result[^void::_has_no_constructor_]\n###";
  public static final String parser3_image = "@CLASS\nimage\n\n@measure[file]\n###\n\n@measure[filename]\n###\n\n@create[x;y]\n###\n\n@create[x;y;background]\n###\n\n@load[filename]\n###\n\n#:dynamic\n@html[]\n$result[]\n###\n\n#:dynamic\n@html[options]\n$result[]\n###\n\n#:dynamic\n@gif[]\n$result[^file::create[binary;filename;text]]\n###\n\n#:dynamic\n@line[x0;y0;x1;y1;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@pixel[x;y]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@pixel[x;y;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@fill[x;y;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@rectangle[x0;y0;x1;y1;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@bar[x0;y0;x1;y1;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@polyline[color;table]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@polygon[color;table]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@polybar[color;table]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@replace[oldcolor;newcolor;table]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@replace[oldcolor;newcolor]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@replace[x;y;radius;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@arc[x;y;width;height;start;end;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@sector[x;y;width;height;start;end;color]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@font[letters;filename;spacewidth]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@font[letters;filename;spacewidth;charwidth]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@font[letters;filename;options]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@text[x;y;text]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@length[text]\n$result(1)\n###\n\n#:dynamic\n@copy[source;x1;y1;width1;height1;x2;y2]\n$result[^void::_has_no_constructor[]]\n###\n\n#:dynamic\n@copy[source;x1;y1;width1;height1;x2;y2;width2;height2;hsr]\n$result[^void::_has_no_constructor[]]\n###";
  public static final String parser3_inet = "@CLASS\ninet\n\n@static:aton[string]\n$result(1)\n###\n\n@static:ntoa(integer)\n$result[]\n###";
  public static final String parser3_int = "@CLASS\nint\n\n@sql[default]\n###\n\n@int[default]\n$result(1)\n###\n\n@double[default]\n$result(1)\n###\n\n@inc[number]\n$result(1)\n###\n\n@dec[number]\n$result(1)\n###\n\n@mul[number]\n$result(1)\n###\n\n@div[number]\n$result(1)\n###\n\n@mod[number]\n$result(1)\n###\n\n@format[options]\n$result(1)\n###";
  public static final String parser3_json = "@CLASS\njson\n\n@parse[json-string;options]\n$result[^hash::create[]]\n###\n\n@string[object;options]\n$result[]\n###";
  public static final String parser3_junction = "@CLASS\njunction\n\n@_has_no_constructor_[]\n###";
  public static final String parser3_mail = "@CLASS\nmail\n\n@auto[]\n$received[^hash::create[]]\n###\n\n@static:send[hash]\n$result[^void::_has_no_constructor_]\n###";
  public static final String parser3_math = "@CLASS\nmath\n\n@static:abs[number]\n$result(1)\n###\n\n@static:sign[number]\n$result(1)\n###\n\n@static:round[number]\n$result(1)\n###\n\n@static:floor[number]\n$result(1)\n###\n\n@static:ceiling[number]\n$result(1)\n###\n\n@static:trunc[number]\n$result(1)\n###\n\n@static:frac[number]\n$result(1)\n###\n\n@static:degrees[number]\n$result(1)\n###\n\n@static:radians[number]\n$result(1)\n###\n\n@static:sin[number]\n$result(1)\n###\n\n@static:asin[number]\n$result(1)\n###\n\n@static:cos[number]\n$result(1)\n###\n\n@static:acos[number]\n$result(1)\n###\n\n@static:tan[number]\n$result(1)\n###\n\n@static:atan[number]\n$result(1)\n###\n\n@static:exp[number]\n$result(1)\n###\n\n@static:log[number]\n$result(1)\n###\n\n@static:log10[number]\n$result(1)\n###\n\n@static:pow[number;power]\n$result(1)\n###\n\n@static:sqrt[number]\n$result(1)\n###\n\n@static:random[number]\n$result(1)\n###\n\n@static:uuid[]\n$result[]\n###\n\n@static:uid64[]\n$result[]\n###\n\n@static:md5[str]\n$result[]\n###\n\n@static:crypt[password;salt]\n$result[]\n###\n\n@static:crc32[str]\n$result[]\n###\n\n@static:sha1[str]\n$result[]\n###\n\n@static:convert[number;src;dest]\n$result[]\n###";
  public static final String parser3_memory = "@CLASS\nmemory\n\n@static:compact[]\n$result[^void::_has_no_constructor[]]\n###";
  public static final String parser3_reflection = "@CLASS\nreflection\n\n@static:create[classname;constructor]\n###\n\n@static:create[classname;constructor;*args]\n###\n\n@static:classes[]\n$result[^hash::create[]]\n###\n\n@static:class[object]\n$result[]\n###\n\n@static:class_name[object]\n$result[]\n###\n\n@static:base[class]\n###\n\n@static:base_name[class]\n$result[]\n###\n\n@static:base_name[object]\n$result[]\n###\n\n@static:methods[classname]\n$result[^hash::create[]]\n###\n\n@static:method_info[classname;methodname]\n$result[^hash::create[]]\n###\n\n@static:fields[class]\n$result[^hash::create[]]\n###\n\n@static:fields[object]\n$result[^hash::create[]]\n###\n\n@static:dynamical[]\n$result[^bool::_has_no_constructor_[]]\n###\n\n@static:dynamical[class]\n$result[^bool::_has_no_constructor_[]]\n###\n\n@static:dynamical[object]\n$result[^bool::_has_no_constructor_[]]\n###\n\n@static:copy[from;to]\n$result[^void::_has_no_constructor_[]]\n###";
  public static final String parser3_regex = "@CLASS\nregex\n\n@create[template]\n###\n\n@create[template;options]\n###";
  public static final String parser3_request = "@CLASS\nrequest\n\n@auto[]\n$uri[]\n$query[]\n$charset[]\n$post-charset[]\n$body[]\n$post-body[]\n$document-root[]\n$argv[^hash::create[]]\n###\n\n@_has_no_constructor_[]\n###";
  public static final String parser3_response = "@CLASS\nresponse\n\n@auto[]\n$refresh[^hash::create[]]\n$location[]\n$expires[]\n$headers[^hash::create[]]\n$body[]\n$download[]\n$charset[]\n###\n\n@_has_no_constructor_[]\n###\n\n@static:clear[]\n$result[^void::_has_no_constructor_[]]\n###";
  public static final String parser3_status = "@CLASS\nstatus\n\n@auto[]\n$rusage[^hash::create[]]\n$memory[^hash::create[]]\n$pid(1)\n$tid(1)\n###\n\n@_has_no_constructor_[]\n###";
  public static final String parser3_string = "@CLASS\nstring\n\n@int[default]\n$result(1)\n###\n\n@double[default]\n$result(1)\n###\n\n@format[options]\n$result(1)\n###\n\n@split[divider;options]\n$result[^table::create[]]\n###\n\n@upper[]\n###\n\n@lower[]\n###\n\n@length[]\n$result(1)\n###\n\n@mid[P;N]\n###\n\n@left[N]\n###\n\n@right[N]\n###\n\n@pos[substring]\n$result(1)\n###\n\n@replace[tableData]\n###\n\n@save[append;filename]\n###\n\n@match[template;options]\n$result[^table::create[]]\n###\n\n@match[template;options;replace]\n$result[^table::create[]]\n###\n\n@trim[position;symbol]\n###";
  public static final String parser3_table = "@CLASS\ntable\n\n@create[data]\n###\n\n@create[nameless;data]\n###\n\n@create[data;options]\n###\n\n@load[filename]\n###\n\n@load[filename;options]\n###\n\n@load[nameless;filename]\n###\n\n@load[nameless;filename;options]\n###\n\n#:constructor\n@sql[query]\n###\n\n#:constructor\n@sql[query;limit;offset;bind]\n###\n\n#:dynamic\n@save[filename]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@save[filename;options]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@save[nameless;filename]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@save[nameless;filename;options]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@save[append;filename]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@save[append;filename;options]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@count[]\n$result(1)\n###\n\n#:dynamic\n@menu[code]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@menu[code;split]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@append[data]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@offset[offset]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@offset[cur;offset]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@offset[set;offset]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@line[]\n$result(1)\n###\n\n#:dynamic\n@sort[function]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@sort[function;order]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@join[table]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@join[table;options]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@flip[]\n$result[^table::create[]]\n###\n\n#:dynamic\n@locate[column;seachword]\n###\n\n#:dynamic\n@locate[column;seachword;options]\n###\n\n#:dynamic\n@select[criteria]\n$result[^table::create[]]\n###\n\n#:dynamic\n@select[criteria;options]\n$result[^table::create[]]\n###\n\n#:dynamic\n@hash[key]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@hash[key;options]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@hash[key;column;options]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@columns[]\n$result[^table::create[]]\n###\n\n#:dynamic\n@columns[column]\n$result[^table:;create[]]\n###";
  public static final String parser3_void = "@CLASS\nvoid\n\n@_has_no_constructor_[]\n###\n\n@static:sql[]\n###";
  public static final String parser3_xdoc = "@CLASS\nxdoc\n\n@create[xmlcode]\n###\n\n@create[basepath;xmlcode]\n###\n\n@create[tagname]\n###\n\n@create[basepath;tagname]\n###\n\n@create[file]\n###\n\n@load[filename]\n###\n\n#:dynamic\n@createElement[tagName]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createDocumentFragment[]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createTextNode[data]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createComment[data]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createCDATASection[data]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createProcessingInstruction[target;data]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createAttribute[name]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createEntityReference[name]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@getElementsByTagName[tagname]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@importNode[importedNode;deep]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createElementNS[namespaceURI;qualifiedName]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@createAttributeNS[namespaceURI;qualifiedName]\n$result[^xnode::create[]]\n###\n\n#:dynamic\n@getElementsByTagNameNS[namespaceURI;localName]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@getElementById[elementId]\n$result[^xnode::create[]]\n###";
  public static final String parser3_xnode = "@CLASS\nxnode\n\n@_has_no_constructor_[]\n###\n\n#:dynamic\n@insertBefore[newChild;refChild]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@replaceChild[newChild;refChild]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@removeChild[oldChild]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@appendChild[oldChild]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@hasChildNodes[]\n$result[^bool::_has_no_constructor_[]]\n###\n\n#:dynamic\n@cloneNode[deep]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@getAttribute[name]\n$result[]\n###\n\n#:dynamic\n@setAttribute[name;value]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@removeAttribute[name;value]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@getElementsByTagName[name]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@getAttributeNS[namespaceURI;localName]\n$result[]\n###\n\n#:dynamic\n@setAttributeNS[namespaceURI;qualifiedName;value]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@removeAttributeNS[namespaceURI;localName]\n$result[^void::_has_no_constructor_[]]\n###\n\n#:dynamic\n@getAttributeNodeNS[namespaceURI;localName]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@setAttributeNodeNS[newAttr]\n$result[^xnode::_has_no_constructor_[]]\n###\n\n#:dynamic\n@getElementsByTagNameNS[namespaceURI;localName]\n$result[^hash::create[]]\n###\n\n#:dynamic\n@hasAttribute[name]\n$result[^bool::_has_no_constructor_[]]\n###\n\n#:dynamic\n@hasAttributeNS[namespaceURI;localName]\n$result[^bool::_has_no_constructor_[]]\n###\n\n#:dynamic\n@hasAttributes[]\n$result[^bool::_has_no_constructor_[]]\n###";
}