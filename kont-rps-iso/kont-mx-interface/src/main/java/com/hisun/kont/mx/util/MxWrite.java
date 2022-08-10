/*
 * Copyright 2006-2021 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hisun.kont.mx.util;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.EscapeHandler;

/**
 * @deprecated use the {@link MxWriteImpl} directly
 */
public interface MxWrite {

    String message(String namespace, AbstractMX obj, Class[] classes, final String prefix, boolean includeXMLDeclaration);


    default String message(String namespace, AbstractMX obj, Class[] classes, final String prefix, boolean includeXMLDeclaration, EscapeHandler escapeHandler) {
        return message(namespace, obj, classes, prefix, includeXMLDeclaration, null);
    }

}
