/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2012 Red Hat, Inc.
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
package org.jboss.classfilewriter.test.bytecode.i;

import org.junit.Assert;

import org.jboss.classfilewriter.code.CodeAttribute;
import org.jboss.classfilewriter.test.bytecode.MethodTester;
import org.junit.Test;

public class IincTest {

    @Test
    public void iincTest() {
        MethodTester<Integer> mt = new MethodTester<Integer>(int.class, int.class);
        CodeAttribute ca = mt.getCodeAttribute();
        ca.iinc(0, 10);
        ca.iload(0);
        ca.returnInstruction();
        Assert.assertEquals(20, (int) mt.invoke(10));
    }

    @Test
    public void iincWideTest() {
        MethodTester<Integer> mt = new MethodTester<Integer>(int.class, int.class);
        CodeAttribute ca = mt.getCodeAttribute();
        ca.iinc(0, 0xFFF);
        ca.iload(0);
        ca.returnInstruction();
        Assert.assertEquals(10 + 0xFFF, (int) mt.invoke(10));
    }

}
