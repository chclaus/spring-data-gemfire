/*
 * Copyright 2010-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.gemfire.repository.sample;

import java.util.List;

import org.springframework.data.gemfire.repository.GemfireRepository;

/**
 * The UserRepository class is a DAO for accessing and persisting Users.
 * <p/>
 * @author John Blum
 * @see org.springframework.data.gemfire.repository.GemfireRepository
 * @see org.springframework.data.gemfire.repository.Query
 * @see org.springframework.data.gemfire.repository.sample.User
 * @since 1.3.4
 */
@SuppressWarnings("unused")
public interface UserRepository extends GemfireRepository<User, String> {

	//@Query("SELECT DISTINCT * FROM /Users u WHERE u.active = true")
	public List<User> findDistinctByActiveTrue();

	//@Query("SELECT DISTINCT * FROM /Users u WHERE u.active = false")
	public List<User> findDistinctByActiveFalse();

	public List<User> findDistinctByUsernameLike(String username);

	// NOTE unfortunately, the 'NOT LIKE' operator is unsupported in GemFire's Query/OQL syntax
	//public List<User> findDistinctByUsernameNotLike(String username);

}
