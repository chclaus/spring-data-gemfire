/*
 * Copyright 2010-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.gemfire.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.internal.datasource.GemFireBasicDataSource;

/**
 * This test requires a real cache
 * <p/>
 * @author David Turanski
 * @author John Blum
 */
@ContextConfiguration("jndi-binding-ns.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@SuppressWarnings("unused")
public class JndiBindingsTest {

	@Autowired
	private Cache cache;

	@Test
	public void testJndiBindings() throws Exception {
		Object dataSourceObject = cache.getJNDIContext().lookup("java:/SimpleDataSource");

		assertTrue(dataSourceObject instanceof GemFireBasicDataSource);

		GemFireBasicDataSource dataSource = (GemFireBasicDataSource) dataSourceObject;

		assertEquals("org.apache.derby.jdbc.EmbeddedDriver", dataSource.getJDBCDriver());
		assertEquals(60, dataSource.getLoginTimeout());
	}

}
